import java.util.*;

public class StringheUniche {
    public static void main(String[] args) {
        String array[]={"Mela", "Pera", "Arancia", "Fragola", "Kiwi", "Arancia"};

        // Pipeline dellastream API
        Arrays.stream(array)            // SORGENTE: Usa il metodo factory della classe Arrays per generare uno Stream<String> dall'array iniziale
            .distinct()                 //OP. INTERMEDIA: rimuove i duplicati basandosi su equals()
            .forEach(s ->               //OP.TERMINALE: innesca il calcolo ed esegue l'azione per ogni elemento
                System.out.println(s)); // la lambda s -> System.out.println(s) si può anche scrivere con il method reference System.out::println
    }
}
