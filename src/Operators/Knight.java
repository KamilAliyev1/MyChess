package Operators;

import digerpackage.Main;
import digerpackage.Operator;
import digerpackage.SideName;
import digerpackage.Square;

public class Knight extends Operator {

    public Knight(SideName side) {
        super(side);
        if(side == SideName.White) picname = "chess_pieces_white_knight.png";
        else picname = "chess_pieces_black_knight.png";
    }

    @Override
    public void moves(int i, int j) {
        Square[][] table = Main.table;
        if (i + 1 < 8 && j + 2 < 8 && (table[i + 1][j + 2].operator == null || table[i + 1][j + 2].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i + 1][j + 2]);
        if (i + 1 < 8 && j - 2 >= 0 && (table[i + 1][j - 2].operator == null || table[i + 1][j - 2].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i + 1][j - 2]);
        if (i + 2 < 8 && j + 1 < 8 && (table[i + 2][j + 1].operator == null || table[i + 2][j + 1].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i + 2][j + 1]);
        if (i + 2 < 8 && j - 1 >= 0 && (table[i + 2][j - 1].operator == null || table[i + 2][j - 1].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i + 2][j - 1]);

        if (i - 1 >= 0 && j + 2 < 8 && (table[i - 1][j + 2].operator == null || table[i - 1][j + 2].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i - 1][j + 2]);
        if (i - 1 >= 0 && j - 2 >= 0 && (table[i - 1][j - 2].operator == null || table[i - 1][j - 2].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i - 1][j - 2]);
        if (i - 2 >= 0 && j + 1 < 8 && (table[i - 2][j + 1].operator == null || table[i - 2][j + 1].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i - 2][j + 1]);
        if (i - 2 >= 0 && j - 1 >= 0 && (table[i - 2][j - 1].operator == null || table[i - 2][j - 1].operator.side != side))
            table[i][j].operator.legalmoves.add(table[i - 2][j - 1]);
    }
}
