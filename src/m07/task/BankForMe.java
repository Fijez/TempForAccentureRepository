package m07.task;

/**
 * Необходимо создать программу, которая содержит информацию о наличии средств на счете ( депозит)
 * реализуйте метод позволяющий пополнять счет
 * реализуйте метод, который позволяет снять денежный средства со счета, но если запрос превышает
 * количесвто средств то выдает следующее сообщение : "Извините , но у Вас $"
 *
 */

public class BankForMe {
    public static void main(String[] args) {
        BankForMe bankForMe = new BankForMe();
        bankForMe.addMoney(100);
        bankForMe.removeMoney(101);

    }
    private static Double balance = 0.0;
    public void addMoney(double money) {
        if (money >= 0) {
            balance += money;
        } else {
            throw new IllegalArgumentException("для снятия денег есть другой метод");
        }
    }
    public void removeMoney(double money) {
        if( balance >= money){
        balance -=money;
        }
        else {
            throw new IllegalArgumentException("Извините, но у Вас " + balance);
        }
    }
}
