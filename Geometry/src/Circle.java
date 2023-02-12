public class Circle {
    //deklaracja zmiennej promien
    double radius;

    //moetody obliczeniowe:
    //pole powierzcni
    public double area() {
        return Math.PI * radius * radius;
    }
    public double perimeter(){
        return 2*Math.PI*radius;
    }
    public void print(){
        System.out.println("Area: "+this.area());
        System.out.println("Perimeter: "+this.perimeter());
        System.out.println("");
    }
}
