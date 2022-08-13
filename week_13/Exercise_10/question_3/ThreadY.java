package Exercise_10.question_3;

public class ThreadY implements Runnable{
    private String s;
    private int n;

    public ThreadY(String s, int n){
        this.s = s;
        this.n = n;
    }

    @Override
    public void run(){
        for (int i=1; i<=this.n; i++){
            System.out.print(this.s);
        }
    }
}

class PrintJava{
    public static void main(String[] args) {
        Runnable threadY = new ThreadY("Java", 100);
        Thread thread = new Thread(threadY);
        thread.start();
    }
}