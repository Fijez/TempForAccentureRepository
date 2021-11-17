package m11pattern.tasks.home;

public class Director {
    public void constructHomeWithGarageAndGardenAveragePrice(Builder builder) {
        builder.setElectrician(true);
        builder.setGarage(new Garage(1, Garage.GarageEnum.SMALL));
        builder.setGarden(true);
        builder.setFoundation(new Foundation(Foundation.FoundationEnum.WITHOUT_PILES));
        builder.setRoof(new Roof(Roof.RoofEnum.FLAT));
        builder.setSewerage(true);
        builder.setWalls(new Wall(4, Wall.WallEnum.STONE));
        builder.setWindows(new Window(4, Window.WindowEnum.PLASTIC));
    }
    public void constructHomeWithoutGarageAndGardenExpensive(Builder builder) {
        builder.setElectrician(true);
        builder.setFoundation(new Foundation(Foundation.FoundationEnum.PILE));
        builder.setRoof(new Roof(Roof.RoofEnum.FLAT));
        builder.setSewerage(true);
        builder.setWalls(new Wall(10, Wall.WallEnum.STONE));
        builder.setWindows(new Window(8, Window.WindowEnum.PLASTIC));
    }
    public void constructHut(Builder builder) {
        builder.setElectrician(false);
        builder.setFoundation(new Foundation(Foundation.FoundationEnum.WITHOUT_PILES));
        builder.setRoof(new Roof(Roof.RoofEnum.SLOPE));
        builder.setSewerage(false);
        builder.setWalls(new Wall(4, Wall.WallEnum.WOODEN));
        builder.setWindows(new Window(2, Window.WindowEnum.NOT_PLASTIC));
    }
}
