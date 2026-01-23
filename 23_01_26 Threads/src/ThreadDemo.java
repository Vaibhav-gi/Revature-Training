class mythread extends Thread{
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Child thread");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }}
class ThreadDemo{

    public static void main(String [] args)
    {
        mythread t=new mythread();
        t.start();
        for(int i=0;i<10;i++)
        {
            System.out.println("main thread");
        }
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

 