import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

public class SiteMapExtractor
{
    Set<String> listSites = new TreeSet<String>();
    String pageUrl;
    int flag = 0;
    public SiteMapExtractor() {}

    public SiteMapExtractor(String pageUrl)  {
        this.pageUrl = pageUrl;
    }

    //    public Set<String> uniqueURL = new HashSet<String>();
    public Map<String, Boolean> allURL = new TreeMap<>();


    //метод должен возвращать список ссылок имеющихся на странице
    public void get_links( String pageUrl) {

        try {
            Document doc = Jsoup.connect(pageUrl).userAgent("Mozilla").get();
            Elements links = doc.select("a");
//            if (links.isEmpty()) {
//                return;
//            }

            for (Element element : links)
            {
                String thisLink = (element.attr("abs:href"));
                if (thisLink.contains(pageUrl))
                {
                   if (listSites.contains(thisLink) && !thisLink.equals(pageUrl))
                    {
                        listSites.add("\t" + thisLink);
                    }else  if (!listSites.contains(thisLink))
                    {
                       listSites.add(thisLink);
                       allURL.put(thisLink,false);
                   }

                   if (pageUrl.equals(thisLink))
                   {
                       allURL.replace(thisLink,false,true);
                       flag += 1;
                   }
                }
            }

            if (flag == allURL.size() - 1 ){return;}

            for (Map.Entry entry : allURL.entrySet()) {

                if (entry.getValue().equals(false))
                {
                    get_links(entry.getKey().toString());
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
        } catch (Exception  ex) {
            ex.printStackTrace();
        }
    }

    public Map<String, Boolean> getAllURL()
    {
        return allURL;
    }

    public Set<String> getListSites(){return listSites;}

}
