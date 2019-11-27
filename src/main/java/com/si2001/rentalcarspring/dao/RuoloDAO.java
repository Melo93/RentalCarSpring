package com.si2001.rentalcarspring.dao;

import com.si2001.rentalcarspring.entities.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuoloDAO extends JpaRepository<Ruolo,Integer> {
    Ruolo findByDescrizione(String desc);
}
