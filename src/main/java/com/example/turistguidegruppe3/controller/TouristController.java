package com.example.turistguidegruppe3.controller;

import com.example.turistguidegruppe3.model.TouristAttraction;
import com.example.turistguidegruppe3.service.TouristService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        TouristAttraction t = service.findTouristAttractionByName(name);

        if (t != null) {
            return new ResponseEntity<>(t, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addTouristAttraction(@RequestBody TouristAttraction touristAttraction) {
        if (touristAttraction != null) {
            service.getTouristAttractions().add(touristAttraction);
            return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateTouristAttraction(@RequestBody TouristAttraction touristAttraction) {

        if (service.helperForUpdate(touristAttraction) != null) {
                return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping("/seeAll")
    public ResponseEntity<ArrayList<TouristAttraction>> seeAllTest() {
        return new  ResponseEntity<>(service.getTouristAttractions(), HttpStatus.ACCEPTED);
    }


    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {

        TouristAttraction t = service.findTouristAttractionByName(name);

        if (t != null) {
            service.getTouristAttractions().remove(t);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
