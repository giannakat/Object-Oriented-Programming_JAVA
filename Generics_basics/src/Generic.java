public class Generic {

    public static <T> void displayArray(T[] array){
        for(T x: array){
            System.out.println(x + " ");
        }
        System.out.println();
    }
}
