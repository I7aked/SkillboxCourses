import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int numberCommand =0;
        boolean ciklYslovie = true;
        String vvodKonsol = "";
        String mainCommand = "";
        int  schetchik = 0;

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
            { schetchik++;
                System.out.println(schetchik + " " + item);
            }

        System.out.println("Список команд");

        for(String item:commandList)
        {
            System.out.println(item);
        }
        while (ciklYslovie) {
            schetchik = 0;
            System.out.println("Введите команду установленного образца");

            Scanner scanner = new Scanner(System.in);
            String commandListChange = scanner.nextLine();

            vvodKonsol=commandListChange.replaceAll("(([A-Z]+\\s)(\\d)?)",""); //Определяем вводимый продукт
            vvodKonsol = vvodKonsol.trim();

            mainCommand = commandListChange.replaceAll("(((\\d)?(\\s)+[A-Z]*[a-z]*).*)|(((\\d)?(\\s)+[a-z]+).*)|(\\d?)","");//Определяем выполняемую команду

            mainCommand = mainCommand.trim();
            commandListChange = commandListChange.replaceAll("([A-Z]+\\s)?","");//Убирем команду из введённой строки


            if (Character.isDigit(commandListChange.charAt(0)))// Проверяем есть ли номер строки в вводимой команде
            {
                numberCommand = Integer.parseInt(commandListChange.substring(0, 1))- 1;//Записываем первую цифру переменную
//                commandListChange = commandListChange.replaceAll("[0-9]", "");//Стирем первую цифру с нашей переменной
//                commandListChange = commandListChange.trim();//Удаляем все незначащие пробелы
            }
            else{
                numberCommand = productList.size();
            }
//
            switch (mainCommand) {//определяем введённую команду и выбирем что делать
                case "ADD":
                    System.out.println("Добавлен новый продукт");
                    productList.add(numberCommand,vvodKonsol);
                    break;
                case "EDIT":
                    System.out.println("Внесены необходимые изменения");
                    productList.set(numberCommand, vvodKonsol);
                    break;
                case "DELETE":
                    productList.remove(numberCommand);
                    System.out.println("Выполнено");
                    break;
                case "LIST":
                    for (String item: productList){
                        schetchik++;
                        System.out.println(schetchik +" " + item);

                    }
                    System.out.println();
                    break;
                case "EXIT" :
                    ciklYslovie = false;
                    break;
                default:
                    System.out.println("Неправильная команда, перезапустите работу");
                    ciklYslovie = false;
                    System.out.println(mainCommand);
                    break;
            }
            continue;

        }
    }
}
