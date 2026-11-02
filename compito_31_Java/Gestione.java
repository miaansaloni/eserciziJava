import java.io.*;
import java.util.*;

public class Gestione {
    public static void main(String[] args) {

        //struttura dati per memorizzare i veicoli letti dal file (chiave: codice)
        Map<Integer, Veicolo> mappaVeicoli = new LinkedHashMap<>();

        //struttura dati per memorizzare i clienti letti dal file
        List<Cliente> listaClienti = new ArrayList<>();

        //---------- Lettura del file veicoli.txt (PUNTO 1) ----------//
        try(BufferedReader br = new BufferedReader(new FileReader("veicoli.txt"))){
            String line = br.readLine();

            while(line != null){

                //salta eventuali righe vuote
                if(line.trim().isEmpty()){
                    line = br.readLine();
                    continue;
                }

                //Riga 1: codice, tipo, targa
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String tipo = tok.nextToken();
                String targa = tok.nextToken();

                //Righe 2 e 3: modello e marca
                String modello = br.readLine().trim();
                String marca = br.readLine().trim();

                if(tipo.equals("auto")){

                    //riga 4: bagagliaio e cilindrata
                    tok = new StringTokenizer(br.readLine());
                    double bagagliaio = Double.parseDouble(tok.nextToken());
                    int cilindrata = Integer.parseInt(tok.nextToken());

                    //riga 5: categoria (con spazi)
                    String categoria = br.readLine().trim();

                    //riga 6: costo giornaliero
                    double costo = Double.parseDouble(br.readLine().trim());

                    mappaVeicoli.put(codice, new Auto(codice, targa, modello, marca, bagagliaio, cilindrata, categoria, costo));

                } else { //furgone

                    //riga 4: rimorchio, posti, vano di carico
                    tok = new StringTokenizer(br.readLine());
                    boolean rimorchio = Boolean.parseBoolean(tok.nextToken());
                    int posti = Integer.parseInt(tok.nextToken());
                    boolean vano = Boolean.parseBoolean(tok.nextToken());

                    //riga 5: costo giornaliero
                    double costo = Double.parseDouble(br.readLine().trim());

                    mappaVeicoli.put(codice, new Furgone(codice, targa, modello, marca, rimorchio, posti, vano, costo));
                }

                //prima riga del prossimo veicolo
                line = br.readLine();
            }
        } catch (IOException e){
            System.out.println("Errore durante la lettura del file veicoli.txt: " + e.getMessage());
        }

        //---------- Lettura del file clienti.txt (PUNTO 2) ----------//
        try(BufferedReader br = new BufferedReader(new FileReader("clienti.txt"))){
            String line = br.readLine();

            while(line != null){

                //salta le righe vuote tra un cliente e l'altro
                if(line.trim().isEmpty()){
                    line = br.readLine();
                    continue;
                }

                //riga con nome e cognome
                Cliente c = new Cliente(line.trim());

                //legge i noleggi finché non trova una riga vuota o fine file
                line = br.readLine();
                while(line != null && !line.trim().isEmpty()){
                    StringTokenizer tok = new StringTokenizer(line);
                    int codiceVeicolo = Integer.parseInt(tok.nextToken());
                    int giorni = Integer.parseInt(tok.nextToken());

                    Veicolo v = mappaVeicoli.get(codiceVeicolo);
                    if(v != null){
                        c.aggiungiNoleggio(new Noleggio(v, giorni));
                    } else {
                        System.out.println("Veicolo " + codiceVeicolo + " inesistente (cliente " + c.getNome() + ")");
                    }
                    line = br.readLine();
                }
                listaClienti.add(c);
            }
        } catch (IOException e){
            System.out.println("Errore durante la lettura del file clienti.txt: " + e.getMessage());
        }

        //---------- Stampa della tabella dei veicoli (PUNTO 3) ----------//
        System.out.println("tipo\ttarga\tcodice\tmodello\tmarca\tcosto giornaliero\tbagagliaio\tcilindrata\tcategoria\trimorchio\tnumero di posti\tvano di carico");
        for(Veicolo v : mappaVeicoli.values()){
            System.out.println(v); //toString() automatico
        }

        //---------- Stampa dei clienti (PUNTO 4) ----------//
        for(Cliente c : listaClienti){
            System.out.println(c);
        }

        //---------- Targa da tastiera (PUNTO 5) ----------//
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserisci la targa del veicolo di cui vuoi conoscere il numero di noleggi: ");
        String targa = sc.nextLine().trim();

        boolean esiste = false;
        for(Veicolo v : mappaVeicoli.values()){
            if(v.getTarga().equalsIgnoreCase(targa)){
                esiste = true;
            }
        }

        if(esiste){
            int totale = 0;
            for(Cliente c : listaClienti){
                totale += c.contaNoleggi(targa);
            }
            System.out.println(totale);
        } else {
            System.out.println("Nessun veicolo con targa " + targa);
        }
    }
}