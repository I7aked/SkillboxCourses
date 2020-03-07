import java.util.Scanner;

public class Fio
{


    public static void main(String[] args) {
        String fio;
        String secondName = " ";
        String firstName = " ";
        String surname = " ";

        Scanner scanner = new Scanner(System.in);
        fio = scanner.nextLine();

        int dlinaFio = fio.length(); //определяем длину входных данных
        int indexProbel = fio.indexOf(' '); // находим индекс первого пробела между словами

        if (indexProbel == -1 || dlinaFio == 0) { // если пробела нет или входное слово пустое
            surname = "Фамилия:" + fio;
            System.out.println(surname);
            fio = "";
        }
        else { // если входное слово не пустое, то делаем следующее
            surname = fio.substring(0, indexProbel); // берём всё что до пробелов как наша Фамилия
            fio = fio.substring(indexProbel+1); // меняем длину строки выкинув с неё значение Фамилиии
            System.out.println("Фамилия: "+ surname);
        }

            dlinaFio = fio.length();
            indexProbel = fio.indexOf(' ');

        if (indexProbel == -1 || dlinaFio == 0) {
            firstName = "Имя:" + fio;
            System.out.println(firstName);
            fio = " ";
        }
        else {
            firstName = fio.substring(0, indexProbel);
            fio = fio.substring(indexProbel+1);
            System.out.println("Имя: "+ firstName);
        }

        dlinaFio = fio.length();
        indexProbel = fio.indexOf(' ');

        if (indexProbel == -1 || dlinaFio == 0) {
            secondName = "Отчество:" + fio;
            System.out.println(secondName);
            fio = " ";
        }
        else {
            secondName = fio.substring(0, indexProbel);
            fio = fio.substring(indexProbel+1);
            System.out.println("Отчество: "+ secondName);
        }

    }



}
