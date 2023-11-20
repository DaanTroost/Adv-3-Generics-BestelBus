package model;

import java.util.ArrayList;
import java.util.List;

public class PakkettenBus {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<Pakket> lading;

    public PakkettenBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadPakket(Pakket pakket) {
        if (pakket.getGewicht() < 0) {
            throw new IllegalArgumentException("Het gewicht is negatief!");
        } else if (pakket.getGewicht() + totaalGewicht > maximumGewicht){
            throw new IllegalArgumentException("Het inladen van dit pakket overschrijdt het " +
                    "maximumgewicht. Pakket niet toegevoegd.");
        } else {
            lading.add(pakket);
            totaalGewicht += pakket.getGewicht();
        }

    }

    public List<Pakket> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public Pakket zoekZwaarstePakket() {
       return null;
    }

}