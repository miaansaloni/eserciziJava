public abstract class Campo {
    protected int codice;
    protected String sport;
    protected String nomeCampo;
    private float larghezza; //in metri
    private float lunghezza; //in metri
    private float costoOrario;

    public Campo(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario){
        this.codice=codice;
        this.sport=sport;
        this.nomeCampo=nomeCampo;
        this.larghezza=larghezza;
        this.lunghezza=lunghezza;
        this.costoOrario=costoOrario;
    }
}
