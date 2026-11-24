import java.util.*;
import static java.util.Arrays.asList;

public class LunghezzaMassima {
    public static void main(String[] args) {
        List<String> strings = asList("Lorem", "ipsum", "dolor", "sit", "amet,", "consectetur", "adipiscing", "elit.");

        Optional<Integer> risultato = strings.stream() //Optional<Integer>: la risposta viene incapsulata nel caso la lista di artenza sia vuota
                                                       // .stream() Sorgente: apre uno stream a partire dalla lista iniziale e trasporta le 8 stringhe
                .map(String::length)                   // Op. intermedia: trasformazione uno a uno degli elementi del flusso, conversione delle parole nelle rispettive lunghezze numeriche
                                                       // String::length equivale all'interfaccia funzionale Function<String, Integer>
                                                       // => lo stream diventa uno Stream<Integer> contenente la sequenza di numeri
                .reduce(Math::max);                    //Operazione terminale di riduzione: Math::max confronta due numeri e restituisce il maggiore
        
        System.out.println(risultato.orElse(0)); // un oggetto Optional contenente il valore 11
                                                 // .orElse(0) gestione sicura: se la lista è vuota restituisce valore di default
    }
}
