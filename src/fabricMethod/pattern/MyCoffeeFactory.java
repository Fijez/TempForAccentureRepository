package fabricMethod.pattern;

public class MyCoffeeFactory {
    public Coffee createCoffee(CoffeeType type) {
        Coffee coffe = null;
        switch (type) {
            case CAPPUCINO:
                coffe = new Cappuchino();
                break;
            case ESPRESSO:
                coffe = new Espresso();
                break;
            case AMERICANO:
                coffe = new Americano();
                break;
        }
        return coffe;
    }

}
