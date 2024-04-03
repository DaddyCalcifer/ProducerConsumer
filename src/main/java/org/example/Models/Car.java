package org.example.Models;

import org.example.Logic.ParkingQueue;

public class Car implements Runnable {
    private int id;
    private int waitTime, maxWaitTime;
    private ParkingQueue<Car> parkingQueue;

    public Car(int id, int waitTime, int maxWaitTime, ParkingQueue<Car> parkingQueue) {
        this.id = id;
        this.waitTime = waitTime;
        this.maxWaitTime = maxWaitTime;
        this.parkingQueue = parkingQueue;
    }

    @Override
    public void run() {
        try {
            for(int i=0;i < id; i++)
                System.out.print("  ");
            System.out.println("Автомобиль " + id + " приехал на парковку.");
            long startTime = System.currentTimeMillis(); // Начало ожидания
            Thread.sleep(waitTime); // Симуляция времени ожидания
            long elapsedTime = System.currentTimeMillis() - startTime; // Рассчет затраченного времени
            if (elapsedTime < maxWaitTime) {
                for(int i=0;i < id; i++)
                    System.out.print("  ");
                System.out.println("Автомобиль " + id + " нашел место и припарковался.");
                parkingQueue.produce(this); //Автомобиль занял место
            } else {
                for(int i=0;i < id; i++)
                    System.out.print("  ");
                System.out.println("Автомобиль " + id + " не дождался места и уехал.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString()
    {
        Integer res = id;
        return res.toString();
    }
}