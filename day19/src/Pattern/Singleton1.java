package Pattern;

public class Singleton1 {
    //让构造方法私有，别人无法创建这个实例
    private Singleton1(){}
    //自己创建这个实例
    private static final Singleton1 ME=new Singleton1();
    //获取唯一实例
    public static Singleton1 getInstance(){
        return ME;
    }
}
