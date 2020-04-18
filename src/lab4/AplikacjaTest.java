package lab4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;


public class AplikacjaTest {
    private final static Logger LOGGER = Logger.getLogger(AplikacjaTest.class.getName());

    @Test
    public void zadanie2() {

        Notatka notatka1 = Notatka.zanotuj("Pierwsza");
        LOGGER.info("notatka nr " + notatka1.getNr() + " została zmodyfikowana 1 raz");
        for (int licznik = 1; licznik < 3; ) {
            notatka1.zmienTresc("zmiana " + licznik++);
            LOGGER.info("notatka nr " + notatka1.getNr() + " została zmodyfikowana " + licznik + " raz");
            if (licznik == 3){
                LOGGER.info("PODEJŚCIE NUMER 4. Pozytywny przejście testu oznacza odmowę edycji");
                assertFalse(notatka1.zmienTresc("zmiana " + licznik));
            }
        }

    }
}