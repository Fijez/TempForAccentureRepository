package m07.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Реализуйте программу , которая содержит перчень студентов ( имя, фамилия, порядковый номер)
 * и позволяет  вызвать студента путем ввода с консоли порядкового номера.
 * При неверно введенном номере ( если такого нет в списке) программа завершается исключением ArrayIndexOutOfBoundsException
 *
 * необходимо , чтобы в консоли при данной операции выводилась фраза : "Студента с таким номером не существует"
 */
public class ClassAnswer {

    public static void main(String[] args) {
        ClassAnswer classAnswer = new ClassAnswer();
        classAnswer.addStudent("stName", "stLastName",  1);
        classAnswer.addStudent("stName1", "stLastName1",  12);
        classAnswer.addStudent("stName2", "stLastName2",  123);
        classAnswer.addStudent("stName3", "stLastName3",  1234);

        classAnswer.callStudent(1);
        classAnswer.callStudent(2);

    }


    Map<Integer, Student> students = new HashMap<>();

    public ClassAnswer(String name, String lastName, int id) {
        this.students.put(id, new Student(name, lastName));
    }

    public ClassAnswer() {
    }

    public void addStudent(String name, String lastName, int id) {
        if (!students.containsKey(id)) {
            this.students.put(id, new Student(name, lastName));
        } else {
            System.out.println("Студент с таким номером существует, введите другой номер");
            id = new Scanner(System.in).nextInt();
            addStudent(name, lastName, id);
        }
    }

    @Override
    public String toString() {
        return "ClassAnswer{" +
                "student=" + students +
                '}';
    }

    public void callStudent (int id) {
        if (students.containsKey(id)) {
            System.out.println(students.get(id).toString());
        } else {
            throw new IllegalArgumentException("Такого студента не существует");
        }
    }
    private static class Student {
    String name;
    String lastName;

        public Student(String name, String lastName) {
            this.name = name;
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

}
