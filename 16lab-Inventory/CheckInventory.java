import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CheckInventory {
    public static void main(String[] args) {
        String line, name;
        int units, count=0;
        float price;
        String file = "inventory.dat";
        InventoryItem[] items = new InventoryItem[100];
        StringTokenizer tok;

        try {
            FileReader fr = new FileReader(file);
            BufferedReader inFile = new BufferedReader(fr);
            line = inFile.readLine();

            while(line!=null){
                tok= new StringTokenizer(line);
                name=tok.nextToken();

                try{
                    units = Integer.parseInt(tok.nextToken());
                    price = Float.parseFloat(tok.nextToken());
                    items[count++]=new InventoryItem(name, units, price);
                }
                catch(NumberFormatException e){
                    System.out.println("Error in input. Line: "+line);
                }
                line = inFile.readLine();
            }
            inFile.close();

            //scrive a video i dati letti
            System.out.println("--- Dati letti dal file ---");
            for(int scan=0; scan<count; scan++){
                System.out.println(items[scan]);
            }
        
        // Gestione dele eccezioni a cascata
        } catch (FileNotFoundException e) {
            System.out.println("File " + file + " not found.");
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
