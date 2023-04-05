import java.util.Random;

public class Proces {
    private int numer;
    private int dlFazy;
    private int momentZgloszenia;
    private int czasOczekiwania = 0;

    public Proces(int numer) {
        Random rand = new Random();
        this.numer = numer;
        this.dlFazy = rand.nextInt(50)+1;
        this.momentZgloszenia = rand.nextInt(400)+1;
        this.czasOczekiwania=0;
    }
    public Proces(int numer,int dlFazy,int momentZgloszenia){
        this.numer = numer;
        this.dlFazy = dlFazy;
        this.momentZgloszenia = momentZgloszenia;
        this.czasOczekiwania=0;
    }
    public void zmniejszMomentZgloszenia(int dlugosc){
        momentZgloszenia-=dlugosc;
    }

    public void zmniejszDlFazy(int dlugosc){
        dlFazy-=dlugosc;
    }
    public int getDlFazy() {
        return dlFazy;
    }
    public int getMomentZgloszenia() {
        return momentZgloszenia;
    }

    public String toString(){
        return dlFazy + " " + momentZgloszenia + " ";
    }

    public void addCzasOczekiwania(int czasOczekiwania) {
        this.czasOczekiwania += czasOczekiwania;
    }

    public int getCzasOczekiwania() {
        return czasOczekiwania;
    }
}

