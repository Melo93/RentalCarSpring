package com.si2001.rentalcarspring.entities.dto;

import com.si2001.rentalcarspring.entities.Categoria;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NewCarDTO {

    @NotEmpty(message = "{NotEmpty.NewCar.targa.validation}")
    private String targa;
    @NotEmpty(message = "{NotEmpty.NewCar.costruttore.validation}")
    private String costruttore;
    @NotEmpty(message = "{NotEmpty.NewCar.modello.validation}")
    private String modello;
    @NotNull(message = "{NotEmpty.NewCar.annoCostruzione.validation}")
    private Integer annoCostruzione;
    private String tipologia;
    @NotNull(message = "{NotEmpty.NewCar.prezzo.validation}")
    private Integer prezzo;
    private String urlImg;
    @NotEmpty(message = "{NotEmpty.NewCar.alimentazione.validation}")
    private String alimentazione;
    @NotNull(message = "{NotEmpty.NewCar.cilindrata.validation}")
    private Integer cilindrata;
    @NotNull(message = "{NotEmpty.NewCar.cavalli.validation}")
    private Integer cavalli;

    public NewCarDTO() {
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCostruttore() {
        return costruttore;
    }

    public void setCostruttore(String costruttore) {
        this.costruttore = costruttore;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Integer getAnnoCostruzione() {
        return annoCostruzione;
    }

    public void setAnnoCostruzione(Integer annoCostruzione) {
        this.annoCostruzione = annoCostruzione;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public Integer getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Integer cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Integer getCavalli() {
        return cavalli;
    }

    public void setCavalli(Integer cavalli) {
        this.cavalli = cavalli;
    }

    @Override
    public String toString() {
        return "NewCarDTO{" +
                "targa='" + targa + '\'' +
                ", costruttore='" + costruttore + '\'' +
                ", modello='" + modello + '\'' +
                ", annoCostruzione=" + annoCostruzione +
                ", tipologia='" + tipologia + '\'' +
                ", prezzo=" + prezzo +
                ", urlImg='" + urlImg + '\'' +
                ", alimentazione='" + alimentazione + '\'' +
                ", cilindrata=" + cilindrata +
                ", cavalli=" + cavalli +
                '}';
    }
}
