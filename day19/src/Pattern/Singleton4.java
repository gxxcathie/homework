package Pattern;

public class Singleton4 {
    static{
        System.out.println("Singleton4类被加载了");
    }
    private Singleton4(){}
    private static class Holder{
        static{
            System.out.println("Holder类被加载了");
        }
        static Singleton4 ME=new Singleton4();
    }
    public static Singleton4 getInstance(){
        return Holder.ME;
    }
    public static void test(){
        System.out.println("Singleton4其他方法");
    }
}
