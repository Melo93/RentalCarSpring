package com.si2001.rentalcarspring.controller;

import com.si2001.rentalcarspring.entities.Prenotazioni;
import com.si2001.rentalcarspring.entities.Utente;
import com.si2001.rentalcarspring.entities.Veicoli;
import com.si2001.rentalcarspring.service.interfaces.PrenotazioniService;
import com.si2001.rentalcarspring.service.interfaces.VeicoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/booking")
public class BookingController {

    private final VeicoliService veicoliService;
    private final PrenotazioniService prenotazioniService;

    public BookingController(VeicoliService veicoliService, PrenotazioniService prenotazioniService) {
        this.veicoliService = veicoliService;
        this.prenotazioniService = prenotazioniService;
    }

    @PostMapping("/rent")
    public String rentCar(@RequestParam("id") Integer id,
                          HttpServletRequest request){

        Veicoli bookCar=veicoliService.getCarById(id);
        Prenotazioni newBooking=new Prenotazioni();
        newBooking.setDataInizio((LocalDate)request.getSession().getAttribute("dataInizio"));
        newBooking.setDataFine((LocalDate)request.getSession().getAttribute("dataFine"));
        newBooking.setStato("PENDING");
        newBooking.setUtente((Utente) request.getSession().getAttribute("utente"));
        newBooking.setVeicolo(bookCar);
        newBooking.setDataPrenotazione(LocalDate.now());

        prenotazioniService.save(newBooking);

        return "index";
    }

    @PostMapping("/action")
    public String setStateBooking(@RequestParam("bookingId") Integer id,
                                  @RequestParam("state") String state,
                                  HttpServletRequest request){

        Prenotazioni newState=prenotazioniService.findById(id);

        newState.setStato(state);

        prenotazioniService.save(newState);

        List<Prenotazioni> pending=prenotazioniService.finPrenotazioniPending();
        List<Prenotazioni> history=prenotazioniService.storicoPrenotazioni();

        System.out.println(pending.toString());
        System.out.println(history.toString());

        request.getSession().setAttribute("prenotazioniInAttesa", pending);
        request.getSession().setAttribute("storicoPrenotazioni", history);

        return "index";
    }
}
