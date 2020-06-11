import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase
{
    List<Station> route = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator calculator = new RouteCalculator(stationIndex);

    @Override
    protected void setUp() throws Exception//инициализирует данные
    {
//        List<Station> route = new ArrayList<>();
//        StationIndex stationIndex = new StationIndex();
//        RouteCalculator calculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");

        route.add(new Station("Sony",line1));
        route.add(new Station("Frey",line1));
        route.add(new Station("Table",line1));
        route.add(new Station("Book",line2));
        route.add(new Station("Child",line2));
        route.add(new Station("Cherry",line3));
        route.add(new Station("Papple",line3));

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.stations.addAll(route);
        stationIndex.addConnection(route);

    }

    public void testGetShortestRoute(){

        List<Station> actual = calculator.getShortestRoute(route.get(0),route.get(2));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(1));
        expected.add(route.get(2));
        assertEquals(expected,actual);

    }
    @Override
    protected void tearDown() throws Exception //удаляет данные после теста
    {

    }
}
