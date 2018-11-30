package meijuTest2;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        // EnumSet的使用
        EnumSet<Day> weekSet = EnumSet.allOf(Day.class);
        for (Day day : weekSet) {
            System.out.println(day);
        }

        // EnumMap的使用
        EnumMap<Day, String> weekMap = new EnumMap(Day.class);
        weekMap.put(Day.MON, "星期一");
        weekMap.put(Day.TUE, "星期二");
        // ... ...
        Iterator<Map.Entry<Day, String>> iterator = weekMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Day, String> next = iterator.next();
            System.out.println(next.getKey() + "==" + next.getValue());

        }
    }
}
