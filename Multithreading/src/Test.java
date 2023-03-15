//Multithreading to działania kilku aplikacji/programów na raz
//np. żeby dwie klasy działały w trybie multithreading w JAVA
//musimy rozrzeszyć klasy od Threads. Jako że w JAVA możemy
//rozrzeszać klasę tylko od jednej klasy aby wykonać
//to z klasą która juz dziedziczy po klasie lepiej
//użyć Runnable Interfejsu.

//Tworzę drugą klasę MyThreads,ale dokładnie to samo zadziała w jeśli zostanie to napisane
//w jednej klasie. Tworzę klasę dziedzićzącą MyThreads od Thread. Metoda run() jest jak
//metoda main() w programach tylko występuje w klasach Threads, musimy jej użyć, żeby uruchomić wątek.
class MyThread extends Thread {
    public void run()
    {
        int i = 1;
        while (i<10) {
            System.out.println(i + "Hello");
            i++;
        }
    }
}
//Druga klasa główna w której utworzę i uruchamiam utworzoną klasę wyjątku. W efekcie otrzymamy
//jednakowe wyświetlanie (pomieszane) dwóch printów jednocześnie. Co dowodzi, że uruchmione zostały
//dwa programy jednocześnie w multithreadingu.
public class Test {
    public static void main(String[] args)
    {
        //tworzę obiekt Thread
        MyThread t=new MyThread();
        t.start(); // aby uruchomić metodę run() z klasy Thread wywołujemy wbudowaną metodę Thread start()
        //wykonuje teraz jakieś instrukcję.
        int i = 1;
        while(i<10)
        {
            System.out.println(i+"World");
            i++;
        }
    }
}