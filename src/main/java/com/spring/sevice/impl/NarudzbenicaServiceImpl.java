/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.sevice.impl;

import com.spring.entity.Dobavljac;
import com.spring.entity.Narudzbenica;
import com.spring.entity.StavkaId;
import com.spring.entity.StavkaNarudzbenice;
import com.spring.repository.NarudzbenicaRepository;
import com.spring.repository.StavkaNarudzbeniceRepository;
import com.spring.service.NarudzbenicaService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author milaz
 */
@Service
@Transactional
public class NarudzbenicaServiceImpl implements NarudzbenicaService {

    private NarudzbenicaRepository narudzbenicaRepository;
    private StavkaNarudzbeniceRepository stavkaNarudzbeniceRepository;
    private EntityManager entityManager;

    public NarudzbenicaServiceImpl(NarudzbenicaRepository narudzbenicaRepository, StavkaNarudzbeniceRepository stavkaNarudzbeniceRepository, EntityManager entityManager) {
        this.narudzbenicaRepository = narudzbenicaRepository;
        this.stavkaNarudzbeniceRepository = stavkaNarudzbeniceRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Narudzbenica> findAll() {
        return narudzbenicaRepository.findAll();
    }

    @Override
    public Narudzbenica findById(int id) {
        Optional<Narudzbenica> optional = narudzbenicaRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public Narudzbenica saveOrUpdate(Narudzbenica narudzbenica) {
        Narudzbenica saved = findById(narudzbenica.getNarudzbenicaID());

        if (saved != null) {
            stavkaNarudzbeniceRepository.deleteByNarudzbenica_narudzbenicaID(saved.getNarudzbenicaID());

            if (narudzbenica.getStavke() != null) {
                for (StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getStavke()) {
                    stavkaNarudzbenice.setNarudzbenica(new Narudzbenica(saved.getNarudzbenicaID(), null, BigDecimal.valueOf(0), null, null, null));
                    int rb = stavkaNarudzbenice.getStavkaID().getRb();
                    stavkaNarudzbenice.setStavkaID(new StavkaId(saved.getNarudzbenicaID(), rb));
                }
                stavkaNarudzbeniceRepository.saveAll(narudzbenica.getStavke());
            }
            saved = narudzbenicaRepository.save(narudzbenica);
        } else {

            saved = narudzbenicaRepository.save(narudzbenica);
            if (narudzbenica.getStavke() != null) {
                for (StavkaNarudzbenice stavkaNarudzbenice : narudzbenica.getStavke()) {
                    stavkaNarudzbenice.setNarudzbenica(new Narudzbenica(saved.getNarudzbenicaID(), null, BigDecimal.valueOf(0), null, null, null));
                    int rb = stavkaNarudzbenice.getStavkaID().getRb();
                    stavkaNarudzbenice.setStavkaID(new StavkaId(saved.getNarudzbenicaID(), rb));
                }
                stavkaNarudzbeniceRepository.saveAll(narudzbenica.getStavke());
            }
        }
        return saved;
    }

    @Override
    public void delete(int id) {
        narudzbenicaRepository.deleteById(id);
    }

    @Override
    public List<Narudzbenica> search(Date datumOd, Date datumDo) {
        return narudzbenicaRepository.findByDatesBetween(datumOd, datumDo);
    }

    @Override
    public List<Narudzbenica> findAllDobavljac(String naziv) {
        return narudzbenicaRepository.findByDobavljacNaziv(naziv);
    }

    @Override
    public List<Narudzbenica> filter(Date datumOd, Date datumDo, String naziv) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery();
        Root<Narudzbenica> narudzbenica = query.from(Narudzbenica.class);
        Join<Narudzbenica, Dobavljac> join = narudzbenica.join("dobavljac");

        List<Predicate> predicates = new ArrayList<>();
        Predicate p;
        if (naziv != null) {
            predicates.add(cb.like(join.get("naziv"), naziv + "%"));
        }
        if (datumOd != null) {
            p = cb.greaterThanOrEqualTo(narudzbenica.get("datum"), datumOd);
            predicates.add(p);

        }
        if (datumDo != null) {
            p = cb.lessThanOrEqualTo(narudzbenica.get("datum"), datumDo);
            predicates.add(p);

        }
        query.select(narudzbenica).where(predicates.toArray(new Predicate[]{}));
        List<Narudzbenica> narudzbenice = entityManager.createQuery(query).getResultList();
        return narudzbenice;

    }

}
