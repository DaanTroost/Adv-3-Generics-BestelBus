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
            return;
        } else if (pakket.getGewicht() + totaalGewicht > maximumGewicht){
            return;
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
        if (lading.isEmpty()){
            return null;
        } else {
            return zoekZwaarstePakket(0);
        }
    }

    private Pakket zoekZwaarstePakket(int index){
        if (lading.size() == index){
            return lading.get(index - 1);
        }
        Pakket zwaarstePakket = zoekZwaarstePakket(index + 1);
        if (lading.get(index).getGewicht() > zwaarstePakket.getGewicht()) {
            return lading.get(index);
        } else {
            return zwaarstePakket;
        }
    }
}