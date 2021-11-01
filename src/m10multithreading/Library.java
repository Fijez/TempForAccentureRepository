package m10multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Напишите программу для работы с библотекой.
 * В библиотеке есть книги которые выдаются только в читальный зал и на руки
 * Посетители могут брать несколько книг как на руки так и в читальный зал
 *
 *реализуйте код без использования  synchronized
 *
 */

public class Library{

    private static final boolean IN_STOCK = true;

    private Map<Book, Boolean> books;
    private Map<Book, Visitor> takenBooks;

    public List<Book> getBooks() {
        List<Book> booksAvailable = new ArrayList<Book>();
        for (Map.Entry<Book, Boolean> book : books.entrySet()) {
            if (book.getValue()) {
                booksAvailable.add(book.getKey());
            }
        }
        return booksAvailable;
    }

    public Library(List<Book> books) {
        this.takenBooks = new HashMap<>();
        this.books = new HashMap<Book, Boolean>();
        for (Book book: books) {
            this.books.put(book, IN_STOCK);
        }
    }

    public Library() {//для теста
        this.takenBooks = new HashMap<>();
        this.books = new HashMap<Book, Boolean>();
        books.put(new Book("b1", false), IN_STOCK);
        books.put(new Book("b2", true), IN_STOCK);
        books.put(new Book("b3", false), IN_STOCK);
        books.put(new Book("b4", true), IN_STOCK);
        books.put(new Book("b5", false), IN_STOCK);
        books.put(new Book("b6", true), IN_STOCK);
        books.put(new Book("b7", false), IN_STOCK);
        books.put(new Book("b8", true), IN_STOCK);
        books.put(new Book("b9", false), IN_STOCK);
        books.put(new Book("b10", true), IN_STOCK);
        books.put(new Book("b11", false), IN_STOCK);
        books.put(new Book("b12", true), IN_STOCK);
        books.put(new Book("b13", false), IN_STOCK);
        books.put(new Book("b14", true), IN_STOCK);
        books.put(new Book("b15", false), IN_STOCK);
        books.put(new Book("b16", true), IN_STOCK);
        books.put(new Book("b17", false), IN_STOCK);
        books.put(new Book("b18", true), IN_STOCK);
        books.put(new Book("b19", false), IN_STOCK);
        books.put(new Book("b20", true), IN_STOCK);
        books.put(new Book("b21", false), IN_STOCK);
        books.put(new Book("b22", true), IN_STOCK);
        books.put(new Book("b23", false), IN_STOCK);
        books.put(new Book("b24", true), IN_STOCK);

    }

    private void giveBooks(List<Book> books, Visitor visitor) {
        for (Book book : books) {
            this.takenBooks.put(book, visitor);
            this.books.put(book, !IN_STOCK);
        }
    }

    private void giveBook(Book book, Visitor visitor) {
            this.takenBooks.put(book, visitor);
            this.books.put(book, !IN_STOCK);
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", takenBooks=" + takenBooks +
                '}';
    }

    public void startThreads(Visitor...v1) {
        for (Visitor visitor : v1) {
            new Thread(visitor).start();
        }
    }

    public static class Visitor implements Runnable{
        private int booksCount = 0;
        private List<Book> books;
        private final String name;
        private final Library library;
        private Semaphore semaphore;

        public Visitor(String name, Library library, Semaphore semaphore) {
            this.books = new ArrayList<Book>();
            this.library = library;
            this.name = name;
            this.semaphore = semaphore;
        }

        public final void takeBook(Book book) {
            this.library.giveBook(book, this);
            this.books.add(book);
        }

        public final void takeBooks(ArrayList<Book> books) {
            this.library.giveBooks(books, this);
            this.books.addAll(books);
        }

        public String getName() {
            return this.name;
        }

        public List<Book> getBooks() {
            return this.books;
        }

        @Override
        public String toString() {
            return "Visitor{" +
                    "books=" + this.books +
                    ", name='" + this.name + '\'' +
                    '}';
        }

        @Override
        public void run() {
            while(library.getBooks().size() != 0 && this.booksCount <4) {
                try {
                    System.out.println(Thread.currentThread().getName() + " ждет");
                    semaphore.acquire();
                    System.out.println("размер библиотеки " + library.getBooks().size());
                    Book tempBook = library.getBooks().get((int) (Math.random()%library.getBooks().size()));

                        this.takeBook(tempBook);
                        this.booksCount++;
                    System.out.println(Thread.currentThread().getName() + " книга: " + tempBook.getName());
                    System.out.println(Thread.currentThread().getName() + " освобождает");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " взял необходимые книги");
        }
    }

}

class Book {
    private final boolean isHandingOver;
    private String name;

    public Book(String name, boolean isHandingOver) {
        this.name = name;
        this.isHandingOver = isHandingOver;
    }

    public Book(boolean b) {
        isHandingOver = b;
    }

    public String getName() {
        return name;
    }

    public boolean isHandingOver() {
        return isHandingOver;
    }
}

class DemoLibrary {
    public static void main(String[] args) {
        Library library = new Library();
        Semaphore sem = new Semaphore(1);
        Library.Visitor visitor1 = new Library.Visitor("v1", library, sem);
        Library.Visitor visitor2 = new Library.Visitor("v2", library, sem);
        Library.Visitor visitor3 = new Library.Visitor("v3", library, sem);
        Library.Visitor visitor4 = new Library.Visitor("v4", library, sem);
        Library.Visitor visitor5 = new Library.Visitor("v5", library, sem);
        Library.Visitor visitor6 = new Library.Visitor("v6", library, sem);

        library.startThreads(visitor1,visitor2,visitor3,visitor4,visitor5,visitor6);
    }

}


