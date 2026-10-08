public class Videoteca {

    public static void main(String[] args) {

        Film[] catalogo = new Film[5];
        catalogo[0] = new Azione("Az1", "Fast and Furious");
        catalogo[1] = new Fantasy("Fy1", "La storia infinita");
        catalogo[2] = new Fantascienza("Fz1", "Interstellar");
        catalogo[3] = new Azione("Az2", "X Men");
        catalogo[4] = new Fantascienza("Fz2", "Terminator");

        Noleggio[] noleggi = new Noleggio[3];
        noleggi[0]= new Noleggio(catalogo[2], 4, "Mario");
        noleggi[1]= new Noleggio(catalogo[3], 6, "Valentina");
        noleggi[2]= new Noleggio(catalogo[1], 10, "Giovanni");
      
        System.out.println("Lista noleggi: ");
        for(int i=0; i<noleggi.length; i++){
            System.out.println(noleggi[i]);
        }
        /* ALTERNATIVA
        for(Noleggio noleggio : noleggi){
        system.out.println(noleggio);
        }*/

        double totalePenali = 0.0;

        for(int i=0; i<noleggi.length; i++){
            totalePenali += noleggi[i].calcolaPenale();
        }

        System.out.println("Il totale delle penali è: " + totalePenali);
    }
}
