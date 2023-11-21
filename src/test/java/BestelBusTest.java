import model.BestelBus;
import model.Pakket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program: testing behaviour of BestelBus generic
 */
public class BestelBusTest {
    private BestelBus testBus;

    @Test
    void ladingTeZwaarWeigeren(){
        maakBus("pakket");
        Pakket pakket1 = new Pakket("Jantje", "snoep", 15);
        Pakket pakket2 = new Pakket("Kees", "laptop", 5);
        Pakket pakket3 = new Pakket("Michael", "PS5", 7);
        testBus.loadCargo(pakket1);
        testBus.loadCargo(pakket2);
        testBus.loadCargo(pakket3);

        Pakket pakket4 = new Pakket("Tom", "Stoel", 20);
        testBus.loadCargo(pakket4);

        Assertions.assertEquals(3, testBus.getCargoList().size());
    }




    private void maakBus(String type){
        switch (type){
            case "pakket":
                testBus = new BestelBus<Pakket>("Zwarte Bus", 40);
                break;
            default:
                return;
        }
    }

} // end of BestelBusTest