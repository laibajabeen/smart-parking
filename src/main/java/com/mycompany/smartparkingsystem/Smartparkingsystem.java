
package com.mycompany.smartparkingsystem;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
public class Smartparkingsystem {
private static void eraseFile(String filename) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
        // Writing an empty string to truncate or create an empty file
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) {
        
        MyStack stack = new MyStack();
        stack.getreservation();
        
        DoublyLinkedList parkingLot = new DoublyLinkedList();

        // Adding cars to the parking lot
        parkingLot.addCar(new Car("ABC123"));
        parkingLot.addCar(new Car("XYZ789"));
        parkingLot.addCar(new Car("OUYH757"));
        parkingLot.addCar(new Car("AWAW09"));
parkingLot.removeCar(licensePlate);
        // Displaying the initial parking lot status
        parkingLot.displayParkingLot();

        // Removing a car from the parking lot
        parkingLot.removeCar("XYZ789");

        // Displaying the updated parking lot status
        parkingLot.displayParkingLot();

        int capacity = 5; // Adjust the capacity as needed
        CarParkingSystem parkingSystem = new CarParkingSystem(capacity);

        // Simulating cars arriving and parking
        parkingSystem.parkCar("ABC123");
        parkingSystem.parkCar("IYIB75");

        // Simulating cars exiting the parking lot
        parkingSystem.unparkCar();

        // Reading and displaying car information from the file
        parkingSystem.readCarInformationFromFile();
    
    
    }
}
