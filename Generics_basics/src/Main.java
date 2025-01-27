//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'E', 'L', 'L', 'L'};
        String[] stringArray = { "B", "Y", "E"};

        displayArray(intArray);
        displayArray(doubleArray);
    }

    public static <T> void displayArray(T[] array){
        for(T x: array){
            System.out.println(x + " ");
        }
        System.out.println();
    }
}