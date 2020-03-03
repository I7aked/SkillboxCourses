import java.util.Scanner;

public class Main
{
    public static int   kolichestvoYaschik;
    public static void main(String[] args) {
        System.out.println("Введите количество ящиков =");

        Scanner scanner = new Scanner(System.in);
        String numberInConsole = scanner.nextLine();
        kolichestvoYaschik = Integer.parseInt(numberInConsole);

        int numberOfYaschik = 0;
        int numberOfGruzovik = 0;
        int numberOfKonteiner = 0;

        while (numberOfYaschik < (kolichestvoYaschik))
        {
            ++numberOfYaschik;

            if (numberOfYaschik % 324 == 1 || numberOfKonteiner == 0)
            {
                ++numberOfGruzovik;
                System.out.println("Номер грузовика " + numberOfGruzovik);
                // System.out.println();
            }

            if (numberOfYaschik % 27 == 1|| numberOfYaschik == 0)
            {
                ++numberOfKonteiner;
                System.out.println("  Номер контейнера " + numberOfKonteiner);
                // System.out.println();
            }
            System.out.println("         Номер Ящика " + numberOfYaschik);
        }
    }

}
