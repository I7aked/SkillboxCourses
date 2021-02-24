import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class SiteMapExtractor extends RecursiveTask<Set<String>> {
    private static Set<String> urls = new HashSet<>();
    String pageUrl;

    public SiteMapExtractor() {
    }

    @Override
    protected Set<String> compute() {
        getChaildUrls();

        return getUrls();
    }

    public SiteMapExtractor(String pageUrl) {
        this.pageUrl = pageUrl;
    }


    public void getChaildUrls() {
        Set<String> urls = new HashSet<>();

        try {
            Document doc = Jsoup.connect(pageUrl).userAgent("Mozilla/5.0")
                    .ignoreHttpErrors(true).get();

            URL baseUrl = new URL(pageUrl);
            urls = doc.select("a").stream()
                    .map(e -> getChildUrl(baseUrl, e.attr("href")))
                    .filter(u -> u.startsWith(pageUrl))
                    .filter(u -> u.matches(pageUrl + "[a-zA-Z]+/"))
                    .collect(Collectors.toSet());

            SiteMapExtractor.urls.add(pageUrl);
            if (urls.size() == 0) {
                return;
            } else {
                for (String url : urls) {
                    if (!getUrls().contains(url)) {
                        SiteMapExtractor extractor = new SiteMapExtractor(url);
                        extractor.fork();
                        extractor.join();
                    }
                }
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getChildUrl(URL baseUrl, String href) {
        try {
            String childUrl = new URL(baseUrl, href).toString();
            int anchorIndex = childUrl.indexOf('#');
            if (anchorIndex > 0) {
                childUrl = childUrl.substring(0, anchorIndex);
            }
            return childUrl;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Некорректная ссылка");
            return "";
        }
    }

    public Set<String> getUrls() {
        return urls;
    }

}
