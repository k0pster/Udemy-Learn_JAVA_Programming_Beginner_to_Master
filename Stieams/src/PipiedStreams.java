import java.io.*;

public class PipiedStreams {
    //Model producent=?konsument ceem jest zasymulowanie pracy porducent produkuje
    //a konsument konsumuje na przemiennie jak w multithreadingu

    //Tworzymy klasę producent która czerpie z klasy Thread
    static class Producer extends Thread
    {
     //Tworzymy zmienna Outputstream
      OutputStream os;
      //Określamy dotęp do klasy
      public Producer(OutputStream o)
      {
          os=o;
      }
      //Metoda pozwalająca na pracę wielowątkową, w której stworzymy prowizoryczną zmienną count
        //mająca na celu zasymulowanie produkowania cześci.
        // następnie nieskończona petlą bedziemy iterować i umieszczać po kolei kolejne czesci w pipie
      public void run()
      {
          int count=1;

          while(true)
          {
                try
                {
                    os.write(count);
                    //metoda wymuszająca oproznienie bufferu z danych i przeslanie do pipa
                    os.flush();
                    //wyświetlamy działanie
                    System.out.println("Producer "+count);
                    //Usypiamy na 10ms watek gdzyz inaczej producent i konsumer nie byliby zsynchronizowani
                    //produecnt np produkowalbym szybciej niz konsument konsumowal
                    Thread.sleep(10);
                    count++;
                }
                catch(Exception e){}
          }
      }
    }

    //Tworzymy klasę konsument która bedzie konsumowac wyprodukowane czesci producenta
    static class Consumer extends Thread
    {
        //Tworzymy zmienna InputStream
        InputStream is;
        //Określamy dotęp do klasy
        public Consumer(InputStream s)
        {
            is=s;
        }
        //Metoda pozwalająca na pracę wielowątkową, w której stworzymy prowizoryczną zmienną count
        //mająca na celu zasymulowanie produkowania cześci.
        // następnie nieskończona petlą bedziemy iterować i umieszczać po kolei kolejne czesci w pipie
        public void run()
        {
            int x;

            while(true)
            {
                try
                {
                    //odczytujemy dane z pipu i umieszczemy je we wczesniej przygotowanej zmiennej x i wyswietlamy.
                    x=is.read();
                    System.out.println("Consumer "+x);
                    System.out.flush();
                    //Konsument tez ma uspiony watek po flushu.
                    Thread.sleep(10);
                }
                catch(Exception e){}
            }
        }
    }
    public static void main(String[] args) throws Exception {
        //tworzymy wejście pipe-u i wyjście
        PipedInputStream pis= new PipedInputStream();
        PipedOutputStream pos=new PipedOutputStream();

        //tworzymy połaćzenie wejscia i wyjscia streamów pipów
        pis.connect(pos);

        //Tworzymy klasy producenta i Consumera
        Producer p=new Producer(pos);
        Consumer c=new Consumer(pis);

        //teraz producent i konsument musza zaczac prace
        p.start();
        c.start();
    }
}