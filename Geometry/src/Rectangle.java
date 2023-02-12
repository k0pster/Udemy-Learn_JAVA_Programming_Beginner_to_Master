public class Rectangle {
    //deklaruje wymiary prostokąta
    double length;
    double breadth;

    //deklaracja konstruktora defaultowe, kiedy nowy obiekt tworzony nie otrzyma żadnych argumentów wywoła
    //on następujące
    public Rectangle(){
        length = 1;
        breadth = 1;
    }
    //konstruktor używający argumentów
    public Rectangle(double _length,double _breadth){
        length = _length;
        breadth = _breadth;
    }
    //deklaracja metod obliczeniowych
    public double area() {
        return length*breadth;
    }
    public double perimeter(){
        return 2*(length*breadth);
    }
    public boolean isSquare(){
        if (length==breadth)
        return true;
        else return false;
    }
    public void print(){
        System.out.println("Area: "+this.area());
        System.out.println("Perimeter: "+this.perimeter());
        System.out.println("Is square: "+this.isSquare());
        System.out.println("");
    }
}
