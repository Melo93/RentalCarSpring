package com.si2001.rentalcarspring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "veicoli")
public class Veicoli implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Targa")
    private String targa;

    @Column(name = "Costruttore")
    private String costruttore;

    @Column(name = "Modello")
    private String modello;

    @Column(name = "Anno_costruzione")
    private Integer annoCostruzione;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tipologia")
    private Categoria tipologia;

    @Column(name = "Prezzo")
    private Integer prezzo;

    @Column(name = "img_URL")
    private String urlImg;

    @Column(name = "Alimentazione")
    private String alimentazione;

    @Column(name = "Cilindrata")
    private Integer cilindrata;

    @Column(name = "Cavalli")
    private Integer cavalli;

    @OneToMany(mappedBy = "veicolo")
    List<Prenotazioni> prenotazioni;

    public Veicoli() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Categoria getTipologia() {
        return tipologia;
    }

    public void setTipologia(Categoria tipologia) {
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

    public List<Prenotazioni> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazioni> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    @Override
    public String toString() {
        return "Veicoli{" +
                "id=" + id +
                ", targa='" + targa + '\'' +
                ", costruttore='" + costruttore + '\'' +
                ", modello='" + modello + '\'' +
                ", annoCostruzione=" + annoCostruzione +
                ", tipologia=" + tipologia +
                ", prezzo=" + prezzo +
                ", urlImg='" + urlImg + '\'' +
                ", alimentazione='" + alimentazione + '\'' +
                ", cilindrata=" + cilindrata +
                ", cavalli=" + cavalli +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Veicoli)) {
            return false;
        }
        Veicoli otherMember = (Veicoli) obj;
        return otherMember.getId().equals(this.getId());
    }
}
