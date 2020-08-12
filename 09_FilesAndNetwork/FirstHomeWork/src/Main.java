import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.LongStream;

public class Main {

    private static long weightFiles;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь до папки");
        Path pathString = Paths.get(scanner.nextLine());

//        try {
//            File workDirectory = new File(pathString);
//            weightFolder(workDirectory);
//
//        } catch (Exception e) {
//            System.out.println("Вы указали неверный путь");
//            e.printStackTrace();
//        }

        try {

            Files.walk(pathString)
                    .map(path -> new File(String.valueOf(path)))
                    .filter(file -> !file.isDirectory())
                    .mapToLong(File::length)
                    .forEach(length -> weightFiles += length);

        } catch (IOException e)
        {
            System.out.println("Вы указали неверный путь");
            e.printStackTrace();
        }
        weightAllFiles(weightFiles);


//        if (weightFiles >= 107374182 ){
//            System.out.println(weightFiles/107374182 +" GB");
//        }
//        else if (weightFiles >= 1048576) {
//            System.out.println(weightFiles/1048576 +" MB");
//        }
//        else if (weightFiles >= 1024) {
//            System.out.println(weightFiles/1024 +" kB");
//        }
//        else {   System.out.println(weightFiles +" Byt");
//        }
    }

    public static void weightAllFiles (Long weightFiles)
    {
        if (weightFiles >= 107374182 ){
             System.out.println(weightFiles/107374182 + ","+ weightFiles % 107374182 +  " GB");
        }
        else if (weightFiles >= 1048576) {
            System.out.println(weightFiles/1048576 + "," + weightFiles % 1048576 +" MB");
        }
        else if (weightFiles >= 1024) {
            System.out.println(weightFiles/1024 + "," + weightFiles % 1024 +" kB");
        }
        else {   System.out.println(weightFiles +" Byt");
        }
    }

//    public static void weightFolder(File foulder)
//    {
//        File[] folderEntries = foulder.listFiles();
//        for (File entry : folderEntries)
//        {
//            if (entry.isDirectory())
//            {
//                weightFiles = weightFiles + entry.length();
//                weightFolder(entry);
//                continue;
//            }
//            else weightFiles = weightFiles + foulder.length();
//        }
//
//    }
}
