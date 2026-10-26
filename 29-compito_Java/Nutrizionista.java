public class Nutrizionista extends Dipendente{
    int telefono;
    boolean medico;
    int app_sett;

    //costruttore
    public Nutrizionista(int codice, String nome, double costo_orario, int telefono, boolean medico, int app_sett){
        super(codice, nome, costo_orario);
        this.telefono=telefono;
        this.medico=medico;
        this.app_sett=app_sett;
    }

    public String toString(){
        return super.toString()+String.format("%14s %4s %20s %20d %20b %20d %6.2f", "nutrizionista", "-", "-", telefono, medico, app_sett);
    }
}

