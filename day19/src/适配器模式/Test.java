package 适配器模式;

public class Test {
    //将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以在一起工作。
    // 已存在的、具有特殊功能、但不符合我们既有的标准接口的类
    class Adaptee {
        public void specificRequest() {
            System.out.println("被适配类具有 特殊功能...");
        }
    }

    // 目标接口，或称为标准接口
    interface Target {
        public void request();
    }

    // 具体目标类，只提供普通功能
    class ConcreteTarget implements Target {
        public void request() {
            System.out.println("普通类 具有 普通功能...");
        }
    }

    // 适配器类，继承了被适配类，同时实现标准接口
    class Adapter extends Adaptee implements Target{
        public void request() {
            super.specificRequest();
        }
    }


}




