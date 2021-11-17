package m11pattern.tasks.home;

public class Roof {
    private Roof.RoofEnum type;

    public Roof(RoofEnum type) {
        this.type = type;
    }

    public enum RoofEnum {
        FLAT, SLOPE
    }

    @Override
    public String toString() {
        return "Roof{" +
                "type=" + type +
                '}';
    }
}
