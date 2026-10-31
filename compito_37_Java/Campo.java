public abstract class Campo {
    protected String sport;
    protected String nomeCampo;
    protected int codice;
    protected float larghezza; //in metri
    protected float lunghezza; //in metri
    protected float costoOrario;

    public Campo(int codice, String sport, String nomeCampo, float larghezza, float lunghezza, float costoOrario){
        this.codice=codice;
        this.sport=sport;
        this.nomeCampo=nomeCampo;
        this.larghezza=larghezza;
        this.lunghezza=lunghezza;
        this.costoOrario=costoOrario;
    }

    public int getCodice(){
        return codice;
    }

    public float getCostoOrario(){
        return costoOrario;
    }

    protected abstract String dettagliSpecifici();

    public String toString(){
        return sport + "\t" + nomeCampo + "\t" + codice + "\t" + larghezza + "\t" + lunghezza + "\t" + dettagliSpecifici() + "\t" +costoOrario;
    }
}
