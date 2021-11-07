package m11pattern.tasks.WeatherStationPackage;

public interface Subject {
    void subscribe(Listener listener);
    void unSubscribe(Listener listener);
    void notifyListeners();
}
