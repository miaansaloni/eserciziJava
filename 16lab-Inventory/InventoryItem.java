public class InventoryItem {
    private String name;
    private int units;
    private float price;

    public InventoryItem(String name, int units, float price){
        this.name=name;
        this.units=units;
        this.price=price;
    }

    public String toString(){
        return name + ": "+ units +" a euro "+ price;
    }
}
