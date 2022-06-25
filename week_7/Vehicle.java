public class Vehicle {
    private String brandName;
    private String modelName;
    private int speed;

    Vehicle(String brandName, String modelName) {
        this.brandName = brandName;
        this.modelName = modelName;
    }
    
    // Vehicle() {
    //     System.out.println("Superclass constructor is called");
    // }


    public void brake() {
        System.out.println("brake is pressed");
        speed--;
    }

    public void accelarate() {
        speed++;
    }

    public void horn() {
        System.out.println("Beep beep");
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Tesla2", "12-TSL");
        car1.horn();
        // car1.setBrandName("Tesla");
        System.out.println("Car Brand " + car1.getBrandName());
    }

}

class Car extends Vehicle {
    Car(String brandName, String modelName){
        super(brandName, modelName);
    }
}