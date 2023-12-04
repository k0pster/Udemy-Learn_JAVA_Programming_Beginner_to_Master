import java.util.List;

public class ArrayDeque {
    public static void main(String[] args)
    {
        //Dodawwanie elementów do tego typu  listy jest możliwe z obydwustron.
        //Tworzymy arrayDeque liste
        java.util.ArrayDeque<Integer> dq1 = new java.util.ArrayDeque<>();

        //Wykonujemy jakieś podstawowe działania dla testów
        //dodanie elementu na koniec poprzez offerLast()
        dq1.offerLast(10);
        dq1.offerLast(20);
        dq1.offerLast(30);
        dq1.offerLast(40);

        //wyświetlamy wszytkie elementy Linkedlisty używając metody i przekazując argumenty za pomocą wyrażenia
        //lambda
        dq1.forEach((x)-> System.out.println(x));

        //Teraz dodajemy elementy na poczatku offerFirst()
        dq1.offerFirst(1);
        dq1.offerFirst(2);
        dq1.offerFirst(3);
        dq1.offerFirst(4);

        dq1.forEach((x)-> System.out.print(x+","));


    }


}