package m08io.task;

import java.io.*;

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

        File file1 = new File("F:\\Java\\Projects\\TempForAccentureRepository\\src\\m08io\\task\\"+ fileName1);
        BufferedReader readerF1 = new BufferedReader(new FileReader(file1));
        File file2 = new File("F:\\Java\\Projects\\TempForAccentureRepository\\src\\m08io\\task\\" + fileName2);
        BufferedReader readerF2 = new BufferedReader(new FileReader(file2));
        StringBuilder textFromF1 = new StringBuilder();
        StringBuilder textFromF2 = new StringBuilder();
        String temp = readerF1.readLine();
        while (temp != null){
            textFromF1.append(temp);
            temp = readerF1.readLine();
        }

        String outStr = "";
        outStr = textFromF1.toString().
                replaceAll("[., ]", "");

        System.out.println(outStr);

        do {
            temp = readerF1.readLine();
            textFromF2.append(readerF2.readLine());
        } while (temp != null);

        outStr = textFromF2.toString().replaceAll("\\. |,| ", "");

        System.out.println(outStr);
    }
}
