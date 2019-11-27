package com.si2001.rentalcarspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Tipologia")
    private String tipologia;

    @OneToMany(mappedBy = "tipologia", cascade = CascadeType.ALL)
    private List<Veicoli> veicoli;


    public Categoria() {
    }

    public Categoria(String tipologia) {
        this.tipologia = tipologia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public List<Veicoli> getVeicoli() {
        return veicoli;
    }

    public void setVeicoli(List<Veicoli> veicoli) {
        this.veicoli = veicoli;
    }
}
