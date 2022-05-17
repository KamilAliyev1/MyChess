package rdk;

import digerpackage.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main2 {

    static Mybutton[] mybuttons = new Mybutton[64];


    public static void openPlayerButtons(SideName sideName) {
        for (int i = 0; i < 64; i++) {
            Mybutton b = mybuttons[i];
            if (b.square != null && b.square.operator != null && b.square.operator.side == sideName) {
                b.addActionListener(e -> b.chooseFirst());
            } else deleteActions(b);
            if (b.square != null) {
                if (b.square.operator == null) b.addOperatorpic(null);
                else b.addOperatorpic(b.square.operator.picname);
            }
        }
    }

    static void openLegalmovesButtons(Move move) {
        ArrayList<Square> H = move.callLegalmoves();
        for (Square i : H) {
            Mybutton bt = mybuttons[(i.y - 1) * 8 + i.x.ordinal()];
            bt.addActionListener(e -> bt.chooseSecond());
        }
    }

    static void deleteActions(Mybutton bt) {
        for (ActionListener al : bt.getActionListeners()) {
            bt.removeActionListener(al);
        }
    }

    public Main2() {

        MyFrame myFrame = new MyFrame();

        int temp = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Mybutton mybutton = new Mybutton(j % 2 == temp ? new Color(140, 100, 6) : Color.lightGray, Main.table[i][j], Main.move);
                mybuttons[i * 8 + j] = mybutton;
                myFrame.add(mybutton);
            }
            if (temp == 1) temp = 0;
            else temp = 1;
        }

        openPlayerButtons(SideName.White);

        myFrame.setVisible(true);
        Main.player1.name=JOptionPane.showInputDialog("White player name");
        Main.player2.name=JOptionPane.showInputDialog("Black player name");

    }
}