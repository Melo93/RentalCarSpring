package com.si2001.rentalcarspring.service.interfaces;

import com.si2001.rentalcarspring.entities.Veicoli;

import java.time.LocalDate;
import java.util.List;

public interface VeicoliService {

    List<Veicoli> getAllCars();
    Veicoli getCarById(Integer id);
    void save(Veicoli car);
}
