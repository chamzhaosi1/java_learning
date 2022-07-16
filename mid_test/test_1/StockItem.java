public class StockItem {

    private int itemID;
    private String description;
    private int unitsOnHand;
    private double price;

    StockItem(int itemID, String description, int unitsOnHand, double price){
        this.itemID = itemID;
        this.description = description;
        this.unitsOnHand = unitsOnHand;
        this.price = price;
    }


    StockItem(){
        this.itemID = 0;
        this.description = "";
        this.unitsOnHand = 0;
        this.price = 0.0;
    }

    public int getItemID() {
        return this.itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitsOnHand() {
        return this.unitsOnHand;
    }

    public void setUnitsOnHand(int unitsOnHand) {
        this.unitsOnHand = unitsOnHand;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}