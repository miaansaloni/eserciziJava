public class StackOverflowException extends Exception {
    //costruttore di default
    public StackOverflowException(){
        super();
    }

    //costruttore con parametro stringa per il messaggio di errore
    public StackOverflowException(String s){
        super(s);
    }
}
