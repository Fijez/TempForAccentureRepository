package m06collection.s.task;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализуйте метод, который получает на вход Map<M,S> и возвращает Map
 * ключи и значение должны поменяться местами
 */

public class ChangeKey<T1, T2> {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("zero",1);
        map.put("one",2);
        map.put("two",3);
        map.put("three",4);
        map.put("fore",5);
        ChangeKey ck = new ChangeKey();
        map = ck.swap(map);
        System.out.println(map.toString());
    }
    public Map swap(Map<T1, T2> map) {
        Map<T2, T1> newMap = new HashMap<>();
        for (Map.Entry<T1, T2> entry:map.entrySet()) {
            newMap.put(entry.getValue(), entry.getKey());
        }
        return (Map<T1, T2>) newMap;
    }
}
