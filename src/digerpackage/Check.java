package digerpackage;

import Operators.*;

import java.util.ArrayList;

public class Check {
    Square[][] table;
    ArrayList<Square> Knight_Pawn_Threat;
    ArrayList<ArrayList<Square>> Bishop_Threat;
    ArrayList<ArrayList<Square>> Rook_Threat;


    public Check() {
        Knight_Pawn_Threat = new ArrayList<>();
        Bishop_Threat = new ArrayList<>();
        Rook_Threat = new ArrayList<>();
        this.table = Main.table;
    }

    public boolean checkSuperKing(SideName side) {
        Knight_Pawn_Threat.clear();
        Bishop_Threat.clear();
        Rook_Threat.clear();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (table[i][j].operator != null && table[i][j].operator instanceof King && table[i][j].operator.side == side) {
                    return checkKing(i, j, side);
                }
            }
        }


        return false;
    }

    public boolean checkKing(int i, int j, SideName side) {
        superBishopKing(i, j, side, Bishop.class);
        superCastleKing(i, j, side, Rook.class);
        superBishopKing(i, j, side, Queen.class);
        superCastleKing(i, j, side, Queen.class);
        superKnightKing(i, j, side);
        if (side == SideName.White) superWhitePawnKing(i, j);
        else superBlackPawnKing(i, j);

        if (Knight_Pawn_Threat.size() > 0 || Bishop_Threat.size() > 0 || Rook_Threat.size() > 0) {
            return true;
        }
        return false;
    }

    void superKnightKing(int i, int j, SideName side) {

        if (i + 1 < 8 && j + 2 < 8 && helpSuperKing(i + 1, j + 2, side, Knight.class))
            Knight_Pawn_Threat.add(table[i + 1][j + 2]);
        if (i + 1 < 8 && j - 2 >= 0 && helpSuperKing(i + 1, j - 2, side, Knight.class))
            Knight_Pawn_Threat.add(table[i + 1][j - 2]);
        if (i + 2 < 8 && j + 1 < 8 && helpSuperKing(i + 2, j + 1, side, Knight.class))
            Knight_Pawn_Threat.add(table[i + 2][j + 1]);
        if (i + 2 < 8 && j - 1 >= 0 && helpSuperKing(i + 2, j - 1, side, Knight.class))
            Knight_Pawn_Threat.add(table[i + 2][j - 1]);
        if (i - 1 >= 0 && j + 2 < 8 && helpSuperKing(i - 1, j + 2, side, Knight.class))
            Knight_Pawn_Threat.add(table[i - 1][j + 2]);
        if (i - 1 >= 0 && j - 2 >= 0 && helpSuperKing(i - 1, j - 2, side, Knight.class))
            Knight_Pawn_Threat.add(table[i - 1][j - 2]);
        if (i - 2 >= 0 && j + 1 < 8 && helpSuperKing(i - 2, j + 1, side, Knight.class))
            Knight_Pawn_Threat.add(table[i - 2][j + 1]);
        if (i - 2 >= 0 && j - 1 >= 0 && helpSuperKing(i - 2, j - 1, side, Knight.class))
            Knight_Pawn_Threat.add(table[i - 2][j - 1]);
    }

    void superWhitePawnKing(int i, int j) {
        if (i + 1 < 8 && j + 1 < 8 && helpSuperKing(i + 1, j + 1, SideName.White, Pawn.class))
            Knight_Pawn_Threat.add(table[i + 1][j + 1]);
        if (i + 1 < 8 && j - 1 >= 0 && helpSuperKing(i + 1, j - 1, SideName.White, Pawn.class))
            Knight_Pawn_Threat.add(table[i + 1][j - 1]);
    }

    void superBlackPawnKing(int i, int j) {
        if (i - 1 >= 0 && j + 1 < 8 && helpSuperKing(i - 1, j + 1, SideName.Black, Pawn.class))
            Knight_Pawn_Threat.add(table[i - 1][j + 1]);
        if (i - 1 >= 0 && j - 1 >= 0 && helpSuperKing(i - 1, j - 1, SideName.Black, Pawn.class))
            Knight_Pawn_Threat.add(table[i - 1][j - 1]);
    }

    void superBishopKing(int i, int j, SideName side, Class opname) {
        ArrayList<Square> squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (i + k < 8 && j + k < 8) {
                if (table[i + k][j + k].operator == null) squares.add(table[i + k][j + k]);
                else if (helpSuperKing(i + k, j + k, side, opname)) {
                    squares.add(table[i + k][j + k]);
                    Bishop_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
        squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (i - k >= 0 && j + k < 8) {
                if (table[i - k][j + k].operator == null) squares.add(table[i - k][j + k]);
                else if (helpSuperKing(i - k, j + k, side, opname)) {
                    squares.add(table[i - k][j + k]);
                    Bishop_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
        squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (i + k < 8 && j - k >= 0) {
                if (table[i + k][j - k].operator == null) squares.add(table[i + k][j - k]);
                else if (helpSuperKing(i + k, j - k, side, opname)) {
                    squares.add(table[i + k][j - k]);
                    Bishop_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
        squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (i - k >= 0 && j - k >= 0) {
                if (table[i - k][j - k].operator == null) squares.add(table[i - k][j - k]);
                else if (helpSuperKing(i - k, j - k, side, opname)) {
                    squares.add(table[i - k][j - k]);
                    Bishop_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }

    }

    void superCastleKing(int i, int j, SideName side, Class opname) {
        ArrayList<Square> squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (j + k < 8) {
                if (table[i][j + k].operator == null) squares.add(table[i][j + k]);
                else if (helpSuperKing(i, j + k, side, opname)) {
                    squares.add(table[i][j + k]);
                    Rook_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
        squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (j - k >= 0) {
                if (table[i][j - k].operator == null) squares.add(table[i][j - k]);
                else if (helpSuperKing(i, j - k, side, opname)) {
                    squares.add(table[i][j - k]);
                    Rook_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
        squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (i + k < 8) {
                if (table[i + k][j].operator == null) squares.add(table[i + k][j]);
                else if (helpSuperKing(i + k, j, side, opname)) {
                    squares.add(table[i + k][j]);
                    Rook_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
        squares = new ArrayList<>();
        for (int k = 1; k < 8; k++) {
            if (i - k >= 0) {
                if (table[i - k][j].operator == null) squares.add(table[i - k][j]);
                else if (helpSuperKing(i - k, j, side, opname)) {
                    squares.add(table[i - k][j]);
                    Rook_Threat.add(squares);
                    break;
                } else break;
            } else break;
        }
    }

    private boolean helpSuperKing(int i, int j, SideName side, Class opname) {
        if (table[i][j].operator != null && table[i][j].operator.side != side && table[i][j].operator.getClass() == opname)
            return true;
        return false;
    }

    public boolean checkMate(SideName side) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (table[i][j].operator != null && table[i][j].operator.side == side) {
                    if (table[i][j].operator.legalmoves.size() > 0) return false;
                }
            }
        }
        return true;
    }

}
