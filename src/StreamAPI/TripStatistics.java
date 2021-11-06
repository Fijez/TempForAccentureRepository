package StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TripStatistics {
    public static List<User> downstreamTrips (List<User> users) {
        return users.stream().
                sorted(Comparator.comparing(user -> user.getTrips().size(),
                        Comparator.reverseOrder())).
                collect(Collectors.toList());
    }

    public static User minimumTrips (List<User> users) {
        return users.stream().min(Comparator.comparing(user -> user.getTrips().size())).get();
    }
}
