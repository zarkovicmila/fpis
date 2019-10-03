/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.controller.dto.NarudzbenicaDTO;
import com.spring.controller.dto.StavkaNarudzbeniceDTO;
import com.spring.entity.Narudzbenica;
import com.spring.entity.StavkaId;
import com.spring.entity.StavkaNarudzbenice;
import com.spring.service.NarudzbenicaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author milaz
 */
@RestController
@RequestMapping(value = "/narudzbenica")
@CrossOrigin
public class NarudzbenicaController {

    private NarudzbenicaService narudzbenicaService;
    private ModelMapper modelMapper;

    public NarudzbenicaController(NarudzbenicaService narudzbenicaService, ModelMapper modelMapper) {
        this.narudzbenicaService = narudzbenicaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(value = "/all")
    public List<NarudzbenicaDTO> findAll() {
        List<Narudzbenica> narudzbenice = narudzbenicaService.findAll();
        return narudzbenice.stream().map(n -> modelMapper.map(n, NarudzbenicaDTO.class)).collect(Collectors.toList());

    }

    @PostMapping(value = "/new")
    public Narudzbenica save(@RequestBody NarudzbenicaDTO dto) {
        Narudzbenica narudzbenica = modelMapper.map(dto, Narudzbenica.class);
        for (StavkaNarudzbenice sn : narudzbenica.getStavke()) {
            sn.setId(new StavkaId(0, dto.getStavke().get(narudzbenica.getStavke().indexOf(sn)).getRb()));
        }
        narudzbenicaService.saveOrUpdate(narudzbenica);
        return narudzbenica;
    }

    @GetMapping(value = "/all/{id}")
    public NarudzbenicaDTO findById(@PathVariable int id) {
        Narudzbenica narudzbenica = narudzbenicaService.findById(id);
        return modelMapper.map(narudzbenica, NarudzbenicaDTO.class);
    }

    @DeleteMapping(value = "/all/{id}/delete")
    public void delete(@PathVariable int id) {
        narudzbenicaService.delete(id);
    }

    @PostMapping(value = "/all/{id}/update")
    public Narudzbenica update(@PathVariable int id, @RequestBody NarudzbenicaDTO dto) {
        Narudzbenica narudzbenica = modelMapper.map(dto, Narudzbenica.class);
        
        if (narudzbenica.getStavke()!= null) {    
            for (StavkaNarudzbenice sn : narudzbenica.getStavke()) {
            sn.setId(new StavkaId(id, dto.getStavke().get(narudzbenica.getStavke().indexOf(sn)).getRb()));
            }
        }

        narudzbenicaService.saveOrUpdate(narudzbenica);
        return narudzbenica;
    }

    @GetMapping(value = "/filter")
    public List<NarudzbenicaDTO> filter(@RequestParam(value = "naziv", required = false) String naziv,
            @RequestParam(value = "datumOd", required = false) String datumOd,
            @RequestParam(value = "datumDo", required = false) String datumDo) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        List<Narudzbenica> narudzbenice = new ArrayList<>();
        try {
            Date datOd = null, datDo = null;
            if (datumOd != null) {
                datOd = sdf.parse(datumOd);
            }
            if (datumDo != null) {
                datDo = sdf.parse(datumDo);
            }
            narudzbenice = narudzbenicaService.filter(datOd, datDo, naziv);
        } catch (ParseException ex) {
            Logger.getLogger(NarudzbenicaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return narudzbenice.stream().map(narudzbenica -> modelMapper.map(narudzbenica, NarudzbenicaDTO.class)).collect(Collectors.toList());
    }

    
     private NarudzbenicaDTO mapirajNarudzbenicu(Narudzbenica narudzbenica) {
        NarudzbenicaDTO narudzbenicaDto = modelMapper.map(narudzbenica, NarudzbenicaDTO.class);
        if (narudzbenica.getStatus()!= null) {
            for (StavkaNarudzbeniceDTO sn : narudzbenicaDto.getStavke()) {
                StavkaId id = narudzbenica.getStavke().get(narudzbenicaDto.getStavke().indexOf(sn)).getId();
                sn.setRb(id.getRb());
                sn.setNanarudzbenica_narudzbenicaID(id.getNarudzbenica_narudzbenicaID());
            }
        }
      
        return narudzbenicaDto;
    }
    
}
