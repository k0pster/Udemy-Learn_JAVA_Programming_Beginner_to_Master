import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class FrameObject extends Frame implements AdjustmentListener
{
    //Wybór koloru za pomocą 3ch scrollbarów
    Scrollbar red,green,blue;
    TextField tf;

    //konstruktor klasy
    FrameObject()
    {
        super("Scrollbar Color Pool");
        //stworzenie 3 pasków przewijania poziomych, ale można też
        //pionowych wtedy VERTICAL
        //zakres kolorów to 0-255 musimy jednak wziać poprwakę na wartość visible,
        //gdyż maksymalna wartość =maximum - visible.
        //jeśli więc dajemy 20 to żeby uzyskać maksymalną wartość 255
        //ustawiamy 275
        red=new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,275);
        green=new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,275);
        blue=new Scrollbar(Scrollbar.HORIZONTAL,0,20,0,275);

        //parametryzujemy okienka wyświetlania koloru
        tf=new TextField(20);
        tf.setBounds(50,50,300,50);
        //oraz pasków przewijania
        red.setBounds(50,150,300,30);
        green.setBounds(50,200,300,30);
        blue.setBounds(50,250,300,30);
        //dodanie elementów
        setLayout(null);
        add(tf);
        add(red);
        add(green);
        add(blue);
        //dodanie nasłuchiwania
        red.addAdjustmentListener(this);
        green.addAdjustmentListener(this);
        //można również za pomocą Lambda expression wtedy można nie pisać klasy
        //adjustmentValueChanged() bo przekazujemy Event utworzony w danej chwili.
        //Nie jest konieczne wtedy również implementacja implements AdjustmentListener
        //do głównego obiektu klasy FrameObject
        blue.addAdjustmentListener((AdjustmentEvent ae)->{tf.setBackground(new Color(red.getValue(),green.getValue(),blue.getValue()));});
        //wywołujemy nową klasę do zamykania okienka
        addWindowListener(new MyWindowAdapter());
    }
    //Ustawienie nasłuchiwania
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        //ustawienie tła w kolorze setBackground() zdefiniowanym przez
        //wartości rgb trzech suwaków pobierając ich wartości.
        tf.setBackground(new Color(red.getValue(),green.getValue(),blue.getValue()));
        //dodatkowo wstawiam tekst z gotową wartością RGB po wybraniu odpowiedniego
        //koloru gotowy do skopiowania
        tf.setText("RGB: "+red.getValue()+";"+green.getValue()+";"+blue.getValue());
    }
    //możemy auaktywnić wyłączanie aplikacji krzyżykiem
    //uzywając WindowsEventsów, wtedy jednak musimy określić
    //instrukcje dla wszystkich 7 stanów okna: Activated,Closed,Closing
    //Deactivated,Deinconified(minimized),Inonified(maximized),Opened
    //Aby wybrać tylko jedną możemy skorzystać z rozszerzenia o klasę
    //Window Adapter wtedy wybrać tylko jedno zachowanie np. do zamykania
    //Jako że klasa MyFrame ma już extends Frame, musimy zrobić drugą klasę
    class MyWindowAdapter extends WindowAdapter
    {
        //za zamknięcie odpowiada krzyżyk, czyli metoda windowClosing()
        public void windowClosing(WindowEvent we)
        {
            //używamy aby zamknąć z arg 0 bo nie wysyłamy do systemu błędu
            System.exit(0);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        //Tworzenie obiektu Frame() i określenie rozmiaru
        FrameObject fo = new FrameObject();
        fo.setSize(500,500);
        fo.setVisible(true);
    }
}