public abstract class Interface_abstract_vehicle {
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

        Car_2 car_1 = new Car_2();
        Truck_2 truck_1 = new Truck_2();

        // car_1.brake();
        stopVehicle(car_1);
        stopVehicle(truck_1);
        horn(car_1);
        horn(truck_1);
    }

    public static void stopVehicle(VehicleI vehI){
        vehI.stop();
    }

    public static void horn(Interface_abstract_vehicle veh){
        veh.horn();
    }
}

class Car_2 extends Interface_abstract_vehicle implements VehicleI, VehicleE{
    public void horn(){
        System.out.println("car press horn................beep beep");
    }

    public void accelarate(){
        System.out.println("car accelarate................");
    }

    public void start(){}
    
    public void stop(){
        System.out.println("Car Stop....");
    }
    public void chargable(){}
    public void autoDrive(){}

}

//abstract class Truck_2 extends Abstract_vehicle{
class Truck_2 extends Interface_abstract_vehicle implements VehicleI, VehicleE{
    public void horn(){
        System.out.println("truck press horn................tut tut");
    }

    public void accelarate(){
        System.out.println("truck accelarate................");
    }

    public void start(){}
    public void stop(){System.out.println("Truck Stop....");}
    public void chargable(){}
    public void autoDrive(){}

}

interface VehicleI{
    public String carFlatNo = "";

    public void start();
    public void stop();
}

interface VehicleE{
    public void chargable();
    public void autoDrive();
}

