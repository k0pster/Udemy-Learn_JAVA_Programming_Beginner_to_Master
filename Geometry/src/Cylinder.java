public class Cylinder {
    //Definicja zmiennych
    double radius;
    double height;
    //deklaruje metody
    public double lidArea(){
        return Math.PI*radius*radius;
    }
    public double totalSurfaceArea(){
        return 2*lidArea()+circumference()*height;
    }
    public double circumference(){
        return 2*Math.PI*radius;
    }
    public double voulume(){
        return lidArea()+height;
    }
    public void print(){
        System.out.println("Area: "+this.totalSurfaceArea());
        System.out.println("Volume: "+this.voulume());
    }
}
