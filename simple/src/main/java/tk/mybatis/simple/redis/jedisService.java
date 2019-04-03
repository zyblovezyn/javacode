package tk.mybatis.simple.redis;

public interface jedisService {
    public Object getObject(String key);
    public boolean setObject(String key, Object value);
    public boolean setObject(String key, Object value, int expiration);
    public String getString(String key);
    public boolean setString(String key, String value, int expiration);
    public boolean setString(String key, String value);
    //public List<T> getListT(String key) ;
}
