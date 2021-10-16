package m06collection.s.task;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * В классе SearchAndDelete реализуйте следующие методы:
 * - метод removeBugWithFor(ArrayList<String>) , который удаляет строку из списка,
 * если она содержит слово bug используя цикл for и счетчик
 *
 * - метод removeBugWithWhile(ArrayList<String>) , который удаляет строку из списка,
 * если она содержит слово bug, используя цикл while и метод iterator
 *
 *- метод removeBugWithCopy(ArrayList<String>) оторый удаляет строку из списка,
 *  * если она содержит слово bug, используя цикл for-each и копию списка
 *
 *  регистр не учитываем
 *
 *  список слов : Risha, Easy ug,bug, Bug, Kerry,Elly, Amigo,Hello world!, I'd like Java
 */
public class SearchAndDelete {

    public static void main(String[] args) {

       ArrayList<String> arr = new ArrayList <>();
       arr.addAll(Arrays.asList(
               "Risha",
               "Easy",
               "ug" ,
               "bug",
               "bUg",
               "Bug",
               "Kerry",
               "Elly",
               "Amigo",
               "Hello world!",
               "I'd like Java"));
        removeBugWithCopy(arr);
       arr.stream().forEach(System.out::println);
    }

    public static void removeBugWithCopy(ArrayList<String> arr) {
        ArrayList<String> copy = new ArrayList<>(arr);

        for (String str : arr) {
            if (str.equalsIgnoreCase("bug")) {
                copy.remove(str);
            }
        }
        arr.clear();
        arr.addAll(copy);
    }

    public static void removeBugWithWhile(ArrayList<String> arr) {
        Iterator<String> iter = arr.iterator();

        while(iter.hasNext()) {
            if (iter.next().equalsIgnoreCase("bug")){
                iter.remove();
            }
        }
    }

public static void removeBugWithFor(ArrayList<String> arr) {
    for (int i = 0; i < arr.size(); i++) {
        if(arr.get(i).equalsIgnoreCase("bug")){
            arr.remove(i);
            i--;
        }

    }
}

}
