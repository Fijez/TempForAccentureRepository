package m11pattern.tasks;

/**
 * Реализуйте схему нагревателя для шоколада, не забудьте учесть такие моменты как слив холодной смеси,
 * переполнение или нагревание пустой емкости
 * используйте паттерн Singleton
 */

class Demo {
    public static void main(String[] args) {
        ChocolateBoiler chocolateBoiler;
        chocolateBoiler = ChocolateBoiler.getInstance(350);
        System.out.println(chocolateBoiler.getVolumeMilliliters());
        chocolateBoiler.pourADrink(1000);
        System.out.println(chocolateBoiler.getVolumeMilliliters());
        chocolateBoiler.pourADrink(100);
        System.out.println(chocolateBoiler.getVolumeMilliliters());
        chocolateBoiler.pourADrink(100);
        System.out.println(chocolateBoiler.getVolumeMilliliters());
    }
}

public class ChocolateBoiler {

    private double volumeMilliliters;
    private static ChocolateBoiler chocolateBoiler;
    private static final double MAX_DRAIN_MILLILITERS = 250;
    //полагаю для объема размера стаканчиков можно поставить константу

    private void liquidDrain(double drainVolume) {
        if (this.volumeMilliliters >= drainVolume) {
            if (drainVolume >= MAX_DRAIN_MILLILITERS) {
                this.volumeMilliliters -= MAX_DRAIN_MILLILITERS;
            } else {
                this.volumeMilliliters -= drainVolume;
            }
        } else {

            this.volumeMilliliters = this.volumeMilliliters >= MAX_DRAIN_MILLILITERS?
                    this.volumeMilliliters - MAX_DRAIN_MILLILITERS:0;
        }
    }

    public void pourADrink(double drainVolume) {
        //можно добавить параментр "напиток" для большей реалистичности
        liquidDrain(drainVolume);
        heatUp();
    }

    private boolean heatUp() {
        if (volumeMilliliters > 0) {
            return true;
        } else {
            System.out.println("boiler is empty, can't heat up");
            return false;
        }
    }


    private ChocolateBoiler(double volumeMilliliters) {
        this.volumeMilliliters = volumeMilliliters;
    }

    public static ChocolateBoiler getInstance(double volumeMilliliters) {
        if(chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler(volumeMilliliters);
        }
        return chocolateBoiler;
    }

    public double getVolumeMilliliters() {
        return volumeMilliliters;
    }

}
