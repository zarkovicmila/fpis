/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service;

import com.spring.entity.Narudzbenica;
import com.spring.entity.StavkaId;
import com.spring.entity.StavkaNarudzbenice;
import java.util.Date;
import java.util.List;

/**
 *
 * @author milaz
 */
public interface NarudzbenicaService {
    public List<Narudzbenica> findAll();
    public Narudzbenica findById(int id);
    public Narudzbenica saveOrUpdate(Narudzbenica narudzbenica);
    public void delete(int id);
    public List<Narudzbenica> search(Date datumOd, Date datumDo);
    public List<Narudzbenica> findAllDobavljac(String naziv);
    public List<Narudzbenica> filter(Date datumOd, Date datumDo, String naziv);
}
