//extends Thread or implements Runnable
public class RunThread extends  Thread{
    public void run()
    {
        System.out.println("inside run method..");
        System.out.println("The running thread is"+Thread.currentThread().getName());
        Thread.currentThread().setName(" newThread");
        System.out.println("The running thread after naming is "+Thread.currentThread().getName());


    }
    public static void main(String[] args) {
        SimpleThread simpleThread1=new SimpleThread();
        simpleThread1.start();
        System.out.println("the thread is "+ Thread.currentThread().getName());
        Thread.currentThread().setName("main method name");
        System.out.println("the thread is in main "+ Thread.currentThread().getName());


    }

}

