package com.si2001.rentalcarspring.dao;

import com.si2001.rentalcarspring.entities.Veicoli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface VeicoliDAO extends JpaRepository<Veicoli,Integer> {

    List<Veicoli> findAll();

    Veicoli findVeicoliById(Integer id);

}
