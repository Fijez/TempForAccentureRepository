package m04strings.tasks;

import java.util.Random;

/**
 * Используя StringBuilder необходимо реализвать два метода :
 * 1. метод  addTo ( String? String[] ) добавляет к строке, полученной первым параметром,
 * все строки по порядку, полученные из массива строк полученные вторым параметром  и возвращает объект типа StringBuilder на основе этой строк
 * 2. метод replace(String, String, int, int) заменяет часть строки, полученной первым параметром, начиная с индекса, полученного третьим параметром,
 * и заканчивая индексом, полученным четвертым параметром, на строку, полученную вторым параметром, и возвращает объект типа StringBuilder на основе этой строки.
 * Добавление нового значения к существующему объекту типа StringBuilder вызываем  append(String)
 * Для замены части значения объекта - вызываем replace (int, int, String)  в который передаем начальную и к онечную позицию для замены
 */

public class StringBuilder2 {
    public static void main(String[] args) {
        String[] testStr = new String[10];
        String testStr1 = "1234567890";
        randStr(testStr);
        testStr1 += addTo(testStr1, testStr);
        System.out.println(testStr1);
        testStr1 = replace(testStr1, "вот моя строка", 3,6).toString();
        System.out.println(testStr1);
    }

    public static StringBuilder replace(String str1, String str2, int leftIndex, int rigthIndex) {
        if(rigthIndex <str1.length() && leftIndex >=0) {
            StringBuilder stringBuilder = new StringBuilder(str1);
            stringBuilder.replace(leftIndex, rigthIndex, str2);
            return stringBuilder;
        }
        throw new IllegalArgumentException();
    }

    public static StringBuilder addTo ( String str1, String[] str2) {
        StringBuilder buffer = new StringBuilder();
        buffer.append(str1).append(str2[0]);
        for (int i = 1; i < str2.length; i++) {
            buffer.append(" " + str2[i]);
            //если делать .append(str2),
            // то строка в итоге будет такой [ , , , , ] (на пропусках слова)
        }
        buffer.toString();
        return buffer;
    }

    public static void randStr (String[] str) {

        int left = 97;
        int right= 122;
        Random random = new Random();
        for (int i = 0; i < str.length; i++) {
            int length = 5 + Math.abs(random.nextInt() % 10);
            StringBuilder buffer = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                int randomInt = left + (int)(random.nextDouble() * (right - left + 1));
                buffer.append((char) randomInt);
            }
            str[i]= buffer.toString();
            buffer = null;
        }

    }


}
