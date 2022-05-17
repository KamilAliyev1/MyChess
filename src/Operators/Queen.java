package Operators;

import digerpackage.Operator;
import digerpackage.SideName;

public class Queen extends Operator {
    Bishop bishop = new Bishop(side);
    Rook castle = new Rook(side);

    public Queen(SideName side) {
        super(side);
        if(side==SideName.White) picname = "chess_pieces_white_queen.png";
        else picname = "chess_pieces_black_queen.png";
    }

    @Override
    public void moves(int i, int j) {
        bishop.moves(i, j);
        castle.moves(i, j);
    }
}
