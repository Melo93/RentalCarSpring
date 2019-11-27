package com.si2001.rentalcarspring.service.impl;

import com.si2001.rentalcarspring.dao.RuoloDAO;
import com.si2001.rentalcarspring.entities.Ruolo;
import com.si2001.rentalcarspring.service.interfaces.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ruoloService")
@Transactional
public class RuoloServiceImpl implements RuoloService {

    private final RuoloDAO ruoloDAO;

    public RuoloServiceImpl(RuoloDAO ruoloDAO) {
        this.ruoloDAO = ruoloDAO;
    }

    @Override
    public Ruolo findRoleByDesc(String desc) {
        return ruoloDAO.findByDescrizione(desc);
    }
}
