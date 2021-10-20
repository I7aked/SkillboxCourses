package redisDemo;

import org.redisson.api.RScoredSortedSet;

import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public class RedisUser {


    private static final int USERS = 10;

    public static void main(String[] args) throws InterruptedException {

        RedisStorage redis = new RedisStorage();
        redis.init();

        for (int i = 1; i < 100; i++) {
            redis.logPageVisit(i);
        }
        redis.workRound();
    }


//        private static void reLocationUser(RScoredSortedSet<Integer> quere){
//        int luckyCount = new Random().nextInt(10);
//        if (luckyCount >8){
//            int luckyNumber = new Random().nextInt(100);
//            quere.add(quere.firstScore() , luckyNumber);
//            }
//        }
//    private static void showFirstUser(RScoredSortedSet<Integer> quere) {
//        int userId= quere.first();
//        System.out.printf(" - На главной странице показываем пользователя %d%n",userId);
//        quere.add(quere.lastScore() + 1,userId);
//    }

}
