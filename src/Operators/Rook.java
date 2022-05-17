package Operators;

import digerpackage.Operator;
import digerpackage.SideName;

public class Rook extends Operator {
    public Rook(SideName side) {
        super(side);

        if(side == SideName.White) picname = "chess_pieces_white_rook.png";
        else picname = "chess_pieces_black_rook.png";
    }

    @Override
    public void moves(int i, int j) {
        for (int k = 1; k < 8; k++) {
            if (j + k < 8) {
                if (table[i][j + k].operator == null) table[i][j].operator.legalmoves.add(table[i][j + k]);
                else if (table[i][j + k].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i][j + k]);
                    break;
                } else break;
            }
            // else break;
        }
        for (int k = 1; k < 8; k++) {
            if (j - k >= 0) {
                if (table[i][j - k].operator == null) table[i][j].operator.legalmoves.add(table[i][j - k]);
                else if (table[i][j - k].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i][j - k]);
                    break;
                } else break;
            }
            // else break;
        }
        for (int k = 1; k < 8; k++) {
            if (i + k < 8) {
                if (table[i + k][j].operator == null) table[i][j].operator.legalmoves.add(table[i + k][j]);
                else if (table[i + k][j].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i + k][j]);
                    break;
                } else break;
            }
            //else break;
        }
        for (int k = 1; k < 8; k++) {
            if (i - k >= 0) {
                if (table[i - k][j].operator == null) table[i][j].operator.legalmoves.add(table[i - k][j]);
                else if (table[i - k][j].operator.side != side) {
                    table[i][j].operator.legalmoves.add(table[i - k][j]);
                    break;
                } else break;
            } else break;
        }

    }
}
