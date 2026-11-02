public class Noleggio {
    private Veicolo veicolo;
    private int giorni;

    public Noleggio(Veicolo veicolo, int giorni){
        this.veicolo=veicolo;
        this.giorni=giorni;
    }

    public Veicolo getVeicolo(){return veicolo;}
    public int getGiorni(){return giorni;}

    //costo del noleggio = costo giornaliero * numero di giorni
    public double getCosto(){
        return veicolo.getCostoGiornaliero() * giorni;
    }
}
