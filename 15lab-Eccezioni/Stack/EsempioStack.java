public class EsempioStack {
    
    public static void main(String[] args) {
        Stack sk = new Stack(100);
        try{
            sk.push("Pippo");
            sk.push("Pluto");

            System.out.println(sk.pop());
            System.out.println(sk.pop());
            System.out.println(sk.pop()); //Underflow
        } 
        catch (StackOverflowException e){
            System.out.println("Overflow!");
        }
        catch(StackUnderflowException e){
            System.out.println("Underflow!");
        }
        catch(Exception e){ //catturiamo comunque tutti gli errori eventuali
            System.out.println("Errore strano: " + e.getMessage());
        }

    }
}
