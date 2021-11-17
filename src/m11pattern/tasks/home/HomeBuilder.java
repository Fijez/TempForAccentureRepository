package m11pattern.tasks.home;

public class HomeBuilder implements Builder{

    Wall wall;
    Window window;
    boolean sewerage;
    boolean electrician;
    Roof roof;
    Foundation foundation;
    Garage garage;
    boolean garden;
    boolean isLarge;

    @Override
    public void setWalls(Wall wall) {
        this.wall = wall;
    }

    @Override
    public void setWindows(Window window) {
        this.window = window;
    }

    @Override
    public void setSewerage(boolean sewerage) {
        this.sewerage = sewerage;
    }

    @Override
    public void setElectrician(boolean electrician) {
        this.electrician = electrician;
    }

    @Override
    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    @Override
    public void setFoundation(Foundation foundation) {
        this.foundation = foundation;
    }

    @Override
    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    @Override
    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public Home getResult() {
        return new Home(wall, window,
                sewerage, electrician, roof, foundation,
                garage, garden, isLarge);
    }
}
