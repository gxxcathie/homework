package Pattern;

public class Singleton2 {
    private Singleton2(){}
    private static  Singleton2 ME;
    public static synchronized Singleton2 getInstance(){
        if(ME==null){
            ME=new Singleton2();
        }
        return ME;
    }
}
