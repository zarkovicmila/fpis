/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author milaz
 */
@Embeddable
public class StavkaId implements Serializable{
    
    private int narudzbenica_narudzbenicaID;
    private int rb;

   
    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public StavkaId() {
    }

    public StavkaId(int narudzbenica_narudzbenicaID, int rb) {
        this.narudzbenica_narudzbenicaID = narudzbenica_narudzbenicaID;
        this.rb = rb;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.narudzbenica_narudzbenicaID;
        hash = 47 * hash + this.rb;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StavkaId other = (StavkaId) obj;
//        if (this.narudzbenica_narudzbenicaID != other.narudzbenica_narudzbenicaID) {
//            return false;
//        }
        if (this.rb != other.rb) {
            return false;
        }
        return true;
    }

    public int getNarudzbenica_narudzbenicaID() {
        return narudzbenica_narudzbenicaID;
    }

    public void setNarudzbenica_narudzbenicaID(int narudzbenica_narudzbenicaID) {
        this.narudzbenica_narudzbenicaID = narudzbenica_narudzbenicaID;
    }


}
