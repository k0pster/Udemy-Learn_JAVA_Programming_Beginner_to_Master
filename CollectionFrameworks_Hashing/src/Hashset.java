import java.util.*;
public class Hashset {
    //Hashowanie opiera się na metodzie HashTable składających się z bucket-ów
    //Każdy z nich może przechowywać warotść albo wartość kluczową (value key)
    //wartość wstawiana jest na bieżąco w indeks = x%10. Jeśli jest kilka takich samych
    //indeksów wstwaiane sa miejsce dalej(open addresssing) albo łączenie nodami w łańcucy
    //wartości (chaining).

    public static void main(String[] args)
    {
        //Tworzę treeset wartości Integer
        java.util.TreeSet<Integer> ts = new java.util.TreeSet<>(List.of(10,30,50,70,10,40));
        //duplikaty nie bedą działać z uwagi na metodę set() i powinny być posortowane
        System.out.println(ts);
        //Dodaje element, i powienien być drugi.
        ts.add(25);
        System.out.println(ts);
        //metoda ceiling zwraca wartość podaną lub najbliższą wartości powinno zwócić 70
        System.out.println(ts.ceiling(55));;
    }
}