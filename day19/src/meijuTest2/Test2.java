package meijuTest2;

public class Test2 {
    public static void main(String[] args) {
        Day test = Day.TUE;
        int i = test.compareTo(Day.MON);
        switch (i){
            case -1:
                System.out.println("TUE 在 MON 之前");
                break;
            case 1:
                System.out.println("TUE 在 MON 之后");
                break;
            default:
                System.out.println("TUE 与 MON 在同一位置");
                break;
        }

    }

}
