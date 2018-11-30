package meijuTest;

public class Test {
    public static void main(String[] args) {
        //获取枚举对象的序号，序号从0开始
        System.out.println(Sex.MALE.ordinal());
        System.out.println(Sex.FEMALE.ordinal());
        //把枚举对象转换为字符串
        System.out.println(Sex.MALE.name());
        System.out.println(Sex.FEMALE.name());
        //把字符串转为枚举对象
        System.out.println(Sex.valueOf("MALE"));
        System.out.println(Sex.valueOf("FEMALE"));
        //虚拟机中枚举对象只有一个，可以用==连接
        System.out.println(Sex.valueOf("MALE")==Sex.MALE);
        //打印所有枚举对象
        for (Sex value : Sex.values()) {
            System.out.println(value);
        }
        //枚举对象调用构造方法
        System.out.println(Sex.MALE.getCnName());
        System.out.println(Sex.FEMALE.getCnName());
        //枚举对象调用方法
        System.out.println(Sex.MALE.test());

    }
}
