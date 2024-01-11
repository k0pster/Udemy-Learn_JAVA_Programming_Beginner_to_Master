import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//Różnice między AWT a Swingiem to głównie niezależność
//platformowa tzn wygląd okienek i działania intefrejsu
//na każdym systemie bedzie działał/wyglądał w ten sam sposób

//wszytko robi się w podobny sposób jak z AWT,
//ale do klas/metod należy dodawać J przed
// np. dziedziczymy tu z obiektu JFrame a nie Frame
//napiszmy proste okienko z couterem kliknięć
class FrameObject extends JFrame implements ActionListener
{
    //piszemy jak JWT tylko dodajemy J
    JLabel l;
    JButton btn;
    int count=0;

    //konstruktor klasy
    FrameObject()
    {
        super("Swing Demo");
        //Swing dalej wymaga komponentów z AWT jak np.FlowLayout()
        setLayout(new FlowLayout());
        //inicjalizacja parametrów do labelu i przycisku
        l=new JLabel("Clicked "+count+" times");
        btn = new JButton("Click");
        btn.setSize(2,2);
        //dodajemy elementy tak samo jak przy AWT
        add(l);
        add(btn);
        //dodajemy Actionlistenery, żeby zwiększać count po kliknęciu
        //i Swing znowu wykorzystuje go też z AWT
        //konieczne jest stworzenie metody w tym przypadku skorzystam
        //z implementacji ActionListenera i dodam go tutaj
        btn.addActionListener(this);
        //ustawiamy przycisk jako defaultowy gdyż na ten moment
        //getRootPane ustawia button z góry jako naciśnięty
        //przez co działa on nawet po naciśnieciu enter a nie spacja
        getRootPane().setDefaultButton(btn);
        //w Swing możemy również dodawać image na button
        //poprzez setIcon() i ImageIcon("url do grafiki")
        btn.setIcon(new ImageIcon("/Users/mikopec/Desktop/JAVA/Własne/Swing/red-button.png"));
        //oraz jaki tekst ma się pojawiac po najechaniu na label
        l.setToolTipText("Counter");

        //w Swingu dodatkowo pojawia się sformatowany textField
        // i oprócz zwykłego JTextField mamy też np.
        //przyjmujący tylko dany format tekstu np. daty, liczby, walut itp.
        ///określamy formaty jako SimpleDateFormat DDMMYYYY
        //i jako numberFormat
        NumberFormat nf=NumberFormat.getInstance();
        NumberFormatter nft=new NumberFormatter(nf);
        //dodatkowo włączamy podanie tylko liczb z klawiatury
        nft.setAllowsInvalid(false);
        //możemy określać przedział
        nft.setMaximum(1000);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        //i definiujemy go dla textFieldów
        JFormattedTextField tf1= new JFormattedTextField(nft);
        JFormattedTextField tf2 = new JFormattedTextField(df);
        //rozmiar nadajemy przez setColumns()
        tf1.setColumns(15);
        //określamy rozmiar i ustawiamy np. dzisiejszą datę
        tf2.setColumns(15);
        tf2.setValue(new Date());
        //dodaje oba txt fieldy
        add(tf1);
        add(tf2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //w logice zwiększe po prostu counter
        count++;
        //i dodaje zaktualizowany text do labela
        l.setText("Clicked "+count+" times");
    }
}
public class Main {
    public static void main(String[] args) {
        //Tworzenie obiektu FrameObject() i określenie rozmiaru
        //oraz włączenie visibility
        FrameObject fo = new FrameObject();
        fo.setSize(500,500);
        fo.setVisible(true);
        //aby zamykać aplikacje w SWING wystarczy dodać CloseOperation()
        fo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}