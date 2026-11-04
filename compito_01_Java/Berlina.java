public class Berlina extends Automobile{
    private double dimBagagliaio; //in cm^3

    public Berlina(String modello, String produttore, double dimBagagliaio, int peso, int codice){
        super(modello, produttore, peso, codice);
        this.dimBagagliaio=dimBagagliaio;
    }

    public double getBagagliaio(){
        return dimBagagliaio;
    }
}
