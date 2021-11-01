package m10multithreading;

/**
 *есть счет, с которого с помощью метода transaction можно производить списание средств.
 * создайте счет с определенной суммой на балансе
 * создайте несколько клиентов ( потоков) которые будут списыватьсредства со счета
 * по окончании списания проверить остаток на балансе
 *  реализуйте данный код двумя способами:
 *  1. синхронизация по методу//для меня
 *  2. синхронизация по объекту
 */

class Demo {
    public static void main(String[] args) {
        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount();
        BankAccount ba3 = new BankAccount();
        BankAccount ba4 = new BankAccount();
        new Thread(ba1).start();
        new Thread(ba2).start();
        new Thread(ba3).start();
        new Thread(ba4).start();
    }
}

public class BankAccount implements Runnable{

    private static double balance = 1000;

    public synchronized void transaction(double writeOff) {
        if (balance >=writeOff) {
            balance -= writeOff;
        }
        else {
            throw new IllegalArgumentException("вы не можеете снять столько денег");
        }
    }

    public BankAccount() {
    }

    public synchronized double getBalance() {
        return balance;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            transaction(5);
            System.out.println("Списание, осталось: " + getBalance() + " поток: " + Thread.currentThread().getName() );
        }
        System.out.println("По итогу списаний, осталось: " + getBalance() + "поток: " + Thread.currentThread().getName() );
    }
}
