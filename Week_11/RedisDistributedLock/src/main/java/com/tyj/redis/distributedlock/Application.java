package com.tyj.redis.distributedlock;

import com.tyj.redis.distributedlock.lock.RedisLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tyjwan
 */
@SpringBootApplication
public class Application {
    private final static String LOCK = "LOCK";
    private final static int EXPIRE_TIME = 3;
    private static int amount = 10;

    public static void lockTest() {
        System.out.println("lock test :: start");

        if (!RedisLock.getInstance().lock(LOCK, EXPIRE_TIME)) {
            System.out.println("lock test :: 获取锁失败");
            return;
        }

        try {
            Thread.sleep(10000);
            amount -= 1;
            System.out.println("lock test :: 库存减一，剩余库存" + amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RedisLock.getInstance().releaseLock(LOCK);
        System.out.println("lock test :: release lock");
    }

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);

        Thread thread1 = new Thread(Application::lockTest);
        Thread thread2 = new Thread(Application::lockTest);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(Application::lockTest);
        thread3.start();
        thread3.join();
    }
}
