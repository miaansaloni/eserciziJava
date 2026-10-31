import java.util.*;
import java.io.*;
public class Gestione {
    public static void main(String[] args) {

        List<Campo> campi = new ArrayList<>();
        List<Socio> soci = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("campi.txt"));
            String line = reader.readLine();
    
            while(line != null){
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String sport = tok.nextToken();
                String nomeCampo = reader.readLine();
                float larghezza = Float.parseFloat(tok.nextToken());
                float lunghezza = Float.parseFloat(tok.nextToken());

                if(sport.equals("tennis")){
                    float temperatura = Float.parseFloat(tok.nextToken());
                    String terreno = reader.readLine();
                    float costoOrario = Float.parseFloat(tok.nextToken());

                    CampoTennis campoTennis = new CampoTennis(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, temperatura, terreno);
                    campi.add(campoTennis);

                } else {
                    float altezza = Float.parseFloat(tok.nextToken());
                    int piano = Integer.parseInt(tok.nextToken());
                    float costoOrario = Float.parseFloat(tok.nextToken());

                    CampoSquash campoSquash = new CampoSquash(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, altezza, piano);
                    campi.add(campoSquash);
                }
                line = reader.readLine();
            }
            reader.close();
            
        } catch (Exception e1) {
            System.err.println(e1.getMessage());
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("soci.txt"));
            String line = reader.readLine();

            while (line != null) {
                StringTokenizer tok = new StringTokenizer(line);
                int codiceSocio = Integer.parseInt(tok.nextToken());
                String nomeCognome = reader.readLine();
                int eta = Integer.parseInt(tok.nextToken());
                int categoria = Integer.parseInt(tok.nextToken());

                //GESTIONE DELLE PRENOTAZIONI CON LE MAPPE
            }

        } catch (Exception e1) {
            System.err.println(e1.getMessage());
        }
    }
}

/*
private int codiceSocio;
    private String nomeCognome;
    private int eta;
    private int categoria;
*/