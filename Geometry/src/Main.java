
public class Main {
    //Program napisany obiektowo dający możliwość policzenia geometrycznych wymiarów
    //figur matematycznych.
    public static void main(String[] args) {
        //tworze nowy obiekt klasy koło, nadaje wymiary i printuje
        Circle circle1 = new Circle();
        circle1.radius=10;
        circle1.print();
        //tworze nowy obiekt klasy prostokąt, nadaje wymiary i printuje
        //sprawdzam również obiekt powstały defultowo
        Rectangle rectangle1 = new Rectangle();
        Rectangle rectangle2 = new Rectangle(10,10);
        rectangle1.print();
        rectangle2.print();
        //tworze nowy obiekt klasy walec, nadaje wymiary i printuje w przypadku
        //walca zadeklarowane zmienne są private czyli ukryte, nie możliwe do modyfikacji
        //z zewnątrz. Musimy użyć set-era aby je ustawić
        Cylinder cylinder1 = new Cylinder();
        cylinder1.setRadius(7);
        cylinder1.setHeight(10);
        cylinder1.print();
    }


}