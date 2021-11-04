package m08io.task;

import java.io.*;
import java.util.Scanner;

/**
 * Напишите программу , которая будет считыватьс консоли путь к файлу1 и файлу2
 * Далее все байты из файла 1 записывает в файл2 и меняте их местами:
 * первый со вторым, второй с третьим и тд
 * (переписать байты из первого файла во второй и из второго в первый)
 */



public class FileOwnFileTwo {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите полный путь к файлу 1:");
        File file1 = new File(readPath());
        System.out.println("Введите полный путь к файлу 2:");
        File file2 = new File(readPath());

        recordingBytes(file1, file2);

        System.out.println("file1: " + new BufferedReader(new FileReader(file1)).readLine());
        System.out.println("file2: " + new BufferedReader(new FileReader(file2)).readLine());
    }

    public static String readPath() {
        Scanner in = new Scanner (System.in);
        return in.nextLine();
    }

    public static void recordingBytes (File file1, File file2) throws IOException {
        byte[] temp;

        FileInputStream fileInputStream = new FileInputStream(file2);
        temp = fileInputStream.readAllBytes();
        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        fileOutputStream.write(new FileInputStream(file1).readAllBytes());
        fileOutputStream.close();

        fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write(temp);
    }
}
