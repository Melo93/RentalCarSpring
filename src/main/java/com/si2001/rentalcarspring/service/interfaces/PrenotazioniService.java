package com.si2001.rentalcarspring.service.interfaces;

import com.si2001.rentalcarspring.entities.Prenotazioni;
import com.si2001.rentalcarspring.entities.projection.VeicoliByPrenotazioni;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PrenotazioniService {

    List<VeicoliByPrenotazioni> findBookingStartToEnd(LocalDate start, LocalDate end);
    void save(Prenotazioni prenotazioni);

    List<Prenotazioni> finPrenotazioniPending();
    List<Prenotazioni> storicoPrenotazioni();

    Prenotazioni findById(Integer id);
}
