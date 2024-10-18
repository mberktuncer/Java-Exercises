package CodingListClassWithGenerics;

public class MyList <T>{

    int capacity;
    public T[] array;
    int size = 0;

    public MyList(){
        this.capacity = 10;
        this.array = (T[]) new Object[capacity];
    }

    public MyList(int capacity){
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public int getSize(){
        return size;
    }

    public void add(T data){
        if (size == capacity){
            increaseCapacity();
        }
        array[size] = data;
        size++;
    }

    private void increaseCapacity() {
        capacity *= 2;
        T[] tempArray = (T[]) new Object[capacity];
        for (int i = 0; i< size; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
    }

    public int getIndex(int index) {
        return (int) array[index];
    }

    public T remove(int index){
        if (index >= 0 && index < size) {
            T removed = array[index];

            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
            return removed;
        }
        return null;

    }

    public T set(int index, T data){
        if (index >= 0 && index < size) {
            T oldData = array[index];
            array[index] = data;
            return oldData;
        }
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(", ");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }

    public int getCapacity(){
        return capacity;
    }

}

class Main {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("list created");
        System.out.println(list.toString());
        System.out.println("value of 2. index : " + list.getIndex(2));
        list.remove(2);
        System.out.println("after delete index 2");
        System.out.println(list.toString());
        list.add(40);
        System.out.println("40 element added");
        System.out.println(list.toString());
        list.set(0, 100);
        System.out.println("first element set to 100");
        System.out.println(list.toString());
    }
}