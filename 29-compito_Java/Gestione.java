import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;

public class Gestione {
    public static void main(String[] args){
        List<Dipendente> ld=new ArrayList<Dipendente>();
        List<Clienti> clienti=new ArrayList<>();

        Map<Integer, Dipendente> codDip=new HashMap<>

        try{
            BufferedReader br=new BufferedReader(new FileReader("dipendenti.txt"));
            String line=br.readLine();
            
            while(line!=null){
                StringTokenizer tok=new StringTokenizer(line);
                int codice=Integer.parseInt(tok.nextToken());
                String tipo=tok.nextToken();
                String nome=br.readLine();

                if(tipo.equals("trainer")){
                    line=br.readLine();
                    tok=new StringTokenizer(line);
                    int ore=Integer.parseInt(tok.nextToken());
                    double costo=Double.parseDouble(tok.nextToken());
                    String specialita=br.readLine();

                    Trainer t=new Trainer(codice, nome, costo, ore, specialita);
                    ld.add(t);
                }
                else{ //se il dipendente è un nutrizionista
                    line=br.readLine();
                    tok=new StringTokenizer(line);
                    int telefono=Integer.parseInt(tok.nextToken());
                    boolean medico=Boolean.parseBoolean(tok.nextToken());
                    int app_sett=Integer.parseInt(tok.nextToken());
                    double costo=Double.parseDouble(tok.nextToken());

                    Nutrizionista n=new Nutrizionista(codice, nome, costo, telefono, medico, app_sett);
                    ld.add(n);
                }
                line=br.readLine();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        for(Dipendente d : ld){
            System.out.println(d);
        }

        try{
            BufferedReader br=new BufferedReader(new FileReader("clienti.txt"));
            String line=br.readLine();
            

            while(line!=null){
                int codice=Integer.parseInt(line);
                String nome=br.readLine();
                line=br.readLine();

                while(line!=null & !line.equals("")){
                    StringTokenizer tok=new StringTokenizer(line);
                    int cod_dip=Integer.parseInt(tok.nextToken());
                    double ore=Double.parseDouble(tok.nextToken());
                    Dipendente d=codDip.get(cod_dip);
                    Servizio s=new Servizio(ore, d)
                }
            }
        }
    }
}
