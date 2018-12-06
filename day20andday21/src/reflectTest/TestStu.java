package reflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class TestStu {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class aClass = Class.forName("reflectTest.Student");
        System.out.println("获取所有公共属性");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("获取所有属性");
        Field[] fields1 = aClass.getDeclaredFields();
        for (Field field1 : fields1) {
            System.out.println(field1);
        }
        System.out.println("获取公共属性name");
        Field name = aClass.getField("name");
        System.out.println(name);
        Object o = aClass.getConstructor().newInstance();//获取对象
        name.set(o,"张小雨");///为Student对象中的name属性赋值--》stu.name = "刘德华"
        Student stu=(Student)o;
        System.out.println(stu.name);
        System.out.println("获取私有属性");
        Field phoneNum = aClass.getDeclaredField("phoneNum");
        System.out.println(phoneNum);
        phoneNum.setAccessible(true);//暴力反射，解除私有限定
        phoneNum.set(o, "18888889999");
        System.out.println(stu);//私有属性需get/set方法

        System.out.println("获取所有构造方法");
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("获取所有构造方法");
        Constructor[] constructors1 = aClass.getDeclaredConstructors();
        for (Constructor constructor11 : constructors1) {
            System.out.println(constructor11);
        }
        System.out.println("获取公有、无参的构造方法");
        Constructor constructor2= aClass.getConstructor();
        System.out.println(constructor2);
        //调用构造方法
        Object obj = constructor2.newInstance();
        System.out.println("obj = " + obj);
        Student stu1 = (Student)obj;
        System.out.println(stu1);
        System.out.println("获取私有构造方法");
        Constructor constructor3 = aClass.getDeclaredConstructor(int.class);
        System.out.println(constructor3);
        constructor3.setAccessible(true);
        constructor3.newInstance(28);
        System.out.println(stu1.age);

    }
}
