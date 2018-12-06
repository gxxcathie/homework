package reflectTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        //方式一
//        System.out.println(new User().getClass());
//        //方式二
//        Class<?> aClass = Class.forName("reflectTest.User");
//        System.out.println(aClass);
//        //这个类型信息在jvm仍表现为一个对象，而且只有一份
//        System.out.println(new User().getClass()==Class.forName("reflectTest.User"));
//        //方式三
//        System.out.println(User.class);
//
//        User user = User.class.newInstance();
//        System.out.println(user);

        System.out.println("调用所有公共方法");
        Class<?> aClass = Class.forName("reflectTest.User");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("调用所有方法");
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(methods1);
        }
        System.out.println("获取单个公共show1方法");
        Method show1 = aClass.getMethod("show1", String.class);
        System.out.println(show1);
        System.out.println("获取私有show4方法");
        Method show4 = aClass.getDeclaredMethod("show4", int.class);
        System.out.println(show4);
        System.out.println("获取多个形参公共方法");
        Method m1 = aClass.getMethod("m1", int.class, int.class);
        System.out.println(m1);
        System.out.println("无参方法");
        Method m11 = aClass.getDeclaredMethod("m1");
        System.out.println(m11);

        User u = new User();
        // 方法.invoke(对象， 参数);
        Method m = User.class.getDeclaredMethod("m1");
        m.setAccessible(true); // 设置这个方法可以被访问，可以突破访问修饰符的限制
        m.invoke(u); // 反射调用方法（性能低）

        // 反射调用 public void m1(int a)
        Method m12 = User.class.getDeclaredMethod("m1", int.class);
        m12.invoke(u, 1);

        Method m13 = User.class.getDeclaredMethod("m1", int.class, int.class);
        m13.invoke(u, 4, 5);

    }
}
