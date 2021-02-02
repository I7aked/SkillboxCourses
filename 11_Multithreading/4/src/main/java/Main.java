import java.util.Set;
import java.util.TreeSet;

public class Main
{
    //Пишу в одном потоке программу ИЛИ сразу придумываю принцип разделения
    //Просмотреть как парсить сайты и получать ссылки (JSOUP втидимо)
    //Разобраться с записью в файл и оступом в табуляцию при этом
    //
    //Идея работы - смотрим сайт, допустим стринговая переменная, нашли ссылку - создали новый поток и обрабатываем её
    //и так до тех пор, пока не получится что мы не находим новых ссылок, тогда возвращаемся обратно
    // собирая всё в кучу
    //ПОка так, потом придумаем дальше
    public static void main(String[] args) {
        Set<String> listSites = new TreeSet<String>();
        String url = "https://lenta.ru/";
        SiteMapExtractor extractor = new SiteMapExtractor(url);
        extractor.get_links(url);
        extractor.listSites.forEach(System.out::println);




    }

}
