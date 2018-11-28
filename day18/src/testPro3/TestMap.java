package testPro3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BiConsumer;

public class TestMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","李四");
        map.put("b","张三");
        map.put("c","王五");
        //通过Map.entrySet使用iterator遍历key和value
        //map集合遍历
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<String, String> entry = iterator.next();
//            System.out.println(entry.getKey()+"=="+entry.getValue());
//
//        }
        //通过forEach来遍历
//        map.forEach(new BiConsumer<String, String>() {
//            @Override
//            public void accept(String key, String value) {
//                System.out.println("key:"+key+"=="+"value:"+value);
//            }
//        });
        //简化版
        map.forEach((key,value)->{System.out.println("key:"+key+"=="+"value:"+value);});
    }
}
