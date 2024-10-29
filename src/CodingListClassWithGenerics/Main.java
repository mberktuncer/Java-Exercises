package CodingListClassWithGenerics;

public class Main {

    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("list created");
        System.out.println(list.toString());
        System.out.println("value of 2. index : " + list.getIndexOf(2));
        list.remove(2);
        System.out.println("after delete index 2");
        System.out.println(list.toString());
        list.add(40);
        System.out.println("40 element added");
        System.out.println(list.toString());
        list.set(0, 100);
        System.out.println("first element set to 100");
        System.out.println(list.toString());
        list.add(100);
        System.out.print("Index of 100: ");
        System.out.println(list.getIndexOf(100));
        System.out.print("Last index of 100: ");
        System.out.println(list.lastIndexOf(100));
        System.out.print("Check if list is empty: ");
        System.out.println(list.isEmpty());

        System.out.println(list.contains(40));



    }

}
