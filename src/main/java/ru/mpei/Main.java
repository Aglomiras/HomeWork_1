package ru.mpei;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        MyLinkedDeque myLinkedDeque = new MyLinkedDeque();
        System.out.println(myLinkedDeque);
        System.out.println(myLinkedDeque.checkNull());
        int A = myLinkedDeque.getSizeLinkDeque();
        System.out.println(A);

//        List B = List.of(myLinkedDeque.getTripletDeque());
//        System.out.println(B);

//        System.out.println(myLinkedDeque);
//        myLinkedDeque.addMyLinkDeq(67);
//        System.out.println(myLinkedDeque);
//        System.out.println(myLinkedDeque.checkNull());
//        myLinkedDeque.addMyLinkDeq(3453);
//        System.out.println(myLinkedDeque);
//        myLinkedDeque.addMyLinkDeq(12);
//        myLinkedDeque.addMyLinkDeq(767);
//        myLinkedDeque.addMyLinkDeq(1);
//        System.out.println(myLinkedDeque);
//        myLinkedDeque.addMyLinkDeq(90);
//        System.out.println(myLinkedDeque);
//
//        TripletDeque tripletDeque = new TripletDeque();
//        System.out.println(tripletDeque);
//        System.out.println(myLinkedDeque.checkFullMass());

        MyLinkedDeque myLinkedDeque1 = new MyLinkedDeque();
        myLinkedDeque1.addLast(23);
        myLinkedDeque1.addLast(9);
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.addLast(45);
        System.out.println(myLinkedDeque1.getSizeLinkDeque());
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.addLast(13);
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.addFirst(2);
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.addFirst(4555);
//        myLinkedDeque1.addLast(90);
        System.out.println("--------------------");
        myLinkedDeque1.removeFirst();
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.removeLast();
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.removeLast();
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.removeFirst();
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.removeFirst();
        System.out.println(myLinkedDeque1);
        myLinkedDeque1.removeFirst();
        System.out.println("---------------------");

        TripletDeque tripletDeque = new TripletDeque();
        System.out.println(tripletDeque);
        tripletDeque.addFirst(1);
        tripletDeque.addFirst("ret");
        tripletDeque.addFirst(3);
        tripletDeque.addFirst(4);
        tripletDeque.toStringDeque();
        tripletDeque.addLast(5);
//        tripletDeque.addFirst(20);
        tripletDeque.addLast(333);
        System.out.println(tripletDeque.offerFirst(9));
        System.out.println("---------------------");
        tripletDeque.toStringDeque();
        System.out.println("---------------------");
        System.out.println(tripletDeque.removeLast());
//        System.out.println(tripletDeque.removeFirst());
        System.out.println(tripletDeque.removeLast());
//        System.out.println(tripletDeque.offerLast(8));
//        System.out.println(tripletDeque.offerLast(null));

        tripletDeque.toStringDeque();

    }
}