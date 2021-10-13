package m02basics.samples;

public class LoopSamples {
    public static void main(String[] args) {
        // Цикл for
        System.out.println("----------Цикл for----------");
        for(int i = 0; i < 5; i++) {
            System.out.println(i + "^2 = " + i * i);
        }

        // Цикл for в обратном порядке
        System.out.println("----------Цикл for в обратном порядке----------");
        for(int i = 5; i >= 0; i--) {
            System.out.println("Индекс = " + i);
        }

        // Цикл for-each по массиву
        int[] intArray = { 1, 2, 6, -5 };
        System.out.println("----------Цикл for-each----------");
        for(int element: intArray) {
            System.out.println(element);
        }

        // Цикл for с без условия окончания с выходом через break
        // Вывести 10 чисел по условию
        System.out.println("----------Цикл for с без условия окончания с выходом через break----------");
        int count = 0;
        for(int i = 1; ; i++) {
            if (i % 3 == 2) {
                count++;
                System.out.println("Число №" + count + " = " + i);
                if(count == 10) {
                    break;
                }
            }
        }

        // Цикл while
        System.out.println("----------Цикл while----------");
        int counter = 0;
        while(counter < 5){
            System.out.println("Значение: " + counter);
            counter++;
        }

        //"Бесконечный цикл" через while с break/continue
        System.out.println("----------\"Бесконечный цикл\" через while с break/continue----------");
        counter = 0;
        while(true){
            counter++;
            if(counter % 2 == 0) {
                continue;
            }
            if(counter * counter > 1000) {
                System.out.println("Минимальное нечетное число с квадратом > 1000: " + counter);
                break;
            }
        }
    }
}
