//Tworzę dwie klasy gdzie jedna Sub dziedziczy od klasy Super
//Poprzez override nadpisuję tak samo nazwaną metodę dla clasy Sub,
//żeby to właśnie ona dla powstałych wg. tej klasy obiektów została wywołana

class Super{
    public void display(){
        System.out.println("Super class Display");
    }
}

class Sub extends Super{
    @Override
    public void display(){
        System.out.println("Sub class Display");
    }

}

public class Main {
    public static void main(String[] args)
    {
        Super sup = new Super();
        sup.display();

        Sub s = new Sub();
        s.display();

        //WAŻNE: w przypadku stworzenia referencji/obiektu wg klasy dziecka
        //wywoływana metoda w JAVIE zawsze wywoła tą z obiektu czyli w tym przypadku klasy Sub,
        //a nie referencji do obiektu czyli (zmiennej referencyjnej klasy Super)
        Super parent = new Sub();
        parent.display(); //wyświetli Sub class
    }
}