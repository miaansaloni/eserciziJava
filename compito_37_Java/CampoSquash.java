public class CampoSquash extends Campo {
    private float altezza; //in metri
    private int piano;

    public CampoSquash(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario, float altezza, int piano){
        super(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario);
        this.altezza=altezza;
        this.piano=piano;
    }
}
