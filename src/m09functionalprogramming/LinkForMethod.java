package m09functionalprogramming;

/**
 * Разработать статический метод, который получает радиус шара и вычисляет
 * объем шара.
 * Реализовать передачу метода вычисления объема шара в другой метод
 * в качестве параметра.
 * Результат вывести в консоль
 *
 * Необходимые элементы :
 * - функциональный интерфейс с объявленным 1 методом
 * ( получает и возвращает  число типа double)
 * - класс  в котором объяв-ся статический метод
 * ( метод получает радиус шара и возвращает объем )
 * - класс в котором объявл-ся метод
 * (этот метод получает два парметра : 1 - ссылк ана интерфейс,
 * 2- радиус окружности)
 *
 */

public class LinkForMethod {

    public static void main(String[] args) {
        double radius = 10;
        MyFuncInterface<Double> myFuncInterface = SphereVolume::volume;
        double volume = volume(myFuncInterface, radius);
        System.out.println(volume);
    }

    public static double volume(MyFuncInterface<Double> myInterface, double radius){
        return myInterface.method(radius);
 }
}

class SphereVolume {
    private static final double pi = 3.14;

    public static double volume(double radius) {
        return (4 * pi * radius * radius * radius)/3;
    }
}

@FunctionalInterface
interface MyFuncInterface<Double> {
    double method(double value);
}
