package tk.mybatis.simple.redis;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.*;

@Service
public class RedisMethod implements jedisService {

    private static Jedis jedis = null;

    private Jedis getJedis() {
        jedis = JedisPoolManager.getJedis();
        return jedis;
    }


    public void test() {

        Jedis jedis = null;
        try {
            jedis = JedisPoolManager.getJedis();
//		  jedis.auth("hello");

            //simple key-value
            jedis.set("redis", "myredis");
            System.out.println(jedis.get("redis"));

            jedis.append("redis", "yourredis");
            jedis.append("mq", "RabbitMQ");

            //incr
            String pv = jedis.set("pv", "0");
            System.out.println("pv:" + pv);
            jedis.incr("pv");
            jedis.incrBy("pv", 10);
            System.out.println("pv:" + pv);

            //mset
            jedis.mset("firstName", "ricky", "lastName", "Fung");
            System.out.println(jedis.mget("firstName", "lastName"));

            //map
            Map<String, String> cityMap = new HashMap<String, String>();
            cityMap.put("beijing", "1");
            cityMap.put("shanghai", "2");

            jedis.hmset("city", cityMap);
            System.out.println(jedis.hget("city", "beijing"));
            System.out.println(jedis.hlen("city"));
            System.out.println(jedis.hmget("city", "beijing", "shanghai"));

            //list
            jedis.lpush("hobbies", "reading");
            jedis.lpush("hobbies", "basketball");
            jedis.lpush("hobbies", "shopping");

            List<String> hobbies = jedis.lrange("hobbies", 0, -1);
            System.out.println("hobbies:" + hobbies);

            jedis.del("hobbies");

            //set
            jedis.sadd("name", "ricky");
            jedis.sadd("name", "kings");
            jedis.sadd("name", "demon");

            System.out.println("size:" + jedis.scard("name"));
            System.out.println("exists:" + jedis.sismember("name", "ricky"));
            System.out.println(String.format("all members: %s", jedis.smembers("name")));
            System.out.println(String.format("rand member: %s", jedis.srandmember("name")));
            //remove
            jedis.srem("name", "demon");

            //hset
            jedis.hset("address", "country", "CN");
            jedis.hset("address", "province", "BJ");
            jedis.hset("address", "city", "Beijing");
            jedis.hset("address", "district", "Chaoyang");

            System.out.println("city:" + jedis.hget("address", "city"));
            System.out.println("keys:" + jedis.hkeys("address"));
            System.out.println("values:" + jedis.hvals("address"));

            //zadd
            jedis.zadd("gift", 0, "car");
            jedis.zadd("gift", 0, "bike");
            Set<String> gift = jedis.zrange("gift", 0, -1);
            System.out.println("gift:" + gift);

        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        /// ... when closing your application:
        JedisPoolManager.destroy();
    }

    @Override
    public Object getObject(String key) {
        try {
            if (!existsByteKey(key.getBytes()))
                return null;
            byte[] bytes = this.getJedis().get(key.getBytes());
            Object object = deserialize(bytes);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setObject(String key, Object value) {
        Jedis localJedis;
        localJedis = this.getJedis();
        try {
            byte[] keyBytes = key.getBytes();
            if (existsByteKey(keyBytes))
                localJedis.del(keyBytes);
            byte[] bytes = serialize(value);
            localJedis.set(keyBytes, bytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setObject(String key, Object value, int expiration) {
        try {
            if (setObject(key, value))
                setExpire(key.getBytes(), expiration);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String getString(String key) {
        try {
            String value = this.getJedis().get(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setString(String key, String value, int expiration) {
        try {
            if (setString(key, value))
                setExpire(key, expiration);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setString(String key, String value) {
        Jedis localJedis;
        localJedis = this.getJedis();
        try {
            if (existsStrKey(key))
                localJedis.del(key);
            localJedis.set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
/*
    @Override
    public List<T> getListT(String key) {
        try {
            if (!existsByteKey(key.getBytes()))
                return null;
            Object object = this.getJedis().get(key.getBytes());
            return (List<T>) object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

  /*  @Override
    public boolean setListT(String key, List<T> list) {
        Jedis localJedis = this.getJedis();
        try {
            if (existsByteKey(key.getBytes()))
                localJedis.del(key.getBytes());
            byte[] bytes = serialize(list);
            localJedis.set(key.getBytes(), bytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setMap(String key, Map<String, String> map) {
        Jedis localJedis;
        localJedis = this.getJedis();
        try {
            if (existsStrKey(key))
                localJedis.del(key);
            localJedis.hmset(key, map);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Map<String, String> getMap(String key) {
        Jedis localJedis;
        localJedis = this.getJedis();
        try {
            if (!existsStrKey(key))
                return null;
            Iterator<String> iter = localJedis.hmget(key).iterator();
            Map<String, String> map = new HashMap<String, String>();
            while (iter.hasNext()) {
                String mapKey = iter.next();
                List<String> mapValues = localJedis.hmget(key, mapKey);
                String mapValue = "<<<illegal parameters>>>"; //非法参数
                if (mapValues.size() <= 0) {
                    mapValue = null;
                } else if (mapValues.size() == 1) {
                    mapValue = mapValues.get(0);
                }
                map.put(mapKey, mapValue);
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setMap(String key, Map<String, String> map, int expiration) {
        try {
            if (setMap(key, map))
                this.setExpire(key, expiration);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean getSet(String key) {
        return false;
    }

    @Override
    public boolean setSet(String key, Set<String> set) {
        Jedis localJedis = this.getJedis();
        try {
            if (set.size() <= 0)
                return false;
            if (existsStrKey(key))
                localJedis.del(key);
            Iterator<String> iter = set.iterator();
            while (iter.hasNext()) {
                String uniqueValue = (String) iter.next();
                if (localJedis.sismember(key, uniqueValue))
                    localJedis.srem(key, uniqueValue);
                localJedis.sadd(key, uniqueValue);
            }
            return true;
        } catch (Exception e) {
            localJedis = null;
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeValueOfSet(String key, String value) {
        Jedis localJedis = this.getJedis();
        try {
            if (!existsStrKey(key))
                return false;
            if (localJedis.sismember(key, value))
                localJedis.srem(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setSet(String key, Set<String> set, int expiration) {
        try {
            if (setSet(key, set))
                setExpire(key, expiration);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean addValueToSet(String key, String value) {
        Jedis localJedis = this.getJedis();
        try {
            if (!existsStrKey(key))
                return false;
            if (localJedis.sismember(key, value))
                localJedis.srem(key, value);
            localJedis.sadd(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public void clearAllCache() {
        this.getJedis().flushDB();
    }

    @Override
    public void destory() {
        //JedisPoolManager.getMgr().destroy();
        JedisPoolManager.destroy();
    }*/


    private boolean existsStrKey(String key) {
        return this.getJedis().exists(key);
    }

    private boolean existsByteKey(byte[] key) {
        return this.getJedis().exists(key);
    }

   /* private byte[] serialize(Class<T> tClass) throws IOException {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(tClass);
            oos.flush();
            return baos.toByteArray();
        } finally {
            oos.close();
            baos.close();
        }
    }
*/
    private byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream baos = null;
        ObjectOutputStream oos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            oos.flush();
            return baos.toByteArray();
        } finally {
            oos.close();
            baos.close();
        }
    }

    private Object deserialize(byte[] byteArray) throws ClassNotFoundException, IOException {
        ObjectInputStream ois = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(byteArray);
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } finally {
            ois.close();
        }
    }

    private void setExpire(String key, int expiration) {
        this.getJedis().expire(key, expiration);
    }

    private void setExpire(byte[] key, int expiration) {
        this.getJedis().expire(key, expiration);
    }
}
