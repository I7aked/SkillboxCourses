import java.util.HashMap;
import java.util.Random;

public class Bank {
    private HashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank() {
    }

    public Bank(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        System.out.println("Проверка");
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     * <p>
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {

        synchronized (accounts.get(fromAccountNum)) {
            if (amount > 50000 & accounts.get(fromAccountNum).isAlive()) {
                accounts.get(fromAccountNum).setAlive(!isFraud(fromAccountNum, toAccountNum, amount));
                System.out.println(accounts.get(fromAccountNum).isAlive());
            }
        }

        synchronized (accounts.get(fromAccountNum)) {
            synchronized (accounts.get(toAccountNum)){
            if (getBalance(fromAccountNum) < amount || !accounts.get(fromAccountNum).isAlive() || !accounts.get(toAccountNum).isAlive()) {
                System.out.println("Недостаточно денег на счёте или счёт заморожен");
            } else {
                accounts.get(fromAccountNum).setMoney(getBalance(fromAccountNum) - amount);
                accounts.get(toAccountNum).setMoney(getBalance(toAccountNum) + amount);
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public void addNewKlient(Account account) {
        accounts.put(account.getAccNumber(), account);
    }
}
