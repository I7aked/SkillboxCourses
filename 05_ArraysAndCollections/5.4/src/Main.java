import java.util.*;

public class Main {

    public static void main(String[] args) {
        String foundKey = "";
        String namePeople = "";
        Integer phoneNumber ;
        TreeMap<String ,Integer> phoneBook = new TreeMap<>();// Ввели список имя - номер



        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя или номер телефона");
            namePeople = scanner.nextLine();


            if (namePeople.equals("LIST")) {
                printMap(phoneBook);
            }
            else {


                if (Character.isDigit(namePeople.charAt(0)) == false) {//Проверяем введено ли у нас число на первой позиции, а следовательно и всё в строке

                    if (phoneBook.containsKey(namePeople)) {//Вывод имени и номера при совпадении имени
                        System.out.println(phoneBook.ceilingKey(namePeople) + " = " + phoneBook.get(namePeople));

                    } else {//Просьба ввести номер телефона при задании нового имени
                        System.out.println("Введите номер телефона " + namePeople);
                        phoneNumber = Integer.parseInt(scanner.nextLine());
                        phoneBook.put(namePeople, phoneNumber);
                        System.out.println("Изменения добавлены");
                    }
                } else {

                    if (phoneBook.containsValue(Integer.parseInt(namePeople)))  {//Вывод имени и номера при совпадении номера
                        foundKey = setValueMap(phoneBook,namePeople);
                        System.out.println(foundKey + " = " + namePeople);

                    } else {//Просьба ввести имя при задании нового номера телефона
                        System.out.println("Введите имя для номера " + namePeople);
                        phoneNumber = Integer.parseInt(namePeople);
                        namePeople = scanner.nextLine();
                        phoneBook.put(namePeople, phoneNumber);
                        System.out.println("Изменения добавлены");
                    }
                }

            }
        }



    }
    private static void printMap (Map<String ,Integer> map){//Метод вывода списка в консоль
        for (String key:map.keySet()){
            System.out.println(key + " = " + map.get(key));
        }
    }

    private static String  setValueMap (Map<String ,Integer> map, String  name){//Метод получения имени по номеру телефона
        String result = name;
        for (String key:map.keySet()){
           if (map.get(key) == Integer.parseInt(result) ){
               name = key;
           }
        }
        return name;
    }

//     private void kostiliMap (Map<String ,Integer> map, String firstNumber){//Метод вывода списка в консоль
//        boolean pravda = false;
//        for (String key:map.keySet()){
//            if ( map.get(key) == Integer.parseInt(firstNumber)){
//               firstNumber
//                }
//            }
//
//    }
}
