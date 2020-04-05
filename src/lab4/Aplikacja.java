package lab4;


import java.util.Collections;
import java.util.logging.Logger;

public class Aplikacja {

    public static  final String NAZWA_PLIKU = "moje_notatki.bin";
    private final static Logger LOGGER = Logger.getLogger(Aplikacja.class.getName());


    private void dodawanieNotatek(){
        Notatka notatka1 = Notatka.zanotuj("Pierwsza");
        Notatka notatka2 = Notatka.zanotuj("Druga");
        Notatka notatka3 = Notatka.zanotuj("Trzecia notatka");
        Notatka notatka4 = Notatka.zanotuj("Czwarta notatka");
        Notatka notatka5 = Notatka.zanotuj("Piąta notatka");
        Notatka notatka6 = Notatka.zanotuj("Szósta notatka");
        Notatka notatka7 = Notatka.zanotuj("Siódma notatka");
        Notatka notatka8 = Notatka.zanotuj("Ósma notatka");


        zmienTresc(notatka1,"Bla bla bla");
        zmienTresc(notatka2,"Inna treść");
        zmienTresc(notatka3,"Znowu inna treść");
        zmienTresc(notatka4,"Wersja ostateczna");

        Skoroszyt skoroszyt = new Skoroszyt();
        System.out.println(Skoroszyt.class);
        skoroszyt.add(notatka3);

        skoroszyt.add(notatka1);
        skoroszyt.add(notatka2);
        skoroszyt.add(notatka4);
        skoroszyt.forEach(System.out::println);
        System.out.println();
        skoroszyt.add(notatka5);
        skoroszyt.forEach(System.out::println);
        System.out.println();
        skoroszyt.add(notatka6);
        skoroszyt.forEach(System.out::println);
        System.out.println();
        skoroszyt.add(notatka7);
        skoroszyt.forEach(System.out::println);
        System.out.println();
        skoroszyt.add(notatka8);
        skoroszyt.forEach(System.out::println);
        System.out.println();

        Collections.sort(skoroszyt);
        skoroszyt.zapiszDoPliku(NAZWA_PLIKU);
    }

    public void zmienTresc(Notatka notatka, String tresc){

        if (!notatka.zmienTresc(tresc))
            LOGGER.info("notatka nr "+ notatka.getNr()+ " została już zmodyfikowana 3 razy");
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
        System.out.println("lab4.Aplikacja do notowania");
        dodawanieNotatek();
        czytanieNotatek();
    }

}
