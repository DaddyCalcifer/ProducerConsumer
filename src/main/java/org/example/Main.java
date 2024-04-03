package org.example;

import org.example.Logic.ParkingQueue;
import org.example.Models.Car;
import org.example.Models.Parking;

public class Main {
    public static void main(String[] args) {
        ParkingQueue<Car> parkingQueue = new ParkingQueue<>();
        Parking parking = new Parking(parkingQueue);

        Thread parkingThread = new Thread(parking);
        parkingThread.start();

        for (int i = 1; i <= 10; i++) {
            int waitTime = (int) (Math.random() * 6000);
            int maxWaitTime = 5000;
            Car car = new Car(i, waitTime, maxWaitTime, parkingQueue);
            Thread carThread = new Thread(car);
            carThread.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}