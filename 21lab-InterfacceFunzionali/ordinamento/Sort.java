import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class Sort{
    public static void main(String[] args) {

        List<Node> list = Arrays.asList(new Node("c"), new Node("b"), new Node("d"), new Node("a"));
        System.out.println(list);
        Collections.sort(list, (a,b) -> a.getName().compareTo(b.getName()));
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