/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.repository;

import com.spring.entity.Dobavljac;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author milaz
 */
@Repository
public interface DobavljacRepository extends JpaRepository<Dobavljac, Integer>{

    public Optional<Dobavljac> findByPib(String pib);
 
}
