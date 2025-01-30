public class ArrayList<T>{
    private static final int capacity = 5;
    private int sz;
    private T[] array = (T[]) new Object[capacity];

    public void add(T num) throws ArrayFullExceptions{
        try{
            array[sz++] = num;
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayFullExceptions("Adding failed");
        }
    }


    public void addAt(int pos, int num) throws ArrayFullExceptions, ArrayInvalidPosition{
        if(pos < 1 || pos - 1 > sz){
            throw new ArrayInvalidPosition("addAT failed");
        }

        if(sz >= capacity){
            throw new ArrayFullExceptions("AddAT failed because array is full");
        }
    }


    public int remove(int num) throws ArrayFullExceptions, ArrayInvalidPosition{

        return 0;
    }

    public int removeAt() throws ArrayFullExceptions, ArrayInvalidPosition{
        return 0;
    }

    public boolean contains(int num) throws ArrayInvalidPosition{
        return false;
    }

    public int size() throws ArrayInvalidPosition{
        return 1;
    }

    public boolean isEmpty() throws ArrayInvalidPosition{
        return false;
    }

    public int get(int pos) throws ArrayInvalidPosition{
        return 0;
    }

    public int set(int pos, int num) throws ArrayInvalidPosition{
        return 0;
    }

    public void print(){

        System.out.println(array[0]);
    }
}
