public class OnlineOrder {
    
    private String custName;
    private int custNumber;
    protected int quantity;
    protected double unitPrice;

    OnlineOrder(String custName, int custNumber, int quantity, double unitPrice){
        this.custName = custName;
        this.custNumber = custNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    OnlineOrder(){
        this.custName = "";
        this.custNumber = 0;
        this.quantity = 0;
        this.unitPrice = 0.0;
    }


    public String getCustName() {
        return this.custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustNumber() {
        return this.custNumber;
    }

    public void setCustNumber(int custNumber) {
        this.custNumber = custNumber;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double computePrice(){
        return this.quantity * this.unitPrice;
    }
}
