package pl.sda.wwa5.lab11.queue;

import org.junit.Test;

import java.util.Date;

public class LifoSpeed {

    @Test
    public void testContains() {
        Lifo<Integer> lifoArrayList = new LifoArrayList();
        Lifo<Integer> lifoLinkedList = new LifoLinkedList();

        for(int i =0; i < 200000; i++) {
            lifoArrayList.push(i);
            lifoLinkedList.push(i);
        }

        long start = new Date().getTime();
        for(int i =0; i < 200000; i++) {
            lifoArrayList.contains(i);
        }
        long timeElapsed = new Date().getTime() - start;
        System.out.println(timeElapsed);

        start = new Date().getTime();
        for(int i =0; i < 200000; i++) {
            lifoLinkedList.contains(i);
        }
        timeElapsed = new Date().getTime() - start;
        System.out.println(timeElapsed);
    }

}
