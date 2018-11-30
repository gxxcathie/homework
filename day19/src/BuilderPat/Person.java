package BuilderPat;

public class Person {
    private String name;
    private String sex;
    private Integer weight;
    private Integer height;

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }

    private Person(String name, String sex, Integer weight, Integer height) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
    }
    //建造器，给属性赋值
    public static class PersonBuilder{
        private String name;
        private String sex;
        private Integer weight;
        private Integer height;
        public PersonBuilder name(String name){
            this.name=name;
            return this;
        }
        public PersonBuilder sex(String sex){
            this.sex=sex;
            return this;
        }
        public PersonBuilder weight(Integer weight){
            this.weight=weight;
            return this;
        }
        public PersonBuilder height(Integer height){
            this.height=height;
            return this;
        }
        //创建真正的Person对象
        public Person build(){
            //需要的信息收集齐了
            return new Person(this.name,this.sex,this.weight,this.height);
        }

    }
}
