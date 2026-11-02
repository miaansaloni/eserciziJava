import java.util.*;
import java.io.*;
public class Gestione {

    public static void main(String[] args) {

        List<Campo> campi = new ArrayList<>();
        List<Socio> soci = new ArrayList<>();
        // codice socio -> elenco delle sue prenotazioni
        Map<Integer, List<Prenotazione>> prenotazioni = new HashMap<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("campi.txt"));
            String line = reader.readLine();

            while(line != null){
                if(line.trim().isEmpty()){
                    line = reader.readLine();
                    continue;
                }
                // riga 1: codice e sport
                StringTokenizer tok = new StringTokenizer(line);
                int codice = Integer.parseInt(tok.nextToken());
                String sport = tok.nextToken();
                // riga 2: nome del campo
                String nomeCampo = reader.readLine().trim();
                // riga 3: dimensioni e dati specifici
                tok = new StringTokenizer(reader.readLine());
                float larghezza = Float.parseFloat(tok.nextToken());
                float lunghezza = Float.parseFloat(tok.nextToken());

                if(sport.equals("tennis")){
                    float temperatura = Float.parseFloat(tok.nextToken());
                    String terreno = reader.readLine().trim();
                    float costoOrario = Float.parseFloat(reader.readLine().trim());

                    campi.add(new CampoTennis(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, temperatura, terreno));

                } else {
                    float altezza = Float.parseFloat(tok.nextToken());
                    int piano = Integer.parseInt(tok.nextToken());
                    float costoOrario = Float.parseFloat(tok.nextToken());

                    campi.add(new CampoSquash(codice, sport, nomeCampo, larghezza, lunghezza, costoOrario, altezza, piano));
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
                if(line.trim().isEmpty()){
                    line = reader.readLine();
                    continue;
                }
                // riga 1: codice socio
                StringTokenizer tok = new StringTokenizer(line);
                int codiceSocio = Integer.parseInt(tok.nextToken());
                // riga 2: nome e cognome
                String nomeCognome = reader.readLine().trim();
                // riga 3: età e categoria
                tok = new StringTokenizer(reader.readLine());
                int eta = Integer.parseInt(tok.nextToken());
                int categoria = Integer.parseInt(tok.nextToken());

                soci.add(new Socio(codiceSocio, nomeCognome, eta, categoria));

                // riga 4: prenotazioni (coppie codice campo, ora inizio)
                List<Prenotazione> lista = new ArrayList<>();
                String rigaPrenotazioni = reader.readLine();
                if(rigaPrenotazioni != null){
                    tok = new StringTokenizer(rigaPrenotazioni);
                    while(tok.hasMoreTokens()){
                        int codiceCampo = Integer.parseInt(tok.nextToken());
                        int oraInizio = Integer.parseInt(tok.nextToken());
                        lista.add(new Prenotazione(codiceCampo, oraInizio));
                    }
                }
                prenotazioni.put(codiceSocio, lista);

                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e1) {
            System.err.println(e1.getMessage());
        }

        System.out.println("sport, nome del campo, codice, larghezza, lunghezza, temperatura, terreno, altezza, piano, costo");
        for(Campo c : campi){
            System.out.println(c);
        }

        System.out.println("codice, nome e cognome, età, categoria, prenotazioni");
        for(Socio s : soci){
            System.out.println(s + "\t" + prenotazioni.get(s.getCodiceSocio()));
        }

        if(args.length > 0){
            try {
                int codiceCampo = Integer.parseInt(args[0]);
                System.out.println(incasso(codiceCampo, campi, prenotazioni));
            } catch (NumberFormatException e) {
                System.err.println("Il codice del campo deve essere un intero");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Uso: java Gestione <codice campo>");
        }
    }

    // incasso = costo orario del campo * numero di prenotazioni per quel campo
    private static float incasso(int codiceCampo, List<Campo> campi, Map<Integer, List<Prenotazione>> prenotazioni){
        Campo campo = null;
        for(Campo c : campi){
            if(c.getCodice() == codiceCampo){
                campo = c;
            }
        }
        if(campo == null){
            throw new IllegalArgumentException("Campo " + codiceCampo + " inesistente");
        }

        int numPrenotazioni = 0;
        for(List<Prenotazione> lista : prenotazioni.values()){
            for(Prenotazione p : lista){
                if(p.getCodiceCampo() == codiceCampo){
                    numPrenotazioni++;
                }
            }
        }
        return campo.getCostoOrario() * numPrenotazioni;
    }
}