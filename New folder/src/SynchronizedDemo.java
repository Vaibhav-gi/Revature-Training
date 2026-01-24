class A{
    int count=0;
    synchronized void increment()
    {   while(count<=10)
        System.out.println(count++);
    }

}
class B{
    int count =10;
    synchronized void decrement()
    {
        while (count>=1)
            System.out.println(count--);
    }
}

public class SynchronizedDemo extends Thread{
    public void run()
    {
        A aobj=new A();
        aobj.increment();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // System.out.println(aobj.count);
        B bobj=new B();
        bobj.decrement();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        // System.out.println(bobj.count);
    }
    public static void main(String[] args) {
        SynchronizedDemo d1=new SynchronizedDemo();
        SynchronizedDemo d2=new SynchronizedDemo();
        Thread th1=new Thread(d1);
        Thread th2=new Thread(d2);
        th1.start();
        //  th2.start();
    }
}
 