import java.util.*;
//LinkedHashMap to pochodna Hashmapy (umieszczanie w indeks = x%10),ale oprócz każdej pary
//klucz-wartość dodatkowo są pointery do poprzedniej i kolejnego elementu

public class LinkedHashMap {

    public static void main(String[] args)
    {
        //tworze obiekt linkedHashMap
        java.util.LinkedHashMap<Integer,String> lhm=new java.util.LinkedHashMap<>(5);
        //dodajemy elementy
        lhm.put(1,"A");
        lhm.put(2,"B");
        lhm.put(3,"C");
        lhm.put(4,"D");
        lhm.put(5,"E");
        lhm.put(6,"F");
        //printuowanie za pomocą lambda
        lhm.forEach((k,v)-> System.out.println(k+" "+v));
        //można tworzyć także LinkedHasHMap porządkujące po aktywności dostępu do elementu
        //struktury tej używa się do Cache. dodajemy 2 dodatkowe parametry
        java.util.LinkedHashMap<Integer,String> lhm2=new java.util.LinkedHashMap<>(5, .75f,true)
        {
            //można ograniczyć wielkość/pojemność LinkedHashMapy.
            //musimy stworzyć do tego metodę która liczy puty()
            protected boolean removeEldestEntry(Map.Entry e)
            {
                return size()>5;
            }
        };
        //dodajemy elementy
        lhm2.put(1,"A");
        lhm2.put(2,"B");
        lhm2.put(3,"C");
        lhm2.put(4,"D");
        lhm2.put(5,"E");
        lhm2.put(6,"F");
        //sumulujemy użycie danego elementu
        String s=lhm2.get(2);//używamy 2gi element
        s=lhm2.get(5);//nastepnie 5ty
        s=lhm2.get(1);//i ostatni używany jest 1
        //więc wyświeltić powinno w kolejności jakiej były najmniej używane 3,4 potem 2,5,1
        lhm2.forEach((k,v)-> System.out.println(k+" "+v));
    }
}