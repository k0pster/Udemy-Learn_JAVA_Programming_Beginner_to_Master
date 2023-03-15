//Multithreading w JAVA możemy osiągnąć również poprzez dziedziczenie interfejsu Runnable
public class Main {

    //Tworzę klasę Test w której umieszczam w niej metodę run() niezbędną
    //do uruchomienia wątku klasy Thread
    static class Test implements Runnable {
        public void run() {
            int i = 1;
            while (i < 10) {
                System.out.println(i + "Hello");
                i++;
            }
        }
    }

    public static void main(String[] args) {
        //W głównej klasie programu najpierw tworzę obiekt klasy Test z metodą uruchamiająca wątek
        Test t = new Test();
        //następnie tworzę obiekt klasy Thread i umieszczam w argumentach obiekt powstałej klasy Test
        Thread th = new Thread(t);
        //następnie uruchamiam wątek metodą start z klasy Thread na obiekcie wątku klasy Thread
        th.start();
        //Tutaj wywołuje kolejnego printa, uruchamiajać oba printy jednocześnie. Efekt jest identyczny jak
        //za pomocą klasy Thread (program Multithreading.java.
        int i = 1;
        while (i < 10) {
            System.out.println(i + "World");
            i++;
        }
    }
}


