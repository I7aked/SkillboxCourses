import java.util.Set;
import java.util.TreeSet;

public class Main
{
    public static void main(String[] args) {
        String url = "https://skillbox.ru/";
        SiteMapExtractor extractor = new SiteMapExtractor(url);
        extractor.getChaildUrls();
        extractor.getUrls().forEach(System.out::println);
        System.out.println(extractor.getUrls().size());



    }

}
