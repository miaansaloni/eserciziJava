public class CampoTennis extends Campo {
    private float temperaturaMedia;
    private String terreno;
    
    public CampoTennis(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario, float temperaturaMedia, String terreno){
        super(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario);
        this.temperaturaMedia=temperaturaMedia;
        this.terreno=terreno;
    }
}
