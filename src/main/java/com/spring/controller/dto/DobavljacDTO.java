/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller.dto;

import java.io.Serializable;

/**
 *
 * @author milaz
 */
public class DobavljacDTO implements Serializable{
   private int dobavljacID;
    private String naziv;
    private String pib;
    private String adresa;
    private String telefon;
    private String email;
    

    public DobavljacDTO() {
    }

    public DobavljacDTO(int dobavljacID, String naziv, String pib, String adresa, String telefon, String email) {
        this.dobavljacID = dobavljacID;
        this.naziv = naziv;
        this.pib = pib;
        this.adresa = adresa;
        this.telefon = telefon;
        this.email = email;
    }

    public int getDobavljacID() {
        return dobavljacID;
    }

    public void setDobavljacID(int dobavljacID) {
        this.dobavljacID = dobavljacID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dobavljac{" + "dobavljacID=" + dobavljacID + ", naziv=" + naziv + ", pib=" + pib + ", adresa=" + adresa + ", telefon=" + telefon + ", email=" + email + '}';
    }

}
