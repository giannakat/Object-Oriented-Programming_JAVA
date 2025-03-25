import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //List<Person> people = new ArrayList<>();
        List<Student> people = new ArrayList<>();


        //deserialized
        try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream("person.txt"));) {
            people = (ArrayList<Student>)ios.readObject();
            for(Student p: people){
                p.start();
            }
        }catch (IOException| ClassNotFoundException e){
            System.err.println(e.getClass());
        }




        while(true){
            String name;
            System.out.println("Enter name: ");
            name = sc.next();

            if(name.equalsIgnoreCase("done")){
                break;
            }

            System.out.println("Enter age: ");
            int age = sc.nextInt();

            Student p = new Student(name, age);
            people.add(p);
        }

        for(Student p : people){
            System.out.println(p);
            //int i = Student.indexOf(p);


        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));){
            oos.writeObject(people);
        }catch (IOException e){
            System.err.println(e.getClass());
        }
    }
}