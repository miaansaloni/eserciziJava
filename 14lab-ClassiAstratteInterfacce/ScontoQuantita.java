//sottoclasse concreta di PoliticaSconto
public class ScontoQuantita implements PoliticaSconto {
    //campi (attributi) d'istanza per salvare lo stato
    private int minimo;
    private double percentuale;

    //costruttore con due parametri, minimo e percentuale. per inizializzare gli attributi
    public ScontoQuantita(int minimo, double percentuale){
        this.minimo = minimo;
        this.percentuale = percentuale;
    }

    //ridefinizione(overriding) del metodo astratto della superclasse
    public double calcolaSconto(int numeroArticoli, double prezzoArticolo){
        
        if(numeroArticoli > minimo){ //se la quantità di un articolo acquistato è maggiore del minimo
            double totaleSenzaSconto = numeroArticoli * prezzoArticolo;
            return totaleSenzaSconto * (percentuale / 100.0); // lo sconto è di percentuale sul totale.
        
        } else {
            return 0.0;
        }
    }
}
