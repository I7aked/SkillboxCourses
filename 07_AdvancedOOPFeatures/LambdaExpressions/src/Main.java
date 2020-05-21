import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;


public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";


    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        staff.stream()
                .filter(e -> e.getWorkStart().before(new Date(01, 01, 2018)) && e.getWorkStart().after(new Date(31, 12,2016)))
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);

        Airport airport = Airport.getInstance();

        airport.getTerminals().stream()
                .map(Terminal::getFlights).filter();




//        for (Employee employee: staff)
//        {
//            System.out.println(employee);
//        }
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}