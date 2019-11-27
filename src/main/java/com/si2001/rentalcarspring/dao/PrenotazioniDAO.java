package com.si2001.rentalcarspring.dao;

import com.si2001.rentalcarspring.entities.Prenotazioni;

import com.si2001.rentalcarspring.entities.projection.VeicoliByPrenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PrenotazioniDAO extends JpaRepository<Prenotazioni,Integer> {

    List<Prenotazioni> findPrenotazioniByDataInizioBetween(Date start, Date end);
  /*  @Query( value = "SELECT new  FROM prenotazioni WHERE (prenotazioni.Data_inizio) BETWEEN '2019-11-22'AND '2019-11-24' OR (prenotazioni.Data_fine) BETWEEN '2019-11-22'AND '2019-11-24'")*/
    List<VeicoliByPrenotazioni> findVeicoliByDataInizioBetweenOrDataFineBetweenAndStatoIs(LocalDate dataInizio, LocalDate dataInizio2, LocalDate dataFine, LocalDate dataFine2, String stato);
    List<Prenotazioni> findPrenotazioniByStatoAndDataInizioIsAfter(String stato, LocalDate today);
    List<Prenotazioni>findPrenotazioniByStatoNot(String stato);
    Prenotazioni findPrenotazioniById(Integer id);
}
