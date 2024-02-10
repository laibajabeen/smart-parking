
package com.mycompany.smartparkingsystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MyStack {
        Reservation top;

    public MyStack() {
        top = null;
    }

    void getreservation() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the time you want to reserve for your parking ");
        System.out.println("Enter starting time");
        int start_time = sc.nextInt();
        System.out.println("Enter ending time");
        int end_time = sc.nextInt();
        reserve(start_time, end_time);
    }

    public boolean reserve(int startTime, int endTime) {
        Reservation newReservation = new Reservation(startTime, endTime);
        newReservation.next = top;
        top = newReservation;
        System.out.println("Reserved from " + startTime + " to " + endTime);
        writeToFile("Reserved from " + startTime + " to " + endTime);
        return true;
    }

    public void cancelReservation() {
        if (top == null) {
            System.out.println("Reservation stack is empty");
        } else {
            Reservation cancelledReservation = top;
            top = top.next;
            System.out.println(
                    "Cancelled reservation from " + cancelledReservation.startTime + " to " + cancelledReservation.endTime);
            writeToFile("Cancelled reservation from " + cancelledReservation.startTime + " to "
                    + cancelledReservation.endTime);
        }
    }

    private void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservation_information.txt", true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
        }
    }
}
