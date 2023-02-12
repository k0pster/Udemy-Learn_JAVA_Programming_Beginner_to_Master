public class Rectangle {
    //deklaruje wymiary prostokąta
    double length;
    double breadth;
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
    }
}
