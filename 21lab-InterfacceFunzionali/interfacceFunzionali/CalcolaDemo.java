public class CalcolaDemo{

    public static void main(String[] args) {
        int numeri[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
       
        Calcola somma = a->{
        int s=0;
        for(int i=0; i<a.length; i++){
            s+=a[i];
        }
        return s;
        };  

        Calcola massimo = a->{
        int max=-1;
        for(int i=0;i<a.length; i++){
            if (a[i]>max)
                max=a[i];
        }
        return max;
        };

        Calcola minimo = a->{
        int min=100000000;
        for(int i=0;i<a.length; i++){
            if (a[i]<min)
                min=a[i];
        }
        return min;
        };

        int sum = somma.calcola(numeri);
        int max=massimo.calcola(numeri);
        int min=minimo.calcola(numeri);

        System.out.println("Somma: " + sum + " Max: " + max + " Min: " + min);
        
    }

}


interface Calcola { //un'interfaccia per essere funzionale deve definire un solo metodo astratto
    int calcola(int valori[]);
}