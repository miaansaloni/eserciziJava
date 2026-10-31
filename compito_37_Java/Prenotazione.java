public class Prenotazione {
    private int codiceCampo;
    private int oraInizio;

    public Prenotazione(int codiceCampo, int oraInizio){
        this.codiceCampo=codiceCampo;
        this.oraInizio=oraInizio;
    }

    public int getCodiceCampo(){
        return codiceCampo;
    }

    public int getOraInizio(){
        return oraInizio;
    }
}
