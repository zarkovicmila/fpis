/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entity.Narudzbenica;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milaz
 */
@Repository
public interface NarudzbenicaRepository extends JpaRepository<Narudzbenica, Integer>{

    @Query("select n from Narudzbenica n " +
         "where n.datum between ?1 and ?2")
  List<Narudzbenica> findByDatesBetween(Date datumOd, Date datumDo);
  List<Narudzbenica> findByDobavljacNaziv(String naziv);  
}
