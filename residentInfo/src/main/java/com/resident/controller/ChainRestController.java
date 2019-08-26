package com.resident.controller;

import com.resident.entity.buliding.Building;
import com.resident.entity.buliding.Flat;
import com.resident.repo.FlatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest/")
public class ChainRestController {
    @Autowired
    private FlatRepo flatRepo;

    @GetMapping(value = "flat/{id}")
    public ResponseEntity<Iterable<Flat>> flatByBuilding(@PathVariable("id") Long id) {
        Iterable<Flat> flats = this.flatRepo.findAllByBuilding(new Building(id));
        return new ResponseEntity<>(flats, HttpStatus.OK);
    }

}