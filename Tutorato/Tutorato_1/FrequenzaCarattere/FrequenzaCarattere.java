public class FrequenzaCarattere {

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Errore --> Uso tipico: java FrequenzaCarattere <numero di telefono>");
            System.exit(1);
        }

        String numero = args[0];

        if(numero.matches("[0-9]{10}")== false){
            System.out.println("Numero errato: inserire un numero");
            System.out.println();
            System.exit(2);
        }
        
        int[] frequenze = new int[10];

        for(int i=0; i<frequenze.length; i++){
            frequenze[i]=0;
        }

        for(int i=0; i<numero.length();i++){ // qua length ha le parentesi perchè è un metodo della classe string
            
            char cifra = numero.charAt(i);
            int elemento = Character.getNumericValue(cifra);
            frequenze[elemento]++;
        }

        for(int i=0; i<frequenze.length; i++){
            System.out.println("Cifra " + i + " --> Frequenza: " + frequenze[i]);
        }
    }
}