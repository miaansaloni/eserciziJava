public class ProgettoInnovazione extends Progetto{
    private int aziende;
    
    public ProgettoInnovazione(int codice, String tipo, String titolo, String coordinatore, String organizzazione, int aziende, double importoTotale){
        super(codice, "innovazione", titolo, coordinatore, organizzazione, importoTotale);
        this.aziende=aziende;
    }

    public int getAziende(){
        return aziende;
    }
}
