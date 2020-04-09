import java.util.*;

public class Main {

    public static void main(String[] args) {
        String foundKey = "";
        String namePeople = "";
        String phoneNumber ;
        TreeMap<String ,String> phoneBook = new TreeMap<>();// Ввели список имя - номер



        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя или номер телефона");
            namePeople = scanner.nextLine();
            namePeople = namePeople.replaceAll("(\\+)?((\\-)*([\\(])*([\\)]*)((\\s)*))","");



            if (namePeople.equals("LIST")) {
                printMap(phoneBook);
            }
            else {


                if (!namePeople.replaceAll("(\\d+)","").equals("") ) {//Проверяем что остаётся после использование регулярного выражения

                    if (phoneBook.containsKey(namePeople)) {//Вывод имени и номера при совпадении имени
                        System.out.println(phoneBook.ceilingKey(namePeople) + " = " + phoneBook.get(namePeople));

                    } else {//Просьба ввести номер телефона при задании нового имени
                        System.out.println("Введите номер телефона " + namePeople);
                        phoneNumber = scanner.nextLine();
                        phoneNumber = phoneNumber.replaceAll("(\\+)?((\\-)*([\\(])*([\\)]*)((\\s)*))","");
                        phoneBook.put(namePeople, phoneNumber);
                        System.out.println("Изменения добавлены");
                    }
                } else {

                    if (phoneBook.containsValue(namePeople))  {//Вывод имени и номера при совпадении номера
                        foundKey = setValueMap(phoneBook,namePeople);
                        System.out.println(foundKey + " = " + namePeople);

                    } else {//Просьба ввести имя при задании нового номера телефона
                        System.out.println("Введите имя для номера " + namePeople);
                        phoneNumber = namePeople;
                        namePeople = scanner.nextLine();
                        phoneBook.put(namePeople, phoneNumber);
                        System.out.println("Изменения добавлены");
                    }
                }

            }
        }



    }
    private static void printMap (Map<String ,String> map) {//Метод вывода списка в консоль
        for (String key : map.keySet()) {
            String localValue;
            if (map.get(key).length() > 10) {
                localValue = map.get(key);
                localValue = localValue.substring(1,localValue.length());
                System.out.println(key + " = +7" + localValue);
            } else if (map.get(key).length() == 10) {
                System.out.println(key + " = +7" + map.get(key));
            }else{
                System.out.println(key + " = " + map.get(key));
            }
        }
    }

    private static String  setValueMap (Map<String ,String> map, String  name){//Метод получения имени по номеру телефона
        String result = name;
        for (String key:map.keySet()){
           if (map.get(key).equals(result) ){
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
