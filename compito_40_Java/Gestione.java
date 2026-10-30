import java.io.*;
import java.util.*;

public class Gestione {
    public static void main(String[] args) {

        List<Veicolo> veicoli=new ArrayList<Veicolo>();
        List<Cliente> clienti = new ArrayList<Cliente>();
        Map<Integer, String> codTarga = new HashMap<Integer, String>();    
        Map<Integer, Double> codCosto=new HashMap<Integer, Double>();   
        Map<Integer, Double> codTotale=new HashMap<Integer, Double>();   
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader("veicoli.txt"));
            String linea=reader.readLine();
            while (linea!=null) {
                StringTokenizer riga=new StringTokenizer(linea);
                int codice =Integer.parseInt(riga.nextToken());
                String tipo =riga.nextToken();
                String targa =riga.nextToken();
                String modello =reader.readLine();
                String marca = reader.readLine();

                if(tipo.equals("auto")){
                    riga =new StringTokenizer(reader.readLine());
                    int cilindrata =Integer.parseInt(riga.nextToken());
                    double bagagliaio =Double.parseDouble(riga.nextToken());
                    double costo =Double.parseDouble(reader.readLine());

                    Auto auto = new Auto(codice, targa, modello, marca, costo, cilindrata, bagagliaio);
                    veicoli.add(auto);
                    codTarga.put(codice, targa);
                    codCosto.put(codice, costo);
                    codTotale.put(codice, 0.0);
                } else {
                    String categoria=reader.readLine();
                    riga=new StringTokenizer(reader.readLine());
                    int posti=Integer.parseInt(riga.nextToken());
                    boolean vano=Boolean.parseBoolean(riga.nextToken());
                    double costo =Double.parseDouble(reader.readLine());

                    Furgone furgone = new Furgone(codice, targa, modello, marca, costo, categoria, posti, vano);
                    veicoli.add(furgone);
                    codTarga.put(codice, targa);
                    codCosto.put(codice, costo);
                    codTotale.put(codice, 0.0);
                }
                linea=reader.readLine();
            }
            reader.close();

        } catch(IOException e1){
            System.err.println(e1.getMessage());
        } catch(Exception e2){
            System.err.println(e2.getMessage());
        }

        try{
            BufferedReader reader = new BufferedReader(new FileReader("clienti.txt"));
            String linea = reader.readLine();
            while(linea!=null){
                String nomeCognome = linea;
                Cliente cliente= new Cliente(nomeCognome);
                clienti.add(cliente);

                StringTokenizer riga= new StringTokenizer(reader.readLine());
                while (riga.hasMoreTokens()) {
                    int codice =Integer.parseInt(riga.nextToken());
                    int giorni=Integer.parseInt(riga.nextToken());
                    String targa=codTarga.get(codice);
                    double costo=codCosto.get(codice);
                    cliente.addNoleggio(targa, giorni, costo);

                    double temp= codTotale.get(codice);
                    codTotale.put(codice,temp+giorni*costo);
                }
                linea=reader.readLine();
            }
            reader.close();

        } catch(IOException e1){
            System.err.println(e1.getMessage());

        } catch(Exception e2){
            System.err.println(e2.getMessage());
        }

        System.out.println("tipo, targa, codice, modello, marca, costo giornaliero, cilindrata, bagagliaio, categoria, numero di posti, vano di carico");
        for(Veicolo v:veicoli){
            System.out.println(v);
        }
        System.out.println("\n\n");

        for(Cliente c:clienti){
            System.out.println(c);
        }

        System.out.println("\n\n");

        if(args.length == 0){
            System.out.println("Nessun argomento passato alla linea di comando, per sapere l'importo totale di tutti i noleggi di un veicolo specifico -> java Gestione <codiceVeicolo>");
        } else {
            try {
                int codice = Integer.parseInt(args[0]);
                Double tot = codTotale.get(codice);

                if(tot == null){
                    System.out.println("Nessun veicolo con codice " + codice);
                } else {
                    System.out.println(codice + " " + tot);
                }
            } catch (NumberFormatException e) {
                System.out.println("Il codice veicolo deve essere un numero intero -> "
                        + "java Gestione <codiceVeicolo>");
            }
        }
    }
}
