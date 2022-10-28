package ClassFile;

import java.util.ArrayList;

public class VarSymbol extends Symbol {
    private final boolean isGlobal;
    private final boolean isConst;
    private final int dimension;
    private int ident;
    private final int sizeOne = 0;
    private final int sizeTwo = 1;
    private final boolean isRealParam;
    private final boolean hasValue;
    private int value;
    private int line;
    private final ArrayList<Integer> oneDimArray = new ArrayList<>();
    private final ArrayList<ArrayList<Integer>> twoDimArray = new ArrayList<>();

    public VarSymbol(Token token, boolean isConst, int dimension,
                     ArrayList<ArrayList<Integer>> initVal, boolean isGlobal, int line) {
        super(token);
        setName(token.context);
        this.isConst = isConst;
        this.dimension = dimension;
        this.isRealParam = false;
        this.hasValue = true;
        this.isGlobal = isGlobal;
        this.line = line;
    }

    public VarSymbol(Token token, boolean isConst, int dimension, boolean isGlobal, int line) {
        super(token);
        setName(token.context);
        this.isConst = isConst;
        this.dimension = dimension;
        this.isRealParam = true;
        this.hasValue = false;
        this.isGlobal = isGlobal;
        this.line = line;
    }

    public boolean isConst() {
        return isConst;
    }

    public int getDimension() {
        return dimension;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void SearchLastSymbol(SymbolTable table) {
        if (table == null) {
            return;
        }
        Symbol symbol = table.findName(getName());
        if (symbol instanceof VarSymbol) {
            ident = ((VarSymbol) symbol).getIdent() + 1;
        } else {
            SearchLastSymbol(table.getParent());
        }
    }

    public int getIdent() {
        return ident;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    @Override
    public int getLine() {
        return line;
    }
}
