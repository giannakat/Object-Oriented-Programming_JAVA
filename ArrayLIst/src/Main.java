import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArrayFullExceptions, ArrayInvalidPosition {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        char op;

        do{
            System.out.println("Enter op: ");
            op = sc.nextLine().charAt(0);

            switch (op){
                case 'a':
                    break;
                case 'A':
                    break;
                case 'r':
                    break;
                case 'R':
                    break;
                case 'p':
                    list.print();
                case 'x':
                    System.out.println("bye");
                default:
                    System.out.println("Taka lang");
            }

        }while(op != 'x');
        list.add(5);
        list.print();
    }
}