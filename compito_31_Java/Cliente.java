import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String nome; //nome e cognome
    private List<Noleggio> noleggi;

    public Cliente(String nome){
        this.nome=nome;
        this.noleggi=new ArrayList<>();
    }

    public String getNome(){return nome;}
    public List<Noleggio> getNoleggi(){return noleggi;}
    public void aggiungiNoleggio(Noleggio n){noleggi.add(n);}

    public int getNumeroNoleggi(){
        return noleggi.size();
    }

    //punto 4: costo del noleggio di costo maggiore
    public double getCostoMax(){
        double max=0.0;
        for(Noleggio n : noleggi){
            if(n.getCosto() > max){
                max = n.getCosto();
            }
        }
        return max;
    }

    //punto 5: quante volte il cliente ha noleggiato il veicolo con la targa data
    public int contaNoleggi(String targa){
        int conta=0;
        for(Noleggio n : noleggi){
            if(n.getVeicolo().getTarga().equalsIgnoreCase(targa)){
                conta++;
            }
        }
        return conta;
    }

    public String toString(){ //punto 4
        return nome + "\t" + getCostoMax() + "\t" + getNumeroNoleggi();
    }
}