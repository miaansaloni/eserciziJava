public class Impegno {
    private int codiceProgetto;
    private double ore;

    public Impegno(int codiceProgetto, double ore){
        this.codiceProgetto=codiceProgetto;
        this.ore=ore;
    }

    public int getCodiceProgetto(){return codiceProgetto;}
    public double getOre(){return ore;}

    //per il punto 4, genera la stringa nella forma (codice, ore)
    public String toString(){
        return "(" + codiceProgetto + "," + ore + ")";
    }
}
