package m08io.task;

import java.io.*;
import java.util.Scanner;

/**
 * Напишите программу которая считывает из консоли имя текстового файла
 *считывает символы из этого файла и выводит на экран все , за исключением точки, запятой, и пробела
 *
 */

public class FileControl {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя двух файлов: ");
        String fileName1 = "";
        String fileName2 = "";
        try {
            fileName1 = in.readLine();
            fileName2 = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file1 = new File(fileName1);
        BufferedReader readerF1 = new BufferedReader(new FileReader(file1));
        File file2 = new File(fileName2);
        BufferedReader readerF2 = new BufferedReader(new FileReader(file2));
        StringBuilder textFromF1 = new StringBuilder();
        StringBuilder textFromF2 = new StringBuilder();
        String temp;
        do {
            temp = readerF1.readLine();
            textFromF1.append(temp);
        } while (temp != null);


        textFromF1.toString().replace(",", "");
        textFromF1.toString().replace(" ", "");
        textFromF1.toString().replace(".", "");

        System.out.println(textFromF1.toString());
        do {
            temp = readerF1.readLine();
            textFromF2.append(readerF2.readLine());
        } while (temp != null);


        textFromF2.toString().replace(",", "");
        textFromF2.toString().replace(" ", "");
        textFromF2.toString().replace(".", "");

        System.out.println(textFromF2.toString());
    }
}
