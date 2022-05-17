package digerpackage;


public class TurnControl {

    Opponents player1 = Main.player1;
    Opponents player2 = Main.player2;

    public void changeTurn() {
        player1.turn = !player1.turn;
        player2.turn = !player2.turn;
    }

    public boolean controlTurn(Square square) {
        if (square.operator != null && square.operator.side == player1.side)
            return player1.turn;
        else if (square.operator != null && square.operator.side == player2.side)
            return player2.turn;
        return false;
    }

    public void controlCheckCase() {
        player1.incheck = player1.check.checkSuperKing(player1.side);
        player2.incheck = player2.check.checkSuperKing(player2.side);
    }

    public SideName getLegalSide() {
        if (player1.turn == true)
            return player1.side;
        return player2.side;
    }

    public boolean checkTurnForSquare(Square square) {
        if (square.operator.side == player1.side && player1.turn == true)
            return true;
        else if (square.operator.side == player2.side && player2.turn == true)
            return true;
        return false;
    }

}
