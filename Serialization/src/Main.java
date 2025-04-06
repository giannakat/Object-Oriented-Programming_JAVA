import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        //deserialize - converting data from file back to an object

        //Step 1: open file inputStream
        //Step 2: wrap it with ObjectInputStream
        //Step 3: Read and cast the object readObject()
        try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream("person.txt"));){
            people = (ArrayList<Person>)ios.readObject(); //returns generic object - cast it to the correct type
            for(Person p: people){
                System.out.println(p);
            }
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getClass());
        }

        while (true){
            String name;
            System.out.println("Enter name: ");
            name = sc.next();

            if(name.equalsIgnoreCase("done")){
                break;
            }

            System.out.println("Enter age: ");
            int age = sc.nextInt();

            Person n = new Person(name,age);
            people.add(n);

            for(Person p : people){
                System.out.println(p);
                //int i = Student.indexOf(p);

            }

        }

        //serialize
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"));){
            oos.writeObject(people);
        }catch (IOException e){
            System.err.println(e.getClass());
        }
    }
}