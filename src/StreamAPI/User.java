package StreamAPI;

import java.util.List;

public class User{

    private String name;
    private List<Trip> trips;

    public User(String name) {
        this.name = name;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", trips=" + trips.size() +
                '}' + '\n';
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
