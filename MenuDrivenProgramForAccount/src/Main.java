import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

//rozwiązanie bedzie zaimplemoentowane poprzez Hashmape, która wykorzystuje pary key,value

//Tworzę klasę główną account implementując Serializable, aby móc zczytywać/odczytywać dane do/z pliku.
class Account implements Serializable {
    //zmienne do rpzechowywania numeru konta, imienia, i balancu
    String accno;
    String name;
    double balance;

    //Ponieważ implementuje Serialization klasę, muszę stworzyć konstruktor bezparametrowy
    Account(){}
    //Tworzę również konstruktor z parametrami
    Account(String a, String n, double b){
        accno = a;
        name=n;
        balance = b;
    }
    //Tworzę metodę zwracająca wartości w obiekcie
    public String toString()
    {
        return "Account No:"+accno+"\nName:"+name+"\nBalance:"+balance;
    }
}
public class Main {
    public static void main(String[] args) throws Exception
    {
        //Jako że bedziemy pobierać wartości od użytkownika tworzę skanner
        Scanner sc = new Scanner(System.in);
        //Tworzę nullowy obiekt
        Account acc=null;
        //Oraz strukturę hashmapy
        HashMap<String,Account> hm=new HashMap<>();

        //jako że założono wczytywanie/zapis danych o kontach do pliku poniżej używam odpowiedniego bloku try/catch
        //Klasa rozrzeszona o throws Exceptions
        try
        {
        //wczytuje plik
            FileInputStream fis = new FileInputStream("Accounts.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
        //pierwsza rzeczą to zczytuje ile jest kont w pliku, aby ustalić counter dla pętli for
        int count=ois.readInt();
        //zczytuje wszystkie konta i umieszczam je w strukturze Hashmapy
        for(int i=0;i<count;i++)
        {
            //tworzę zmienną acc typuje ją na obiekt klasy Account
            acc=(Account)ois.readObject();
            System.out.println(acc);
            hm.put(acc.accno,acc);
        }
        //zamykam plik i stream
        fis.close();
        ois.close();


        }
        catch(Exception e)
        {

        }
        //tworze fileOutput stream który utworzy mi plik z kontami jeśli go nie ma
        FileOutputStream fos = new FileOutputStream("Accounts.txt");
        ObjectOutputStream oos= new ObjectOutputStream(fos);
        //Stworze i wyświetlam proste menu jako interfejs za pomocą Switcha.
        System.out.println("Menu");
        int choice;
        String accno,name;
        double balance;

        do
        {
            //wyświetlam menu dostępnych opcji programu
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. View Account");
            System.out.println("4. View All Account");
            System.out.println("5. Save Accounts to file");
            System.out.println("6. Exit");
            System.out.println("Enter your Choice");
            //zczytuje wybór uzytkownika
            choice=sc.nextInt();
            //ignorując wszelkie nowe linie character, slashe
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            switch(choice)
            {
                //Tworzenie konta poprzez zczytanie zmmiennych od usera. Następnie za pomocą put() umieszczenie
                //obiektu w Hashmapie
                case 1:
                    System.out.println("Enter Details Accno, Name, balance");
                    accno=sc.nextLine();
                    name=sc.nextLine();
                    balance=sc.nextDouble();
                    //tworze obiekt z podanych wartości
                    acc=new Account(accno,name,balance);
                    //umiesczam obiekt w hashmapie
                    hm.put(accno,acc);
                    System.out.println("Account Created for "+name);
                    break;
                //Usuwamy podane konto przez usera metodą hashmapy remove()
                case 2:
                    System.out.println("Enter Accno");
                    accno=sc.nextLine();
                    hm.remove(accno);
                    break;
               //Wyświetlamy info o koncie podanym przez usera metodą Hashmapy get()
                case 3:
                    System.out.println("Enter Accno");
                    accno=sc.nextLine();
                    acc=hm.get(accno);
                    System.out.println(acc);
                    break;
                //Wyświetlenie wszystkich userów pętlą foreach po wartościach Hashmapy .values()
                case 4:
                    for(Account a:hm.values())
                        System.out.println(a);
                    break;
                //Jako że i w przypadku 5 i 6 musi nastąpic zapisanie danych do pliku
                case 5:
                case 6:
                    //ustalam stream o wielkości sczytanej za pomoca metody HM size() i foreach
                    //wpisuje jako obiekty
                    oos.writeInt(hm.size());

                    for(Account a:hm.values())
                        oos.writeObject(a);
            }
        }while(choice!=6);
        //zamykamy stream i plik
        oos.flush();
        oos.close();
        fos.close();
    }
}