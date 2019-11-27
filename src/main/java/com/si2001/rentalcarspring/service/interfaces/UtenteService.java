package com.si2001.rentalcarspring.service.interfaces;

import com.si2001.rentalcarspring.entities.Utente;

import java.text.ParseException;
import java.util.List;

public interface UtenteService {

    List<Utente> getAllUser();
    Utente getUserByUsernameAndPassword(String username, String password) throws ParseException;
    void update(Utente utente);
    Utente findById(int id);
}
