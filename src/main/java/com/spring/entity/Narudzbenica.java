/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


/**
 *
 * @author milaz
 */
@Entity
public class Narudzbenica implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int narudzbenicaID;
    @Temporal(TemporalType.DATE)
    private Date datum;
    private BigDecimal iznos;
    private String status;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "dobavljacID")                
    private Dobavljac dobavljac;
    @OneToMany(mappedBy = "narudzbenica",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StavkaNarudzbenice> stavke;

    public Narudzbenica() {
    }

    public Narudzbenica(int narudzbenicaID, Date datum, BigDecimal iznos, String status, Dobavljac dobavljac, List<StavkaNarudzbenice> stavke) {
        this.narudzbenicaID = narudzbenicaID;
        this.datum = datum;
        this.iznos = iznos;
        this.status = status;
        this.dobavljac = dobavljac;
        this.stavke = stavke;
    }
    
    

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

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public List<StavkaNarudzbenice> getStavke() {
        return stavke;
    }

    public void setStavke(List<StavkaNarudzbenice> stavke) {
        this.stavke = stavke;
    }

    @Override
    public String toString() {
        return "Narudzbenica{" + "narudzbenicaID=" + narudzbenicaID + ", datum=" + datum + ", iznos=" + iznos + ", status=" + status + ", dobavljac=" + dobavljac + ", stavke=" + stavke + '}';
    }
    
    
    
    
}
