package m05oopbasics;


import java.util.Locale;
import java.util.Scanner;

/**
 * реализуйте программу в которой вводятся произведения разных жанров.
 * Класс Book кроме обычных переменных содержит также переменную типа нашего перечисления.
 * Само перечисление объявлено вне класса, оно содержит четыре жанра книг ( SCIENCE, BELLETRE,PHANTASY,SCIENCE_FICTION)
 * С помощью конструкции switch..case  проверить принадлежность значения bookType определенной константе перечисления.
 */
public class EnumDays {
    public static void main(String[] args) {
        Book book = Book.input();
    }


    private static class Book {
        String name;
        GenresOfBook bookType;

        private Book(String name, GenresOfBook bookType) {
            this.name = name;
            this.bookType = bookType;
        }

        public static Book input () {
            Scanner scanner = new Scanner (System.in);
            System.out.println("введите имя книги ");
            String name = scanner.nextLine();
            System.out.println("введите жанр ");
            String genre = scanner.nextLine();
            switch (GenresOfBook.valueOf(genre.toUpperCase())) {
                case BELLETRE:
                    return new Book(name,GenresOfBook.BELLETRE);
                case PHANTASY:
                    return new Book(name, GenresOfBook.PHANTASY);
                case SCIENCE:
                    return new Book(name, GenresOfBook.SCIENCE);
                case SCIENCE_FICTION:
                    return new Book(name, GenresOfBook.SCIENCE_FICTION);
                default:
                    System.out.println("неверый жанр");
                    throw new IllegalArgumentException();
            }
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", bookType=" + bookType +
                    '}';
        }
    }
}

enum GenresOfBook {
    BELLETRE, PHANTASY, SCIENCE, SCIENCE_FICTION
}

