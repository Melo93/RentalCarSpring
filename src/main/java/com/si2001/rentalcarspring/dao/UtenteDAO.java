package com.si2001.rentalcarspring.dao;

import com.si2001.rentalcarspring.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtenteDAO extends JpaRepository<Utente, Integer>{

    List<Utente> findAll();
    Utente findByUsernameAndPassword(String username, String password);
    Utente findUtenteById(int id);



}
