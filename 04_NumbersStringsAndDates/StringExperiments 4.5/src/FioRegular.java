import java.util.Scanner;

public class FioRegular
{
    public static void main(String[] args) {
        String fio;
        int i=0;
        Scanner scanner = new Scanner(System.in);
        fio = scanner.nextLine();

        String[] sentences = fio.split("\\s");


        if (i <= sentences.length)// проверяем больше ли количество получившихся разбиений, чем необходимые нам 3 значения
            {
                System.out.println("Фамилия " + sentences[i]);
             }
            i++;

        if (i < sentences.length)
        {
            System.out.println("Имя " + sentences[i]);
        }
        else
            {
                System.out.println("Имя ");
            }
        i++;

        if (i < sentences.length)
        {
            System.out.println("Отчество " + sentences[i]);
        }
        else
        {
            System.out.println("Отчество ");
        }


        }


    }

