import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Handler extends DefaultHandler {
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private Voter voter;
    private HashMap<Voter,Integer> voterCounts;

    public Handler(){
        voterCounts = new HashMap<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {
            int count = voterCounts.getOrDefault(voter, 0);
            voterCounts.put(voter, count + 1);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

    public void printDuplicatedVoters()
    {
        for (Voter vot:voterCounts.keySet())
        {
            int count = voterCounts.get(vot);
            if (count > 1){
                System.out.println( vot.toString() + " - " + count);
            }
        }
    }
}
