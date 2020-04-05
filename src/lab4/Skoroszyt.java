package lab4;

import java.io.*;
import java.util.*;

public class Skoroszyt extends LinkedList<Notatka> {



    public void pokazWszystkie() {
        Iterator iterator = this.iterator();
        System.out.println("Wszystkie notatki:");
        while (iterator.hasNext()) {
            Notatka n = (Notatka) iterator.next();
            System.out.println(n);
        }
        System.out.println();

        pokazNajstarsza();
        pokazNajnowsza();
    }

    private void pokazNajnowsza() {
        System.out.println("Najnowsze");
        System.out.println(Collections.max(this));
    }

    private void pokazNajstarsza() {
        System.out.println("Najstarsze");
        System.out.println(Collections.min(this));
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

    @Override
    public boolean add(Notatka notatka) {
        if (this.size() < 5){
        return super.add(notatka); }
        else
        {
            super.removeFirst();
            super.add(notatka);
        }
        return true;
    }
}
