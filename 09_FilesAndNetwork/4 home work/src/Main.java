import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String FILE_TO = "../images" ;
    public static void main(String[] args) throws IOException {


        Document lenta = Jsoup.connect("https://lenta.ru/").get();//соединились с сайтом
        String body = lenta.body().toString();//собрали тело документа в строку
        Document doc = Jsoup.parse(body);//полуичли html файл из этой строки
        Elements element = doc.select("img");//получил теги рисунков с атрибутами и прочим

        element.stream()
                .map(el -> el.attr("abs:src"))
                .collect(Collectors.toList())
//               .forEach(System.out::println);
                .forEach(el ->
                {
                    try{

                        String fileName = el.replaceAll("(.+?\\/)","");
                        System.out.println(fileName);
                        String website = "";

                        if (!el.contains("watch")) {
                             website = el.replaceAll("([A-Z]*[a-z]*[0-9]*\\_.+\\.[jp]?[jpg]?[png]?.?)", "") + fileName;
                        }
                        else{
                             website = el.replaceAll("([A-Z]*[a-z]*[0-9]*\\_.+\\.[jp]?[jpg]?[png]?.?)", "") ;
                        }

                        URL url = new URL(website);
                        File file = new File("./images/" + fileName);

                        InputStream inputStream = url.openStream();
                        OutputStream outputStream = new FileOutputStream(file);
                        byte[] buffer = new byte[2048];

                        int length = 0;

                        while ((length = inputStream.read(buffer)) != -1) {
                            System.out.println("Buffer Read of length: " + length);
                            outputStream.write(buffer, 0, length);
                        }

                        inputStream.close();
                        outputStream.close();


                    } catch(Exception e) {
                        System.out.println("Exception: " + e.getMessage());
                    }

                });    ;

//        List<String> imageOnes = Arrays.asList(element.toString().split("\\n"));
//
//        imageOnes.stream()
//                .map(el -> el.replaceAll("((\\<img.+?src)[^\"])",""))
//                .map(el -> el.replaceAll("\\s.+",""))
//
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

    }
}
