import java.util.ArrayList;
import java.util.Collections;

/**
 * Registers.java keeps track of the free registers available at compile.
 * saveAllRegisters() is called at the start to store 
 * the current status of the registers.
 * The registers are restored at the end of the function.
 * regs.next() is called when a new register is needed
 * regs.restore() is called to free the register when no longer needed
 */

public class Registers {

  private static final String[] Regs = 
      { "$t0", "$t1"};
  ArrayList<String> pool = new ArrayList<String>();

  public int savedRegistersCount() {
    return Regs.length;
  }

  public Registers() {
  }

  public void saveAllRegisters() {
    for(String s:Regs) {
      Codegen.genPush(s);
      pool.add(s);
    }
  }

  public String nextRegister() {
    if(!hasNextRegister()) {
      System.out.println("Registers.java fatal error.");
      System.exit(-1);
    }
    return pool.remove(0);
  }

  public boolean hasNextRegister() {
    if(pool.size() <= 0) return false;
    else return true;
  }

  public void releaseRegister(String reg) {
    if(pool.contains(reg)) {
      System.out.println("Fatal Error: Register released more than once.");
      int a = 0 / 0;
    }

    pool.add(0,reg);
    Collections.sort(pool);
  }

  public void restoreAllRegisters() {
    for(int i = Regs.length - 1; i>= 0; i--) {
      Codegen.genPop(Regs[i]);
    }
  }
}
