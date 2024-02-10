
package com.mycompany.smartparkingsystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DoublyLinkedList {
      Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void addCar(Car car) {
        Node newNode = new Node(car);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println("Car with license plate " + car.licensePlate + " parked successfully.");
        writeToFile("Car with license plate " + car.licensePlate + " parked successfully.");
    }

    public void removeCar(String licensePlate) {
        Node current = head;
        while (current != null) {
            if (current.carnode.licensePlate.equals(licensePlate)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println(
                        "Car with license plate " + licensePlate + " removed from the parking lot.");
                writeToFile("Car with license plate " + licensePlate + " removed from the parking lot.");
                return;
            }
            current = current.next;
        }
        System.out.println("Car with license plate " + licensePlate + " not found in the parking lot.");
        writeToFile("Car with license plate " + licensePlate + " not found in the parking lot.");
    }

    public void displayParkingLot() {
        Node current = head;
        MyStack stack = new MyStack();
        System.out.println("Current Parking Lot Status:");
        while (current != null) {
            System.out.println("License Plate: " + current.carnode.licensePlate);
            current = current.next;
        }
        System.out.println("----------------------------");
    }

    private void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("parking_lot_information.txt", true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
        }
    }
}
