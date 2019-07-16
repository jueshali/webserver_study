package XML_reader;

/**
 * 项目名：webserver_study
 * 描述：
 *
 * @author : Lpc
 * @date : 2019-07-11 15:45
 **/
public class Person {
    private String name;
    private int age;
    public Person(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
