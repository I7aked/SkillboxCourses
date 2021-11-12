import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Loader {

    private static SimpleDateFormat birthDayFormat = new SimpleDateFormat("yyyy.MM.dd");
    private static SimpleDateFormat visitDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    private static HashMap<Integer, WorkTime> voteStationWorkTimes = new HashMap<>();
    private static HashMap<Voter, Integer> voterCounts = new HashMap<>();

    public static void main(String[] args) throws Exception {
        String fileName = "C:\\Users\\User.DESKTOP-64BU9IM\\Desktop\\java\\Skillbox\\java_basics\\20_Performance\\VoteAnalyzer\\src\\main\\resources/data-1572M.xml";
        parseFile(fileName);
        DBConnection.printVoterCounts();
    }

    private static void parseFile(String fileName) throws Exception {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        Handler handler = new Handler();
        parser.parse(new File(fileName), handler);
        findEqualVoters(handler.getVoterCounts());
    }

    private static void findEqualVoters(List<Voter> mapVoter) throws Exception {

        for (Voter voter : mapVoter) {
            String name = voter.getName();
            SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy.MM.dd");
            String birthDay = dayFormat.format(voter.getBirthDay());
            DBConnection.countVoter(name, birthDay);
        }
        DBConnection.executeMultiInsert();
    }

}