import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Terminal;

import java.util.List;

public class Main
{
    private static List<Aircraft> kolichestvo;
     public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        airport.getTerminals();

        kolichestvo = airport.getAllAircrafts();
        kolichestvo.size() ;

        System.out.println(airport.getAllAircrafts());
        System.out.println(airport.getTerminals());
        System.out.println("Количество самолетов " + kolichestvo.size());



    }

}
