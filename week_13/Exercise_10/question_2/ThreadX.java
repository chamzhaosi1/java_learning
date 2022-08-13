package Exercise_10.question_2;

class ThreadX implements Runnable {
    @Override
    public void run() {
        try {
            int i = 0;

            while (i < 10) {
                Thread.sleep(2000);
                System.out.println("Hello");
                i++;
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}

class ThreadDemo1 {
    public static void main(String args[]) {
        ThreadX tx = new ThreadX();
        Thread thread = new Thread(tx);

        thread.start();
    }
}
