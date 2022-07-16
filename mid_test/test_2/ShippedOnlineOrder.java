public class ShippedOnlineOrder extends OnlineOrder{
    private double shippingCharge = 75.00;

    ShippedOnlineOrder(String custName, int custNumber, int quantity, double unitPrice){
        super(custName, custNumber, quantity, unitPrice);
    }

    public double computePrice(){
        return (super.quantity * super.unitPrice) + this.shippingCharge;
    }

    public void setShippingCharge(double shippingCharge){
        this.shippingCharge = shippingCharge;
    }

    public double getShippingCharge(){
        return this.shippingCharge;
    }
}
