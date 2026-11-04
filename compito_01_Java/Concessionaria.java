import java.util.*;
import java.io.*;

public class Concessionaria {
    public static void main(String[] args) {

        List<Automobile> automobili = new ArrayList<>();
        Map<String, Integer> pesi = new HashMap<>();
        
        //Punto 1
        try (BufferedReader br = new BufferedReader(new FileReader("ordini.txt"))){
            String line = br.readLine();

            while(line!=null){
                StringTokenizer tok = new StringTokenizer(line);
                String tipo = tok.nextToken(); //b o f
                String modello = tok.nextToken();
                String produttore = tok.nextToken();

                if(tipo.equals("b")){
                    double dimBagagliaio = Double.parseDouble(tok.nextToken());
                    int peso = Integer.parseInt(tok.nextToken());
                    int codice = Integer.parseInt(tok.nextToken());

                    Automobile a = new Berlina(modello, produttore, dimBagagliaio, peso, codice);
                    automobili.add(a);

                } else{
                    int nMarce = Integer.parseInt(tok.nextToken());
                    int peso = Integer.parseInt(tok.nextToken());
                    int codice = Integer.parseInt(tok.nextToken());

                    Automobile a = new Fuoristrada(modello, produttore, nMarce, peso, codice);
                    automobili.add(a);
                }
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println(e);
        }catch (Exception e1) {
            System.err.println(e1);
        }

        //Punto 2
        System.out.println("Codice\tMarca\tModello\tBagagliaio\tMarce");
        for(Automobile a : automobili){
            System.out.println(a);
        }

        //Punto 3
        System.out.println("\nN. Automobili per range di peso:");
        for(Automobile a : automobili){
           
            int peso = a.getPeso();
           
            if(peso >= 800 && peso <= 1000){
                Integer n = pesi.get("800-1000");
                if(n==null){ pesi.put("800-1000", 1); }
                else{ pesi.put("800-1000", n+1); }
            }

            if(peso >= 1000 && peso <= 1500){
                Integer n = pesi.get("1000-1500");
                if(n==null){ pesi.put("1000-1500", 1); }
                else{ pesi.put("1000-1500", n+1); }
            }

            if(peso >= 1500 && peso <= 2000){
                Integer n = pesi.get("1500-2000");
                if(n==null){ pesi.put("1500-2000", 1); }
                else{ pesi.put("1500-2000", n+1); }
            }

            System.out.println(pesi);
        }

        //Punto 4
        if(args.length == 0){
            System.out.println("Nessun argomento passato alla linea di comando, per stampare l'elenco dei modelli di una marca specifica -> java Concessionaria <marca automobile>");
        } else {
            try {
                System.out.println("Modelli presenti della marca " + args[0]);
                for(Automobile a : automobili){
                    String marca = a.getProduttore();

                    if(marca.equals(args[0])){
                        System.out.println(a.getModello());
                    }
                }

            } catch (Exception e) {
                System.out.println("La marca dell'auto non esiste -> "
                        + "java Concessionaria <marca automobile>");
            }
        }
    }
}

