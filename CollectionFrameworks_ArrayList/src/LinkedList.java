import java.util.*;

public class LinkedList {
    public static void main(String[] args)
    {
        //Tworzymy Linked Listy
        java.util.LinkedList<Integer> ll1 = new java.util.LinkedList<>();
        java.util.LinkedList<Integer> ll2 = new java.util.LinkedList<>(List.of(50,60,70,80));

        //Wykonujemy jakieś podstawowe działania dla testów
        //dodanie elementu
        ll1.add(10);
        //dodanie w odpowiednie miejsce
        ll1.add(0,6);
        //dodanie wszystkich elem. linkedlisty ll2 od wskazanego miejsca
        ll1.addAll(1,ll2);
        //wstawienie na elementu na pozycje
        ll1.set(5,100);
        //linkedLista ma również addFirst() i addLast() dodajace element na poczatku lub koncu.
        ll1.addFirst(15);
        ll1.addLast(400);
        //wyświetlamy wszytkie elementy Linkedlisty używając metody i przekazując argumenty za pomocą wyrażenia
        //lambda
        ll1.forEach(n->show(n));
        //mamy również removeFirst() i removeLast()
        ll1.removeFirst();
        ll1.removeLast();

        ll1.forEach(n->show(n));
    }

    static void show(int n)
    {
        System.out.println(n);
    }

}