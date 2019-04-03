package tk.mybatis.simple.redis;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
public class JedisPoolManager {

    //连接池
    //private volatile static JedisPoolManager manager;
    // private final JedisPool pool;


    //单例模式

    /*  private JedisPoolManager() {

        try {
            //加载redis配置
            Properties props = PropertyUtils.load("redis.properties");

            // 创建jedis池配置实例
            JedisPoolConfig config = new JedisPoolConfig();

            // 设置池配置项值
            String maxTotal = props.getProperty("redis.pool.maxTotal", "4");
            config.setMaxTotal(Integer.parseInt(maxTotal));

            String maxIdle = props.getProperty("redis.pool.maxIdle", "4");
            config.setMaxIdle(Integer.parseInt(maxIdle));

            String minIdle = props.getProperty("redis.pool.minIdle", "1");
            config.setMinIdle(Integer.parseInt(minIdle));

            String maxWaitMillis = props.getProperty("redis.pool.maxWaitMillis", "1024");
            config.setMaxWaitMillis(Long.parseLong(maxWaitMillis));

            String testOnBorrow = props.getProperty("redis.pool.testOnBorrow", "true");
            config.setTestOnBorrow("true".equals(testOnBorrow));

            String testOnReturn = props.getProperty("redis.pool.testOnReturn", "true");
            config.setTestOnReturn("true".equals(testOnReturn));

            String server = props.getProperty("redis.server");
            if (StringUtils.isEmpty(server)) {
                throw new IllegalArgumentException("JedisPool redis.server is empty!");
            }

            String[] server_arr = server.split(",");
            if (server_arr.length > 1) {
                throw new IllegalArgumentException("JedisPool redis.server length > 1");
            }

            String[] arr = server_arr[0].split(":");
            String host = arr[0];
            int port = Integer.parseInt(arr[1]);
            int timeout = Integer.parseInt(props.getProperty("redis.timeout"));
            String password = props.getProperty("redis.password");

            System.out.println("host->" + host + ",port->" + port + ",timeout=" + timeout + ",password:" + password);

            pool = new JedisPool(config, host, port, timeout, password);

        } catch (IOException e) {
            throw new IllegalArgumentException("init JedisPool error", e);
        }

    }

    public static JedisPoolManager getMgr() {
        if (manager == null) {
            synchronized (JedisPoolManager.class) {
                if (manager == null) {
                    manager = new JedisPoolManager();
                }
            }
        }
        return manager;
    }

    public Jedis getResource() {

        return pool.getResource();
    }

    public void destroy() {
        // when closing your application:
        pool.destroy();
    }

    public void close() {
        pool.close();
    }*/
//

    //主从配置
    private volatile static JedisSentinelPool jedisSentinelPool;

    public static JedisSentinelPool getJedisSentinelPool() {
        try {
            if (jedisSentinelPool == null) {
                synchronized (JedisSentinelPool.class) {
                    if (jedisSentinelPool == null) {
                        //加载redis配置
                        Properties props = PropertyUtils.load("sentinelredis.properties");

                        // 创建jedis池配置实例
                        //JedisPoolConfig config = new JedisPoolConfig();
                        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
                        // 设置池配置项值
                        String maxTotal = props.getProperty("sentinel.pool.maxTotal", "4");
                        config.setMaxTotal(Integer.parseInt(maxTotal)); //最大连接数

                        String maxIdle = props.getProperty("sentinel.pool.maxIdle", "4");
                        config.setMaxIdle(Integer.parseInt(maxIdle));//最大空闲连接数

                        String minIdle = props.getProperty("sentinel.pool.minIdle", "1");
                        config.setMinIdle(Integer.parseInt(minIdle));

                        String maxWaitMillis = props.getProperty("sentinel.pool.maxWaitMillis", "1024");
                        config.setMaxWaitMillis(Long.parseLong(maxWaitMillis));

                        String testOnBorrow = props.getProperty("sentinel.pool.testOnBorrow", "true");
                        config.setTestOnBorrow("true".equals(testOnBorrow));

                        String testOnReturn = props.getProperty("sentinel.pool.testOnReturn", "true");
                        config.setTestOnReturn("true".equals(testOnReturn));

                        String server1 = props.getProperty("sentinel.server1");
                        String server2 = props.getProperty("sentinel.server2");
                        String server3 = props.getProperty("sentinel.server3");
                        String server4 = props.getProperty("sentinel.server4");
                        serverIsIlleage(server1);
                        serverIsIlleage(server2);
                        serverIsIlleage(server3);
                        serverIsIlleage(server4);
                        int timeout = Integer.parseInt(props.getProperty("sentinel.timeout"));
                        String password = props.getProperty("sentinel.commonpassword");
                        String clusterName = props.getProperty("sentinel.cluster");

                        Set<String> sentinels = new HashSet<String>();
                        String hostAndPort1 = server1;
                        String hostAndPort2 = server2;
                        String hostAndPort3 = server3;
                        String hostAndPort4 = server4;

                        sentinels.add(hostAndPort1);
                        sentinels.add(hostAndPort2);
                        sentinels.add(hostAndPort3);
                        sentinels.add(hostAndPort4);

                        jedisSentinelPool = new JedisSentinelPool(clusterName, sentinels, config, password);
                    }
                }
            }
            //jedisSentinelPool.
            return jedisSentinelPool;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean serverIsIlleage(String server) {
        try {
            if (StringUtils.isEmpty(server))
                throw new IllegalArgumentException("sentinel redis.server is empty!");
            String[] server_arr = server.split(",");
            if (server_arr.length > 1)
                throw new IllegalArgumentException("sentinel redis.server length > 1");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Jedis getJedis() {
        try {
            getJedisSentinelPool();
            Jedis jedis = getJedisSentinelPool().getResource();
            jedis.auth("myredis12358");
            return jedis;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void destroy() {
        // when closing your application:
        jedisSentinelPool.destroy();
    }

    public static void close() {
        jedisSentinelPool.close();
    }
}
