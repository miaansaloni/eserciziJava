import java.util.*;
import java.util.stream.IntStream;
import  java.util.stream.Collectors;

public class Primi5NumDiv17 {
    public static void main(String[] args) {
        //SORGENTE: Genera uno IntStream infinito di interi casuali positivi (seed = 0)
        IntStream numbers = new Random(0).ints().map(Math::abs);
        
        //PIPELINE STREAM: Filtra, limita, converte in oggetti e raccoglie in lista
        List<Integer> risultato = numbers.filter(n -> n%17==0)  // OP.INTERMEDIA: seleziona i multipli di 17
                .limit(5)                                       // si ferma al raggiungimento di 5 elementi
                .mapToObj(n -> n)                               // OP.INTERMEDIA:incapsula gli int primitivi in oggetti Integer
                .collect(Collectors.toList());                  // OP.TERMINALE: raccoglie i 5 valori in una List<Integer>
        
        System.out.println(risultato);
    }
}
