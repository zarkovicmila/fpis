/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sevice.impl;

import com.spring.entity.Dobavljac;
import com.spring.repository.DobavljacRepository;
import com.spring.service.DobavljacService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author milaz
 */
@Service
@Transactional
public class DobavljacServiceImpl implements DobavljacService{

   
    private DobavljacRepository dobavljacRepository;
    private EntityManager entityManager;

    public DobavljacServiceImpl(DobavljacRepository dobavljacRepository, EntityManager entityManager) {
        this.dobavljacRepository = dobavljacRepository;
        this.entityManager = entityManager;
    }
    
    @Override
    public List<Dobavljac> findAll() {
        return dobavljacRepository.findAll();
    }

    @Override
    public Dobavljac findById(int id) {
        Optional<Dobavljac> optional = dobavljacRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public void saveOrUpdate(Dobavljac dobavljac) {
        dobavljacRepository.save(dobavljac);
    }

    @Override
    public void delete(int id) {
       dobavljacRepository.deleteById(id);
    }

  
    @Override
    public List<Dobavljac> search(String naziv, String adresa) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Dobavljac> dobavljac = query.from(Dobavljac.class);
        
        List<Predicate> predicates = new ArrayList<>();
        if(naziv!=null){
            predicates.add(cb.like(dobavljac.get("naziv"), naziv+"%"));
        }
         if(adresa!=null){
            predicates.add(cb.like(dobavljac.get("adresa"), "%"+adresa+"%"));
        }
        query.select(dobavljac).where(predicates.toArray(new Predicate[]{}));
        List<Dobavljac> dobavljaci = entityManager.createQuery(query).getResultList();
        return dobavljaci;
    }

    @Override
    public Dobavljac findByPib(String pib) {
        Optional<Dobavljac> optional = dobavljacRepository.findByPib(pib);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    
}
