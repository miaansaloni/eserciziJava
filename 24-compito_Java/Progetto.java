public class Progetto {
    private int codice;
    private String tipo;
    private String titolo;
    private String coordinatore;
    private String organizzazione;
    private double importoTotale; //(in milioni)

    public Progetto(int codice, String tipo, String titolo, String coordinatore, String organizzazione, double importoTotale){
        this.codice=codice;
        this.tipo = tipo; 
        this.titolo = titolo; 
        this.coordinatore = coordinatore; 
        this.organizzazione = organizzazione; 
        this.importoTotale = importoTotale;
    }

    public int getCodice(){return codice;}
    public String getTipo(){return tipo;}
    public String getTitolo(){return titolo;}
    public String getCoordinatore(){return coordinatore;}
    public String getOrganizzazione(){return organizzazione;}
    public double importoTotale(){return importoTotale;}

    public double getImportoMigliaia(){
        return importoTotale * 1000.0;
    }
}
