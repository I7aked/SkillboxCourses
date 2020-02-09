import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

public class Main
{

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        airport.getAllAircrafts();
        airport.getTerminals();

        System.out.println(airport.getAllAircrafts()+ " 1");
        System.out.println(airport.getTerminals() +" 2");


    }

}
