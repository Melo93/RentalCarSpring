package com.si2001.rentalcarspring.service.impl;

import com.si2001.rentalcarspring.dao.CategoriaDAO;
import com.si2001.rentalcarspring.entities.Categoria;
import com.si2001.rentalcarspring.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("categoriaService")
@Transactional
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaDAO categoriaDAO;

    public CategoriaServiceImpl(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @Override
    public Categoria carCategoryByTipo(String tipo) {
        return categoriaDAO.findByTipologia(tipo);
    }
}
