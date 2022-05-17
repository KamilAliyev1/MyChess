package digerpackage;

import java.util.ArrayList;

import Operators.*;
import rdk.Main2;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static Square table[][] = new Square[8][8];

    public static Opponents player1 = new Opponents("White", true, SideName.White);

    public static Opponents player2 = new Opponents("Black", false, SideName.Black);

    public static Move move = new Move();

    public static TurnControl turnControl = new TurnControl();

    static void addOperatorToTable(Opponents player) {
        int y1 = 8, y2 = 7, z = -1;
        if (player.side == SideName.White) {
            y1 = 1;
            y2 = 2;
            z = -1;
        }
        table[y1 + z][ColumnName.A.ordinal()] = new Square(player.operators.get(0), ColumnName.A, y1);
        table[y1 + z][ColumnName.H.ordinal()] = new Square(player.operators.get(1), ColumnName.H, y1);
        table[y1 + z][ColumnName.B.ordinal()] = new Square(player.operators.get(2), ColumnName.B, y1);
        table[y1 + z][ColumnName.G.ordinal()] = new Square(player.operators.get(3), ColumnName.G, y1);
        table[y1 + z][ColumnName.E.ordinal()] = new Square(player.operators.get(4), ColumnName.E, y1);
        table[y1 + z][ColumnName.D.ordinal()] = new Square(player.operators.get(5), ColumnName.D, y1);
        table[y1 + z][ColumnName.C.ordinal()] = new Square(player.operators.get(6), ColumnName.C, y1);
        table[y1 + z][ColumnName.F.ordinal()] = new Square(player.operators.get(7), ColumnName.F, y1);

        for (int i = 8; i < 16; i++) {
            table[y2 + z][i - 8] = new Square(player.operators.get(i), ColumnName.values()[i - 8], y2);
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = new Square(null, ColumnName.values()[j], i + 1);
            }
        }

        addOperatorToTable(player1);

        addOperatorToTable(player2);

        player1.findLegalMoves();

        player2.findLegalMoves();

        Main2 Gui = new Main2();


    }

}
