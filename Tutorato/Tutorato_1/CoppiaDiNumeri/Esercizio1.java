public class Esercizio1 {
    public static void main(String[] args) {
        
        if(args.length != 2){
            System.out.println("Errore --> Uso tipico: java Esercizio1 <numero1> <numero2>");
            System.exit(1);
        }

        int num1, num2;

        num1 = Integer.parseInt(args[0]); //chiama la classe integer con il metodo parseint a cui viene passato il primo argomento della linea di comando
        num2 = Integer.parseInt(args[1]);

        CoppiaDiNumeri coppia = new CoppiaDiNumeri(num1, num2);

        System.out.println("Somma tra " + num1 + " e " + num2 + " = " + coppia.somma());
        System.out.println("Prodotto tra " + num1 + " e " + num2 + " = " + coppia.prodotto());
    }
}
