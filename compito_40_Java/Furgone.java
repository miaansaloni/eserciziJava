public class Furgone extends Veicolo {
    protected String categoria;
    protected int posti;
    private boolean vano;

    public Furgone(int codice, String targa, String modello, String marca, double costo, String categoria, int posti, boolean vano){
        super(codice, targa, modello, marca, costo);
        this.categoria=categoria;
        this.posti=posti;
        this.vano=vano;
    }

    public String toString(){
        return "commerciale\t" + super.toString() + "-\t-\t" + categoria + "\t" + posti + "\t" + vano;  }

}
