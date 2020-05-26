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
        Calendar calendar = Calendar.getInstance();
        Date dateFirst = calendar.getTime();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + 720000);
        Date dateSecond = calendar.getTime();

        calendar.set(2016, Calendar.DECEMBER,31);
        long keyFirst = calendar.getTimeInMillis();
        calendar.set(2018, Calendar.JANUARY,1);
        long keySecond = calendar.getTimeInMillis();

//        staff.stream()
////                .filter(e -> e.getWorkStart().before(new Date(2018, Calendar.JANUARY, 1)))
////                .filter(e -> e.getWorkStart().after(new Date(2016, Calendar.DECEMBER,31)))
//                .max(Comparator.comparing(Employee::getSalary))
//                .ifPresent(System.out::println);

//        staff.stream()
//                .filter(e -> e.getWorkStart().getTime() >= dateSecond.getTime() && e.getWorkStart().getTime() <= dateFirst.getTime())
//                .max(Comparator.comparing(Employee::getSalary))
//                .ifPresent(System.out::println);

        staff.stream().
                filter(e -> e.getWorkStart().getTime() > keyFirst)
                .filter(e -> e.getWorkStart().getTime() < keySecond)
                .max(Comparator.comparing(Employee::getSalary))
                .ifPresent(System.out::println);



        Airport airport = Airport.getInstance();
        airport.getTerminals().stream()//получаем список терминалов
                .map(Terminal::getFlights)//получаем список полётов из этих терминалов
                .flatMap(Collection::stream)//Сливаем все полёты в кучу
                .filter(f -> f.getDate().after( new Date( System.currentTimeMillis())))
                .filter(f -> f.getDate().before( new Date( System.currentTimeMillis() + 720000)))
                .peek(System.out::print)//Выводим список времени полёта
                .map(Flight::getAircraft)//переходим к моделям самолётов
                .forEach(System.out::println);//выводим списки самолётов



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