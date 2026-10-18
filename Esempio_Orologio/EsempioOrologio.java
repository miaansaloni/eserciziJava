public class EsempioOrologio {
    public static void main(String[] args) {
        Orologio o;
        o = new Orologio(); //creazione Orologio
        o.tic(); //invocazione dei metodi di Orologio
        System.out.println(o.getOre()); //invocazione dei metodi di Orologio
        System.out.println(o.getMinuti()); //invocazione dei metodi di Orologio
        o.reset(); //invocazione dei metodi di Orologio
    }
}
