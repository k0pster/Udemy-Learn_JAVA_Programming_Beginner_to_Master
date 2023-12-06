import java.util.*;

public class TreeAndHashMap {


    public static void main(String[] args)
    {
      //Tworzymy TreeMap z wartością key and value <k,v>
      TreeMap<Integer,String> tm=new TreeMap<>(Map.of(0,"A",1,"B",2,"C"));
      //print tree
      System.out.println(tm);
      //dodajemy kolejne elementy poprzez metodę put()
        tm.put(3,"D");
        tm.put(4,"E");
        tm.put(6,"F");
      //metoda ceilingEntry() i getValue() zwraca wartość element o kluczu podanym jako argument,
        //albo następny, wiec w tym przypadku zwróci G, bo brak 5tego elementu
        System.out.println(tm.ceilingEntry(5).getValue());
        //do pobierania wartości używa się get()
        System.out.println(tm.get(3));
        System.out.println(tm);

        //Tworzymy HasMap tak samo z wartością key and value <k,v>
        HashMap<Integer,String> hm=new HashMap<>(Map.of(0,"A",1,"B",2,"C"));
        //print hash
        System.out.println(hm);
        //dodajemy kolejne elementy poprzez metodę put()
        hm.put(3,"D");
        hm.put(4,"E");
        hm.put(6,"F");

    }
}