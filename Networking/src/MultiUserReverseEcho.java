import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

//Modyfikacja servera, żeby mógł przyjmować wiele msg wielu klientów
//poprzez wyykorzystanie i stworzenie dla każdego socketu Threda-czyli
//osobnego watku

//Klasa aplikacji Server
public class MultiUserReverseEcho extends Thread{
    //Tworzę Socket
    Socket stk;
    //tworzymy konstruktor który przypisuje socket do stk
    public MultiUserReverseEcho(Socket st)
    {
        stk=st;
    }
    //Korzystając z rozszerzenia Thread muszę nadpisać metodę run()
    public void run() {
        //musimy użyć try/catch
        try {
            //wykorzystuje napisany server z poprzedniej wersji

            //dla steorzonego socketu połączenia potrzebujemy
            //utworzyć input jak i output stream
            //pobieramy do socketu inputstream metodą getInputStream()
            //przekazujemy do InputStreamReadera a następnie łączymy z BufferReaderem
            BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
            //deklaruje obiekt printStream wczytuje getOutpudStream() socketu
            PrintStream ps = new PrintStream(stk.getOutputStream());
            //Tworze string z msg klienta i stringbuiilder do odwrócenia Stringa
            String msg;
            StringBuilder sb;
            do {
                //czytanie klienta
                msg = br.readLine();
                //odwrócenie warotści String za pomoca stringBuildera
                sb = new StringBuilder(msg);
                sb.reverse();
                //konwersja do stringa
                msg = sb.toString();
                //print wartości
                ps.println(msg);
            } while (!msg.equals("dne"));
            stk.close();
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) throws Exception
    {
    int count = 1;
    System.out.println("Server running...");
    ServerSocket ss = new ServerSocket(2000);
    //metoda akceptująca połączenie accept()
    Socket stk;
    //poprzez niekonczaca się petla akceptujemy tyle socketow ile powstanie
    MultiUserReverseEcho mre;
    do
    {
        stk = ss.accept();
        //po otwaricu socketu wyświetlam informacje ile połączonych klientów
        System.out.println("Client Connected : "+count++);
        mre = new MultiUserReverseEcho(stk);
        mre.start();
    }while(true);
    }




}
//Klasa aplikacji po stronie klienta taka sama jak w poprzednim programie
class Clients {
    public static void main(String[] args) throws Exception
    {
        //Tworzę socket na potrzeby komunikacji podajac port i ip(localhost jako maszyna ta(or ip from cmd ipconfig/ethernetIPv4).
        Socket stk = new Socket("localhost",2000); ////10.44.243.114

        //zczytanie klawiatury do buffered readera
        BufferedReader keyb=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br=new BufferedReader(new InputStreamReader(stk.getInputStream()));
        //deklaruje obiekt printStream wczytuje getOutpudStream() socketu
        PrintStream ps=new PrintStream(stk.getOutputStream());
        //Tworze string z msg klienta i stringbuiilder do odwrócenia Stringa
        String msg;
        do
        {
            //wysłanie msg do servera
            msg=keyb.readLine();
            //print wartości którą wysyłamy na server
            ps.println(msg);
            //zczytujemy odwróconą odpowiedź serwera
            msg=br.readLine();
            //print msg
            System.out.println("Response From Server : "+msg);
        }while(!msg.equals("dne"));
        //zamykamy socket zawsze po skończeniu operacji na nim!
        stk.close();
    }
}

//Teraz można przetestować aplikację budując projekt wchodząc do folderu z klasami
//...Networking\out\production\Networking następnie odpalamy w osobnych
//cmd-ach klienta(Clients i w tym wypadku może być ich ile chcemy) oraz server(MultiUserReverseEcho) [java Client i Java MulitUserReverseEcho]
//Teraz możemy testować poprzed cmd line klientó wysyłać wiadomości
//i będziemy odbierać odwróconą od serwera do momentu aż nie napiszemy end
//który zamyka połącznie i widzieć kolejność podłączonych userów