
//obiekt drukujący litera po literze podany string
class MyData {
    public void display(String str)
    {
        //dodajemy synchronized(this) aby uzyskać printowanie(korzystanie z obiektu) w kolejce,
        //jeden po drugim bez zapisu sunchronized
        //w efekcie otrzymam print "Hello WorldWelcome" czyli obiekt ten nie jest zsynchronizowany
        //i przez jednoczesne wykorzystanie obiektu przez kilka innych result czyli printy sa pomieszane
        //po użyciu synchronized otrzymamy najpierw wydruk z wyołania przez pierwszy obiekt nastepnie
        //kolejny wydruk z drugiego. Czyli wątki zostaną umieszone w kolejce i wywołane nie naraz a po kolei.
        //Jak to powinno wyglądać "Hello WorldWelcome"
        synchronized(this)
        {
            for (int i = 0; i < str.length(); i++) {
                System.out.print(str.charAt(i));
            }
        }
    }
}
//Tworzę dwa różne obiekty wątków Thread, które tworzą obiekt klasy MyData i wykorzystują metodę display() do wydrukowania
//stringów
class MyThread1 extends Thread {
    MyData d;
    public MyThread1(MyData d)
    {
        this.d = d;
    }

    public void run()
    {
        d.display("Hello World");
    }
}
class MyThread2 extends Thread {
    MyData d;

    MyThread2(MyData d)
    {
        this.d = d;
    }

    public void run()
    {
        d.display("Welcome");
    }
}
public class Test {
    public static void main(String[] args)
    {
        MyData data = new MyData();  //tworzę obiekt klasy myData
        MyThread1 t1= new MyThread1(data); //oraz obiekty class Thread1
        MyThread2 t2= new MyThread2(data); // i Thread2
        //startuje dwa wątki Thread i korzystam z tego samego obiektu MyData jednocześnie
        t1.start();
        t2.start();

    }
}



