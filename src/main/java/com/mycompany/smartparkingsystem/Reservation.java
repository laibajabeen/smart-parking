
package com.mycompany.smartparkingsystem;
public class Reservation {
      int startTime;
    int endTime;
    Reservation next;

    Reservation(int start, int end) {
        startTime = start;
        endTime = end;
        next = null;
    }
}
