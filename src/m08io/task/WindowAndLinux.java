package m08io.task;

import java.io.*;

/**
 * Реализуйте программу в которой производиться чтения из файла тремя способами:
 * отдельно для windows linux и для любой ОС
 */

public class WindowAndLinux {
    public static byte[] windowsRead(File file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        return input.readAllBytes();
    }

    public static byte[] linuxRead(File file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        return input.readAllBytes();
    }

    public static byte[] universalRead(File file) throws IOException {
        FileInputStream input = new FileInputStream(file);
        return input.readAllBytes();
    }
}
