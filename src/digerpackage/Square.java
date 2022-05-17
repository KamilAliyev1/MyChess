package digerpackage;


public class Square {
    public Operator operator = null;
    SideName color = null;
    public int y;
    public ColumnName x;

    public Square(Operator operator, ColumnName x, int y) {
        this.operator = operator;
        this.y = y;
        this.x = x;
    }
}


