package exercise_6;
 
public class Circle{
    private double radius;
    
    protected void setRadius(double radius){
        this.radius = radius;
    }

    public double calArea(){
        return Math.PI * radius * radius;
    }

    public static void main(String [] args){
        Point p = new Point();
        p.setRadius(19);
        System.out.println(p.calArea());
    }
}

class Point extends Circle{

}