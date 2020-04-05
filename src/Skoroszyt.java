import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Skoroszyt extends ArrayList<Notatka> {


    public void pokazWszystkie() {
        Iterator iterator = this.iterator();
        System.out.println("Wszystkie notatki:");
        while (iterator.hasNext()) {
            Notatka n = (Notatka) iterator.next();
            System.out.println(n);
        }
        System.out.println();
    }


    boolean zapiszDoPliku(String nazwaPliku) {
        try {
            FileOutputStream strumienPlikowy = new FileOutputStream(nazwaPliku);
            ObjectOutputStream strumienObiektowy = new ObjectOutputStream(strumienPlikowy);
            strumienObiektowy.writeObject(this);
            strumienObiektowy.close();
            strumienPlikowy.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("!Błąd strumienia plikowego");
            return false;
        } catch (IOException e) {
            System.out.println("!Błąd strumienia obiektowego");
            return false;
        }
    }

    static Skoroszyt odczytZPliku(String nazwaPliku) {
        try {
            FileInputStream strumienPlikowy = new FileInputStream(nazwaPliku);
            ObjectInputStream strumienObiektowy = new ObjectInputStream(strumienPlikowy);
            Skoroszyt s = (Skoroszyt) strumienObiektowy.readObject();
            strumienObiektowy.close();
            strumienPlikowy.close();
            return s;
        } catch (FileNotFoundException e) {
            System.out.println("!Błąd strumienia plikowego");
            return null;
        } catch (IOException e) {
            System.out.println("!Błąd strumienia obiektowego");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("!Błąd konwersji do docelowego typu");
            return null;
        }

    }
}
