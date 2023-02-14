
class Rectangle{
    int lenght;
    int breadth;
    //deklaracja kontruktorów bez argumentowego i 2arg.
    Rectangle(){
        lenght=breadth=1;
    }
    Rectangle(int l,int b){
        lenght=l;
        breadth=b;
    }
}
//Klasa Rectangle poprzez słówko extends dziedziczy wszystkie zmienne length i breadth.
class Cuboid extends Rectangle{
    int height;
    //deklaracja konstruktorów zero i jedno arg.
    Cuboid(){
        height =1;
    }
    Cuboid(int h){
        height =h;
    }
    //dodanie konstruktora 3 argumentowego z określeniem dziedziczenia dwóch zmiennych z klasy poprzez referencję
    //super(rodzica/rectangle).
    Cuboid(int l, int b, int h){
        super(l,b);
        height =h;
    }
    //Metoda obliczenia objętości
    int volume(){
        return lenght*breadth*height;
    }
}


public class Main {

    public static void main(String[] args)
    {
        //tworząc nowy obiekt klasy Cuboid
        Cuboid c = new Cuboid();
        //Printując teraz metodę volume obiekt/klasa Cuboid
        //Pobiera niezbędne zmienne l i b z metody rodzica klasy rectangle.
        //następie odpala konstruktor bezargumentowy w klasie Cuboid
        //inicjalizuje height jako 1 przez co drukuje objętośc 1
        System.out.println(c.volume());
        //Teraz jeśli chcemy użyć metody volume z obiektu, który zostanie utworzony poprzez
        //konstruktor z Cuboid gdzie podajemy 3 argumenty, musimy dodać w niej
        //przekazanie super i przekazać w argumentach zmienne z rodzica z konstruktora 2 argumentowego
        //w innym przypadku kontruktor Rectangle() zostanie użyty
        Cuboid c2 = new Cuboid(3,5,10);
        System.out.println(c2.volume()); //wynik = 10, bo konstruktor klasy rodzica jest ważniejszy a tam l i b = 1;
        //Konieczne jest dodanie do klasy dziecka na początku wyrażenia super(l,b)
        //wtedy wynik jest 150 czyli poprawny.

    }
}