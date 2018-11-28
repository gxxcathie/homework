package testPro3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        //实现由小到大排序
        //Collections.sort(list);
        //加一个比较器实现由大到小排序
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -(o1-o2);
//            }
//        });
        //简化后
        Collections.sort(list,(o1,o2)-> o2-o1);
        System.out.println(list);
    }
}
