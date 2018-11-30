package Packagepro;

import java.util.Date;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        deepcopy();
    }
    private static void deepcopy() throws CloneNotSupportedException {
        User2 user = new User2();
        user.setName("王小帅");
        user.setAge(19);
        user.setBirthday(new Date());
        User2 user22 =(User2) user.clone();
        System.out.println(user==user22);
        System.out.println(user22.getAge());
        System.out.println(user22.getName());
        System.out.println(user22.getBirthday());
        user22.getBirthday().setDate(28);
        System.out.println("新克隆用户的生日："+user22.getBirthday());
        System.out.println("王小帅的生日："+user.getBirthday());
    }
    private static void copy() throws CloneNotSupportedException {
        User user = new User();
        user.setName("王小帅");
        user.setAge(19);
        user.setBirthday(new Date());
        User user2 =(User) user.clone();
        System.out.println(user==user2);
        System.out.println(user2.getAge());
        System.out.println(user2.getName());
        System.out.println(user2.getBirthday());
        user2.getBirthday().setDate(28);
        System.out.println("新克隆用户的生日："+user2.getBirthday());
        System.out.println("王小帅的生日："+user.getBirthday());
    }
}
