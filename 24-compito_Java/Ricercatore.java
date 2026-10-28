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
    
    public String getNome(){return nome;}
    public String getCognome(){return cognome;}
    public List<Impegno> getImpegni(){return impegni;}
    public void aggiungiImpegno(Impegno i){impegni.add(i);}

    //punto 4, calcolo della somma delle ore di tutti i progetti a cui ricercatore partecipa
    public double getOreTotali(){
        double totale=0.0;
        for(Impegno i : impegni){
            totale += i.getOre();
        }
        return totale;
    }
    
    //punto 4, restituisce il numero totale di progetti a cui ricercatore partecipa
    public int getNumeroProgetti(){
        return impegni.size();
    }

    public String toString(){ //punto 4, riga di output finale:
        return nome +" "+ cognome +" "+ getOreTotali() +" "+ getNumeroProgetti() +" "+ impegni;
    }

    public Impegno getImpegnoMax(){
        if(impegni.isEmpty()){
            return null;
        }
        Impegno max= impegni.get(0);
        for (Impegno i : impegni){
            if (i.getOre() > max.getOre()){
                max = i;
            }
        }
        return max;
    }
}
