import java.util.Random;
import java.util.Scanner;

/*
//Dorobić możliwość wybierania własnej listy i porównania jej z wynikami
        System.out.println("Provide your five numbers in range 1-50");
                Scanner sc = new Scanner(System.in);
*/

public class Main {
    public static void main(String[] args) {
        //Program radomowo wybierający 5 liczb i tworzący z nich liste
        System.out.println("Lotto Lottery");
        //Inicjalizacja listy 5 liczb do losowania;
        int WinnerNumbers[] = new int[5];

        //Losowanie 5 randomowych liczb przy użyciu funkcji generującej loswy int
        for (int i = 0; i < WinnerNumbers.length; i++){
            int random = generateRandomIntFromRange(1,50);
            WinnerNumbers[i] = random;
        }

        System.out.println("Numbers has been generated");

        //drukuje każdą liczbę wylosowaną pętlą for each
        for (int number: WinnerNumbers){
            System.out.print(number+" ");
        }

    }
    //Funkcja losująca zmienną INT z wybranego przedziału.
    public static int generateRandomIntFromRange(int min, int max){
        //Inicjalizacja randomowej liczby
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}