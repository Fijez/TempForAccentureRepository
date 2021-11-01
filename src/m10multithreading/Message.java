package m10multithreading;

/**
 * Выведите сообщение содержащее : "Многопоточность - лучший инструмент " ( один поток)
 *  сообщение необходимо выводить на экран каждые 5 секунд ( второй поток)
 *
 *///доделать

public class Message implements Runnable{

    boolean isInfinit;

    public Message(boolean isInfinit) {
        this.isInfinit = isInfinit;
    }

    public static void main(String[] args) {
      Message ms1 = new Message(true);
      Message ms2 = new Message(false);
      new Thread(ms1).start();
      new Thread(ms2).start();
    }

    @Override
    public void run() {
        if (isInfinit) {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " Многопоточность - лучший инструмент ");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println(Thread.currentThread().getName() + " Многопоточность - лучший инструмент ");
        }
    }
}
