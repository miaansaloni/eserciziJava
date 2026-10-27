public class ProgettoRicerca extends Progetto {
    private String argomento;
    private int partner;

    public ProgettoRicerca(int codice, String tipo, String titolo, String coordinatore, String organizzazione, String argomento, int partner, double importoTotale){
        super(codice, "ricerca", titolo, coordinatore, organizzazione, importoTotale);
        this.argomento=argomento;
        this.partner=partner;
    }

    public String getArgomento(){return argomento;}
    public int getPartner(){return partner;}

    public String toString(){
        return getTipo() + " " + getTitolo() + " " + getCodice() + " " + getCoordinatore() + " " + getOrganizzazione() + " " + argomento + " " + partner + " " + getImportoMigliaia(); 
    }
}
