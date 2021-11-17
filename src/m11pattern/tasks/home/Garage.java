package m11pattern.tasks.home;

public class Garage {
    private int count;
    private Garage.GarageEnum type;

    public Garage(int count, GarageEnum type) {
        this.count = count;
        this.type = type;
    }

    public enum GarageEnum {
        SMALL, LARGE
    }

    @Override
    public String toString() {
        return "Garage{" +
                "count=" + count +
                ", type=" + type +
                '}';
    }
}
