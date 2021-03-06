import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RouteCalculator
{

    private StationIndex stationIndex;

    private static double interStationDuration = 2.5;
    private static double interConnectionDuration = 3.5;

    public RouteCalculator(StationIndex stationIndex)
    {
        this.stationIndex = stationIndex;
    }

    public List<Station> getShortestRoute(Station from, Station to)
    {
        List<Station> route = getRouteOnTheLine(from, to);
        if(route != null) {
            return route;
        }

        //Если закоммитить этот метод, всё работает. Надо смотреть условия вызова метода с двумя пересадками и этого метода
        route = getRouteWithOneConnection(from, to);
        if(route != null && !route.isEmpty()) {
            return route;
        }

        route = getRouteWithTwoConnections(from, to);
        return route;
    }

    public static double calculateDuration(List<Station> route)
    {
        double duration = 0;
        Station previousStation = null;
        for(int i = 0; i < route.size(); i++)
        {
            Station station = route.get(i);
            if(i > 0)
            {
                duration += previousStation.getLine().equals(station.getLine()) ?
                    interStationDuration : interConnectionDuration;
            }
            previousStation = station;
        }
        return duration;
    }

    //=========================================================================

    private List<Station> getRouteOnTheLine(Station from, Station to)
    {
        if(!from.getLine().equals(to.getLine())) {
            return null;
        }
        ArrayList<Station> route = new ArrayList<>();
        List<Station> stations = from.getLine().getStations();
        int direction = 0;
        for(Station station : stations)
        {
            if(direction == 0)
            {
                if(station.equals(from)) {
                    direction = 1;
                } else if(station.equals(to)) {
                    direction = -1;
                }
            }

            if(direction != 0) {
                route.add(station);
            }

            if((direction == 1 && station.equals(to)) ||
                (direction == -1 && station.equals(from))) {
                break;
            }
        }
        if(direction == -1) {
            Collections.reverse(route);
        }
        return route;
    }

    private List<Station> getRouteWithOneConnection(Station from, Station to)
    {
        //если мы лежим на разных линиях(станции) это выражение всегда даёт false и всегда выполняется (или пытается выполниться(
        if(from.getLine().equals(to.getLine())) {
            return null;
        }

        ArrayList<Station> route = new ArrayList<>();

        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();
        for(Station srcStation : fromLineStations)
        {
            for(Station dstStation : toLineStations)
            {
                if(isConnected(srcStation, dstStation))
                {
                    ArrayList<Station> way = new ArrayList<>();
                    way.addAll(getRouteOnTheLine(from, srcStation));
                    way.addAll(getRouteOnTheLine(dstStation, to));
                    if(route.isEmpty() || route.size() > way.size())
                    {
                        route.clear();
                        route.addAll(way);
                    }
                }
            }
        }
        return route;
    }

    private boolean isConnected(Station station1, Station station2)
    {
        Set<Station> connected = stationIndex.getConnectedStations(station1);
        return connected.contains(station2);
    }

    private List<Station> getRouteViaConnectedLine(Station from, Station to)
            //Здесь должны просматривать многие станции и получать маршрут для тех, которые находятся на одной линии
            //fromConnected и toConnected - список станций(Set<Station>) которые имеют переходы со станциями from и to
            //Ниже, по идеи, мы просматриваем эти станци во вложенном цикле и в случаи нахождения их на одной линии строим маршрут по линиии
    {
        Set<Station> fromConnected = stationIndex.getConnectedStations(from);
        Set<Station> toConnected = stationIndex.getConnectedStations(to);
        for(Station srcStation : fromConnected)
        {
            for(Station dstStation : toConnected)
            {
                if(srcStation.getLine().equals(dstStation.getLine())) {
                    return getRouteOnTheLine(srcStation, dstStation);
                }
            }
        }
        return null;
    }

    private List<Station> getRouteWithTwoConnections(Station from, Station to)
    {
//        if (from.getLine().equals(to.getLine())) {
//            return null;
//        }

        ArrayList<Station> route = new ArrayList<>();

        List<Station> fromLineStations = from.getLine().getStations();
        List<Station> toLineStations = to.getLine().getStations();
        //получаем списки станций на линиях, на которых находятся исходные станции
        for(Station srcStation : fromLineStations)
        {
            for (Station dstStation : toLineStations)
            {
                List<Station> connectedLineRoute =
                    getRouteViaConnectedLine(srcStation, dstStation);
                if(connectedLineRoute == null) {
                    continue;
                }
                ArrayList<Station> way = new ArrayList<>();
                way.addAll(getRouteOnTheLine(from, srcStation));
                way.addAll(connectedLineRoute);
                way.addAll(getRouteOnTheLine(dstStation, to));
                if(route.isEmpty() || route.size() > way.size())
                {
                    route.clear();
                    route.addAll(way);
                }
            }
        }

        return route;
    }
}