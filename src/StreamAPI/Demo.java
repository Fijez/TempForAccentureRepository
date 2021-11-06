package StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<>(
                Arrays.asList(
                        new User("u1"),
                        new User("u2"),
                        new User("u3"),
                        new User("u4"),
                        new User("u5"),
                        new User("u6"),
                        new User("u7"),
                        new User("u8")));
        userList.get(0).setTrips(new LinkedList<>(List.of(
                new Trip()
        )));
        userList.get(1).setTrips(new LinkedList<>(Arrays.asList(
                new Trip(),new Trip()
        )));
        userList.get(2).setTrips(new LinkedList<>(Arrays.asList(
                new Trip(),new Trip(),new Trip()
        )));
        userList.get(3).setTrips(new LinkedList<>(Arrays.asList(
                new Trip(),new Trip(),new Trip(),new Trip()
        )));
        userList.get(4).setTrips(new LinkedList<>(Arrays.asList(
                new Trip(),new Trip(),new Trip(),new Trip(),new Trip()
        )));
        userList.get(5).setTrips(new LinkedList<>(Arrays.asList(
                new Trip(),new Trip(),new Trip(),new Trip(),new Trip(),new Trip()
        )));
        userList.get(6).setTrips(new LinkedList<>(Arrays.asList(
                new Trip(),new Trip(),new Trip(),new Trip(),new Trip(),new Trip(),new Trip()
        )));
        userList.get(7).setTrips(new LinkedList<>(List.of(
                new Trip()
        )));

        System.out.println(TripStatistics.minimumTrips(userList));
        System.out.println(TripStatistics.downstreamTrips(userList));
    }
}
