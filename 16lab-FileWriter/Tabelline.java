import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Tabelline {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("tabelline.txt");
        PrintWriter outFile = new PrintWriter(fw);

        for(int i=1; i<=10; i++){
            for(int j=1; j<=10; j++){
                outFile.printf("%4d", i*j);
            }
            outFile.println();
        }
        outFile.close();
    }
}
