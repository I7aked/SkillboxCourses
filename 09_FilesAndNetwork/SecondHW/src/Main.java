import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        System.out.println("Введите откуда копировать");
        Scanner scanner =new Scanner(System.in);
        String sourceDirName = scanner.nextLine();
        System.out.println("Введите папку назначения");
        String targetSourceDir = scanner.nextLine();
        Path sourcePath = null;
        Path destinationePath = null;
        // Path переработанный и улучшенный File

        try {
            sourcePath = Paths.get(sourceDirName);
            destinationePath = Paths.get(targetSourceDir);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Path finalDestinationePath = destinationePath;
        Path finalSourcePath = sourcePath;
        Files.walk(sourcePath)
                .forEach(source -> copy(source, finalDestinationePath.resolve(finalSourcePath.relativize(source))));
                //relativize Вычисляем относительный путь между текущим путём (finalSourcePath) и переданным(source)
                // resolve  обеспечивает изменение пути в зависимости от относительного пути
    }

    static void copy(Path source, Path dest) {
        try {
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
            //REPLACE_EXISTING - заменяет файл если он существует
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



