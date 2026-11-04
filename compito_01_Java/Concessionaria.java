import java.util.*;
import java.io.*;

public class Concessionaria {
    public static void main(String[] args) {
        
        try (BufferedReader br = new BufferedReader(new FileReader("ordini.txt"))){
            String line = br.readLine();

            while(line!=null){
                StringTokenizer tok = new StringTokenizer(line);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}

