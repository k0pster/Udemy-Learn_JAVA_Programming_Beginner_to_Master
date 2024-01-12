import org.w3c.dom.Text;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.StringTokenizer;

//Program prezentujący możliwości JTree
class FrameObject extends JFrame implements TreeSelectionListener
{
    //
    JTree tree;
    JLabel label;
    //konstruktor klasy
    FrameObject()
    {
        super("Tree Demo");
        //podajemy dostęp do ścieżki jako obiekt dla DefaultMutableTreeNode()
        DefaultMutableTreeNode root=new DefaultMutableTreeNode("C:/Users/mikopec/Desktop/JAVA/Własne");
        File f= new File("C:/Users/mikopec/Desktop/JAVA/Własne");
        //jako logikę listujemy pętlą for każdy element listy path
        //sprawdzając czy to plik czy folder
        for(File x:f.listFiles())
        {
            if(x.isDirectory())
            {
                DefaultMutableTreeNode fold=new DefaultMutableTreeNode(x.getName());
                for(File y:x.listFiles())
                {
                    fold.add(new DefaultMutableTreeNode(y.getName()));
                }
                root.add(fold);
            }
            else
            {
                root.add(new DefaultMutableTreeNode(x.getName()));
            }
        }
        //inicjalizujemy JTree i JLabel
        tree=new JTree(root);
        label=new JLabel("No Files Selected");
        //dodajemy listnera na plik jaki został wybrany
        tree.addTreeSelectionListener(this);
        //dodajemy scrollbar, żeby widać było cały path w oknie
        JScrollPane sp=new JScrollPane(tree);
        //Dodajemy scrollPane i label jako borderLayout
        add(sp,BorderLayout.CENTER);
        add(label,BorderLayout.SOUTH);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        label.setText(e.getPath().toString());
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