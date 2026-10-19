public class Esempio {
    public static void main(String[] args) {
        int n;
        Counter c1, c2;
        boolean b1, b2;

        c1 = new Counter();
        c2 = new Counter();

        c1.inc();
        b1 = c1.equals(c2);
        System.out.println(b1);

        c1.copy(c2);
        b2=c1.equals(c2);
        System.out.println(b2);

        n = c1.getValue();
        System.out.println(n);

        n = c2.getValue();
        System.out.println(n);
    }
}