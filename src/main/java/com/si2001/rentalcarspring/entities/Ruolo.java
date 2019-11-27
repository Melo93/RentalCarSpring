package com.si2001.rentalcarspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ruolo")
public class Ruolo implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Descrizione", unique = true)
    private String descrizione;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "ruolo")
    private Set<Utente> utenti ;

    public Ruolo() {
    }

    public Ruolo(String descrizione) {
        this.descrizione = descrizione;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "Ruolo{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }

    public Set<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(Set<Utente> utenti) {
        this.utenti = utenti;
    }
}
