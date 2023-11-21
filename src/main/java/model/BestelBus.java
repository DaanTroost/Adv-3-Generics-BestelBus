package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program
 */
public class BestelBus<T extends Weighable> {
    private String name;
    private int cargoMassCapacity;
    private int cargoTotalMass;
    private List<T> cargoList;

    public BestelBus(String name,
                     int cargoMassCapacity){
        this.name = name;
        this.cargoMassCapacity = cargoMassCapacity;
        this.cargoList = new ArrayList<>();
    }

    public void loadCargo(T cargo){
        if (cargoTotalMass + cargo.getGewicht() > cargoMassCapacity){
            return;
        } else if (cargo.getGewicht() >= 0){
            cargoList.add(cargo);
            cargoTotalMass += cargo.getGewicht();
        }
    }

    public List<T> getCargoList(){
        return this.cargoList;
    }





} // end of BestelBus