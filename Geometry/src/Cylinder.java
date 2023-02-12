public class Cylinder {
    //Definicja zmiennych
    private double radius;
    private double height;

    //deklaruje metody get-er i set-er aby możliwe było korzystanie z wartości które są prywatne.
    //niedostępne z zewnątrz.
    public double getRadius(){
        return radius;
    }
    public void setRadius(double _radius){
        if (_radius>0)
            radius = _radius;
        else
            radius = 0;
    }
    public double getHeight(){
        return height;
    }
    public void setHeight(double _height){
        if (_height>0)
            height = _height;
        else
            height = 0;
    }

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
