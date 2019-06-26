package tk.mybatis.simple.redislock;

import redis.clients.jedis.Jedis;
import tk.mybatis.simple.redis.JedisPoolManager;

public class testredis {
    public static void main(String[] args) {
        Jedis jedis = JedisPoolManager.getJedis();
        //jedis.set("sock", "1000");
        String key1=jedis.get("key1");
        String key2=jedis.get("sock");

        System.out.println(key1);
        System.out.println(key2);

    }
}
