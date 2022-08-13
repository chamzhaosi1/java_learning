public class TaskThreadDemo4 {
  public static void main(String[] args) {
    // Create tasks
    Runnable printA = new PrintChar('a', 100);
    Runnable printB = new PrintChar('b', 100);
    Runnable print100 = new PrintNum(1000);

    // Create threads
    Thread thread1 = new Thread(printA);
    Thread thread2 = new Thread(printB);
    Thread thread3 = new Thread(print100);

    thread1.setPriority(1);
    thread2.setPriority(10);
    // Start threads
    thread1.start();
    thread2.start();
	  thread3.start();

  }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {
  private char charToPrint; // The character to print
  private int times; // The times to repeat

  /** Construct a task with specified character and number of
   *  times to print the character
   */
  public PrintChar(char c, int t) {
    charToPrint = c;
    times = t;
  }

  @Override /** Override the run() method to tell the system
   *  what the task to perform
   */
  public void run() {
    for (int i = 0; i < times; i++) {
      System.out.print(charToPrint);
    }
  }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
  private int lastNum;

  /** Construct a task for printing 1, 2, ... i */
  public PrintNum(int n) {
    lastNum = n;
  }

  @Override /** Tell the thread how to run */
  public void run() {
  
	Thread thread4  = new Thread(new PrintChar('p',1000));
	thread4.start();
	
	try {
		for (int i = 1; i <= lastNum; i++) {
		  //System.out.print(" " + i);
		  System.out.print(" ");
	      System.out.print(i);
		  
		  if(i==10)
			thread4.join();
		  
		  
		}
	} catch(InterruptedException ex) {
	}
  }
}