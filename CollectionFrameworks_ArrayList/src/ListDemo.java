import java.util.*; // import w którym znajdują się metody/klasy Collections

public class ListDemo {
    public static void main(String[] args)
    {
        //Tworzę ArrayListe o początkowej wielkości 20 obiektów
        ArrayList<Integer> all=new ArrayList<>(20);
        //metoda all() dodaje elemnt do listy
        all.add(10);
        //metoda all() z podanymi dwoma elementami dodaje element w podane indeks(miejsce w liście)
        all.add(0,5); // tutaj element 10 zostanie zastąpiony 5.
        //aby użyć metody addAll potrzebujemy drugiej listy, od razu inicjuje przykładowe
        //elementy w środku listy metodą List.of()
        ArrayList<Integer> all2=new ArrayList<>(List.of(50,60,70,80,90));
        all.addAll(all2);//do listy all zostaną dodane wszystkie elem. listy all2
        //możemy też dodać elementy addAll() podając miejsce w które ma być
        //dodane elementy listy
        //sprawdzamy
        System.out.println(all);
        //metoda contanins() sprawdza czy element jest w liście czy nie (true,false)
        System.out.println(all.contains(50));//true
        //get() służy do wyciągania elementu z indexu
        System.out.println(all.get(5)); //5elementem jest 80
        //indexOf() wskazuje na którym miejscu jest podany element
        System.out.println(all.indexOf(80)); //80 jest na 5tym miejscu
        //metoda set() zastępuje wskazany indeks nowym podanym elementem
        all.set(6,100); //zamiana elementu na 6tym miejscu listy 90 na 100;

        System.out.println(all);
        //metoda iteration() pozwala iterować po elementach listy
        for (var i=0; i<all.size();i++)
        {
            System.out.println(all.get(i)); //teraz aby dojść do każdego elem. nie możemy użyć all[i] trzeba np. get()
        }
        //zamiast normalnych pętli for i foreach możemy użyć iterator albo listIteratora
        Iterator<Integer> it=all.iterator();
        //można wykorzystać metodą hasNext() iteratora, która zwróci true jeśli jest następny element
        while(it.hasNext()) //printujemy dopóki jest kolejny element
        {
            System.out.println(it.next());//metodą next dostajemy się do następnego elementu
        }
        //możemy while loop zamienic na for loop
        for (Iterator<Integer> it2=all.iterator();it.hasNext();)
        {
            System.out.println(it2.next());
        }
        //a tutaj forEach() lambda expresja
        all.forEach(n-> System.out.println(n));
        //kolejny syntax który też zadziała tak samo
        all.forEach(System.out::println);

        //forEach i lambda expresja możemy też przekazywać do innych metod klas
        all.forEach(n->show(n));
    }

    //metoda printująca elementy wieksze od 60
    static void show(int n)
    {
        if(n>60)
            System.out.println(n);
    }
}