import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Handler extends DefaultHandler {
    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private Voter voter;
    private List<Voter> voterCounts;

    public Handler() {
        voterCounts = new ArrayList<>();
    }

    public Voter getVoter() {
        return voter;
    }

    public void setVoter(Voter voter) {
        this.voter = voter;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            if (qName.equals("voter")) {
                Date birthDay = birthDayFormat.parse(attributes.getValue("birthDay"));
                voter = new Voter(attributes.getValue("name"), birthDay);
            } else if (qName.equals("visit") && voter != null) {
                voterCounts.add(voter);
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    public List<Voter> getVoterCounts() {
        return voterCounts;
    }

    public void setVoterCounts(List<Voter> voterCounts) {
        this.voterCounts = voterCounts;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("voter")) {
            voter = null;
        }
    }

}
