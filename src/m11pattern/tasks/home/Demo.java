package m11pattern.tasks.home;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        HomeBuilder builder = new HomeBuilder();
        director.constructHomeWithGarageAndGardenAveragePrice(builder);
        Home home1 = builder.getResult();
        director.constructHomeWithoutGarageAndGardenExpensive(builder);
        Home home2 = builder.getResult();
        director.constructHut(builder);
        Home home3 = builder.getResult();
        System.out.println(home1.toString());
        System.out.println(home2.toString());
        System.out.println(home3.toString());
    }
}
