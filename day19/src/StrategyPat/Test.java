package StrategyPat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zhangsan", 18));
        list.add(new Student("lisi", 20));
        list.add(new Student("wangwu", 16));
        list.add(new Student("zhaoliu", 22));
        list.add(new Student("zhaoliu", 20));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }

        });
        Collections.sort(list,(o1,o2)->o1.getAge()-o2.getAge());
        Collections.sort(list,(o1,o2)->o1.getName().compareTo(o2.getName()));
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int i = o1.getName().compareTo(o2.getName());
                if(i!=0){
                    return i;

                }else{
                    return o1.getAge()-o2.getAge();
                }
            }
        });
        System.out.println(list);
    }
}
