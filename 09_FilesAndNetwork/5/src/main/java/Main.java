import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.cliftonlabs.json_simple.Jsoner;
import com.google.gson.stream.JsonWriter;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        int numberStation = 0;
        int numberLine = 0;
        int countRepets = 0;

        Document doc = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").get();
        String bodyMetroMoskow = doc.body().toString();//Всё что тело html документа нынче строка
        Document metroMoskow = Jsoup.parse(bodyMetroMoskow); //полуичли html файл из этой строки

        Map<String, String> lineNameNumber = new TreeMap<>(); //Мапа с именем линии и номером линии.
        Map<String, String> stationNameLineNumber = new TreeMap<>() {
        };//Мапа Имя станции и номер линии
        Map<String, Map<String, String>> stationConnection = new TreeMap<>();//Переходы тоже в виде мапы? ВРоде бы там было так: TreeMap(<String>, Treemap(<String>, <String>))
        NavigableMap<Integer, String> numberLineLocal = new TreeMap();//вспомогательная мапа для получения последней линии и добавления её в мапу со станциями
        Map<String, List<String>> lineWithStations = new TreeMap<>();
        List<String> stationConnectionList = new ArrayList<>();
        List<String> numberLineList = new ArrayList<>();

        Elements elementsSpanHtmlPage = metroMoskow.select("span");
        //Сплитим по пробелам, складываем в лист стринг. Делаем стрим по строкам, ищем соответствия
        // в зависимости от соответствий заполняем мапы с элементами

//        elementsSpanHtmlPage.eachText().stream()// можно получить весь текст и заполнить частично мапы
//                .forEach(e -> { //условие со счетчиком для запоминания предыдущей строки
//                }); Останется как варинт возможного получения текста и работы со станциями
//      Как вариант прописать проверkупервого символа, типа первый цифра, второй точка и тогдачет делаем

        elementsSpanHtmlPage.stream()
                .map(el -> el.toString())
                .collect(Collectors.toList())
//                .forEach(System.out::println);
                .forEach(el -> {

                    //Собираем мапу с линиями метро
                    if (el.contains("data-line=")) {
                        String lineBilder = el.replaceAll("^(.+?>)", "");
                        String numberBilder = el.replaceAll(".+?(ln\\-)", "");
                        numberLineLocal.put(numberLineLocal.size() + 1, numberBilder.replaceAll("\".*", ""));
                        lineNameNumber.put(numberBilder.replaceAll("\".*", ""), lineBilder.replaceAll("<\\/span>", ""));
                        numberLineList.add(numberBilder.replaceAll("\".*", ""));

                    }

                    //Собираем мапу с именами станций и номерами линий станций
                    if (el.contains("class=\"name\"")) {
                        String stationName = el.replaceAll("^(.+?>)", "");
                        //Решение вопроса с повторяющимися названиями станций
                        boolean flag = false;
                        for (Map.Entry entry : stationNameLineNumber.entrySet()) {
                            if (entry.getKey().equals(stationName.replaceAll("<\\/span>", ""))) {
                                flag = stationName.replaceAll("<\\/span>", "").equals(entry.getKey());
                            }
                        }

                        if (!flag) {
                            stationNameLineNumber.put(stationName.replaceAll("<\\/span>", ""), numberLineLocal.lastEntry().getValue());
                            stationConnectionList.add(stationName.replaceAll("<\\/span>", ""));
                        } else {
                            stationNameLineNumber.put(" " + stationName.replaceAll("<\\/span>", ""), numberLineLocal.lastEntry().getValue());
                            stationConnectionList.add(stationName.replaceAll("<\\/span>", ""));
                        }
                    }

                    //Собираем мапу с именами станций и вложенной мапой с номерами линий перехода и комментариями
                    if (el.contains("title=\"переход"))
                    //если я делаю мапу с мапой в качестве ключа внутри, то надо её генерировать здесь в условии
                    //чтоб она записывалась со своими значениями, а не накапливалась
                    {
                        String lineConnection = el.replaceAll("^(.+?ln\\-)", "");
                        lineConnection = lineConnection.replaceAll("\".+", "");
                        String commentConnection = el.replaceAll("(.+?\\=\")", "");
                        commentConnection = commentConnection.replaceAll("\">.+", "");

                        Map<String, String> localMap = new HashMap<>();
                        localMap.put(lineConnection, commentConnection);
//                       stationLineConnection.add(stationConnectionList.get(stationConnectionList.size() - 1) + "  " +lineConnection + "  " +  commentConnection );
                        stationConnection.put(stationConnectionList.get(stationConnectionList.size() - 1), localMap);
                    }
                });

        for (int i = 0; i < numberLineList.size() - 1; i++) {
            List<String> stationLocalList = new ArrayList<>();

            for (Map.Entry entry : stationNameLineNumber.entrySet()) {
                if (numberLineList.get(i).equals(entry.getValue())) {
                    stationLocalList.add(entry.getKey().toString());
                }
            }
            lineWithStations.put(numberLineList.get(i), stationLocalList);
        }
//        lineWithStations.put(numberLineList.get(0),numberLineList);
//Реализовать мапы по принципу ключ - значения( Map<String,ArrayList<String>>)


//добавляю Джейсон обджектами свои мапы, делаю иерархию, потом пробую записать всё бафферед ридером

        //JsonSimple
//        задаём станции и линии в джейсоны
        JSONObject jsonStationNameLineNumber = new JSONObject();
        jsonStationNameLineNumber.putAll(lineWithStations);

        JSONObject jsonStationNameConnection = new JSONObject();
        jsonStationNameConnection.putAll(stationConnection);

        JSONObject jsonlineNameNumber = new JSONObject();
        jsonlineNameNumber.putAll(lineNameNumber);

        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("LinesAndStations.json"));
            writer.write("{ \"stations\" :");
            writer.newLine();
            Jsoner.serialize(jsonStationNameLineNumber, writer);
            writer.write(",");
            writer.newLine();
            writer.write("\"connections\" :");
            Jsoner.serialize(jsonStationNameConnection, writer);
            writer.write(",");
            writer.newLine();
            writer.write("\"lines\" :");
            writer.newLine();
            Jsoner.serialize(jsonlineNameNumber, writer);
            writer.newLine();
            writer.write("}");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//        //Google Jason
//        OutputStream outputStream = new ByteArrayOutputStream();
//        JsonWriter writer = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//        writer.beginObject(); // создаем токен начала главного объекта
//        writer.name("message"); // записываем поле message
//        writer.value("Hi\n");
//        writer.name("place"); // сохраняем объект Place в поле place
//        writer.beginObject(); // начинаем объект Place
//        writer.name("name");
//        writer.value("World!");
//        writer.endObject(); // закрываем объект Place
//        writer.endObject(); // закрываем главный объект
//        writer.close();
//        System.out.println(outputStream.toString()); // напечатает "{"message":"Hi","place":{"name":"World!"}}"

        //Jackson
//        BufferedWriter writer = Files.newBufferedWriter(Paths.get("customer.json"));
//        ObjectMapper mapper = new ObjectMapper();
//        writer.write(mapper.writeValueAsString(lineNameNumber));
//        writer.close();


//        for (Map.Entry entry : lineWithStations.entrySet()) {
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }

//        System.out.println(elementsSpanHtmlPage);
    }
}


