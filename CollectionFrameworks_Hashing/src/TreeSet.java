import java.util.HashSet;

public class TreeSet {
    //Hashowanie opiera się na metodzie HashTable składających się z bucket-ów
    //Każdy z nich może przechowywać warotść albo wartość kluczową (value key)
    //wartość wstawiana jest na bieżąco w indeks = x%10. Jeśli jest kilka takich samych
    //indeksów wstwaiane sa miejsce dalej(open addresssing) albo łączenie nodami w łańcucy
    //wartości (chaining).

    public static void main(String[] args)
    {
        //Tworzę hashset wartości Integer
        HashSet<Integer> hs = new HashSet<>();
        //dodaje kilka elementów
        hs.add(10);
        hs.add(20);
        hs.add(30);
        hs.add(10);
        //kolejność spodziewana [20(wynik po hashu to 0 czyli pierwszy element),10,30]
        //następne również dają wynik 0 ale są dodawane po kolei w następny indeks.
        System.out.println(hs);
    }
}