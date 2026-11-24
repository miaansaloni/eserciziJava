import java.util.*;
import  java.util.stream.Collectors;
import static java.util.Arrays.asList;

public class Divisione {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1,2,3,4,5);

        Set<Integer> risultato = numbers.stream() // Sorgente, apre Stream<Integer> a partire dalla lista iniziale
                .map(n->n/2)                      // Operazione intermedia, mappa ogni elemento dello stream applicando la divisione per 2
                .collect(Collectors.toSet());     // Operazione terminale, innesca l'elaborazione dei dati raccogliendo
                                                  // gli elementi trasformati all'interno di un Set mediante il metodo Collectors.toSet
                                                  // l'interfaccia Set non ammette duplicati, le ripetizioni vengono automaticamente eliminate
        System.out.println(risultato); // [0, 1, 2]
    }
}
