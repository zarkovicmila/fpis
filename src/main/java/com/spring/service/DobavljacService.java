/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.service;

import com.spring.entity.Dobavljac;
import java.util.List;

/**
 *
 * @author milaz
 */
public interface DobavljacService {
    public List<Dobavljac> findAll();
    public Dobavljac findById(int id);
    public void saveOrUpdate(Dobavljac dobavljac);
    public void delete(int id);
    public List<Dobavljac> search(String naziv, String adresa);

    public Dobavljac findByPib(String pib);

}
