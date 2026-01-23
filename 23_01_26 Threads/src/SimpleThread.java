
//extends Thread or implements Runnable
public class SimpleThread extends  Thread{
    public void run()
    {
        System.out.println("inside run method..");
    }

    public static void main(String[] args) {
        SimpleThread simpleThread1=new SimpleThread();
        Thread thread=new Thread(simpleThread1);
        thread.start();
        SimpleThread simpleThread2=new SimpleThread();
        simpleThread2.start();
        SimpleThread simpleThread3=new SimpleThread();
        simpleThread3.start();

    }

}
 