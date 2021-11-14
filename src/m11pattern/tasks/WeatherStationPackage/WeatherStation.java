package m11pattern.tasks.WeatherStationPackage;

import java.util.ArrayList;
import java.util.List;

/**
 * есть проект WeatherStation, который включает класс WeatherData и
 * его элементы
 * Идея состоит в том, что на станцию передают данные о погоде
 * ( температура, давление, направление ветра)
 * по полученным данным строятся мин, среднее и максимальное значения
 *
 * все погодные элементы реализуют интерфейс Observe
 *паттерн "наблюдатель"
 */

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        wd.setPressure(760);
        wd.setTemperatureCelsius(20);
        wd.setWindDirection(DirectionOfTheWind.NORTH);
        Listener st1 = new Station();
        Listener st2 = new Station();
        Listener st3 = new Station();
        Listener st4 = new Station();
        Listener st5 = new Station();
        wd.subscribe(st1);
        wd.subscribe(st2);
        wd.subscribe(st3);
        wd.subscribe(st4);
        wd.subscribe(st5);
        wd.notifyListeners();

        wd.setPressure(60);
        wd.setTemperatureCelsius(70);
        wd.setWindDirection(DirectionOfTheWind.EAST);
        wd.notifyListeners();

        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);
        System.out.println(st4);
        System.out.println(st5);
    }

    static class WeatherData implements Subject{

        List<Listener> listeners = new ArrayList<>();

        private double temperatureCelsius;
        private double pressure;
        private DirectionOfTheWind windDirection;


        public void setTemperatureCelsius(double temperatureCelsius) {
            this.temperatureCelsius = temperatureCelsius;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public void setWindDirection(DirectionOfTheWind windDirection) {
            this.windDirection = windDirection;
        }

        @Override
        public void subscribe(Listener listener) {
            listeners.add(listener);
        }

        @Override
        public void unSubscribe(Listener listener) {
            listeners.remove(listener);
        }

        @Override
        public void notifyListeners() {
            for (Listener listener :
                    listeners) {
                listener.update(temperatureCelsius, pressure, windDirection);
            }
        }
    }
}
