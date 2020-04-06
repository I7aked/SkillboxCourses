import java.util.HashSet;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        String vvodKonsol="";
        String firstCommand = "";
//        String usersMail = "";
        String correctMail = "";
        boolean chekCorrectMail ;
        boolean cikluslovie = true;

        HashSet<String> userMails = new HashSet<>();
        userMails.add("Lublupelmeni@yandex.ru");
        userMails.add("kolya.zhigulin@yandex.ru");

        System.out.println("Введите строкой ниже команду ADD и через пробел Ваш адрес электронной почты, либо команду LIST");

        while (cikluslovie) {

            Scanner scanner = new Scanner(System.in);
            vvodKonsol = scanner.nextLine();

            if (vvodKonsol.equals(""))//Проверка на вводу просто ENTER и прекращение работы
            {
                cikluslovie = false;
                continue;
            }

            firstCommand = vvodKonsol.replaceAll("(\\s).*", "");//firstCommand становится первое записанное слово
            firstCommand = firstCommand.trim();

            vvodKonsol = vvodKonsol.replaceAll("([A-Z]+\\s)?", "");
            vvodKonsol = vvodKonsol.trim();

            correctMail = vvodKonsol.replaceAll(".+@.+\\..+", "correct");
            chekCorrectMail = correctMail.equals("correct");//проверка что именно е-майл введён

            if (chekCorrectMail && firstCommand.equals("ADD")) //Проверка правильного емайл и команды ADD
            {
                userMails.add(vvodKonsol);
                System.out.println("Изменения внесены. Введите следующую команду или нажмите ENTER для окончания");
            }

            else if (firstCommand.equals("LIST"))
                {
                    for (String item : userMails)
                    {
                      System.out.println(item);
                    }
                System.out.println("Введите следующую команду или нажмите ENTER для окончания");
                }

            else
                {
                System.out.println("Вы ввели некорректный емайл или команду ADD. Повторите ");
                }

            }
        }

    }

