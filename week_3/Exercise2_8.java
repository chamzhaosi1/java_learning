public class Exercise2_8 {
    public static void main(String [] args){
        float result = Calculate.average(25,5);
        System.out.println(result);
        result = Calculate.average(25,5,20);
        System.out.println(result);
    }
}

class Calculate{
    public static float average(int num1, int num2){
        return (num1 + num2)/2.0f;
    }

    public static float average(int num1, int num2,int num3){
        return (num1 + num2 + num3)/3.0f;
    }
}