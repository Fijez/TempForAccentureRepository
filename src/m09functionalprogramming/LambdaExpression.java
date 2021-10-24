package m09functionalprogramming;


import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *  написать метод:
 *  -вычисления максимального нечетного числа
 *  в диапазоне от 5 до 13 и вернуть его квадрат
 *
 *  -метод который получает два числа введенных с клавиатуры  и возвращает их произведение
 *
 *  - метод который принимает  три числа ( a, b,c )- стороны треугольника
 *  и возвращает площадь треугольника
 *
 */

public class LambdaExpression {

    public static void main(String[] args) {
        System.out.println(maxOdd());

       // System.out.println(multiply(new Scanner(System.in)));
    }

    public static double maxOdd () {
        Double[] numb = {5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0};
        double max = Stream.of(numb).
                filter(x -> x % 2 != 0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList()).get(0).doubleValue();
        return max * max;
    }

    public static double multiply(double x, double y) {
        return x*y;
    }

    public static double triangle(double a, double b, double c) {
      //  Stream.of(a,b,c).map((x,y,z) )
        return Double.parseDouble(null);
    }
}
