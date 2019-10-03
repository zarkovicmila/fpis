/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author milaz
 */
@Entity
public class StavkaNarudzbenice implements Serializable{
  
    @EmbeddedId
    private StavkaId id;
    private String sifraIgracke;
    private String igracka;
    private int kolicina;
    private BigDecimal cena;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("narudzbenicaID")        
    @JoinColumn
    @JsonBackReference
    private Narudzbenica narudzbenica;

    public StavkaNarudzbenice(StavkaId id, String sifraIgracke, String igracka, int kolicina, BigDecimal cena, Narudzbenica narudzbenica) {
        this.id = id;
        this.sifraIgracke = sifraIgracke;
        this.igracka = igracka;
        this.kolicina = kolicina;
        this.cena = cena;
        this.narudzbenica = narudzbenica;
    }

    public StavkaNarudzbenice() {
    }


    @JsonIgnore
    public StavkaId getStavkaID() {
        return id;
    }

    public void setStavkaID(StavkaId id) {
        this.id = id;
    }

    public String getSifraIgracke() {
        return sifraIgracke;
    }

    public void setSifraIgracke(String sifraIgracke) {
        this.sifraIgracke = sifraIgracke;
    }

    public String getIgracka() {
        return igracka;
    }

    public void setIgracka(String igracka) {
        this.igracka = igracka;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }


    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public StavkaId getId() {
        return id;
    }

    public void setId(StavkaId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "StavkaNarudzbenice{" + "id=" + id + ", sifraIgracke=" + sifraIgracke + ", igracka=" + igracka + ", kolicina=" + kolicina +  ", cena=" + cena + ", narudzbenica=" + narudzbenica + '}';
    }

 
    
}
