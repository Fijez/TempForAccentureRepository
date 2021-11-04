package m08io.task;

import java.io.*;
import java.util.Scanner;

/**
 * Реализуйте программу в которой производиться чтения из файла тремя способами:
 * отдельно для windows linux и для любой ОС
 */

public class WindowAndLinux {
//    public static byte[] windowsRead() throws IOException {
//        return null;
//    }
//
//    public static byte[] linuxRead() throws IOException {
//    return null
//    }

    public static byte[] universalRead() throws IOException {
        System.out.println("введите полный путь к файлу: ");
        Scanner scanner = new Scanner(System.in);
        FileInputStream input = new FileInputStream(scanner.nextLine());
        scanner.close();

        return input.readAllBytes();
    }
}
