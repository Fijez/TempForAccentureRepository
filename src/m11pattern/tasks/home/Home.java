package m11pattern.tasks.home;

/**
 * Реализуйте стройку дома с помощью паттерна
 * builder
 */

public class Home {

    private final Wall wall;
    private final Window window;
    private final boolean sewerage;
    private final boolean electrician;
    private final Roof roof;
    private final Foundation foundation;
    private final Garage garage;
    private final boolean garden;
    private final boolean isLarge;


    public Home(Wall wall, Window window, boolean sewerage,
                boolean electrician, Roof roof, Foundation foundation,
                Garage garage, boolean garden, boolean isLarge) {
        this.wall = wall;
        this.window = window;
        this.sewerage = sewerage;
        this.electrician = electrician;
        this.roof = roof;
        this.foundation = foundation;
        this.garage = garage;
        this.garden = garden;
        this.isLarge = isLarge;
    }

    @Override
    public String toString() {
        return "Home{" +
                "wall=" + wall +
                ", window=" + window +
                ", sewerage=" + sewerage +
                ", electrician=" + electrician +
                ", roof=" + roof +
                ", foundation=" + foundation +
                ", garage=" + garage +
                ", garden=" + garden +
                '}';
    }

    public Wall getWall() {
        return wall;
    }

    public Window getWindow() {
        return window;
    }

    public boolean isSewerage() {
        return sewerage;
    }

    public boolean isElectrician() {
        return electrician;
    }

    public Roof getRoof() {
        return roof;
    }

    public Foundation getFoundation() {
        return foundation;
    }

    public Garage getGarage() {
        return garage;
    }

    public boolean isGarden() {
        return garden;
    }

    public boolean isLarge() {
        return isLarge;
    }
}
