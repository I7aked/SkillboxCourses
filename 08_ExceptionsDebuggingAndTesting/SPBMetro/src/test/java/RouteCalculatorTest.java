import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class RouteCalculatorTest extends TestCase
{
    List<Station> route = new ArrayList<>();
    StationIndex stationIndex = new StationIndex();
    RouteCalculator calculator = new RouteCalculator(stationIndex);
//    TreeMap<Station,Station> connection;
    List<Station> connection = new ArrayList<>();
    @Override
    protected void setUp() throws Exception//инициализирует данные
    {
//        List<Station> route = new ArrayList<>();
//        StationIndex stationIndex = new StationIndex();
//        RouteCalculator calculator = new RouteCalculator(stationIndex);

        Line line1 = new Line(1, "First");
        Line line2 = new Line(2, "Second");
        Line line3 = new Line(3, "Third");
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        Station st1 = new Station("1 Sony",line1);
        Station st2 = new Station("1 Frey",line1);
        Station st3 = new Station("1 Table",line1);
        Station st4 = new Station("2 Book",line2);
        Station st5 = new Station("2 Child",line2);
        Station st6 = new Station("3 Papple",line3);
        Station st7 = new Station("3 Cherry",line3);

        line1.addStation(st1);
        line1.addStation(st2);
        line1.addStation(st3);
        line2.addStation(st4);
        line2.addStation(st5);
        line3.addStation(st6);
        line3.addStation(st7);

        route.add(st1);
        route.add(st2);
        route.add(st3);
        route.add(st4);
        route.add(st5);
        route.add(st6);
        route.add(st7);

        connection.add(st3);
        connection.add(st4);
//        stationIndex.getConnectedStations(st3);
//        connection.add(st2);
//        connection.add(st1);
        connection.add(st6);
        connection.add(st5);
//        connection.add(st7);

        stationIndex.stations.addAll(route);
        stationIndex.addConnection(connection);

    }

    public void testGetShortestRouteWithZeroConnections(){

        List<Station> actual = calculator.getShortestRoute(route.get(0),route.get(2));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        expected.add(route.get(2));
        assertEquals(expected,actual);

    }

    public void testGetShortestRouteWithOneConnections(){

        List<Station> actual = calculator.getShortestRoute(route.get(0),route.get(3));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        expected.add(route.get(2));
        expected.add(route.get(3));
//        expected.add(route.get(4));

        assertEquals(expected,actual);

    }

    public void testGetShortestRouteWithTwoConnections(){

        List<Station> actual = calculator.getShortestRoute(route.get(0),route.get(6));
        List<Station> expected = new ArrayList<>();
        expected.add(route.get(0));
        expected.add(route.get(1));
        expected.add(route.get(2));
        expected.add(route.get(3));
        expected.add(route.get(4));
        expected.add(route.get(5));
        expected.add(route.get(6));
        assertEquals(expected,actual);

    }

    @Override
    protected void tearDown() throws Exception //удаляет данные после теста
    {

    }
}
