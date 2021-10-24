package m09functionalprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Напишите программу , в которой задаете список студентов ( поля: имя , стипендия)
 * и произведите
 * - сортировку по стипендии
 * - сортировку по имени
 *
 */

public class ComparatorSort {

    public static void main(String[] args) {
        Map <String, Double> studentsMap = inputStudents();
        studentsMap.
                entrySet().
                stream().
                sorted(Map.Entry.<String, Double>comparingByValue()).
                forEach(System.out::println);
        System.out.println();
        studentsMap.
                entrySet().
                stream().
                sorted(Map.Entry.<String, Double>comparingByKey()).
                forEach(System.out::println);
    }

    public static Map<String, Double> inputStudents() {
        Scanner in = new Scanner(System.in);
        String str = " ";
        Double grant = 0.0;
        Map <String, Double> reuslt = new HashMap<>();
        for (int i = 0; i < 5; i++ ) {
            str = in.next();
            grant = in.nextDouble();
            reuslt.put(str, grant);
        }
        return reuslt;
    }
}
