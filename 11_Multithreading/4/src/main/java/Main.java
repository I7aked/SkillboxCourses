import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ForkJoinPool;

public class Main
{
    public static void main(String[] args) {
        String url = "https://skillbox.ru/";
        Set<String> urls = new ForkJoinPool().invoke( new SiteMapExtractor(url));
        urls.stream().sorted().forEach(System.out::println);


    }

}
