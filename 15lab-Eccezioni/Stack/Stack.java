public class Stack {
    private int count;
    private String items[];

    //costruttore che stabilisce all'atto della creazione il numero 
    //massimo di elementi che la pila può contenere
    public Stack(int max){
        count = 0;
        items = new String[max];
    }

    //la pila è vuota?
    public boolean isEmpty(){
        return count==0;
    }

    //mette una stringa in cima alla pila + controllo eccezioni
    public void push(String value) throws StackOverflowException{
        try {
            items[count] = value; //possibile eccezione
            count++;
        } catch (ArrayIndexOutOfBoundsException ae) {
            StackOverflowException oe = new StackOverflowException();
            throw oe;
        }
    }

    //estrae la stringa che si trova in cima alla pila + controllo eccezioni
    public String pop() throws StackUnderflowException{
        String value;
        try {
            count --; //se ==0 diventa -1
            value = items[count]; //possibile eccezione
            return value;
        } catch (ArrayIndexOutOfBoundsException ae) {
            count =0; // azione correttiva
            StackUnderflowException ue = new StackUnderflowException();
            throw ue;
        }
    }

    
    
}