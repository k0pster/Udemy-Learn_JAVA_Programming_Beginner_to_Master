import java.util.Map;
//LinkedHashSet różni się od LinkedHasMap, że przechowuje tylko wartość bez klucza

public class LinkedHashSet {

    public static void main(String[] args) {
        //tworze obiekt linkedHashMap
        java.util.LinkedHashSet<String> lhs = new java.util.LinkedHashSet<>();

        //dodajemy elementy metodą add()
        lhs.add("A");
        lhs.add("C");
        lhs.add("G");
        lhs.add("H");
        lhs.add("B");
        lhs.add("G");
        //printowanie za pomocą lambda spodziewamy się kolejności jakiej były dodane
        //ale set nie pozwala na duplikaty
        lhs.add("A");
        lhs.forEach((k) -> System.out.println(k));
        //Różnica pomiędzy HashSetem jest taka,że tam struktura elementów bedzie posortowana.
        //tworze obiekt HashMap
        java.util.HashSet<String> hs = new java.util.HashSet<>();
        hs.add("A");
        hs.add("C");
        hs.add("G");
        hs.add("H");
        hs.add("B");
        hs.add("G");
        hs.forEach(System.out::println);
    }
}