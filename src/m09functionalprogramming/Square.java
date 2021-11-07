package m09functionalprogramming;

import java.util.Scanner;

/**
 * Реализуйте решение квадратного уравнения с использованием лямбда-выражений
 *
 */

public class Square {

    public static void main(String[] args) {
        System.out.println("Ввдеите коэф-ы a, b, c уравнения: ");
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        ForCalculating discriminant = Square::discriminant;

        ForCalculatingSquares squares = (x, y, z) -> {

            double discr = discriminant(x, y, z);
            if (discr < 0) {
                System.out.println("Действительных корней нет");
                throw new IllegalArgumentException();
            }
            if(discr == 0){
                System.out.println("Только один корень: ");
            }

            return Square.squaresF(x,y,discr);
        };

        double[] square = squares.calculate(a,b,c);

        System.out.println(square[0]);
        System.out.println(square[1]);
    }

    public static double discriminant(double a, double b, double c) {
        return b*b - 4*a*c;
    }

    public static double[] squaresF(double a, double b, double discriminant) {
        double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
        return new double[]{x1, x2};
        }
    }

    @FunctionalInterface
    interface ForCalculating {
        double calculate(double val1, double val2, double val3);
    }
    @FunctionalInterface
    interface ForCalculatingSquares {
        double[] calculate(double val1, double val2, double val3);
    }

