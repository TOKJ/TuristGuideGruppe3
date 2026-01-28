package com.example.turistguidegruppe3.controller;

import com.example.turistguidegruppe3.model.TouristAttraction;
import com.example.turistguidegruppe3.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService service;

    /*
    Receives service in constructor, that is used for getters that gives the list needed.
     */

    public TouristController(TouristService service) {
        this.service = service;
    }

    /*
    http://localhost:8080/attractions
     */

    @GetMapping()
    public ResponseEntity<ArrayList<TouristAttraction>> getTouristAttractions() {
        ArrayList<TouristAttraction> touristAttractions = service.getTouristAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    //TODO: get /attractions/{name}



    //TODO: post /attractions/add



    //TODO: post /atractions/update



    //TODO: post /attractions/delete/{name}



}
