import java.io.FileOutputStream;
import java.io.IOException;

public class Loader {

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
//        StringBuilder builder = generateNumber(1,1000);
//        writeTExt(builder);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder builder = generateNumber(333, 666);
                    writeTExt(builder, "numbers1.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder builder = generateNumber(1, 333);
                    writeTExt(builder, "numbers2.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    StringBuilder builder = generateNumber(666, 1000);
                    writeTExt(builder, "numbers3.txt");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder();
        builder.append(number);
        int padSize = numberLength - Integer.toString(number).length();
        for (int i = 0; i < padSize; i++) {
            builder.reverse();
            builder.append("0");
            builder.reverse();
        }
        return builder.toString();
    }

    private static StringBuilder generateNumber(int firstIndex, int secondIndex) {
        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
        StringBuilder builder = new StringBuilder();
        for (int number = firstIndex; number < secondIndex; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        builder.append(firstLetter);
                        builder.append(padNumber(number, 3));
                        builder.append(secondLetter);
                        builder.append(thirdLetter);
                        builder.append(padNumber(regionCode, 2));
                        builder.append('\n');
                    }
                }
            }
        }
        return builder;
    }


    private static void writeTExt(StringBuilder builder, String nameFile) throws IOException {
        FileOutputStream writer = new FileOutputStream("res/" + nameFile);
        writer.write(builder.toString().getBytes());
        writer.flush();
        writer.close();

    }
}


//        char letters[] = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};
//        for (int number = 1; number < 1000; number++) {
//            StringBuilder builder = new StringBuilder();
//            int regionCode = 199;
//            for (char firstLetter : letters) {
//                for (char secondLetter : letters) {
//                    for (char thirdLetter : letters) {
//                        builder.append(firstLetter);
//                        builder.append(padNumber(number, 3)) ;
//                        builder.append(secondLetter);
//                        builder.append(thirdLetter);
//                        builder.append(padNumber(regionCode, 2));
//                        builder.append('\n');
//                    }
//                }
//            }
//            writer.write(builder.toString().getBytes());
//        }