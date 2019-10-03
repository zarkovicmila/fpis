/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entity.StavkaId;
import com.spring.entity.StavkaNarudzbenice;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milaz
 */
@Repository
public interface StavkaNarudzbeniceRepository extends JpaRepository<StavkaNarudzbenice,StavkaId>{

    public void deleteByNarudzbenica_narudzbenicaID(int narudzbenicaID);

    
}
