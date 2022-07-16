public class CustomerOnlineOrder {

    public static void main(String[] args) {
        ShippedOnlineOrder customer = new ShippedOnlineOrder("Jin Lee", 20001, 15, 20);

        System.out.println("Customer name: " + customer.getCustName());
        System.out.println("Customer number: " + customer.getCustNumber());
        System.out.println("Quantity Order: " + customer.getQuantity());
        System.out.println("Unit price: RM" + customer.getUnitPrice());
        System.out.println("Shipping Charge: RM" + customer.getShippingCharge());
        System.out.println("Total Price: RM" + customer.computePrice());
    }
}
