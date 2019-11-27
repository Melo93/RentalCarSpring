package com.si2001.rentalcarspring.dao;

import com.si2001.rentalcarspring.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<Categoria,Integer> {

    Categoria findByTipologia(String tipo);
}
