package com.example.turistguidegruppe3.controller;

import com.example.turistguidegruppe3.model.TouristAttraction;
import com.example.turistguidegruppe3.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    /*
    http://localhost:8080/attractions/{name}
     */

    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getTouristAttractionByName(@PathVariable String name) {
        TouristAttraction t = service.getTouristAttractionByName(name);

        if (t != null) {
            return new ResponseEntity<>(t, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    //TODO: post /attractions/add



    //TODO: post /atractions/update



    //TODO: post /attractions/delete/{name}



}
