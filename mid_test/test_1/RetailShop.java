public class RetailShop {
    public static void main(String[] args) {
        StockItem [] item = new StockItem[3];

        item[0] = new StockItem(1000, "Mouse", 12, 59.00);
        item[1] = new StockItem(2000, "LED Monitor", 40, 534.00);
        item[2] = new StockItem(3000, "Power bank", 20, 250.00);

        System.out.println("Table 1: Stock Item Detail");
        System.out.println("Item ID\t Description\t Units on Hand\t Price(RM)");
        System.out.println("_______________________________________________________");
        System.out.println(item[0].getItemID() + "\t " + item[0].getDescription() + "\t\t " + item[0].getUnitsOnHand() + "\t\t " + item[0].getPrice());
        System.out.println(item[1].getItemID() + "\t " + item[1].getDescription() + "\t " + item[1].getUnitsOnHand() + "\t\t " + item[1].getPrice());
        System.out.println(item[2].getItemID() + "\t " + item[2].getDescription() + "\t " + item[2].getUnitsOnHand() + "\t\t " + item[2].getPrice());
    }
}
