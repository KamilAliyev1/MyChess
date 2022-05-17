package Operators;

import digerpackage.Operator;
import digerpackage.SideName;

import javax.swing.*;

public class Pawn extends Operator {

    public Pawn(SideName side) {
        super(side);
        if(side==SideName.White) picname = "chess_pieces_white_pawn.png";
        else picname = "chess_pieces_black_pawn.png";
    }

    @Override
    public void moves(int i, int j) {
        if (side == SideName.White) {
            if (i + 1 < 8 && table[i + 1][j].operator == null) table[i][j].operator.legalmoves.add(table[i + 1][j]);
            if (table[i][j].y == 2 && table[i + 1][j].operator == null && table[i + 2][j].operator == null)
                table[i][j].operator.legalmoves.add(table[i + 2][j]);
            if (i + 1 < 8 && j + 1 < 8 && table[i + 1][j + 1].operator != null && table[i + 1][j + 1].operator.side == SideName.Black)
                table[i][j].operator.legalmoves.add(table[i + 1][j + 1]);
            if (i + 1 < 8 && j - 1 >= 0 && table[i + 1][j - 1].operator != null && table[i + 1][j - 1].operator.side == SideName.Black)
                table[i][j].operator.legalmoves.add(table[i + 1][j - 1]);
        } else if (side == SideName.Black) {
            if (i - 1 >= 0 && table[i - 1][j].operator == null) table[i][j].operator.legalmoves.add(table[i - 1][j]);
            if (table[i][j].y == 7 && table[i - 1][j].operator == null && table[i - 2][j].operator == null)
                table[i][j].operator.legalmoves.add(table[i - 2][j]);
            if (i - 1 >= 0 && j + 1 < 8 && table[i - 1][j + 1].operator != null && table[i - 1][j + 1].operator.side == SideName.White)
                table[i][j].operator.legalmoves.add(table[i - 1][j + 1]);
            if (i - 1 >= 0 && j - 1 >= 0 && table[i - 1][j - 1].operator != null && table[i - 1][j - 1].operator.side == SideName.White)
                table[i][j].operator.legalmoves.add(table[i - 1][j - 1]);
        }
    }
    @Override
    public Operator pawnPromotion(SideName sideName){
        String[] opnames = {"Queen","Bishop","Rook","Knight"};

        String s = (String) JOptionPane.showInputDialog(null, "Choose",
                "ChangePawn", JOptionPane.QUESTION_MESSAGE, null, opnames, opnames[0]);
        if(s=="Queen"){
            return new Queen(sideName);
        }
        else if(s=="Bishop"){
            return new Bishop(sideName);
        }
        else if(s=="Rook"){
            return new Rook(sideName);
        }
        else if(s=="Knight"){
            return new Knight(sideName);
        }
        return new Pawn(sideName);
    }

}
