public class SommaArgs {

    public static void main(String[] args) {
        int num1, num2;

        //assegnazione del valore alle variabili, conversione della stringa
        //ottenuta da riga di comando in int
        num1 = Integer.parseInt(args[0]);
        num2 = Integer.parseInt(args[1]);

        System.out.println(num1+num2);
    }
}