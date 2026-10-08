import java.util.Scanner;
// import java.util.*; consente di accedere a tutti gli import in util

public class LunghezzaStringhe{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); //stiamo diendo a Scanner di leggere da tastiera
    
        String s1, s2;
    
        System.out.println("Inserire la prima stringa...");
        s1 = scan.nextLine().trim();
    
        System.out.println("Inserire la seconda stringa...");
        s2 = scan.nextLine().trim();
    
        System.out.println("La stringa: \"" + s1 + "\"ha " + s1.length() + " caratteri.");
        System.out.println("La stringa: \"" + s2 + "\"ha " + s2.length() + " caratteri.");
    
        String s3 = s1 + " " + s2;
    
        System.out.println("La stringa completa è \"" + s3 + "\"ha " + s3.length() + " caratteri.");
    
        scan.close();
    }
}