package redisDemo;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public class RedisUser {

    private static final int USERS = 10;

    public static void main(String[] args) throws InterruptedException {

//        for (int i = 0; i < 100; i++) listUsers.put(i + 1, "Пользователь " + i);

        RedisStorage redis = new RedisStorage();
        redis.init();

        do {
            for (int i = 1; i < 100; i++) {
                redis.logPageVisit(i);
                System.out.println("Пользователь " + i + "активен");

                if (i % 10 == 0) {
                    int luckyUser = new Random().nextInt(USERS);
                    System.out.println("Пользователь " + luckyUser + "Оплатил подписку");
                    redis.logPageVisit(luckyUser);
                    Thread.sleep(1000);
//                    redis.listKeys();

                }
            }
        } while (true);
    }


}
