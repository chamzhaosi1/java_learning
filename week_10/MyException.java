public class MyException extends Exception{

    MyException(){
        super("Input with zero value");
    }
    public static void main(String[] args) /*throws MyException*/{

        try{
            String inputStr = "a";
            int input = Integer.parseInt(inputStr);
            checkInputValue(input);
        }catch (MyException e){
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Finally Statement");
        }
        System.out.println("Next Statement");

        // checkInputValue(0);
        // System.out.println("Next Statement");
        
    }

    public static void checkInputValue(int value) throws MyException{
        if(value == 0){
            throw new MyException();
        }
    }
}