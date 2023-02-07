import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Program zwracający odwrotność podanej liczby np 123 = 321

        //Deklaracja scannera i zmiennych
        int reminder;
        int number;
        int reverseNumber = 0;
        Scanner sc = new Scanner(System.in);
        //Prośba o podanie liczby do odwrócenia
        System.out.println("Input number to reverse:");
        number = sc.nextInt();
        //Wyciągnięcie poszczególnych wielkości z liczby za pomocą pętli while
        //Wykorzystuje resztę z dzielenia przez 10 liczby podanej, co daje mi pierwszą cyfrę odwróconej liczby
        //dodaję ją do reszty dzielenia przez 10(umieszczonej w zmiennej reminder) pomnożonej przez 10.
        //Kontynuuje proces tak długo aż licznik nie będzie zerem.
        int counter = number;
        while (counter != 0) {
            reminder = counter%10;
            reverseNumber = reverseNumber * 10 + reminder;
            counter = counter/10;
        }
        System.out.println("Reverse number of "+number+" is "+reverseNumber);
    }
}