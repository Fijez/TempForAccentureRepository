package m11pattern.tasks.WeatherStationPackage;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Station implements Listener{

    double temperatureMin;
    double temperatureMax;
    double temperatureAverage;
    List <Double> temperatureHistory = new LinkedList<>();
    double pressureMin;
    double pressureMax;
    double pressureAverage;
    List <Double> pressureHistory = new LinkedList<>();
    List<DirectionOfTheWind> windDirection;
    DirectionOfTheWind maxWindDirection;
    DirectionOfTheWind minWindDirection;
    DirectionOfTheWind averageWindDirection;

    @Override
    public void update(double temperature, double pressure, DirectionOfTheWind wind) {
        this.pressureMin = Math.min(pressure, this.pressureMin);
        this.pressureMax = Math.max(pressure, this.pressureMax);
        this.pressureHistory.add(pressure);
        this.pressureAverage = average(pressureHistory);
        this.temperatureMin = Math.min(temperature, temperatureMin);
        this.temperatureMax = Math.max(temperature, temperatureMax);
        this.temperatureAverage = average(temperatureHistory);
        this.windDirection.add(wind);
        this.maxWindDirection = maxWindDirectional(windDirection);
        this.minWindDirection = minWindDirectional(windDirection);
        //this.averageWindDirection = averageWindDirection(windDirection);
    }

    private static double average(List <Double> list) {
        double result = 0;
        for (Double value :
                list) {
            result +=value;
        }
        return result/list.size();
    }

    private static DirectionOfTheWind maxWindDirectional(List <DirectionOfTheWind> list) {
        Map<DirectionOfTheWind, Long> counts =
                list.stream().
                        collect(Collectors.
                                groupingBy(e -> e, Collectors.counting()));
        return counts.entrySet().
                stream().
                max(Map.Entry.comparingByValue()).
                get().
                getKey();
    }

    private static DirectionOfTheWind minWindDirectional(List <DirectionOfTheWind> list) {
        Map<DirectionOfTheWind, Long> counts =
                list.stream().
                        collect(Collectors.
                                groupingBy(e -> e, Collectors.counting()));
        return counts.entrySet().
                stream().
                min(Map.Entry.comparingByValue()).
                get().
                getKey();
    }

    private static void averageWindDirectional(List <DirectionOfTheWind> list) {
        Map<DirectionOfTheWind, Long> counts =
                list.stream().
                        collect(Collectors.
                                groupingBy(e -> e, Collectors.counting()));
       //реализовать поиск наибольшего среднего среди всех направлений
    }

}
