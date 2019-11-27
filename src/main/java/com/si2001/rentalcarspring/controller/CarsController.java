package com.si2001.rentalcarspring.controller;

import com.si2001.rentalcarspring.entities.Categoria;
import com.si2001.rentalcarspring.entities.Prenotazioni;
import com.si2001.rentalcarspring.entities.Utente;
import com.si2001.rentalcarspring.entities.Veicoli;
import com.si2001.rentalcarspring.entities.dto.NewCarDTO;
import com.si2001.rentalcarspring.entities.mapper.MyMapper;
import com.si2001.rentalcarspring.entities.projection.VeicoliByPrenotazioni;
import com.si2001.rentalcarspring.service.interfaces.CategoriaService;
import com.si2001.rentalcarspring.service.interfaces.PrenotazioniService;
import com.si2001.rentalcarspring.service.interfaces.VeicoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final VeicoliService veicoliService;
    private final PrenotazioniService prenotazioniService;
    final
    CategoriaService categoriaService;

    public CarsController(VeicoliService veicoliService, PrenotazioniService prenotazioniService, CategoriaService categoriaService) {
        this.veicoliService = veicoliService;
        this.prenotazioniService = prenotazioniService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/getAll")
    public String showAllCars(Model model) {
        List<Veicoli> allCars;
        allCars = veicoliService.getAllCars();

        model.addAttribute("cars", allCars);
        return "cars";
    }

    @GetMapping("/getAvailable")
    public String getAvailableCars(@RequestParam("dataInizio") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataInizio,
                                   @RequestParam("dataFine") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dataFine,
                                   Model model, HttpServletRequest request) {

        List<VeicoliByPrenotazioni> bookingCarsByPrenotazioni=prenotazioniService.findBookingStartToEnd(dataInizio,dataFine);
        List<Veicoli> allCars = veicoliService.getAllCars();

        allCars.removeAll(bookingCarsByPrenotazioni.
                stream().
                map(VeicoliByPrenotazioni::getVeicolo).
                collect(Collectors.toList())
        );


        model.addAttribute("cars", allCars);
        request.getSession().setAttribute("availablecars", allCars);
        request.getSession().setAttribute("dataInizio", dataInizio);
        request.getSession().setAttribute("dataFine", dataFine);

        return "carsAvailable";
    }


    @GetMapping("/newForm")
    public String newCarForm (Model model){
        model.addAttribute("newCar", new NewCarDTO());
        return "newCar";
    }

    @PostMapping("/new")
    public String newCar(@Valid @ModelAttribute("newCar") NewCarDTO car,
                         BindingResult result,
                         HttpServletRequest request){
        if (result.hasErrors()) {
            return "newCar";
        }

        Categoria carCategory=categoriaService.carCategoryByTipo(car.getTipologia());
        Veicoli newCar= MyMapper.INSTANCE.NewCarDTOToVeicoli(car);
        newCar.setTipologia(carCategory);
        veicoliService.save(newCar);
        List<Veicoli> allCars = veicoliService.getAllCars();
        request.getSession().setAttribute("cars", allCars);
        return "cars";
    }
}
