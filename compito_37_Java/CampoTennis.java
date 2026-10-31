public class CampoTennis extends Campo {
    private float temperatura;
    private String terreno;
    
    public CampoTennis(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario, float temperatura, String terreno){
        super(codice, "tennis", nomeCampo, larghezza, lunghezza, costoOrario);
        this.temperatura=temperatura;
        this.terreno=terreno;
    }

    protected String dettagliSpecifici(){
        return temperatura + "\t" + terreno + "-\t-\t";
    }
}
