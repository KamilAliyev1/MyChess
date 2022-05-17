package digerpackage;

import Operators.*;

import java.util.ArrayList;


public class Opponents {
    ArrayList<Operator> operators = new ArrayList<>();
    public String name;
    boolean turn;
    SideName side;
    public boolean incheck;
    public boolean incheckmate;
    public Check check;

    public Opponents(String name, boolean turn, SideName side) {
        this.name = name;
        this.turn = turn;
        this.side = side;
        check = new Check();
        setOperators();
    }

    public void setOperators() {
        operators.add(new Rook(side));
        operators.add(new Rook(side));
        operators.add(new Knight(side));
        operators.add(new Knight(side));
        operators.add(new King(side));
        operators.add(new Queen(side));
        operators.add(new Bishop(side));
        operators.add(new Bishop(side));
        for (int i = 0; i < 8; i++) {
            operators.add(new Pawn(side));
        }
    }

    public void findLegalMoves() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Operator operator = Main.table[i][j].operator;
                if(i==0 && operator instanceof Pawn){

                    Main.table[i][j].operator = operator.pawnPromotion(SideName.Black);
                    Main.turnControl.controlCheckCase();
                }
                if (i == 7 && operator instanceof Pawn ) {
                    Main.table[i][j].operator = operator.pawnPromotion(SideName.White);
                    Main.turnControl.controlCheckCase();
                }
                if (operator != null) {
                    operator.legalmoves.clear();
                    operator.moves(i, j);
                }
            }
        }
        checkCase(Main.player1);
        checkCase(Main.player2);
    }

    void checkCase(Opponents player) {
        if (player.incheck == true) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Main.table[i][j].operator instanceof King && player.side == Main.table[i][j].operator.side) {
                        helpFindWayForKing(i, j, Main.table[i][j].operator.side);
                    } else if (Main.table[i][j].operator != null && player.side == Main.table[i][j].operator.side) {
                        int t = Main.table[i][j].operator.legalmoves.size();
                        for (int k = 0; k < t; k++) {
                            boolean checker = false;
                            if (player.check.Bishop_Threat.contains(Main.table[i][j].operator.legalmoves.get(k)))
                                checker = true;
                            for (ArrayList<Square> l : player.check.Bishop_Threat) {
                                if (l.contains(Main.table[i][j].operator.legalmoves.get(k))) {
                                    checker = true;
                                    break;
                                }
                            }
                            for (ArrayList<Square> l : player.check.Rook_Threat) {
                                if (l.contains(Main.table[i][j].operator.legalmoves.get(k))) {
                                    checker = true;
                                    break;
                                }
                            }
                            if (checker == false) {
                                Main.table[i][j].operator.legalmoves.remove(k);
                                t--;
                                k--;
                            }
                        }
                    }
                }
            }
        }
    }

    void helpFindWayForKing(int r, int c, SideName side) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Main.table[i][j].operator != null && !(Main.table[i][j].operator instanceof King) && side != Main.table[i][j].operator.side) {
                    int size = Main.table[r][c].operator.legalmoves.size();
                    for (int k = 0; k < size; k++) {
                        if (Main.table[i][j].operator.legalmoves.contains(Main.table[r][c].operator.legalmoves.get(k))) {
                            Main.table[r][c].operator.legalmoves.remove(k);
                            size--;
                            k--;
                        }
                    }
                }
            }
        }
    }

}




