class A{
    int count=0;
    void increment()
    {   while(count<=10)
        count++;
    }

}
class B{
    int count =10;
    public void decrement()
    {
        while (count>=1)
            count--;
    }
}

public class SynchronizedDemo extends Thread{
    public void run()
    {
        A aobj=new A();
        aobj.increment();
        System.out.println(aobj.count);
        B bobj=new B();
        bobj.decrement();
    }
    public static void main(String[] args) {
        SynchronizedDemo d1=new SynchronizedDemo();
        SynchronizedDemo d2=new SynchronizedDemo();
        Thread th1=new Thread(d1);
        Thread th2=new Thread(d2);
        th1.start();
        th2.start();
    }
}
 