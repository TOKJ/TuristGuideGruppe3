package com.example.turistguidegruppe3.repository;

import com.example.turistguidegruppe3.model.TouristAttraction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;


@Repository
public class TouristRepository {
    private final ArrayList<TouristAttraction> touristAttractions = new ArrayList<>();
    private String touristAttractionName;

    public TouristRepository() {
        populateTouristAttractions();
    }

    public void populateTouristAttractions() {
        TouristAttraction t1 = new TouristAttraction("Den Lille Havfrue","Verdenskendt statue inspireret af H.C. Andersens eventyr, beliggende ved Københavns havn.");
        TouristAttraction t2 = new TouristAttraction("Nyhavn", "Farverig havnefront med historiske bygninger, restauranter og caféer.");
        TouristAttraction t3 = new TouristAttraction("Rundetårn", "Historisk tårn med spiralrampe og udsigt over Københavns skyline.");
        TouristAttraction t4 = new TouristAttraction("Amalienborg", "De danske kongers vinterresidens og et centralt symbol på monarkiet.");
        TouristAttraction t5 = new TouristAttraction("Nationalmuseet", "Danmarks største kulturhistoriske museum med udstillinger fra hele verden.");
        TouristAttraction t6 = new TouristAttraction("Christiania","Unikt fristadssamfund kendt for alternativ livsstil, kunst og kultur.");

        touristAttractions.add(t1);
        touristAttractions.add(t2);
        touristAttractions.add(t3);
        touristAttractions.add(t4);
        touristAttractions.add(t5);
        touristAttractions.add(t6);
    }



    public ArrayList<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);
    }

    public TouristAttraction findTouristAttractionByName(String nameToFind) {
        for (TouristAttraction t : touristAttractions) {
            if (nameToFind.equalsIgnoreCase(t.getName())) {
                return t;
            }
        }
        return null;
    }



    //Vi bruger standard for-loop da vi bruger "ArrayList.set()" method til at "sette" et nyt object på et
    // eksisterende object.
    public TouristAttraction helperForUpdate(TouristAttraction touristAttraction) {

        for (int i = 0; i < getTouristAttractions().size(); i++) {
            TouristAttraction ta = getTouristAttractions().get(i);

            if (touristAttraction.getName().equalsIgnoreCase(ta.getName())) {
                getTouristAttractions().set(i, touristAttraction);
                return touristAttraction;
            }
        }
        return null;
    }



}
