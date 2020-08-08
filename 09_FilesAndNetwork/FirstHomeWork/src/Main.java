import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static long weightFiles;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки");
        String pathString = scanner.nextLine();

        try {
            File workDirectory = new File(pathString);
            weightFolder(workDirectory);

        } catch (Exception e) {
            System.out.println("Вы указали неверный путь");
            e.printStackTrace();
        }

        if (weightFiles >= 107374182 ){
            System.out.println(weightFiles/107374182 +" GB");
        }
        else if (weightFiles >= 1048576) {
            System.out.println(weightFiles/1048576 +" MB");
        }
        else if (weightFiles >= 1024) {
            System.out.println(weightFiles/1024 +" kB");
        }
        else {   System.out.println(weightFiles +" Byt");
        }
    }

    public static void weightFolder(File foulder)
    {
        File[] folderEntries = foulder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                weightFiles = weightFiles + entry.length();
                weightFolder(entry);
                continue;
            }
            else weightFiles = weightFiles + foulder.length();
        }

    }
}
