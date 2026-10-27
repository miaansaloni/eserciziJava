public class Impegno {
    private int codiceProgetto;
    private double ore;

    public Impegno(int codiceProgetto, double ore){
        this.codiceProgetto=codiceProgetto;
        this.ore=ore;
    }

    public int getCodiceProgetto(){
        return codiceProgetto;
    }

    public double getOre(){
        return ore;
    }
}
