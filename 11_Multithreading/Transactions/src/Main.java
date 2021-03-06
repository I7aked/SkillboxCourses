import java.util.HashMap;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Account> accounts = new HashMap<>();
        String first = "first";
        String second = "second";
        String third = "third";
        Bank bank = new Bank(accounts);
        bank.addNewKlient(new Account(first, 500000, true, 1));
        bank.addNewKlient(new Account(second, 600000, true, 2));
        bank.addNewKlient(new Account(third, 800000, true, 3));

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 10; i++)
                    try {
                        bank.transfer(first, second, random.nextInt(55000));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 10; i++)
                    try {
                        bank.transfer(second, first, random.nextInt(60000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 10; i++)
                    try {
                        bank.transfer(third, first, random.nextInt(50000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("???????????????? ??????????");
        System.out.println(bank.getBalance(first) + " ?????? ???????? ?????????????? " + accounts.get(first).isAlive());
        System.out.println(bank.getBalance(second) + " ?????? ???????? ?????????????? " + accounts.get(second).isAlive());
        System.out.println(bank.getBalance(third) + " ?????? ???????? ?????????????? " + accounts.get(third).isAlive());

    }
}
