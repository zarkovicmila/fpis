/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller.dto;

import com.spring.entity.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



/**
 *
 * @author milaz
 */

public class NarudzbenicaDTO implements Serializable{
    
      
    private int narudzbenicaID;
    private Date datum;
    private BigDecimal iznos;
    private String status;              
    private DobavljacDTO dobavljac;
    private List<StavkaNarudzbeniceDTO> stavke;

    public int getNarudzbenicaID() {
        return narudzbenicaID;
    }

    public void setNarudzbenicaID(int narudzbenicaID) {
        this.narudzbenicaID = narudzbenicaID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public BigDecimal getIznos() {
        return iznos;
    }

    public void setIznos(BigDecimal iznos) {
        this.iznos = iznos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DobavljacDTO getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(DobavljacDTO dobavljac) {
        this.dobavljac = dobavljac;
    }

    public List<StavkaNarudzbeniceDTO> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaNarudzbeniceDTO> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Narudzbenica{" + "narudzbenicaID=" + narudzbenicaID + ", datum=" + datum + ", iznos=" + iznos + ", status=" + status + ", dobavljac=" + dobavljac + ", stavke=" + stavke + '}';
    }
    
    
    
    
}
