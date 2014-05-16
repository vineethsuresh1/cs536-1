import java.util.*;

/**
 * The Sym class defines a symbol-table entry. 
 * Each Sym contains a type (a Type).
 */
public class Sym {
    private Type type;
    private static int base = 0;
    public String mark;
    public int scopeLevel = -1;
    public int offset = 0;

    public static int getBase() {
        base++;
        return base;
    }
  
    public Sym(Type type, int level) {
        this.type = type;
        mark = "SYM[" + getBase() + "]";
        this.scopeLevel = level;
    }
    
    public Type getType() {
        return type;
    }
    
    public String toString() {
        return type.toString();
    }

    public int getLevel() {
        return scopeLevel;
    }
}

/**
 * The FnSym class is a subclass of the Sym class just for functions.
 * The returnType field holds the return type and there are fields to hold
 * information about the parameters.
 */
class FnSym extends Sym {
    // new fields
    private Type returnType;
    private int numParams;
    private List<Type> paramTypes;
    private int localSize;
 
    public FnSym(Type type, int numparams, int lSize, int level) {
        super(new FnType(), level);
        returnType = type;
        numParams = numparams;
        localSize = lSize;
    }

    public void addFormals(List<Type> L) {
        paramTypes = L;
    }
    
    public Type getReturnType() {
        return returnType;
    }

    public int getNumParams() {
        return numParams;
    }

    public List<Type> getParamTypes() {
        return paramTypes;
    }

    public String toString() {
        // make list of formals
        String str = "";
        boolean notfirst = false;
        for (Type type : paramTypes) {
            if (notfirst)
                str += ",";
            else
                notfirst = true;
            str += type.toString();
        }

        str += "->" + returnType.toString();
        return str;
    }

    public int getLocal(int localIndex) {
        return getParam(numParams) - 4 * localIndex;
    }
    
    public int getParam(int paramIndex) {
        return -12 - paramIndex * 4;
    }
    
    public int getControlLinkOff() {
        return -8;
    }

    public int getAccessLinkOff() {
        return -4;
    }

    public int getReturnOff() {
        return 0;
    }
}

/**
 * The StructSym class is a subclass of the Sym class just for variables 
 * declared to be a struct type. 
 * Each StructSym contains a symbol table to hold information about its 
 * fields.
 */
class StructSym extends Sym {
    // new fields
    private IdNode structType;  // name of the struct type
    
    public StructSym(IdNode id) {
        super(new StructType(id), 0);
        structType = id;
    }

    public IdNode getStructType() {
        return structType;
    }    
}

/**
 * The StructDefSym class is a subclass of the Sym class just for the 
 * definition of a struct type. 
 * Each StructDefSym contains a symbol table to hold information about its 
 * fields.
 */
class StructDefSym extends Sym {
    // new fields
    private SymTable symTab;
    
    public StructDefSym(SymTable table) {
        super(new StructDefType(), 0);
        symTab = table;
    }

    public SymTable getSymTable() {
        return symTab;
    }
}
