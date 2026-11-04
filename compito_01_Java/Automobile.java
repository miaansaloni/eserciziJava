public abstract class Automobile {
    protected String modello;
    protected String produttore;
    protected int peso; //in kg
    protected int codice;

    public Automobile(String modello, String produttore, int peso, int codice){
        this.modello=modello;
        this.produttore=produttore;
        this.peso=peso;
        this.codice=codice;
    }

    public int getPeso(){
        return peso;
    }

    public String getProduttore(){
        return produttore;
    }

    public String getModello(){
        return modello;
    }
}
