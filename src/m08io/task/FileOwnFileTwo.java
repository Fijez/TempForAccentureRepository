package m08io.task;

import java.io.*;
import java.util.Scanner;

/**
 * Напишите программу , которая будет считыватьс консоли путь к файлу1 и файлу2
 * Далее все байты из файла 1 записывает в файл2 и меняте их местами:
 * первый со вторым, второй с третьим и тд
 *
 */

//условие?

public class FileOwnFileTwo {
    public static void main(String[] args) {
        System.out.println("Введите полный путь к файлу 1:");
        File file1 = new File(readPath());
        System.out.println("Введите полный путь к файлу 2:");
        File file2 = new File(readPath());


    }

    public static String readPath() {
        Scanner in = new Scanner (System.in);
        return in.nextLine();
    }

    public static void recordingBytes (File file1, File file2) throws IOException {
        byte[] temp = new byte[(int) (file1.length() + file2.length())];
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(new FileInputStream(file1).readAllBytes());
    }
}
