public class Fuoristrada extends Automobile{
    private int nMarce;

    public Fuoristrada(String modello, String produttore, int nMarce, int peso, int codice){
        super(modello, produttore, peso, codice);
        this.nMarce=nMarce;
    }

    public int getMarce(){
        return nMarce;
    }
}
