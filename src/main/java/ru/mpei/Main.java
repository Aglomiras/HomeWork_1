package ru.mpei;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TripletDeque<Integer> tripletDeque = new TripletDeque<>();
        for (int i = 0; i < 3; i++){
            System.out.println(i);
            tripletDeque.addLast(i);
        }
        System.out.println("------------");

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            tripletDeque.addFirst(i);
        }
        tripletDeque.toStringDeque();
        System.out.println("------------");

        for (int i = 0; i < 3; i++) {
            System.out.println(tripletDeque.removeFirst());
        }
        tripletDeque.toStringDeque();
        System.out.println("------------");
        for (int i = 0; i < 3; i++) {
            System.out.println(tripletDeque.removeLast());
        }
        tripletDeque.toStringDeque();
        System.out.println("------------");
    }
}