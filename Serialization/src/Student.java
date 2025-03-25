public class Student extends Person{
    transient Course c;
    public Student(String name, int age) {
        super(name, age);
        c = new Course();
    }

    @Override
    public String toString() {
        return super.toString() + " - " + c;
    }
}
