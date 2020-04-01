import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberCommand =0;
        boolean ciklYslovie = true;
        Character elementListChange;
        ArrayList<String> commandList = new ArrayList<>(){{
            add("ADD");
            add("EDIT");
            add("DELETE");
            add("LIST");
            add("EXIT");
        }};

        ArrayList<String > productList = new ArrayList<>(){{
            add("Bread");
            add("Milk");
            add("Potatoes");
            add("Pancake");
            add("Bublegum");
        }};

        for(String item:productList)
            {
                System.out.print(item);
                System.out.print(" ");
            }
        System.out.println();
        System.out.println("Список команд");

        for(String item:commandList)
        {
            System.out.println(item);
        }
        while (ciklYslovie) {
            System.out.println("Введите номер строки, если необходим, и через пробел команду для работы со списком");

            Scanner scanner = new Scanner(System.in);
            String commandListChange = scanner.nextLine();
//
            if (Character.isDigit(commandListChange.charAt(0)))
            {
                numberCommand = Integer.parseInt(commandListChange.substring(0, 1));//Записываем первую цифру переменную
                commandListChange = commandListChange.replaceAll("[0-9]", "");//Стирем первую цифру с нашей переменной
                commandListChange = commandListChange.trim();//Удаляем все незначащие пробелы
            }
            else{
                numberCommand = productList.size();
            }
//
            switch (commandListChange) {//определяем введённую команду и выбирем что делать
                case "ADD":
                    System.out.println("Введите новый продукт");
                    productList.add(numberCommand,scanner.nextLine());
                    break;
                case "EDIT":
                    System.out.println("Введите необходимые изменения");
                    productList.set(numberCommand, scanner.nextLine());
                    break;
                case "DELETE":
                    productList.remove(numberCommand);
                    break;
                case "LIST":
                    for (String item: productList){
                        System.out.print(item);
                        System.out.print(" ");
                    }
                    System.out.println();
                    break;
                case "EXIT" :
                    ciklYslovie = false;
                    break;
                default:
                    System.out.println("Неправильная команда, перезапустите работу");
                    ciklYslovie = false;
                    break;
            }
            continue;

        }
    }
}
