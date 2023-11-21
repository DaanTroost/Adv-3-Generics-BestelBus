import model.BestelBus;
import model.Pakket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Daan Troost <dq.troost@st.hanze.nl>
 * Purpose of the program: testing behaviour of BestelBus generic
 */
public class BestelBusTest {
    private BestelBus<Pakket> pakketBestelBusTest;

    @Test
    void ladingTeZwaarWeigeren(){
        maakBus("pakket");
        Pakket pakket1 = new Pakket("Jantje", "snoep", 15);
        Pakket pakket2 = new Pakket("Kees", "laptop", 5);
        Pakket pakket3 = new Pakket("Michael", "PS5", 7);
        pakketBestelBusTest.loadCargo(pakket1);
        pakketBestelBusTest.loadCargo(pakket2);
        pakketBestelBusTest.loadCargo(pakket3);

        Pakket pakket4 = new Pakket("Tom", "Stoel", 20);
        pakketBestelBusTest.loadCargo(pakket4);

        Assertions.assertEquals(3, pakketBestelBusTest.getCargoList().size());
    }




    private void maakBus(String type){
        switch (type){
            case "pakket":
                pakketBestelBusTest = new BestelBus<Pakket>("Zwarte Bus", 40);
                break;
            default:
                return;
        }
    }

} // end of BestelBusTest