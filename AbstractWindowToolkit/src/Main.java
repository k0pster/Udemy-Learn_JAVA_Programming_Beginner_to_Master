import org.w3c.dom.Text;

import java.awt.*;

class FrameObject extends Frame
{
    //To samo co poniżej, ale zaleca się pisać jako nową klasę
    //dziedzicząca po Frame, tworze konieczne zmienne obiektów
    Label l;
    TextField txt;
    Button btn;

    public FrameObject()
    {
        super("My App");
        setLayout(new FlowLayout());
        //tworzę obiekty i dodaje je
        l = new Label("Name");
        txt = new TextField(20);
        btn = new Button("OK");

        add(l);
        add(txt);
        add(btn);
    }
}
public class Main {
    public static void main(String[] args) {
        //Tworzenie obiektu Frame()
        Frame frame = new Frame("First App");
        frame.setLayout(new FlowLayout());
        //Określenie rozmiaru okienka setSize()
        frame.setSize(900,600);
        //Aby okienko było widoczne niezbędne jest włączenie widoczności
        //za pomocą metody setVisible()
        frame.setVisible(true);
        //Aby utworzyć przycisk używamy obiektu Button
        Button button = new Button("ok");
        //dodanie przycisku do okna
        frame.add(button);
        //dodanie labelu
        Label label = new Label("Name ");
        frame.add(label);
        //dodanie pola tekstowego
        TextField tf = new TextField(20);
        frame.add(tf);

        //Stworznie okienka z klasy
        FrameObject fo = new FrameObject();
        fo.setSize(400,400);
        fo.setVisible(true);
    }
}