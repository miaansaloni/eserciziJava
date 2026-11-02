public class Auto extends Veicolo {
    private double bagagliaio; //in dm3
    private int cilindrata;
    private String categoria;

    public Auto(int codice, String targa, String modello, String marca, double bagagliaio, int cilindrata, String categoria, double costoGiornaliero){
        super(codice, "automobile", targa, modello, marca, costoGiornaliero);
        this.bagagliaio=bagagliaio;
        this.cilindrata=cilindrata;
        this.categoria=categoria;
    }

    public double getBagagliaio(){return bagagliaio;}
    public int getCilindrata(){return cilindrata;}
    public String getCategoria(){return categoria;}

    //rimorchio, numero di posti, vano di carico non si applicano -> "- - -"
    public String toString(){
        return datiComuni() + "\t" + bagagliaio + "\t" + cilindrata + "\t" + categoria + "\t-\t-\t-";
    }
}