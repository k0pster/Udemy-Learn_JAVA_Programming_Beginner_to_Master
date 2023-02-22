import java.util.Date;

class Student {
    //Tworzę w klasie prywatne unikalne numery studentów
    private String rollNumber; //zmienna String do przechowywania ID studenta
    private static int counter=1; //licznik studentów

    //tworze prywatną metodę przydzielająca numer na podstawie nazwy szkoły roku oraz indywidualnego numeru,
    //zwracającą string,
    private String assignRollNo()
    {
        Date d = new Date(); //nowy obiekt Daty, aby pobrać rok
        String rollnr = "Univ-"+(d.getYear()+1900)+"-"+counter;
        counter++;
        return rollnr;
    }
    //tworzę konstruktor w którym do zmiennej identyfikatora, przypisuje
    //metodę generująca numer.
    Student(){
       rollNumber = assignRollNo();
    }
    public String getRollNumber()
    {
        return rollNumber;
    }


}
public class Main {
    public static void main(String[] args) {
        //Tworzę kilka obiektów klasy student
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        //SPrawdzam czy nadany został unikatowy numer
        System.out.println(s1.getRollNumber());
        System.out.println(s2.getRollNumber());
        System.out.println(s3.getRollNumber());
    }
}