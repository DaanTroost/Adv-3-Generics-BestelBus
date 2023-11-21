package controller;

import model.BestelBus;
import model.Pakket;
import model.PakketLezer;
import model.PakkettenBus;

import java.util.List;

public class BusLauncher {

    public static void main(String[] args) {
//        PakkettenBus kuBus = new PakkettenBus("rode bus", 170);
        BestelBus<Pakket> griezelBus= new BestelBus<>("rode pakkettenbus", 170);
        List<Pakket> lijstVanBestand;
        PakketLezer lezerBestand = new PakketLezer();
        lijstVanBestand = lezerBestand.leesPakketLijst("src/main/resources/pakketlijst.txt");
        System.out.println(lijstVanBestand);
        for (Pakket p : lijstVanBestand) {
            griezelBus.loadCargo(p);
        }
        System.out.println(griezelBus.findHeaviestCargo());
    }
}