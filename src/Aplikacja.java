import java.util.Collection;
import java.util.Collections;

public class Aplikacja {

    public static  final String NAZWA_PLIKU = "moje_notatki.bin";

    int licznikZmian=0;

    private void dodawanieNotatek(){
        Notatka notatka1 = Notatka.zanotuj("Pierwsza");
        Notatka notatka2 = Notatka.zanotuj("Druga");
        Notatka notatka3 = Notatka.zanotuj("Trzecia notatka");
        Notatka notatka4 = Notatka.zanotuj("Czwarta notatka");


        notatka1.zmienTresc("Bla bla bla");
        notatka2.zmienTresc("Inna treść");
        notatka3.zmienTresc("Znowu inna treść");
        notatka4.zmienTresc("Wersja ostateczna");

        Skoroszyt skoroszyt = new Skoroszyt();

        skoroszyt.add(notatka3);
        skoroszyt.add(notatka1);
        skoroszyt.add(notatka2);
        skoroszyt.add(notatka4);

        Collections.sort(skoroszyt);
        skoroszyt.zapiszDoPliku(NAZWA_PLIKU);
    }


    private void czytanieNotatek(){
        Skoroszyt s = Skoroszyt.odczytZPliku(NAZWA_PLIKU);

        if (s != null){
            s.pokazWszystkie();
        } else {
            System.out.println("!Nie udało się odczytać pliku");
        }

    }

    void uruchom(){
        System.out.println("Aplikacja do notowania");
        dodawanieNotatek();
        czytanieNotatek();
    }

}
