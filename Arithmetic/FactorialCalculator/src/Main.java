import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //kalkulator liczący silnię wprowadzonej liczby

        //Deklaruję skaner i silnie
        long factorial = 0;
        Scanner sc = new Scanner(System.in);
        //Wyświetlam prośbę o podanie liczby
        System.out.println("Please input number for calculation factorial:");
        //pobranie liczby i umieszczenie jej w zmiennej
        int number = sc.nextInt();
        //wykonanie obliczeń silni przy pomocy pętli for i umieszczanie w każdej inkrementacji
        //wartości mnożenia każdej kolejnej liczby aż do momentu wskazanej przez usera.
        for (int i = 0; i <= number;i++)
        {
            factorial = number * i;
        }
        System.out.println(number+"! = "+factorial);
    }
}