package BuilderPat;

public class Test {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .height(176)
                .name("王小帅")
                .sex("男")
                .weight(140)
                .build();
        System.out.println(person);
        String s = new StringBuilder().append("aaa").append(1).toString();
        System.out.println(s);

    }
}
