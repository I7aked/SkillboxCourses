import java.util.*;

public class Main {

    public static void main(String[] args) {

        String mashinNumberLetters = "ABCEHKMOTPXY";
        String mashineNumberLettersChanges = "";
        String mashineNumberLettersChangesSecond = "";
        String mashineNumber = "";
        String mashineNumberSecond = "";
        String mashineNumberThird = "";
        String mashineNumberFour = "";
        String mashineNumberFive = "";
        String numberRegion = "";
        String numberNumber = "";
        String timesLetter = "";
        String vvodKonsol ="";
        long duration ;

        ArrayList<String> mashinNumberList = new ArrayList<>();

        mashineNumberLettersChanges = "" + mashinNumberLetters;

        for (int m = 0; m < mashinNumberLetters.length();m++ ) {
            mashineNumber = "";
            mashineNumberLettersChangesSecond = "" + mashinNumberLetters;
            mashineNumber = "" + mashinNumberLetters.charAt(m);//Втсавляем первую букву в наш номер
            timesLetter = "" + mashinNumberLetters.charAt(m);
            mashineNumberLettersChangesSecond = mashineNumberLettersChangesSecond.replaceAll(timesLetter,"");//Стёрли использованную букву

            for (int l = 1; l < 10; l++) {
                mashineNumberSecond ="" + mashineNumber;

                if (l < 10) {
                    numberNumber = "00" + l;
                } else if (l < 100) {
                    numberNumber = "0" + l;
                } else {
                    numberNumber = "" + l;
                }
                mashineNumber = mashineNumber + "" + numberNumber;// добавляем к первой букве номер на номере машины

                for (int k = 0; k < mashineNumberLettersChangesSecond.length(); k++) {
                    mashineNumberThird = "" + mashineNumber;
                    mashineNumberLettersChanges = "" + mashineNumberLettersChangesSecond;//Версия со съеденной буковкой в первом цикле
                    mashineNumber = mashineNumber + "" + mashineNumberLettersChanges.charAt(k);//прибавляем первую букву из 2 к номеру
                    timesLetter = "" + mashineNumberLettersChanges.charAt(k);//вычленяем символ из списка букв и удаляем его
                    mashineNumberLettersChanges = mashineNumberLettersChanges.replaceAll(timesLetter, "");//удаляем символ с соответствующим индексом
                    //Исходим из того, что первая буква уже удалена из списка

                    for (int j = 0; j < mashineNumberLettersChanges.length(); j++) {//Задаём наружнюю букву после цифр в номере машины
                        mashineNumberFour = "" + mashineNumber;
                        mashineNumber = mashineNumber + "" + mashineNumberLettersChanges.charAt(j);//прибавляем вторую букву к номеру из списка оставшихся

                        for (int i = 1; i < 200; i++) {//Определяем регионы. До 10 как 01,02 и тд
                            mashineNumberFive = "" + mashineNumber;
                            if (i < 10) {
                                numberRegion = "0" + i;
                                mashineNumber = mashineNumber.concat(numberRegion);
                                mashinNumberList.add(mashineNumber);
                            } else {

                                numberRegion = "" + i;
                                mashineNumber = mashineNumber.concat(numberRegion);
                                mashinNumberList.add(mashineNumber);
                            }
                            mashineNumber ="" + mashineNumberFive;
                        }
                        mashineNumber = "" + mashineNumberFour;
                    }
                    mashineNumber = mashineNumberThird;
                }
                mashineNumber = "" + mashineNumberSecond;
            }

        }
//        for (String item:mashinNumberList){
//            System.out.println(item);
//        }


        HashSet <String> hashineNumberList = new HashSet<>();
        hashineNumberList.addAll(mashinNumberList);

        TreeSet <String> sashineNumberList = new TreeSet<>();
        sashineNumberList.addAll(mashinNumberList);

        System.out.println("VVedite nomer");
        Scanner scanner = new Scanner(System.in);
        vvodKonsol = scanner.nextLine();

        long start = System.nanoTime();
        if  (mashinNumberList.contains(vvodKonsol)) {
            duration = System.nanoTime() - start;
            System.out.println("Простой перебор = " + duration);
        }else {
            System.out.println("Номера нет в базе");
        }


        start = System.nanoTime();
        if  (sashineNumberList.contains(vvodKonsol)) {
            duration = System.nanoTime() - start;
            System.out.println("Поиск в ТриСет = " + duration);
        }else {
            System.out.println("Номера нет в базе");
        }


        start = System.nanoTime();
           if  (hashineNumberList.contains(vvodKonsol)) {
               duration = System.nanoTime() - start;
               System.out.println("Поиск в ХешСет = " + duration);
           }else {
               System.out.println("Номера нет в базе");
           }

        Collections.sort(mashinNumberList);
        start = System.nanoTime();
        if  (Collections.binarySearch(mashinNumberList,vvodKonsol) > 0) {
            duration = System.nanoTime() - start;
            System.out.println("Бинарный поиск = " + duration);
        }else {
            System.out.println("Номера нет в базе");
        }
    }

}
