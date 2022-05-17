package rdk;

import digerpackage.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Mybutton extends JButton{
    Move move=null;
    Square square=null;
    Mybutton(Color color,Square square,Move move){
        this.setBackground(color);
        this.setFocusable(false);
        this.move = move;
        //this.setContentAreaFilled(false);
        //this.setEnabled(false);

        this.square = square;
        if(square.operator!=null) this.addOperatorpic(square.operator.picname);
    }
    void chooseFirst(){
        if(square.operator!=null) {
            move.setFirstadr(square);
            Main2.openLegalmovesButtons(move);
        }
    }
    void chooseSecond(){
        move.setSecondadr(square);
        if(move.move())
            Main2.openPlayerButtons(Main.turnControl.getLegalSide());
        if(Main.player1.incheck) JOptionPane.showMessageDialog(null,Main.player1.name+" in CHECK","Chess",JOptionPane.INFORMATION_MESSAGE);
        if(Main.player2.incheck) JOptionPane.showMessageDialog(null,Main.player2.name+" in CHECK","Chess",JOptionPane.INFORMATION_MESSAGE);

        if(Main.player1.incheckmate) {JOptionPane.showMessageDialog(null,Main.player1.name+" in CHECKMATE","Chess",JOptionPane.INFORMATION_MESSAGE);System.exit(0);}
        if(Main.player2.incheckmate) {JOptionPane.showMessageDialog(null,Main.player2.name+" in CHECKMATE","Chess",JOptionPane.INFORMATION_MESSAGE);System.exit(0);}
    }
    void removeActions(){
        for( ActionListener al : this.getActionListeners() ) {
            this.removeActionListener( al );
        }
    }
    public void addOperatorpic(String operator){
        try {
            if(operator==null) this.setIcon(null);
            else{
                Image img = ImageIO.read(getClass().getResource(operator));
                this.setIcon(new ImageIcon(img));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }



}
