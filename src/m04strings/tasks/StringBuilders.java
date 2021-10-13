package m04strings.tasks;

import java.util.Random;
import java.util.Scanner;

/**
 * Считать с клавиатуры строку
 * Добавьте к основной строке 50 новых подстрок , используя класс String
 * реализуйте решение с помощью класса StringBuilder
 */

public class StringBuilders {
    public static void main(String[] args) {
        String str = "";
        str += new Scanner(System.in).nextLine();
        int left = 97;
        int right= 122;
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int length = 5 + Math.abs(random.nextInt() % 10);
            int randomInt = left + (int)(random.nextDouble() * (right - left + 1));
            str += ((char) randomInt);
        }
        System.out.println(str);
        str = "" + new Scanner(System.in).nextLine();
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            int length = 5 + Math.abs(random.nextInt() % 10);
            int randomInt = left + (int)(random.nextDouble() * (right - left + 1));
            strBuilder.append((char) randomInt);
        }
        str += strBuilder.toString();
        System.out.println(str);
    }

}
