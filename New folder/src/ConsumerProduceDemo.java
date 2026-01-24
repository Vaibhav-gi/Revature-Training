class Shared {
    int data;
    boolean available = false;

    synchronized void produce(int value) throws InterruptedException {
        while (available) wait();
        data = value;
        available = true;
        notify();
    }

    synchronized int consume() throws InterruptedException {
        while (!available) wait();
        available = false;
        notify();
        return data;
    }
}
    public class ConsumerProduceDemo {
        public static void main(String[] args) throws InterruptedException{
            Shared shared = new Shared();
            shared.produce(12);
            System.out.println(shared.consume());
        }
}