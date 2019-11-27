package com.si2001.rentalcarspring.controller;

import com.si2001.rentalcarspring.entities.Prenotazioni;
import com.si2001.rentalcarspring.entities.Ruolo;
import com.si2001.rentalcarspring.entities.Utente;
import com.si2001.rentalcarspring.entities.dto.EditProfileDTO;
import com.si2001.rentalcarspring.entities.dto.LoginDTO;
import com.si2001.rentalcarspring.entities.mapper.MyMapper;
import com.si2001.rentalcarspring.service.interfaces.PrenotazioniService;
import com.si2001.rentalcarspring.service.interfaces.RuoloService;
import com.si2001.rentalcarspring.service.interfaces.UtenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UtenteService utenteService;
    private final RuoloService ruoloService;
    private final PrenotazioniService prenotazioniService;

    public UserController(UtenteService utenteService, RuoloService ruoloService, PrenotazioniService prenotazioniService) {
        this.utenteService = utenteService;
        this.ruoloService = ruoloService;
        this.prenotazioniService = prenotazioniService;
    }



    @PostMapping(value = "/login")
    public String login(@ModelAttribute @Valid LoginDTO loginDTO,
                        BindingResult result,
                        Model model,
                        HttpServletRequest request
    ) throws ParseException {

        if (result.hasErrors()) {
            return "redirect:/";
        }

        Utente utente = utenteService.getUserByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if(utente.getRuolo().getDescrizione().equals("Admin")){
            List<Prenotazioni> prenotazioniInAttesa=prenotazioniService.finPrenotazioniPending();
            List<Prenotazioni> storicoPrenotazioni=prenotazioniService.storicoPrenotazioni();
            request.getSession().setAttribute("prenotazioniInAttesa", prenotazioniInAttesa);
            request.getSession().setAttribute("storicoPrenotazioni", storicoPrenotazioni);

        }
        if (utente != null) {
            model.addAttribute("utente", utente);
            request.getSession().setAttribute("utente", utente);
        } else
            model.addAttribute("errorLogin", "combinazione Username e Password errata");
        return "index";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model,
                         HttpServletRequest request) {

        model.addAttribute("utente", null);
        request.getSession().removeAttribute("utente");
        request.getSession().removeAttribute("prenotazioniInAttesa");
        request.getSession().removeAttribute("storicoPrenotazioni");
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String getUserInfo(Model model, HttpServletRequest request) throws ParseException {

        EditProfileDTO edit= MyMapper.INSTANCE.UtenteToEditProfileDTO(
                (Utente) request.getSession().getAttribute("utente"));
        model.addAttribute("editUtente", edit);

        return "profile";
    }

    @PostMapping("/edit")
    public String editUserInfo(@Valid @ModelAttribute("editUtente") EditProfileDTO edit,
                               BindingResult result,
                               HttpServletRequest request) throws ParseException {
        if (result.hasErrors()) {
            return "profile";
        }
        Ruolo userRole=ruoloService.findRoleByDesc(edit.getRuolo());
        Utente user= MyMapper.INSTANCE.EditProfileDTOToUtente(edit);
        user.setRuolo(userRole);
        user.setId(((Utente)request.getSession().getAttribute("utente")).getId());
        utenteService.update(user);
        request.getSession().setAttribute("utente", user);
        return "profile";

    }

    @GetMapping("/newForm")
    public String newUserForm(Model model){
        model.addAttribute("newUser", new EditProfileDTO());
        return "newUser";
    }

    @PostMapping("/new")
    public String newUser(@Valid @ModelAttribute("newUser") EditProfileDTO newUser,
                          BindingResult result) throws ParseException {
        if (result.hasErrors()) {
            return "newUser";
        }

        Ruolo userRole=ruoloService.findRoleByDesc(newUser.getRuolo());
        Utente user= MyMapper.INSTANCE.EditProfileDTOToUtente(newUser);
        user.setRuolo(userRole);
        utenteService.update(user);
        return "newUser";
    }

}
