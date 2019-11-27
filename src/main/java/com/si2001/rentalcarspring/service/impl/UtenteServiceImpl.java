package com.si2001.rentalcarspring.service.impl;


import com.si2001.rentalcarspring.dao.UtenteDAO;
import com.si2001.rentalcarspring.entities.Utente;
import com.si2001.rentalcarspring.service.interfaces.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("utenteService")
@Transactional
public class UtenteServiceImpl implements UtenteService {

    private final UtenteDAO utenteRepository;

    public UtenteServiceImpl(UtenteDAO utenteRepository) {
        this.utenteRepository = utenteRepository;
    }


    @Override
    public List<Utente> getAllUser() {
        return utenteRepository.findAll();
    }

    @Override
    public Utente getUserByUsernameAndPassword(String username, String password) {
        return utenteRepository.findByUsernameAndPassword(username,password);
    }



    @Override
    public void update(Utente utente) {
        utenteRepository.save(utente);
    }

    @Override
    public Utente findById(int id) {
        return utenteRepository.findUtenteById(id);
    }


}
