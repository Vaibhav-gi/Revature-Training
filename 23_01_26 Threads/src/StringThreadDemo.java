public class StringThreadDemo extends Thread {

    static String[] words = {"India"};

    @Override
    public void run() {
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                System.out.println(word.charAt(i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        StringThreadDemo t1 = new StringThreadDemo();
        t1.start(); // start thread
    }
}
