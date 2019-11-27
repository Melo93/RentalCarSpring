package com.si2001.rentalcarspring.entities.dto;

import com.si2001.rentalcarspring.entities.Ruolo;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

public class EditProfileDTO implements Serializable {

    @NotEmpty(message = "{NotEmpty.EditProfileDTO.nome.validation}")
    private String nome;
    @NotEmpty(message = "{NotEmpty.EditProfileDTO.cognome.validation}")
    private String cognome;
    @NotEmpty(message = "{NotEmpty.EditProfileDTO.codiceFiscale.validation}")
    private String codiceFiscale;
    private String ruolo;
    private String username;
    @NotEmpty(message = "{NotEmpty.EditProfileDTO.password.validation}")
    private String password;
    private LocalDate dataDiNascita;

    public EditProfileDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDataDiNascita() throws ParseException {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) throws ParseException {
        this.dataDiNascita = dataDiNascita;
    }

    @Override
    public String toString() {
        return "EditProfileDTO{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", ruolo=" + ruolo +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                '}';
    }
}
