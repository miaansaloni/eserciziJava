import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Gestione {
    public static void main(String[] args) {

        //struttura dati per memorizzare i progetti letti dal file
        Map<Integer, Progetto> mappaProgetti = new HashMap<>();

        //---------- Lettura del file progetti.txt ----------//
        try(BufferedReader br=new BufferedReader(new FileReader("progetti.txt"))){
            String line = br.readLine();

            while(line != null){

                //Riga 1 (codice e tipo nello stesso token)
                StringTokenizer tok = new StringTokenizer(line); //line contiene "1 ricerca"
                int codice = Integer.parseInt(tok.nextToken()); //estrae il 1° token: "1"->1
                String tipo = tok.nextToken();                  //estrae il 2° token: "ricerca"

                //Righe 2, 3, 4 (titolo, coordinatore, organizzazione su righe dedicate)
                String titolo = br.readLine();
                String coordinatore = br.readLine();
                String organizzazione = br.readLine();

                //catalogazione in base al tipo di progetto
                if(tipo.equals("ricerca")){

                    //riga 5 (argomento e partner)
                    line=br.readLine();
                    tok=new StringTokenizer(line);
                    String argomento = tok.nextToken();
                    int partner=Integer.parseInt(tok.nextToken());

                    //riga 6 (importo totale)
                    line=br.readLine();
                    double importo=Double.parseDouble(line);

                    //CREAZIONE dell'oggetto specifico e AGGIUNTA alla mappa
                    ProgettoRicerca pr=new ProgettoRicerca(codice, tipo, titolo, coordinatore, organizzazione, argomento, partner, importo);
                    mappaProgetti.put(codice, pr);
                
                } else { //tipo.equals("innovazione")

                    //riga 5 (aziende e importo totale sulla stessa riga)
                    line=br.readLine();
                    tok=new StringTokenizer(line);
                    int aziende=Integer.parseInt(tok.nextToken());
                    double importoTotale=Double.parseDouble(tok.nextToken());

                    //CREAZIONE dell'oggetto specifico e AGGIUNTA alla mappa
                    ProgettoInnovazione pi=new ProgettoInnovazione(codice, tipo, titolo, coordinatore, organizzazione, aziende, importoTotale);
                    mappaProgetti.put(codice, pi);
                }

                //Lettura della prima riga del prossimo progetto
                line=br.readLine();
            }
            System.out.println("Progetti caricati: " + mappaProgetti.size());
        } catch (IOException e){
            System.out.println("Errore durante la lettura del file progetti.txt: "+ e.getMessage());
        }
    }
}
