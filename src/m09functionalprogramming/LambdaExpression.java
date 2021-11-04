package m09functionalprogramming;



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
       MultiplyInterface <Double> multiplyInterface = () -> {
            System.out.println("Введите два числа");
            Scanner scanner = new Scanner(System.in);
            return scanner.nextDouble() * scanner.nextDouble();
        };
        System.out.println(multiplyInterface.multiply());

        System.out.println(triangle(10,20,29));
    }

    public static double maxOdd () {
        Double[] numb = {5.0,6.0,7.0,8.0,9.0,10.0,11.0,12.0,13.0};
        double max = Stream.of(numb).
                filter(x -> x % 2 != 0).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList()).get(0).doubleValue();
        return max * max;
    }

    @FunctionalInterface
    interface MultiplyInterface <T> {
        T multiply();
    }

    public static double triangle(double a, double b, double c) {

        ConditionCheck check = () -> {
            return a + b > c && a + c > b && b + c > a;
        };

        if (check.check()) {
            Square sq = () -> {
                double perimeter = (a + b + c)/2;
                double temp1 = perimeter - a;
                double temp2 = perimeter - b;
                double temp3 = perimeter - c;
                return Math.sqrt(perimeter*temp1*temp2*temp3);
            };
            return sq.square();
        }
        else {
            throw new IllegalArgumentException("Неверно указаны стороны треугольника");
        }
    }
    @FunctionalInterface
    interface Square {
        double square();
    }
    @FunctionalInterface
    interface ConditionCheck {
        boolean check();
    }
}
