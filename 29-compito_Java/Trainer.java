public class Trainer extends Dipendente{
    int ore_sett;
    String specialita;

    //costruttore
    public Trainer(int codice, String nome, double costo_orario, int ore_sett, String specialita){
        super(codice, nome, costo_orario);
        this.ore_sett=ore_sett;
        this.specialita=specialita;
    }

    public String toString(){
        return super.toString()+String.format("%15s %4d %20s %20s %20s %20s %6.2f", "trainer", ore_sett, specialita, "-", "-", "-", costo_orario);
    }
}
