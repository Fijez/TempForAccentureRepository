package m06collection.s.task;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * В классе PerfomanceAcademic необходимо объявить поле grades ( типа HashMap<String, Double>)
 * ключ- имя и фамилия студента, значение - средняя оценка.
 * Реализуйте методы: - который выводит только имена всех студентов;
 * - метод, который будет возвращать средний балл всех студентов
 * - метод, который выводит список студентов по среднему баллу, по убыванию
 *
 */

public class PerfomanceAcademic {
    public PerfomanceAcademic(Map<String, Double> grades) {
        this.grades = grades;
    }

    public static void main(String[] args) {
        Map<String, Double> map = new HashMap<>();
        map.put("A a",0.0);
        map.put("B b",1.0);
        map.put("C c",3.0);
        map.put("D d",2.0);
        map.put("E e",10.0);
        map.put("F f",5.0);
        PerfomanceAcademic perfomanceAcademic = new PerfomanceAcademic(map);
        perfomanceAcademic.sortGrades();
        System.out.println(perfomanceAcademic.getAverageScore());
        perfomanceAcademic.outputNames();
        Double[] arr = perfomanceAcademic.getAverageScoreOfEach();
        System.out.println(Arrays.toString(arr));
    }

    Map<String, Double> grades = new HashMap<>();

    public void outputNames () {
        for (String str : grades.keySet()) {
            System.out.println(str.split(" ")[0]);
        }
    }

    public Double[] getAverageScoreOfEach() {
        Collection<Double> values = grades.values();
        Double[] arr = values.toArray(new Double[0]);
        return arr;
    }

    public Double getAverageScore() {
       double avSc = 0;
        for (Double score : grades.values()) {
            avSc += score;
        }
        return avSc/grades.size();

    }

    public void sortGrades() {
        grades.entrySet().
                stream().
                sorted(Map.Entry.<String, Double>comparingByValue().reversed()).
                forEach(System.out::println);
    }

}
