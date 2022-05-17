package Operators;

import digerpackage.Main;
import digerpackage.Operator;
import digerpackage.SideName;

public class King extends Operator {

    public King(SideName side) {
        super(side);
        if(side == SideName.White) picname = "chess_pieces_white_king.png";
        else picname = "chess_pieces_black_king.png";
    }

    /*
    public void moves(int i, int j){
        if(i+1<8 && j+1<8 && (table[i+1][j+1].operator==null || table[i+1][j+1].operator.side!=side))table[i][j].operator.legalmoves.add(table[i+1][j+1]);
        if(i+1<8 && j-1>=0 && (table[i+1][j-1].operator==null || table[i+1][j-1].operator.side!=side))table[i][j].operator.legalmoves.add(table[i+1][j-1]);
        if(i-1>=0 && j+1<8 && (table[i-1][j+1].operator==null || table[i-1][j+1].operator.side!=side))table[i][j].operator.legalmoves.add(table[i-1][j+1]);
        if(i-1>=0 && j-1>=0 && (table[i-1][j-1].operator==null || table[i-1][j-1].operator.side!=side))table[i][j].operator.legalmoves.add(table[i-1][j-1]);
        if(i+1<8 && (table[i+1][j].operator==null || table[i+1][j].operator.side!=side)) table[i][j].operator.legalmoves.add(table[i+1][j]);
        if(i-1>=0 && (table[i-1][j].operator==null || table[i-1][j].operator.side!=side)) table[i][j].operator.legalmoves.add(table[i-1][j]);
        if(j+1<8 && (table[i][j+1].operator==null || table[i][j+1].operator.side!=side)) table[i][j].operator.legalmoves.add(table[i][j+1]);
        if(j-1>=0 && (table[i][j-1].operator==null || table[i][j-1].operator.side!=side)) table[i][j].operator.legalmoves.add(table[i][j-1]);
    }

     */
    @Override
    public void moves(int i, int j) {
        if (i + 1 < 8 && j + 1 < 8) {
            if (table[i + 1][j + 1].operator == null) table[i][j].operator.legalmoves.add(table[i + 1][j + 1]);
            else if (table[i + 1][j + 1].operator.side != side) {
                if (helpCheckDanger(i + 1, j + 1)) table[i][j].operator.legalmoves.add(table[i + 1][j + 1]);
            }
        }
        if (i + 1 < 8 && j - 1 >= 0) {
            if (table[i + 1][j - 1].operator == null) table[i][j].operator.legalmoves.add(table[i + 1][j - 1]);
            else if (table[i + 1][j - 1].operator.side != side) {
                if (helpCheckDanger(i + 1, j - 1)) table[i][j].operator.legalmoves.add(table[i + 1][j - 1]);
            }
        }
        if (i - 1 >= 0 && j + 1 < 8) {
            if (table[i - 1][j + 1].operator == null) table[i][j].operator.legalmoves.add(table[i - 1][j + 1]);
            else if (table[i - 1][j + 1].operator.side != side) {
                if (helpCheckDanger(i - 1, j + 1)) table[i][j].operator.legalmoves.add(table[i - 1][j + 1]);
            }
        }
        if (i - 1 >= 0 && j - 1 >= 0) {
            if (table[i - 1][j - 1].operator == null) table[i][j].operator.legalmoves.add(table[i - 1][j - 1]);
            else if (table[i - 1][j - 1].operator.side != side) {
                if (helpCheckDanger(i - 1, j - 1)) table[i][j].operator.legalmoves.add(table[i - 1][j - 1]);
            }
        }
        if (i + 1 < 8) {
            if (table[i + 1][j].operator == null) table[i][j].operator.legalmoves.add(table[i + 1][j]);
            else if (table[i + 1][j].operator.side != side) {
                if (helpCheckDanger(i + 1, j)) table[i][j].operator.legalmoves.add(table[i + 1][j]);
            }
        }
        if (i - 1 >= 0) {
            if (table[i - 1][j].operator == null) table[i][j].operator.legalmoves.add(table[i - 1][j]);
            else if (table[i - 1][j].operator.side != side) {
                if (helpCheckDanger(i - 1, j)) {
                    table[i][j].operator.legalmoves.add(table[i - 1][j]);
                }
            }

        }
        if (j + 1 < 8) {
            if (table[i][j + 1].operator == null) table[i][j].operator.legalmoves.add(table[i][j + 1]);
            else if (table[i][j + 1].operator.side != side) {
                if (helpCheckDanger(i, j + 1)) table[i][j].operator.legalmoves.add(table[i][j + 1]);
            }
        }
        if (j - 1 >= 0) {
            if (table[i][j - 1].operator == null) table[i][j].operator.legalmoves.add(table[i][j - 1]);
            else if (table[i][j - 1].operator.side != side) {
                if (helpCheckDanger(i, j - 1)) table[i][j].operator.legalmoves.add(table[i][j - 1]);
            }
        }
    }


    private boolean helpCheckDanger(int i, int j) {
        SideName temp = table[i][j].operator.side;
        table[i][j].operator.side = side;
        Main.player1.findLegalMoves();
        boolean checker = true;
        table[i][j].operator.side = temp;
        table[i][j].operator.moves(i,j);
        inner:
        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (table[l][k].operator != null && table[l][k].operator.legalmoves.contains(table[i][j])) {
                    checker = false;
                    return checker;
                }
            }
        }
        return checker;
    }
}
