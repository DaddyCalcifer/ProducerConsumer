package org.example.Logic;

import java.util.LinkedList;
import java.util.List;

public class ParkingQueue<T> {
    static final int MAX_Q_SIZE = 2;
    List<T> queue = new LinkedList<>();

    public synchronized void produce(T value) throws InterruptedException {
        while (queue.size() == MAX_Q_SIZE)
        {
            wait();
        }
        queue.add(value);
        notify();
    }
    public synchronized T consume() throws InterruptedException{
        while(queue.size() == 0)
        {
            wait();
        }
        T result = queue.remove(0);
        return result;
    }
}
