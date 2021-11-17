package m11pattern.tasks.home;

public interface Builder {
    void setWalls(Wall wall);
    void setWindows(Window window);
    void setSewerage(boolean sewerage);
    void setElectrician(boolean electrician);
    void setRoof(Roof roof);
    void setFoundation(Foundation foundation);
    void setGarage(Garage garage);
    void setGarden(boolean garden);
}
