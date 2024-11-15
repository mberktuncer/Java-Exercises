package ThreadRace;

import java.util.List;

public class ThreadRace implements Runnable{
    private final List<Integer> subList;
    private final List<Integer> evenNumbers;
    private final List<Integer> oddNumbers;

    public ThreadRace(List<Integer> subList, List<Integer> evenNumbers, List<Integer> oddNumbers) {
        this.subList = subList;
        this.evenNumbers = evenNumbers;
        this.oddNumbers = oddNumbers;
    }


    @Override
    public void run() {
        for (int number : subList) {
            if (number % 2 == 0) {
                synchronized (evenNumbers) {
                    evenNumbers.add(number);
                }
            } else {
                synchronized (oddNumbers) {
                    oddNumbers.add(number);
                }
            }
        }
    }
}
