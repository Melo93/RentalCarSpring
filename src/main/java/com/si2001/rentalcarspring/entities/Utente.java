package com.si2001.rentalcarspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Cognome")
    private String cognome;

    @Column(name = "Codice_Fiscale", unique = true)
    private String codiceFiscale;

    @ManyToOne
    @JoinColumn(name = "Ruolo", referencedColumnName = "ID")
    private Ruolo ruolo;

    @Column(name = "Username", unique = true)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Data_di_nascita")
    private LocalDate dataDiNascita;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazioni> prenotazioni;


    public Utente() {
    }

    public Utente(String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataDiNascita = dataDiNascita;
    }

    public Utente(String nome, String cognome, String codiceFiscale, Ruolo ruolo, String username, String password, LocalDate dataDiNascita) throws ParseException {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.ruolo = ruolo;
        this.username = username;
        this.password = password;
        this.dataDiNascita = dataDiNascita;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataDiNascita(){
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita){
        this.dataDiNascita = dataDiNascita;
    }

    public List<Prenotazioni> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", ruolo=" + ruolo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
