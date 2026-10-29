import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Gestione {
    public static void main(String[] args) {

        //struttura dati per memorizzare i progetti letti dal file
        Map<Integer, Progetto> mappaProgetti = new HashMap<>();

        //struttura dati per memorizzare i ricercatori letti dal file
        List<Ricercatore> listaRicercatori = new ArrayList<>();

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

        //---------- Lettura del file ricercatori.txt (PUNTO 2) ----------// 
        try (BufferedReader br = new BufferedReader(new FileReader("ricercatori.txt"))) { 
            String line = br.readLine(); 

            while (line != null) { 
                
                // Ignora eventuali righe vuote o con soli spazi tra un ricercatore e l'altro 
                if (line.trim().isEmpty()) { 
                    line = br.readLine(); 
                    continue; 
                } 
                // Riga 1 (nome) e Riga 2 (cognome) ripulite da spazi invisibili e \\r 
                String nome = line.trim(); 
                String prossimaRiga = br.readLine(); 
                if (prossimaRiga == null) { 
                    break; // Protezione se il file termina inaspettatamente 
                } 
                String cognome = prossimaRiga.trim(); 
                
                // Creazione dell'oggetto Ricercatore con stringhe "pulite" 
                Ricercatore r = new Ricercatore(nome, cognome); 

                // Legge gli impegni (codice progetto e ore) finché non trova una riga vuota o fine file 
                line = br.readLine(); 
                while (line != null && !line.trim().isEmpty()) { 
                    StringTokenizer tok = new StringTokenizer(line); 
                    int codiceProgetto = Integer.parseInt(tok.nextToken()); 
                    double ore = Double.parseDouble(tok.nextToken()); 
                    r.aggiungiImpegno(new Impegno(codiceProgetto, ore)); 
                    line = br.readLine(); 
                } 
                // SALVA il ricercatore popolato nella lista 
                listaRicercatori.add(r); 
            } 
            System.out.println("Ricercatori caricati: " + listaRicercatori.size()); 
        } catch (IOException e) { 
            System.out.println("Errore durante la lettura del file ricercatori.txt: " + e.getMessage()); 
        }


        //---------- Stampa della tabella dei progtti (PUNTO 3) ----------//
        System.out.println("tipo, titolo, codice, coordinatore, organizzazione, argomento, partner, aziende, importo totale in migliaia di euro"); 
        for (Progetto p : mappaProgetti.values()) 
            { System.out.println(p);} //viene invocato toString() automaticamente


        //---------- Stampa dell'elenco dei ricercatori (PUNTO 4) ----------//
        for(Ricercatore r : listaRicercatori){
            System.out.println(r); //che invoca r.toString in automatico
        }


        //---------- Ricerca per cognome da riga di comando (PUNTO 5) ----------//
        if(args.length > 0){
            String cognomeCercato = args[0];

            for(Ricercatore r : listaRicercatori){

                if(r.getCognome().equalsIgnoreCase(cognomeCercato)){
                    Impegno maxImpegno=r.getImpegnoMax();

                    if(maxImpegno != null){
                        int codiceProgetto = maxImpegno.getCodiceProgetto();
                        Progetto p = mappaProgetti.get(codiceProgetto);
                        System.out.println("Punto 5: " + r.getNome() + " " + r.getCognome() + " " + maxImpegno.getOre() + " " + p.getTitolo());
                    }
                }
            }
        } else {
            System.out.println("Nessun cognome passato per riga di comando");
        }
    }
}
