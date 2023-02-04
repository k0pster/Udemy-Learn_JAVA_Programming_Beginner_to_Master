import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Program sprawdza czy email jest na podanej domenie, oraz ma wyciągnąć
        //z adresu username i domene na jakiej jest założony. (username@domena)

        //Tworzę zmienną, która będzie sprawdzać email o dany pattern domeny.
        String domainName = "interia.pl";
        //Tworzę srting, który będzie przechowywał adres email
        String emailAddress = new String();
        //Tworzę zmienne na przechowanie wprowadzonego emaila username i domenę.
        String userName = new String();
        String userDomain = new String();
        //Tworze zmienna pomocna do podziału wprowadzonego emaila, znak małpy pomoże jako miejsce podziału.
        int atChar;

        //Wyświetlam prośbę o adres email
        System.out.println("podaj adres email:");
        //Pobieram dane od użytkownika z klawiatury i umieszczam je w utworzonym Stringu
        Scanner sc = new Scanner(System.in);
        emailAddress = sc.next();
        //Sprawdzam czy email jest zarejestrowany na wymaganej domenie
        boolean correctDomain = emailAddress.endsWith(domainName);
        //Wyświetlam poprawność domeny oraz email
        if (!correctDomain) {
            System.out.println("Nie respektujemy emaili na takiej domenie");
        }
        //Wyznaczam miejsce podziału wprowadzonego Stringa przez użytkownika znajdując małpę metodą indexOf.
        atChar = emailAddress.indexOf('@');
        //i przechwytuję stringa od początku do znaku małpy
        userName = emailAddress.substring(0,atChar);
        //Następnie od miejsca za znakiem małpy do konca stringa jako nazwa domeny.
        userDomain = emailAddress.substring(++atChar,emailAddress.length());
        System.out.println(emailAddress);
        System.out.println(userName);
        System.out.println(userDomain);
    }
}