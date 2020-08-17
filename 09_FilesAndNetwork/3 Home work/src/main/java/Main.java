package main.java;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    public static final String CSV_DOCUMENTS = "src/main/resources/movementList.csv";

    public static void main(String[] args) {

        String delitel = ",";
        double purchase = 0;
        double purchaseDrobi = 0;
        double salary = 0;

        List<String> lines = null;
        HashMap<String, Double> listOfCompany = new HashMap<>();

        String[] linesSplit;

        try {
            lines = Files.readAllLines(Paths.get(CSV_DOCUMENTS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        lines.remove(0);

        for (String line : lines) { //получаем расход по документу в зависимости от валюты платежа
            linesSplit = line.split(delitel);//разбиваем строку на массив по запятым
            linesSplit[5] = linesSplit[5].replaceAll(".+((\\/){1}|(\\\\)){1}", "");
            linesSplit[5] = linesSplit[5].replaceAll("(\\s\\s).*", "");
            //оставляем в строке только информацию о фирме с которой был расход

            if (line.contains("\"")) {

                purchase += Integer.parseInt(linesSplit[linesSplit.length - 2].replace("\"", ""));//складываем целую часть в общую массу
                purchaseDrobi += Integer.parseInt(linesSplit[linesSplit.length - 1].replace("\"", ""));//прибавляем дробную часть
                salary += Integer.parseInt(linesSplit[linesSplit.length - 3]);//считаем доходы в ситуации с зарубежной валютой

                if (listOfCompany.containsKey(linesSplit[5]))//выбираем название фирмы
                {
                    double timesValue = 0;
                    timesValue = Integer.parseInt(linesSplit[linesSplit.length - 2].replace("\"", ""));
                    timesValue += listOfCompany.get(linesSplit[5]);//здесь надо будет накапливать расходы для какого-либо магазина
                    listOfCompany.replace(linesSplit[5], timesValue, timesValue); //меняем в мапе старое значение для ключа на новое
                } else {
                    listOfCompany.put(linesSplit[5], 0.0 + Integer.parseInt(linesSplit[linesSplit.length - 2].replace("\"", "")));
                }

            } else {
                purchase += Integer.parseInt(linesSplit[linesSplit.length - 1].replace("\"", ""));//складываем целую часть в общую массу
                salary += Integer.parseInt(linesSplit[linesSplit.length - 2]);//считаем доходы в ситуации с российской валютой

                if (listOfCompany.containsKey(linesSplit[5]))//выбираем название фирмы
                {
                    double timesValue = 0;
                    timesValue = Integer.parseInt(linesSplit[linesSplit.length - 1].replace("\"", ""));
                    timesValue += listOfCompany.get(linesSplit[5]);//здесь надо будет накапливать расходы для какого-либо магазина
                    listOfCompany.replace(linesSplit[5], timesValue, timesValue); //меняем в мапе старое значение для ключа на новое
                } else {
                    listOfCompany.put(linesSplit[5], 0.0 + Integer.parseInt(linesSplit[linesSplit.length - 1].replace("\"", "")));
                }
            }
            purchase += purchaseDrobi / 100;

        }
        System.out.println("rasxod = " + purchase);
        System.out.println("prixod = " + salary);

        for (Map.Entry entry : listOfCompany.entrySet()) {
            System.out.println(entry.getKey() + " расход: " + entry.getValue());
        }
    }
}

