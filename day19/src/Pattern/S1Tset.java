package Pattern;

public class S1Tset {
    public static void main(String[] args) {
        Singleton1 x = Singleton1.getInstance();
        Singleton1 y = Singleton1.getInstance();
        System.out.println(x==y);
    }
}
