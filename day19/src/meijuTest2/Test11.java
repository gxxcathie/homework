package meijuTest2;

public class Test11 {
    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println(day.toString());
        }
        Day tue = Day.TUE;
        switch (tue) {
            case MON:
                System.out.println("今天是星期一");
                break;
            case TUE:
                System.out.println("今天是星期二");
                break;
            // ... ...
            default:
                System.out.println(tue);
                break;
        }
    }
}
