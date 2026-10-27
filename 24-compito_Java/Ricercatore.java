import java.util.List;
import java.util.ArrayList;

public class Ricercatore {
    private String nome;
    private String cognome;
    private List<Impegno> impegni;

    public Ricercatore(String nome, String cognome){
        this.nome=nome;
        this.cognome=cognome;
        this.impegni= new ArrayList<>();
    }

    public void aggiungiImpegno(Impegno i){
        impegni.add(i);
    }

    public String getNome(){
        return nome;
    }

    public String getCognome(){
        return cognome;
    }

    public List<Impegno> getImpegni(){
        return impegni;
    }

}
