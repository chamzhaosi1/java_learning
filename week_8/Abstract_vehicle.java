public abstract class Abstract_vehicle {
    private String brandName;
    private String modelName;

    public void brake () {
        //implementation code
        System.out.println("press brake................");
    }

    public abstract void horn();

    public abstract void accelarate();

    public static void main(String[] args) {
        //cannot create a object which is abstract class
        //Abstract_vehicle asv = new Abstract_vehicle();

        Car_1 car = new Car_1();
        car.brake();
        Truck_1 truck = new Truck_1();
    }
}

class Car_1 extends Abstract_vehicle{
    public void horn(){
        System.out.println("car press horn................");
    }

    public void accelarate(){
        System.out.println("car accelarate................");
    }
}

//abstract class Truck_1 extends Abstract_vehicle{
class Truck_1 extends Abstract_vehicle{
    public void horn(){
        System.out.println("truck press horn................");
    }

    public void accelarate(){
        System.out.println("truck accelarate................");
    }
}

