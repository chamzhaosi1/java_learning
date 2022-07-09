package exercise_7;

public abstract class Shape {
    
    public abstract double getArea();
    public abstract double getPerimeter();

    public static void main(String[] args) {
        Square square = new Square(5, 5);
        Rectangle rectangle = new Rectangle(7, 4);

        System.out.println(square.getArea());
        System.out.println(square.getPerimeter());

        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getPerimeter());
    }
}

class Square extends Shape{
    private double width;
    private double height; 

    Square(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return 2*width + 2*height;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height; 

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return width * height;
    }

    public double getPerimeter(){
        return 2*width + 2*height;
    }
}