package m06collection.s.task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Реализуйте метод, который добавит 500000 элементов в ArrayList и LinkedList.
 * реализуйте метод, который выберет из заполненного списка наугад элементы 500000 раз.
 * Замерьте время, которое было потрачено на это.
 * сравните результаты
 *
 *
 */
public class ArrayContraLinked {
    public static void main(String[] args) {
        double time1;
        double time2;
        List <Integer> arrayList = new ArrayList<>();
        List <Integer> linkedList = new LinkedList<>();
        time1 = System.currentTimeMillis();
        addFiftyThousands(arrayList);
        time1 =  System.currentTimeMillis() - time1;
        time2 = System.currentTimeMillis();
        outputFiftyThousands(arrayList);
        time2 = System.currentTimeMillis() - time2;

        time1 /= 1000;
        time2 /= 1000;
        double time = time1 + time2;
        System.out.println();
        System.out.println(time1 + " " + time2 + " " + time);//0.035 0.051 0.086

        System.out.println("------------------------------------------------------");

        time1 = System.currentTimeMillis();
        addFiftyThousands(linkedList);
        time1 =  System.currentTimeMillis() - time1;
        time2 = System.currentTimeMillis();
        outputFiftyThousands(linkedList);
        time2 = System.currentTimeMillis() - time2;
        time1 /= 1000;
        time2 /= 1000;
        time = time1 + time2;
        System.out.println();
        System.out.println(time1 + " " + time2 + " " + time);//0.156 486.959 487.115

    }

    public static void addFiftyThousands(List <Integer> list) {
        for (int i = 0; i < 500000; i++) {
            list.add((int) (Math.random()*100000));
        }
    }

    public static void outputFiftyThousands(List <Integer> list) {
        for (int i : list) {
            int j = list.get((int) (Math.random() * 500000));
        }
    }


}
