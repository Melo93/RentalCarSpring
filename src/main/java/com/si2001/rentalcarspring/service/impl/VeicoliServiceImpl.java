package com.si2001.rentalcarspring.service.impl;

import com.si2001.rentalcarspring.dao.VeicoliDAO;
import com.si2001.rentalcarspring.entities.Veicoli;
import com.si2001.rentalcarspring.service.interfaces.VeicoliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service("veicoliService")
@Transactional
public class VeicoliServiceImpl implements VeicoliService {

    private final VeicoliDAO veicoliDAO;

    public VeicoliServiceImpl(VeicoliDAO veicoliDAO) {
        this.veicoliDAO = veicoliDAO;
    }

    @Override
    public List<Veicoli> getAllCars() {
        return veicoliDAO.findAll();
    }

    @Override
    public Veicoli getCarById(Integer id) {
      return veicoliDAO.findVeicoliById(id);
    }

    @Override
    public void save(Veicoli car) {
        veicoliDAO.save(car);
    }


}
