package m04strings.samples;

import java.util.Formatter;

public class StringOperations {
    public static void main(String[] args) {
        stringAsCharSequence();
        stringConcatenation();
        stringsCreationAndComparison();
        stringAPI();
        formatString();
    }

    private static void stringAsCharSequence() {
        String str = "Character sequence";
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            System.out.println("Символ " + i + " = " + ch);
        }
    }

    private static void stringConcatenation() {
        String hello = "Hello";
        String world = "World";

        String result = hello + " " + world;
        System.out.println(result); // "Hello World"

        result.toUpperCase(); // вызов не меняет исходную строку, а возвращает новую
        System.out.println(result); // все еще "Hello World"
    }

    private static void stringsCreationAndComparison() {
        String str = new String("java");
        String str2 = new String("java");

        System.out.println(str == str2);            // false, разные ссылки на объекты
        System.out.println(str.equals(str2));   // true, т.к. одинаковое значение


        String str3 = "java";
        String str4 = "java";
        System.out.println(str3 == str4);       // true, т.к. str4 переиспользует ссылку из String Pool
        System.out.println(str3.equals(str4));  // true, т.к. одинаковое значение

        String strInterned = str.intern(); // intern помещает строку в String Pool, если ее там нет
        System.out.println(strInterned == str3);  // true, т.к. strInterned уже в пуле
    }

    public static void stringAPI() {
        String s = "Строка 1";
        String s2 = "Строка 2";
        String c = s + " " + s2;
        c += "\r\n" + s2;				    // конкатенация, \r\n – перенос строки

        int len = s.length(); 		        // длина строки
        System.out.println(s.charAt(0));	// нумерация символов с 0, последний символ с индексом len-1

        String s3 = s.substring(3);		    // начиная с 3 символа, результат – «ока 1»
        String s4 = s.substring(2, 5);		// с 2 символа по 5-ый (невключительно), результат «рок»
        // длина результата = endIndex - startIndex


        String parts[] = s.split(" "); // разбиение через пробел. Параметром является regexp


        boolean b1 = s.isEmpty(); 		    // проверка строки на пустоту (length = 0)
        boolean b2 = s.isBlank(); 		    // проверка строки на пустоту
        // либо только whitespace символы (пробел, таб)

        String example = "Строка длинного текста";
        boolean b = example.contains("рок"); // вхождение подстроки
        b = example.startsWith("Стр");      // проверка начала строки
        b = example.endsWith(".");          // проверка окончания строки

        String res1 = example.replace('т', '-'); // замена символа > "С-рока длинного -екс-а"
        String res2 = example.replace("текста", "кода"); // замена подстроки > "Строка длинного кода"
        String res3 = example.replaceAll("\\s", "_"); // замена по RegExp > "Строка*длинного*текста"

        res1 = example.toUpperCase();   // Привести к верхнему регистру
        res1 = example.toLowerCase();   // Привести к нижнему регистру

        int index1 = example.indexOf("длин"); // Позиция первого вхождения текста
        int index2 = example.lastIndexOf('т'); // Позиция последнего вхождения символа
    }

    public static void formatString() {
        Formatter formatter = new Formatter();
        formatter.format("PI = %.2f", Math.PI);
        System.out.println(formatter.toString());

        System.out.println(
                new Formatter().format("x=%d, y=%d", 12, 14));
        System.out.println(
                new Formatter()
                        .format("ул. Конева д. %d", 12)
                        .format(", кв. %d", 14));

        System.out.println(
                String.format("Ошибка ORA-%d, %s", 123, "Нарушение PK"));
    }
}
