public class NumeriSottoLaMedia {
    public static void main(String[] args) {
        if(args.length != 5){
            System.out.println("Errore --> Uso tipico: java NumeriSottoLaMedia <numero1> <numero2> <numero3> <numero4> <numero5>");
            System.exit(1);
        }

        double [] temperature = new double[5];

        for(int i=0; i<temperature.length; i++){
            temperature[i] = Double.parseDouble(args[i]);
        }

        double somma = 0;

        for(int i=0; i<temperature.length; i++){
            somma += temperature[i];
        }

        double media = somma / temperature.length;

        System.out.println("La media delle temperature è: " + media);

        int contatoreSottoMedia = 0;

        for(int i=0; i<temperature.length; i++){
            if(temperature[i]<media){
                contatoreSottoMedia++;
            }
        }

        System.out.println("Il numero di valori sotto la media è: " + contatoreSottoMedia);
    }
}
