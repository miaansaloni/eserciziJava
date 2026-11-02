public class Furgone extends Veicolo {
    private boolean rimorchio;
    private int posti;
    private boolean vanoCarico;

    public Furgone(int codice, String targa, String modello, String marca, boolean rimorchio, int posti, boolean vanoCarico, double costoGiornaliero){
        super(codice, "furgone", targa, modello, marca, costoGiornaliero);
        this.rimorchio=rimorchio;
        this.posti=posti;
        this.vanoCarico=vanoCarico;
    }

    public boolean hasRimorchio(){return rimorchio;}
    public int getPosti(){return posti;}
    public boolean hasVanoCarico(){return vanoCarico;}

    //bagagliaio, cilindrata, categoria non si applicano -> "- - -"
    public String toString(){
        return datiComuni() + "\t-\t-\t-\t" + rimorchio + "\t" + posti + "\t" + vanoCarico;
    }
}