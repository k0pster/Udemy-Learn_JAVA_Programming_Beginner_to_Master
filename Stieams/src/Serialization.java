import java.io.*;

//Serializacja to proces zapisania/odczytania danych do plików jako obiekty
//zmiennne które tworzą klasę/obiekt bedą przechowane/odczytane do pliku w formie
//takiej jakiej zostały zadeklarowane. Tutaj przykład programu zapisujace do pliku
//obiektów
//Przykład obiektu student, jednak musi posiadać implementacje interfejsu Serializable oraz posiadać konsktruktor
class Student implements Serializable{
    private int rollnr;
    private String name;
    private double uniqenr;
    public static int Data=10; //stworzony tylko żeby pamietac, że static i transient zmienne nie dają sie serializować
    public transient int t;

    //pusty bez parametrowy konstruktor
    public Student(int r,String n,double u)
    {
        rollnr=r;
        name=n;
        uniqenr=u;
        Data=500; //nie daja sie serializowac wiec nie dadza sie zapisac
        t=500; //nie daja sie serializowac wiec nie dadza sie zapisac
    }

    //Tworze metodę przekształcająca dane obiektu do stringu i printującą obiekt
    public String toString()
    {
        return "\nStudent Details:\n"+"Roll: "+rollnr+"\nName: "+name+"\nUnique: "+uniqenr+"\nData: "+Data+"\nTransient: "+t+"\n";
    }
}
public class Serialization {

    /*public static void main(String[] args) throws Exception
    {
        //tworze FileOutputStream ze sciezka do pliku
        FileOutputStream fos = new FileOutputStream("C:\\Users\\mikopec\\Desktop\\JAVA\\Własne\\Stieams\\SerialaizedObject.txt");
        //Tworze ObjectOutputSream i jako argument wskazuje OutputStream
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //Tworze obiekt klasy, która ma zostać zapisana i wypełniam obiekt danymi
        Student student1 = new Student(10,"Michal",1.0);
        //metodą writeObjcet() klasy ObjectOutpusStream zapisuje obiekt do pliku.
        oos.writeObject(student1);
        //zamykamy FileOutputStream
        fos.close();
        //zamykamy ObcjecOutputStream
        oos.close();
    }*/
    //Program do odczytywania danych obiektu
    public static void main(String[] args) throws Exception
    {
        //tworze FileIputStream ze sciezka do pliku
        FileInputStream fis = new FileInputStream("C:\\Users\\mikopec\\Desktop\\JAVA\\Własne\\Stieams\\SerialaizedObject.txt");
        //Tworze ObjectInputSream i jako argument wskazuje InputStream
        ObjectInputStream ois = new ObjectInputStream(fis);
        //Tworze obiekt klasy, która ma zostać odczytana i castuje go na obiekt klasy jaki potrzebujemy
        Student student1 = (Student)ois.readObject();
        //sprawdzamy metoda print info o obiekcie zapisanym w pliku
        System.out.println(student1);
        //zamykamy FileOutputStream
        fis.close();
        //zamykamy ObcjecOutputStream
        ois.close();
    }
}
