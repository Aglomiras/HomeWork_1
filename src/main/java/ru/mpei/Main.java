package ru.mpei;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TripletDeque<Integer> tripletDeque = new TripletDeque<>();
        for (int i = 0; i < 27; i++){
            tripletDeque.addLast(i);
        }
        tripletDeque.toStringDeque();
        System.out.println("------------");
        tripletDeque.addFirst(28);
        tripletDeque.removeLast();
        tripletDeque.removeLast();
        tripletDeque.toStringDeque();
        System.out.println();

        Iterator<Integer> iterator = tripletDeque.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}