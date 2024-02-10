
package com.mycompany.smartparkingsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CarParkingSystem {
        String[] parkingSpaces;
    int front, rear;
    int capacity;

    public CarParkingSystem(int size) {
        capacity = size;
        parkingSpaces = new String[capacity];
        front = rear = -1;
    }

    // Method to check if the parking queue is empty
    boolean isQueueEmpty() {
        return front == -1;
    }

    // Method to check if the parking queue is full
    boolean isQueueFull() {
        return (front == 0 && rear == capacity - 1);
    }

    // Method to park a car
    public void parkCar(String carLicensePlate) {
        if (isQueueFull()) {
            System.out.println("Parking lot is full. Cannot park car " + carLicensePlate + ".");
            writeToFile("Parking lot is full. Cannot park car " + carLicensePlate + ".");
        } else {
            if (front == -1) {
                front = rear = 0;
            } else if (rear == capacity - 1) {
                rear = 0;
            } else {
                rear++;
            }
            parkingSpaces[rear] = carLicensePlate;
            System.out.println("Car " + carLicensePlate + " parked in space " + rear + ".");
            writeToFile("Car " + carLicensePlate + " parked in space " + rear + ".");
        }
    }

    public void unparkCar() {
        if (isQueueEmpty()) {
            System.out.println("Parking lot is empty. No cars to unpark.");
            writeToFile("Parking lot is empty. No cars to unpark.");
        } else {
            String carLicensePlate = parkingSpaces[front];
            System.out.println("Car " + carLicensePlate + " unparked from space " + front + ".");
            writeToFile("Car " + carLicensePlate + " unparked from space " + front + ".");

            if (front == rear) {
                front = rear = -1;
            } else if (front == capacity - 1) {
                front = 0;
            } else {
                front++;
            }
        }
    }

    public void readCarInformationFromFile() {
        // Read and display car information from the file
        try (BufferedReader reader = new BufferedReader(new FileReader("parking_lot_information.txt"))) {
            String line;
            System.out.println("Car Information from the File:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
        }
    }

    private void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("car_information.txt", true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
        }
    }
}
