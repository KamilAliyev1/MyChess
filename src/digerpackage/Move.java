package digerpackage;

import java.util.ArrayList;

public class Move {
    private Square Firstadr;
    private Square Secondadr;


    public void setFirstadr(Square firstadr) {
        if (firstadr.operator != null) {
            Firstadr = firstadr;
        }
    }

    public void setSecondadr(Square secondadr) {
        if (Firstadr != null && Firstadr.operator != null && Firstadr.operator.legalmoves.contains(secondadr) && Main.turnControl.controlTurn(Firstadr)) {
            Secondadr = secondadr;
        }
    }

    public boolean move() {
        if (Firstadr != null && Secondadr != null && Main.turnControl.checkTurnForSquare(Firstadr)) {
            Secondadr.operator = Firstadr.operator;
            Firstadr.operator = null;
            Main.turnControl.controlCheckCase();
            Main.player1.findLegalMoves();
            Firstadr = null;
            Secondadr = null;
            Main.turnControl.changeTurn();

            Main.player1.incheckmate = Main.player1.check.checkMate(Main.player1.side);
            Main.player2.incheckmate = Main.player2.check.checkMate(Main.player2.side);


            return true;
        }
        return false;
    }

    public ArrayList<Square> callLegalmoves() {
        return Firstadr.operator.legalmoves;
    }
}
