package ThreadRace;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        ArrayList<Integer> mainList = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            mainList.add(i);
        }

        List<ArrayList<Integer>> subLists = new ArrayList<>();
        int chunkSize = mainList.size() / 4;
        for (int i = 0; i < 4; i++) {
            subLists.add(new ArrayList<>(mainList.subList(i * chunkSize, (i + 1) * chunkSize)));
        }

        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        List<Thread> threads = new ArrayList<>();
        for (ArrayList<Integer> subList : subLists) {
            Thread thread = new Thread(new ThreadRace(subList, evenNumbers, oddNumbers));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);

    }

}
