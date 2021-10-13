package m04strings.tasks;


import java.util.Scanner;

/**
 * Считать с клавиатуры 7 строк и заполнить ими массив strings
 * Удалить повторяющиеся сроки из массива
 * Заменить удаленные строки на null
 */

public class RepeatLines {

    private static final int NUMB_STRINGS = 7;

    public static void main(String[] args) {
        String[] userStr = new String[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUMB_STRINGS; i++) {
            userStr[i] = scanner.nextLine();
        }

        for (int i = 0; i < NUMB_STRINGS; i++) {
            {
                for (int j = i + 1; j < NUMB_STRINGS; j++) {
                    if (userStr[j] != null && userStr[j].equals(userStr[i])) {
                        userStr[j] = userStr[i] = null;
                    }
                }
            }
        }

    }
}
