package com.example.turistguidegruppe3.service;

import com.example.turistguidegruppe3.model.TouristAttraction;
import com.example.turistguidegruppe3.repository.TouristRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class TouristService {
    private final TouristRepository repository;


    public TouristService(TouristRepository repository) {
        this.repository = repository;
    }

    public ArrayList<TouristAttraction> GetAttractions(){
        return repository.getAllAttractions();
    }


}
