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

    public int getIndexOf(T data){
        for (int i = 0; i < array.length; i++){
            if (array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = array.length - 1; i >= 0; i--){
            if (array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return !(array.length > 0);
    }

    public T[] toArray(){
        T[] tempArray = (T[]) new Object[array.length];
        for (int i = 0; i < array.length; i++){
            tempArray[i] = array[i];
        }
        return tempArray;
    }

    public void clear(){
        for (int i = 0; i < array.length; i++){
            array[i] = null;
        }
    }

    public T[] sublist(int start, int finish){
        T[] tempArray = (T[]) new Object[finish - start + 1];
        for (int i = start; i <= finish; i++){
            int j = 0;
            tempArray[j] = array[i];
            j++;
        }
        return tempArray;
    }

    public boolean contains(T data){
        for (T t : array) {
            if (t == data)
                return true;
        }
        return false;
    }
}
