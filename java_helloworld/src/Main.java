import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        /*        MapTest();*/
        maptest();
    }

    /*    Map test*/
    public static void MapTest() {
       /* Map<String,String> map=new HashMap<String, String>();
        map.put("key1","value1");
        map.get("key1");
        map.remove("key1");
        map.clear();
        System.out.println("MapTest end!");*/

        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");

        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        System.out.println("-----------------------------------");

        for (Map.Entry<String, String> item : map.entrySet()) {
            System.out.println(item.getKey() + ":" + item.getValue());
        }
        System.out.println("-----------------------------------");

        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + ":" + map.get(key));
        }
        System.out.println("-----------------------------------");

        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, String> entry = iterator1.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    public static void maptest() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000000; i++) {
            map.put(i, i);
        }
        long start = System.currentTimeMillis();
        for (Integer key : map.keySet()) {
            map.get(key);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");

        start = System.currentTimeMillis();
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            item.getValue();
            item.getKey();
        }
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");

        start = System.currentTimeMillis();
        Iterator<Integer> iterator = map.keySet().iterator();
        Integer key;
        while (iterator.hasNext()) {
            key = iterator.next();
            map.get(key);
        }
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");

        start = System.currentTimeMillis();
        Iterator<Map.Entry<Integer, Integer>> iterator1 = map.entrySet().iterator();
        Map.Entry<Integer, Integer> entry;
        while (iterator1.hasNext()) {
            entry = iterator1.next();
            entry.getKey();
            entry.getValue();

        }
        end = System.currentTimeMillis();
        System.out.println((end - start) + " ms");
    }
}
