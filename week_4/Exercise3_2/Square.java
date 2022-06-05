package Exercise3_2;

public class Square {
    private double sideLength;

    public Square(){
        this.sideLength = 0.0;
    }

    // Q2.B
    // public Square(double sl){
    //     sideLength = sl;
    // }

    public Square(double sideLength){
        this.sideLength = sideLength;
    }

    public double getArea(){
        
        return sideLength*sideLength;
    }

    public double getSideLength(){
        return sideLength;
    }

}
