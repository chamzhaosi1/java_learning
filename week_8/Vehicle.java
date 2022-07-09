public class Vehicle {
    protected String brandName;
    private String modelName;
    protected int speed;

    Vehicle(String brandName, String modelName) {
        this.brandName = brandName;
        this.modelName = modelName;
    }
    
    Vehicle() {
        System.out.println("Superclass constructor is called");
    }


    public void brake() {
        System.out.println("brake is pressed");
        speed--;
    }

    public void accelarate() {
        speed++;
    }

    public /*final*/ void horn() { // final keyword - subclass cannot override this method
        System.out.println("Beep beep");
    }
    
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
    
    public String getBrandName() {
        return brandName;
    }
    
    public static void main(String[] args) {
        // Car car1 = new Car("Tesla", "12-TSL");
        // car1.horn();
        // car1.setBrandName("Tesla");
        // System.out.println("Car Brand " + car1.getBrandName());
        // Truck truck1 = new Truck();
        // truck1.setBrandName("Tesla again");
        // truck1.horn();
        // System.out.println("Track Brand " + truck1.getBrandName());
        // System.out.println("Track Brand " + truck1.brandName);

        //Polymorphism
        Vehicle [] veh = new Vehicle[2];
        veh[0] = new Car("Honda", "City");
        veh[1] = new Truck();

        for (int i=0; i<veh.length; i++){
            veh[i].horn();
        }

        //Because this method is declared in subclass, 
        //then polymorphism is not allow to invoke a method which did not 
        //exsits in the super class
        //veh[1].pressBrake();

        Truck truck = new Truck();
        truck.pressBrake();
    }
    
}

class Car extends Vehicle {
    Car(String brandName, String modelName){
        super(brandName, modelName);
    }
    
    Car(){
        // super(); // not need to call, because parent non-agrument constructor will be called first 
        System.out.println("Subclass constructor is called");
    }
    
    public void horn(){
        System.out.println("Tut tut");
        super.horn();
    }
}

class Truck extends Vehicle{
    public void horn(){
        System.out.println("Beep---------------beep");
    }

    public void accelarate(){
        speed+=2;
    }

    public void pressBrake(){
        System.out.println("press brake");
    }
}