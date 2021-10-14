package m07.task;

/**
 * Реализуйте программу , которая содержит перчень студентов ( имя, фамилия, порядковый номер)
 * и позволяет  вызвать студента путем ввода с консоли порядкового номера.
 * При неверно введенном номере ( если такого нет в списке) программа завершается исключением ArrayIndexOutOfBoundsException
 *
 * необходимо , чтобы в консоли при данной операции выводилась фраза : "Студента с таким номером не существует"
 */
public class ClassAnswer {

    public static void main(String[] args) {
        Student st = new Student();
    }


    Student student;

    public ClassAnswer(String name, String lastName, double id) {
        this.student.name = name;
        this.student.lastName = lastName;
        this.student.id = id;
    }
    @Override
    public String toString() {
        return "ClassAnswer{" +
                "name='" + student.name + '\'' +
                ", lastName='" + student.lastName + '\'' +
                ", id=" + student.id +
                '}';
    }

    public void callStudent (int id) {

    }
    private static class Student {
    String name;
    String lastName;
    double id;
    }

}
