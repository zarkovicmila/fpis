/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.controller;

import com.spring.controller.dto.DobavljacDTO;
import com.spring.entity.Dobavljac;
import com.spring.service.DobavljacService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
@RequestMapping(value = "/dobavljaci")
@CrossOrigin
public class DobavljacController {

    private DobavljacService dobavljacService;
    private ModelMapper modelMapper;

    public DobavljacController(DobavljacService dobavljacService, ModelMapper modelMapper) {
        this.dobavljacService = dobavljacService;
        this.modelMapper = modelMapper;
    }

    @PostMapping(value = "/new")
    public Dobavljac save(@RequestBody DobavljacDTO dto) {
       Dobavljac dobavljvac = modelMapper.map(dto, Dobavljac.class);
       dobavljacService.saveOrUpdate(dobavljvac);
       return dobavljvac;
    }
    
    @PutMapping(value = "/update/{id}")
    public Dobavljac update(@RequestBody DobavljacDTO dto, @PathVariable int id) {
       Dobavljac dobavljvac = modelMapper.map(dto, Dobavljac.class);
       dobavljacService.saveOrUpdate(dobavljvac);
       return dobavljvac;
    }

    @GetMapping("")
    public List<DobavljacDTO> findAll() {
        List<Dobavljac> dobavljaci = dobavljacService.findAll();
        return dobavljaci.stream().map(dobaljvac -> modelMapper.map(dobaljvac, DobavljacDTO.class)).collect(Collectors.toList());
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        dobavljacService.delete(id);
        
    }
    @GetMapping(value = "/{id}")
    public DobavljacDTO findById(@PathVariable int id){
        Dobavljac dobavljac = dobavljacService.findById(id);
        return modelMapper.map(dobavljac, DobavljacDTO.class);
    }
    
    @GetMapping(value = "/search")
    public List<DobavljacDTO> search(@RequestParam(value = "naziv", required = false) String naziv, @RequestParam(value = "adresa", required = false) String adresa){
        List<Dobavljac> dobavljaci = dobavljacService.search(naziv, adresa);
        return dobavljaci.stream().map(dobavljac -> modelMapper.map(dobavljac, DobavljacDTO.class)).collect(Collectors.toList());
                
    }
    @GetMapping(value = "/pib")
    public DobavljacDTO findByPib(@RequestParam(value = "pib", required = true) String pib){
        Dobavljac dobavljac = dobavljacService.findByPib(pib);
        return modelMapper.map(dobavljac, DobavljacDTO.class);
    }
    
    
}
