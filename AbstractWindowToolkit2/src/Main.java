import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

class FrameObject extends Frame implements ItemListener
{
    //Tworzymy nowy obiekt/klase okienka dziedziczący po Frame
    //oraz implementujący ItemListener pozwalający nasłuchiwać
    //co dzieje się w naszym programie.
    //tworzenie zmiennych label,checkbox.
    Label l;
    Checkbox c1,c2,c3;
    CheckboxGroup cbg;

    public FrameObject()
    {
        super("Rock Papper and Scissors");

        //tworzę label do wyświetlania i checkboxy radio(tylko
        // jeden możliwy wybór) i zani je dodam do frame-a
        l = new Label("Papier, kamień czy nożyce?");
        c1 = new Checkbox("Papier",false,cbg);
        c2 = new Checkbox("Kamień",false,cbg);
        c3 = new Checkbox("Nożyce",false,cbg);
        //muszę uaktywnić nasłuchiwanie wciśniecia
        c1.addItemListener(this);
        c2.addItemListener(this);
        c3.addItemListener(this);
        //nakładam FlowLayout()
        setLayout(new FlowLayout());
        //dodaje elementy do okienka
        add(l);
        add(c1);
        add(c2);
        add(c3);

    }
    //Tutaj piszemy logikę programu papier kamień nożyce.
    @Override
    public void itemStateChanged(ItemEvent e) {
        //wykorzystam pusty string z dopasowaniem do wyboru losowego
        //komputera z 3 dostępnych opcji.
        String str="Papier, kamień czy nożyce?";
        //Tworzę wybór kompa
        Random rand = new Random();
        int cpuchoice = rand.nextInt(3);
        //Tworzę listę ze stringami
        ArrayList<String> choice = new ArrayList<String>();
        choice.add("Papier");
        choice.add("Kamień");
        choice.add("Nożyce");
        //przypisuje komputerowi wybór
        String cpustr=choice.get(cpuchoice);
        //logika gry
        if(c1.getState())
        {
            if(cpustr=="Papier"){
                str="CPU ma "+cpustr+".\nWynik: "+"Remis";
            }
            if(cpustr=="Kamień"){
                str="CPU ma "+cpustr+".\nWynik: "+"Wygrałeś";
            }
            if(cpustr=="Nożyce"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Przegrałeś";
            }
        }

        if(c2.getState())
        {
            if(cpustr=="Papier"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Przegrałeś";
            }
            if(cpustr=="Kamień"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Remis";
            }
            if(cpustr=="Nożyce"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Wygrałeś";
            }
        }

        if(c3.getState())
        {
            if(cpustr=="Papier"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Wygrałeś";
            }
            if(cpustr=="Kamień"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Przegrałeś";
            }
            if(cpustr=="Nożyce"){
                str="CPU ma "+cpustr+".\nWynik: :"+"Remis";
            }
        }
        //wyświetlam w labelu wartość stringa
        l.setText(str);
    }
}
public class Main {
    public static void main(String[] args) {
        //Tworzenie obiektu Frame()
        FrameObject fo = new FrameObject();
        fo.setSize(400,400);
        fo.setVisible(true);
    }
}