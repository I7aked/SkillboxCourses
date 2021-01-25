import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinksName
{

    //    public Set<String> uniqueURL = new HashSet<String>();
    public Set<String> allURL = new TreeSet<>();

    //метод должен возвращать список ссылок имеющихся на странице
    public void get_links(String url) {
        try {
            Document doc = Jsoup.connect(url).userAgent("Mozilla").get();
            Elements links = doc.select("a");

//            if (links.isEmpty()) {
//                return;
//            }

            for (Element elements : links)
            {
                if (elements.attr("abs:href").contains(url))
                {
                    allURL.add(elements.attr("abs:href"));
                }
            }
//
//            links.stream().map((link) -> link.attr("abs:href")).forEachOrdered((this_url) -> {
//                boolean add = uniqueURL.add(this_url);
//                if (add && this_url.contains(url)) {
//                    allURL.add("\t" + this_url );
//                    get_links(this_url);
//                }
//            });

//            links.stream().map(link -> link.attr("abs:href")).forEach(link ->allURL.add(link) );
////            allURL.addAll(uniqueURL);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Set<String> getAllURL()
    {
        return allURL;
    }

}
