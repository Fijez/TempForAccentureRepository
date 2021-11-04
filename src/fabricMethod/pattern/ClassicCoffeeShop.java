package fabricMethod.pattern;

public class ClassicCoffeeShop implements CoffeeShop{

    private final MyCoffeeFactory coffeeFactory;

    public ClassicCoffeeShop(MyCoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    @Override
    public Coffee orderCoffee(CoffeeType type) {
        Coffee classicCoffee = coffeeFactory.createCoffee(type);
        classicCoffee.grindCoffee();
        classicCoffee.makeCoffee();
        classicCoffee.pourIntoCup();
        System.out.println("вот ваш кофе!");
        return classicCoffee;
    }

}
