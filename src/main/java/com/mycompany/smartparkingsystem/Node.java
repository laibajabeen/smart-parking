
package com.mycompany.smartparkingsystem;

public class Node {
       Car carnode;
    Node prev;
    Node next;

    public Node(Car car) {
        carnode = car;
        prev = null;
        next = null;
    }
}
