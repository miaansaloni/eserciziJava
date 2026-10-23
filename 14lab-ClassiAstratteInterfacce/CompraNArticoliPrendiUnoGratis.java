public class CompraNArticoliPrendiUnoGratis extends PoliticaSconto{
    private int n;

    //costruttore:
    public CompraNArticoliPrendiUnoGratis(int n){
        this.n = n;
    }

    //ridefinizione(overriding) del metodo astratto della superclasse
    public double calcolaSconto(int numeroArticoli, double prezzoArticolo){
        //calcolo del numero di articoli gratuiti:
        int articoliGratis = numeroArticoli / n;

        //sconto:
        return articoliGratis * prezzoArticolo;
    }
    
}
