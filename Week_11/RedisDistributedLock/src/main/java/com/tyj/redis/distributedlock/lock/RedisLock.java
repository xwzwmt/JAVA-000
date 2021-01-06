package com.tyj.redis.distributedlock.lock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Collections;

/**
 * redis 分布式锁
 * @author tyjwan
 */
public class RedisLock {
    String ip = "127.0.0.1";
    int port = 6379;

    private enum EnumSingleton {
        /**
         * 懒汉枚举单例,枚举类型是线程安全的，并且只会装载一次
         */
        INSTANCE;
        private RedisLock instance;

        EnumSingleton() {
            instance = new RedisLock();
        }

        private RedisLock getInstance() {
            return instance;
        }
    }

    public static RedisLock getInstance() {
        return EnumSingleton.INSTANCE.getInstance();
    }

    private JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), ip, port);

    /**
     * 加锁
     * @param lockKey     分布式锁的key，这个应该是全局唯一的
     * @param expireTime  锁过期时间
     * @return 是否获得锁
     */
    public boolean lock(String lockKey, int expireTime) {
        try(Jedis jedis = jedisPool.getResource()) {
            return "OK".equals(jedis.set(lockKey, lockKey, "NX", "EX", expireTime));
        }
    }

    /**
     * 释放锁
     * @param lockKey 要释放的锁
     * @return 释放锁是否成功
     */
    public boolean releaseLock(String lockKey) {
        String luaScript = "if redis.call('get',KEYS[1]) == ARGV[1] then " + "return redis.call('del',KEYS[1]) else return 0 end";
        try(Jedis jedis = jedisPool.getResource()) {
            return jedis.eval(luaScript, Collections.singletonList(lockKey), Collections.singletonList(lockKey)).equals(1L);
        }
    }
}
