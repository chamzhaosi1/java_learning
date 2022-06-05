package Exercise3_4;

public class Car {
    private int yearModel;
    private String make;
    private int speed;

    public Car(int yearModel, String make) {
        this.yearModel = yearModel;
        this.make = make;
        this.speed = 0;
    }

    public int getYearModel() {
        return this.yearModel;
    }

    public String getMake() {
        return this.make;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void accelerate(){
        speed += 5;
        System.out.println("Current speed is (accelerate)" + speed + "!");
    } 

    public void brake(){
        if (speed > 0){
            speed -= 5;
            System.out.println("Current speed is (brake)" + speed + "!" );
        }else{
            System.out.println("Current speed is 0!");
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car(2021, "Honda");
        
        for (int i=0; i<5; i++){
            car1.accelerate();
        }

        for (int i=0; i<5; i++){
            car1.brake();
        }
    }

}
