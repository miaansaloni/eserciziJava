public class Noleggio {

    private Film film;
    private int ritardo;
    private String cliente;

    public Noleggio(Film film, int ritardo, String cliente){
        this.film = film;
        this.ritardo = ritardo;
        this.cliente = cliente;
    }

    public double calcolaPenale(){
        return film.calcolaPenale(this.ritardo); //automaticamente calcola la penale apposita per il genere in questione
    }

    public String toString(){
        return "{film = " + this.film + "\tcliente = " + this.cliente + "\tritardo = " + this.ritardo + "\tpenale totale = " + this.calcolaPenale() + " }";
    }
}
