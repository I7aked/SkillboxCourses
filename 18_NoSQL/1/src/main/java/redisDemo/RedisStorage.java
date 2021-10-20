package redisDemo;

import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class RedisStorage {

    // Объект для работы с Redis
    private RedissonClient redisson;

    int count;
    // Объект для работы с ключами
    private RKeys rKeys;

    public RScoredSortedSet<Integer> getOnlineUsers() {
        return onlineUsers;
    }

    // Объект для работы с Sorted Set'ом
    private RScoredSortedSet<Integer> onlineUsers;

    private final static String KEY = "Users";

//    private double getTs() {
//        return new Date().getTime() / 1000;
//    }

    // Пример вывода всех ключей
    public void listKeys() {
        Iterable<String> keys = rKeys.getKeys();
        for (String key : keys) {
            out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }



    void shutdown() {
        redisson.shutdown();
    }

    // Фиксирует посещение пользователем страницы
    void logPageVisit(int userId) {
        //ZADD ONLINE_USERS
        onlineUsers.add((double) userId, userId);
    }

    private static void showFirstUser(RScoredSortedSet<Integer> quere) {
        int userId = quere.first();
        System.out.printf(" - На главной странице показываем пользователя %d%n", userId);
        quere.add(quere.lastScore() + 1, userId);
    }

    private static void reLocationUser(RScoredSortedSet<Integer> quere) throws InterruptedException {
        int luckyCount = new Random().nextInt(10);
        if (luckyCount > 8) {
            int luckyNumber = new Random().nextInt(100);
            quere.add(quere.firstScore(), luckyNumber);
            System.out.println(" - ПОльзователь  " + luckyNumber +  " Оплатил подписку");
            Thread.sleep(1000);
        }
    }


     void workRound() throws InterruptedException {
        do {
            count++;
            if (count == 100 )  count = 0;
            showFirstUser(onlineUsers);
            reLocationUser(onlineUsers);
            } while (true);
    }

    // Удаляет
//    void deleteOldEntries(int secondsAgo)
//    {
//        //ZREVRANGEBYSCORE ONLINE_USERS 0 <time_5_seconds_ago>
//        onlineUsers.removeRangeByScore(0, true, getTs() - secondsAgo, true);
//    }

//    int calculateUsersNumber()
//    {
//        //ZCOUNT ONLINE_USERS
//        return onlineUsers.count(Double.NEGATIVE_INFINITY, true, Double.POSITIVE_INFINITY, true);
//    }
}