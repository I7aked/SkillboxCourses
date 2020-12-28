import java.io.File;

public class Main {
    private static int newWidth = 300;

    public static void main(String[] args) {
        String srcFolder = "/home/nikolay/Рабочий стол/src";
        String dstFolder = "/home/nikolay/Рабочий стол/dst";

        File srcDir = new File(srcFolder);
        File[] files = srcDir.listFiles();

        int countProcessor = Runtime.getRuntime().availableProcessors();
        int foreign = files.length / countProcessor;

        for (int i = 0; i < countProcessor; i++) {
            File[] files1 = new File[foreign];
            System.arraycopy(files, foreign * i, files1, 0, foreign);
            ImageResizer resizer = new ImageResizer(files1, newWidth, dstFolder);
            new Thread(resizer).start();
        }
    }
}