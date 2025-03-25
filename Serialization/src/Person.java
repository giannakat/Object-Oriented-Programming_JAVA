import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

public class Person implements Serializable {
    String name;
    int age;
    Date birthday;
    private transient long starTime;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        birthday = Date.from(Instant.now());
        starTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}' + birthday.getMinutes() + " sec:" + totalTime();
    }

    void eat(){
        System.out.println(name + " is eating");
    }

    public long totalTime(){
        return (System.currentTimeMillis() - starTime )/ 1000;
    }

    public void start() {
        starTime = System.currentTimeMillis();
    }
}
