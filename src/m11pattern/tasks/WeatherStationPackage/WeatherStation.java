package m11pattern.tasks.WeatherStationPackage;

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

    class WeatherData implements Subject{

        List<Listener> listeners;

        private double temperatureCelsius;
        private double pressure;
        private DirectionOfTheWind windDirection;


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
