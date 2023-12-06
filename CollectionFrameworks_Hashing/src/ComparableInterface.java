import java.util.List;
//tworzę przykładową klasę
class Point implements Comparable
{
    int x;
    int y;
    //konstruktor

    public Point(int x,int y) {
        this.x = x;
        this.y = y;
    }
    //koniecznie musi być metoda pozwalająca stringować
    public String toString()
    {
        return "x = "+x+" y = "+y;
    }
    public int compareTo(Object o)
    {
        Point p=(Point)o;
        if(this.x<p.x)
            return -1;
        else if(this.x>p.x)
            return 1;
        else
        {
            if(this.y<p.y)
                return -1;
            else if(this.y>p.y)
                return 1;
            else
                return 0;
        }
    }

}
public class ComparableInterface {
    public static void main(String[] args)
    {
        //Tworze treeSet typu naszego obiektu (stworzonej klasy Point)
        java.util.TreeSet<Point> ts = new java.util.TreeSet<>();
        ts.add(new Point(1,1));
        ts.add(new Point(5,5));
        ts.add(new Point(5,2));
        System.out.println(ts);
    }
}