package org.example.Models;

import org.example.Logic.ParkingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Parking implements Runnable{
    private ParkingQueue<Car> parkingQueue;

    public Parking(ParkingQueue<Car> parkingQueue) {
        this.parkingQueue = parkingQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Car car = parkingQueue.consume();
                if (car != null) {
                    for(int i=0;i < car.getId(); i++)
                        System.out.print("  ");
                    System.out.println("Автомобиль " + car.getId() + " покинул парковку.");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
