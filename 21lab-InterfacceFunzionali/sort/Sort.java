import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Sort{
    public static void main(String[] args) {

        List<Node> list = Arrays.asList(new Node("c"), new Node("b"), new Node("d"), new Node("a"));
        System.out.println(list);

        //Collections.sort(list, (a,b) -> a.getName().compareTo(b.getName())); //CON ESPRESSIONE LAMBDA
        Collections.sort(list, Comparator.comparing(Node::getName)); //CON METODO FACTORY DELLA CLASSE COMPARATOR

        System.out.println(list);
    }
}

class Node {
    private final String name;

    public Node(String name) {
    this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }
}