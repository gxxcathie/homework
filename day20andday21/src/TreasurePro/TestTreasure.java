package TreasurePro;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestTreasure {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // E:\9.22实训班共享\笔记资料
        // 类加载器, 作用：加载一个不在classpath下的类
        ClassLoader cl = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in  = new FileInputStream("F:\\JAVAclass\\day201201_1\\Treasure.class");
                    byte[] bytes = new byte[1024*8];
                    int len = in.read(bytes);

                    // 调用父类的方法根据字节数组加载类
                    return defineClass(name, bytes, 0, len);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        Class<?> clazz = cl.loadClass("com.westos.Treasure"); // 根据类名加载类, 得到类对象
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object o = constructor.newInstance();
//        for (Method method : clazz.getMethods()) {
//           // method.getAnnotation();
////            System.out.println(method.getAnnotations());
//
//        }
        /*
        m1 []
        m2 []
        @R
        m3 [1]
        ...
         */
        Method[] methods = clazz.getMethods();
        for (int i = 0; i < methods.length-1; i++) {
           /* if (methods[i].getAnnotations().equals(methods[i+1].getAnnotations())){
            }else{
                methods[i].invoke(o);
            }*/
            if(methods[i].getAnnotations().length >=1){
                methods[i].invoke(o);
            }

        }

        /*
        public void com.westos.Treasure.me247e3d53e724001a4e828add5698d3c()
public void com.westos.Treasure.m58bc2e8a640640c2b29559a2c377ab13()
public void com.westos.Treasure.mc21085e018bc48f586b0365a2778263d()
         */
    }
}
