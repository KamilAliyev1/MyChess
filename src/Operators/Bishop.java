package Operators;

import digerpackage.Operator;
import digerpackage.SideName;
import digerpackage.Square;

public class Bishop extends Operator {
    public Bishop(SideName side) {
        super(side);
        if(side==SideName.White) picname = "chess_pieces_white_bishop.png";
        else  picname = "chess_pieces_black_bishop.png";
    }
    @Override
    public void moves(int i, int j) {
        for (int k = 1; k < 8; k++) {
            if (i + k < 8 && j + k < 8) {
                if (table[i + k][j + k].operator == null) table[i][j].operator.legalmoves.add(table[i + k][j + k]);
                else if (table[i + k][j + k].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i + k][j + k]);
                    break;
                } else break;
            } else break;
        }
        for (int k = 1; k < 8; k++) {
            if (i - k >= 0 && j - k >= 0) {
                if (table[i - k][j - k].operator == null) table[i][j].operator.legalmoves.add(table[i - k][j - k]);
                else if (table[i - k][j - k].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i - k][j - k]);
                    break;
                } else break;
            } else break;
        }
        for (int k = 1; k < 8; k++) {
            if (i + k < 8 && j - k >= 0) {
                if (table[i + k][j - k].operator == null) table[i][j].operator.legalmoves.add(table[i + k][j - k]);
                else if (table[i + k][j - k].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i + k][j - k]);
                    break;
                } else break;
            } else break;
        }
        for (int k = 1; k < 8; k++) {
            if (i - k >= 0 && j + k < 8) {
                if (table[i - k][j + k].operator == null) table[i][j].operator.legalmoves.add(table[i - k][j + k]);
                else if (table[i - k][j + k].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i - k][j + k]);
                    break;
                } else break;
            } else break;
        }
    }
}
