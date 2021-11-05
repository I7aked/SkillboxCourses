import java.io.FileOutputStream;
import java.io.IOException;

public class MyThread extends Thread {
    static Integer countText = 0;

    @Override
    public void run() {
        try {
            countText++;
            StringBuilder builder = generateNumber(333, 666);
            writeTExt(builder, "res/numbers" + countText + ".txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String padNumber(int number, int numberLength) {
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

    private StringBuilder generateNumber(int firstIndex, int secondIndex) {
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


    private void writeTExt(StringBuilder builder, String nameFile) throws IOException {
        FileOutputStream writer = new FileOutputStream(nameFile);
        writer.write(builder.toString().getBytes());
        writer.flush();
        writer.close();

    }
}
