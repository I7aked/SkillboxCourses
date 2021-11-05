import java.io.FileOutputStream;
import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        Thread firstThread = new MyThread();
        Thread secondThread = new MyThread();
        Thread thirdThread = new MyThread();

        firstThread.start();
        secondThread.start();
        thirdThread.start();

        firstThread.join();
        secondThread.join();
        thirdThread.join();


        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}