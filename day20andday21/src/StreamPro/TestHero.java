package StreamPro;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestHero {

    public static void main(String[] args) throws IOException {
        System.out.println("找到武将中武力前三的hero对象");
        Stream<String> lines = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        // \t  split("\t")
       // lines.forEach(str-> System.out.println(str));

        Stream<Hero> heroStream = lines.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        /*1.找到武将中武力前三的hero对象, 提示流也可以排序*/
        Stream<Hero> l1 = heroStream.sorted(Comparator.comparing(Hero::getPower).reversed()).limit(3);
        l1.forEach(str-> System.out.println(str));

        // 2. 按出生地分组
        System.out.println("按出生地分组");
        Stream<String> lines1 = Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream1 = lines1.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );

        Map<String, List<Hero>> map1 = heroStream1.collect(Collectors.groupingBy(Hero::getLoc));
        for (Map.Entry<String, List<Hero>> listEntry : map1.entrySet()) {
            List<Hero> value = listEntry.getValue();
            String key = listEntry.getKey();
            for (Hero hero : value) {
                System.out.println(key+"=="+hero);
            }
        }

        // 3. 找出寿命前三的武将
        System.out.println("寿命前三的武将");
        Stream<String> lines2= Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream2 = lines2.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        Stream<Hero> map2 = heroStream2.sorted((a,b)->(b.getDeath()-b.getBirth())-(a.getDeath()-a.getBirth())).limit(3);
        map2.forEach(str1-> System.out.println(str1));

        System.out.println("女性寿命最高的");
        Stream<String> lines3= Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream3 = lines3.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        Optional<Hero> max = heroStream3.filter(s -> s.getSex() .equals("女") ).max((a, b) -> (b.getDeath() - b.getBirth()) - (a.getDeath() - a.getBirth()));
        System.out.println(max);
        System.out.println("武力排名前三");
        Stream<String> lines4= Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream4 = lines4.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        Stream<Hero> l2 = heroStream4.sorted((a,b)->(b.getPower()-a.getPower()));
        System.out.println("按各个年龄段分组0-20,21-40，41-60,60以上");
        Stream<String> lines5= Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream5 = lines5.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        List<Hero> collect = heroStream5.sorted((a, b) -> ((b.getDeath() - b.getBirth()) - (a.getDeath() - a.getBirth()))).collect(Collectors.toList());
        ArrayList<Hero> list1 = new ArrayList<>();
        ArrayList<Hero> list2 = new ArrayList<>();
        ArrayList<Hero> list3 = new ArrayList<>();
        ArrayList<Hero> list4 = new ArrayList<>();
        for (Hero hero : collect) {
            int day=hero.getDeath()-hero.getBirth();
            if(day>0&&day<=20){
                list1.add(hero);
            }else if(day>=21&&day<=40){
                list2.add(hero);
            }else if(day>=41&&day<=60){
                list3.add(hero);
            }else{
                list4.add(hero);
            }
        }
        System.out.println("0-20年龄段："+list1);
        System.out.println("21-40年龄段："+list2);
        System.out.println("41-60年龄段："+list3);
        System.out.println("60以上年龄段："+list4);

        System.out.println("按照武力段分组");
        Stream<String> lines6= Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream6 = lines6.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        List<Hero> collect1 = heroStream6.sorted((a, b) -> (b.getPower() - a.getPower())).collect(Collectors.toList());
        ArrayList<Hero> Plist1 = new ArrayList<>();
        ArrayList<Hero> Plist2 = new ArrayList<>();
        ArrayList<Hero> Plist3 = new ArrayList<>();
        ArrayList<Hero> Plist4 = new ArrayList<>();
        for (Hero hero : collect1) {
            int power=hero.getPower();
            if(power>=90){
                Plist1.add(hero);
            }else if(power>=80&&power<=89){
                Plist2.add(hero);
            }else if(power>=70&&power<=79){
                Plist3.add(hero);
            }else if(power<70){
                Plist4.add(hero);
            }
        }
        System.out.println(">90武力段："+Plist1);
        System.out.println("80-89武力段："+Plist2);
        System.out.println("70-79武力段："+Plist3);
        System.out.println("<70武力段："+Plist4);
        System.out.println("按出生地分组后，统计各组人数");
        Stream<String> lines7= Files.lines(Paths.get("heroes.txt"), Charset.forName("utf-8"));
        Stream<Hero> heroStream7 = lines7.map(str -> str.split("\t")).map(array ->
                new Hero(
                        Integer.parseInt(array[0]),
                        array[1], array[2], array[3],
                        Integer.parseInt(array[4]),
                        Integer.parseInt(array[5]),
                        Integer.parseInt(array[6]))
        );
        Map<String, List<Hero>> collect2 = heroStream7.collect(Collectors.groupingBy(s -> s.getLoc()));
        int count=0;
        for (Map.Entry<String, List<Hero>> map : collect2.entrySet()) {
            List<Hero> list = map.getValue();
            for (Hero hero : list) {
                System.out.println(hero);
                count++;
            }
            System.out.println(map.getKey()+"出现了"+count+"次");
            count=0;
        }

        // 1. 找到武将中武力前三的hero对象, 提示流也可以排序
        // 2. 按出生地分组
        // 3. 找出寿命 前三的武将
        // 4. 女性寿命最高的
        // 5. 找出武力排名前三  100, 99, 97 97 ==> 4个人 吕布", "张飞", "关羽", "马超

    }
}
