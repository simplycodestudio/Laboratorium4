import java.io.Serializable;

public class Notatka implements Comparable<Notatka>, Serializable {

    public final int nr;
    private int wersja;
    private String tresc;
    private static int ostatniNumer = 0;


    public Notatka() {
        nr = ++ostatniNumer;
        wersja = 0;
    }

    public void zmienTresc(String _tresc) {
        tresc = _tresc;
        wersja++;
    }

    public static Notatka zanotuj(String tresc) {
        Notatka n = new Notatka();
        n.zmienTresc(tresc);
        return n;
    }

    @Override
    public String toString() {
        return "Nr=" + nr + ", wersja=" + wersja + " :" + tresc;
    }

    @Override
    public int compareTo(Notatka innaNotatka) {
        if (this.nr == innaNotatka.nr){
            return 0;
        } else if (this.nr > innaNotatka.nr){
            return 1;
        } else {
            return -1;
        }

    }
}
