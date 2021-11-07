package m11pattern.tasks.WeatherStationPackage;

public interface Listener {
    void update(double temperature, double pressure,
                DirectionOfTheWind wind);
}
