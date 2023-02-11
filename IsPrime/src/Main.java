public class Main {
    public static void main(String[] args) {
        //Stworzenie metody która sprawdza czy podana liczba jest liczbą pierwszą

        System.out.println(isPrime(19));
    }

    //Tworzę metodę statyczną 'static' isPrime przyjmującą argument w postaci liczby int, zwracający
    //wartość prawda lub fałsz. Inaczej do deklaracji jej w głównej klasie Main musiał bym najpierw zadeklarować
    //nowy obiekt klasy Main [Main obiekt = new Main();] w metodzie głównej main i powołać się
    //na nowo utworzony obiekt klasy Main, korzystając z jej metody isPrime [ System.out.println(obiekt.isPrime(19));].
    //Logika sprawdzenie to przejście pętlą for przez każdą liczbę w zakresie od 2 do połowy podanej liczby
    //Jeśli po drodzę dzielenie podanej liczby przez jakikolwiek inny czynnik niż 1 i ją samą będzie bez reszty
    //nie mamy doczynienia z liczbą pierwszą. Jeśli pętla dobrnie do konca i dzielenia beda miały resztę,
    //wtedy możemy mówić o liczbie pierwszej.
    public static boolean isPrime(int number){
        for (int i=2; i<=number/2;i++)
        {
            if (number%i==0) {
                return false;
            }
        }
        return true;
    }
}