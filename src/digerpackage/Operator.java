package digerpackage;

import java.util.ArrayList;

public class Operator {
    protected Square[][] table = Main.table;
    public SideName side;
    public ArrayList<Square> legalmoves;
    public String picname;
    public Operator() {}
    public Operator(SideName side) {
        this.side = side;
        legalmoves = new ArrayList<>();
        picname = null;
    }

    public void moves(int i, int j) {}
    public Operator pawnPromotion(SideName side){return null;}
}
