public class StackUnderflowException extends Exception{
    //costruttore di default
    public StackUnderflowException(){
        super();
    }
    
    //costruttore con parametro stringa per il messaggio di errore
    public StackUnderflowException(String s){
        super(s);
    }
}
