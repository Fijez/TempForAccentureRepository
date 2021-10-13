package m04strings.tasks;

import java.util.Scanner;

/**
 * Буквы
 * Напишите программу , которая вводит с клавиатуры текст.
 * Программа должна вывести на экран:
 * 1. количество гласных и согласных букв - вывести "количество гласных ", "количесвто согласных"
 * 2. удвоить все гласные буквы - вывести текст
 * 3. @param toUpperCase вывести на экране введенную строку в верхнем регистре
 */
public class Letters {

    //создать чаровские массивы гласных и согласных букв алфавита (работает с русским алфамитом)
    public static final char[] VOWELS= {'а', 'о', 'э', 'е', 'и', 'ы', 'у', 'ё', 'ю', 'я'};
    public static final char[] CONSONANTS = {'б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л',
            'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ'};

    public static void main(String[] args) {
        String str = inputStr();
        String upStr = toUpperCase(str);
        String doubleVowels = doubleVowels(str);


        int numbCons = numberOfConsonants(str);
        int numbVow = numberOfVowels(str);

        System.out.println("кол-во согласных = " + numbCons);
        System.out.println("кол-во гласных = " + numbVow);
        System.out.println("double Vowels: " + doubleVowels);
        System.out.println("Upper Case: " + upStr);
    }

    public static String inputStr(){
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public static int numberOfVowels(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            for (char ch: VOWELS){
                if (ch == temp) {
                  count++;
                  break;
                }
            }
        }
        return count;
    }

    public static int numberOfConsonants(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            for (char ch: CONSONANTS){
                if (ch == temp) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static String doubleVowels(String str) {
        String tempStr = "";
        char tempChar;
        for (int i = 0; i < str.length(); i++) {
            tempChar = str.charAt(i);
            tempStr += Character.toString(tempChar);
            for (char ch : VOWELS) {
                if (ch == tempChar) {
                    tempStr += tempChar;
                    break;
                }
            }
        }
        return tempStr;
    }



    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
}
