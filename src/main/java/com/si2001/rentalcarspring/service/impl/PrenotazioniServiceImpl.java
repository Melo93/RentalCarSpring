package com.si2001.rentalcarspring.service.impl;

import com.si2001.rentalcarspring.dao.PrenotazioniDAO;
import com.si2001.rentalcarspring.entities.Prenotazioni;
import com.si2001.rentalcarspring.entities.projection.VeicoliByPrenotazioni;
import com.si2001.rentalcarspring.service.interfaces.PrenotazioniService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Service("prenotazioniService")
@Transactional
public class PrenotazioniServiceImpl implements PrenotazioniService {

    private final PrenotazioniDAO prenotazioniDAO;

    public PrenotazioniServiceImpl(PrenotazioniDAO prenotazioniDAO) {
        this.prenotazioniDAO = prenotazioniDAO;
    }

    @Override
    public List<VeicoliByPrenotazioni> findBookingStartToEnd(LocalDate start, LocalDate end) {

        return prenotazioniDAO.findVeicoliByDataInizioBetweenOrDataFineBetweenAndStatoIs(start, end, start, end,"APPROVED");
    }

    @Override
    public void save(Prenotazioni prenotazioni) {
        prenotazioniDAO.save(prenotazioni);
    }

    @Override
    public List<Prenotazioni> finPrenotazioniPending() {
        return prenotazioniDAO.findPrenotazioniByStatoAndDataInizioIsAfter("PENDING", LocalDate.now());
    }

    @Override
    public List<Prenotazioni> storicoPrenotazioni() {
        return prenotazioniDAO.findPrenotazioniByStatoNot("PENDING");
    }

    @Override
    public Prenotazioni findById(Integer id) {
        return prenotazioniDAO.findPrenotazioniById(id);
    }


}
