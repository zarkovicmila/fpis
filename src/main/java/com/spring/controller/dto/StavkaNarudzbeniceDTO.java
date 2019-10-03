/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.entity.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 *
 * @author milaz
 */

public class StavkaNarudzbeniceDTO implements Serializable{
  

    private int narudzbenica_narudzbenicaID;
    private int rb;
    private String sifraIgracke;
    private String igracka;
    private int kolicina;
    private BigDecimal cena;  
    @JsonIgnore
    private NarudzbenicaDTO narudzbenica;

    public StavkaNarudzbeniceDTO() {
    }

    public StavkaNarudzbeniceDTO(int narudzbenica_narudzbenicaID, int rb, String sifraIgracke, String igracka, int kolicina, BigDecimal cena, NarudzbenicaDTO narudzbenica) {
        this.narudzbenica_narudzbenicaID = narudzbenica_narudzbenicaID;
        this.rb = rb;
        this.sifraIgracke = sifraIgracke;
        this.igracka = igracka;
        this.kolicina = kolicina;
        this.cena = cena;
        this.narudzbenica = narudzbenica;
    }


    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getRb() {
        return rb;
    }

    public int getNarudzbenica_narudzbenicaID() {
        return narudzbenica_narudzbenicaID;
    }

    public void setNanarudzbenica_narudzbenicaID(int narudzbenica_narudzbenicaID) {
        this.narudzbenica_narudzbenicaID = narudzbenica_narudzbenicaID;
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

    public NarudzbenicaDTO getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(NarudzbenicaDTO narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    @Override
    public String toString() {
        return "StavkaNarudzbeniceDTO{" + "narudzbenicaID=" + narudzbenica_narudzbenicaID + ", rb=" + rb + ", sifraIgracke=" + sifraIgracke + ", igracka=" + igracka + ", kolicina=" + kolicina + ", cena=" + cena + ", narudzbenica=" + narudzbenica + '}';
    }

    
    
    
    
}
