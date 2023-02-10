import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Symulator Losowania Dużego Lotto, losujący randomo 5 liczb i po podaniu własnych sprawdza ile jest trafionych

        //Inicjalizacja licznika trafień i list:
        //5 liczbowych do losowania, do pobrania od usera jego 5ciu i do przechowania trafionych
        int LottoNumbers[] = new int[5];
        int CrossedNumbers[] = new int[5];
        int GuessedNumbers[] = new int[5];
        int hitCounter = 0;

        //Losowanie 5 randomowych liczb przy użyciu funkcji generującej losowy int
        //Podwójna pętla for z uwagi na wykluczenie możliwości powtórzeń
        //Po każdym losowaniu przchodzę po elentach listy i sprawdzam, czy nie ma powtórek,
        //jeśli napotka ma powtórzyć funkcję random.
        for (int i = 0; i < LottoNumbers.length; i++){
            int random = generateRandomIntFromRange(1,50);
            for(int j=0; j< LottoNumbers.length;j++){
                if (random==LottoNumbers[j]) {
                    random = generateRandomIntFromRange(1,50);
                    if (random==random){
                        random = generateRandomIntFromRange(1,50);
                    }
                }
            }
            LottoNumbers[i] = random;
        }
        //Wyświetlam informację o rozpoczęciu losowania i proszę o podanie własnych numerków
        System.out.println("Lotery started!!!");
        System.out.println("Chose your numbers:");
        Scanner sc = new Scanner(System.in);
        for (int i = 0;i< CrossedNumbers.length;i++){
            System.out.println("Number "+(i+1)+": ");
            CrossedNumbers[i]=sc.nextInt();
        }
        //drukuje każdą liczbę skreśloną przez usera liczbę pętlą for each
        System.out.print("Your Numbers:");
        for (int number: CrossedNumbers){
            System.out.print(number+" ");
        }
        System.out.println("");
        //drukuje każdą liczbę wylosowaną pętlą for each
        System.out.print("Lotto Numbers:");
        for (int number: LottoNumbers){
            System.out.print(number+" ");
        }
        System.out.println("");
        //Sprawdzam poprawność skreślonych liczb z wylosowanymi podwójną petlą for
        //posiłkując się licznikiem trafień. Inkrementuję jego wartość,
        //jeśli liczby w listach lotto i skreślonych są takie same
        //Umieszczając ją jednocześnie na indeksie równym licznikowi trafień
        //W liście Trafionych, ponieważ z defaultu wypełniona jest zerami.
        for (int i = 0;i<CrossedNumbers.length;i++){
            for (int j =0;j<LottoNumbers.length;j++){
                if (CrossedNumbers[i]==LottoNumbers[j]){
                    hitCounter++;
                    GuessedNumbers[hitCounter-1] = LottoNumbers[j];
                }
            }
        }
        //Wyświetlam wyniki losowania
        if (hitCounter>0) {
            System.out.println("You got " + hitCounter + " hit(s)");
            System.out.print("You hitted number(s): ");
            for (int i = 0; i < hitCounter; i++) {
                System.out.print(GuessedNumbers[i]+" ");
            }
        }
        else {
            System.out.println("\nYou didn't guess any number.\nPlease Try again!");
        }
    }
    //Funkcja losująca zmienną INT z wybranego przedziału.
    public static int generateRandomIntFromRange(int min, int max){
        //Inicjalizacja randomowej liczby
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
