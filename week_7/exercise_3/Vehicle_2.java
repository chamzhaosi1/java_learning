package exercise_3;
	//Superclass
public class Vehicle_2{
    private double cost;
    
    public Vehicle_2(double c){
           cost = c;
    }

    public static void main(String[] args) {
        Car car_1 = new Car(20.0, 6);
        // System.out.println(car_1.cost);
        // System.out.println(car_1.passengers);
    }
}

// Subclass
class Car extends Vehicle_2{
    private int passengers;

    public Car(double cost, int passengers){
        super(cost);
    	this.passengers = passengers;
    }
}

