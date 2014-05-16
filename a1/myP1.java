import java.util.*;

/**
 * P1 (main for testing Assignment 1 classes)
 * @author John L. Peterson
 * @version Feb 3, 2014 
 *
 * This is a class whose sole purpose is to test the SymTable (and thus the Sym)
 * class. SymTable provides the following operations:
 *     no-arg constructor                 -- create a SymTable and add one empty
 *                                           HashMap
 *     void addDecl(String name, Sym sim) -- if list is empty, throws an
 *                                           EmptySymTableException. Or, if the
 *                                           name, sym or both are null, throws
 *                                           a NullPointerException. Else if the
 *                                           first HashMap contains that key,
 *                                           throws DuplicateSymException.
 *                                           Otherwise, it adds the name and sym
 *                                           to the first HashMap in the list.
 *     void addScope()                    -- Adds a new, empty HashMap to the
 *                                           front of the list.
 *     Sym lookupLocal(String name)       -- If the list is empty, returns null.
 *                                           Otherwise, if first HashMap in list
 *                                           contains the name as a key, returns
 *                                           that Sym. Otherwise returns null.
 *     Sym lookupGlobal(String name)      -- If any HashMap in the list contains
 *                                           name as a key, returns that Sym.
 *                                           Else, returns null.
 *     void removeScope()                 -- If SymTable's list is empty, throws
 *                                           EmptySymTableException. Else, it
 *                                           removes HashMap from front of list.
 *     void print()                       -- Prints "\n\Sym Table\n" then each
 *                                           HashMap in list toString() padded
 *                                           by newlines in between.
 * This program does not expect user input or any command-line arguments. 
 * It will only produce an output if something did not work as expected.
 * Each operation is tested for standard and error cases.
 */

public class P1 {
  public static void main(String[] args) {
    // Create new SymTable instance, and list of Strings for testing with
    SymTable myTab = new SymTable();
    ArrayList<String> nameList = new ArrayList<String>();
    Integer i = new Integer(0);
    while(i < 100) {
      nameList.add(new String(i.toString()));
      i++;
    }
    // declare then remove scope; if it fails then the problem is either
    // in the constructor for SymTable or in removeScope 
    try {
      myTab.removeScope();
    } catch(Exception ex) {
        System.out.println("Exception thrown after construct empty SymTable"
            + " and immediate removeScope");
    }
    
    // test addScope method by adding, then immediately removing. If no error 
    // received, then it is functioning properly
    myTab.addScope();
    try {
      myTab.removeScope();
    } catch(Exception ex) {
        System.out.println("Exception thrown after add scope and immediate"
            + " removeScope");
    }

    // Create sample Sym and String for basic tests
    Sym mySym = new Sym("int");
    String myString = new String("132");
    boolean success = false;
    
    // Try adding invalid arguments for addDecl()
    myTab.addScope();
    try {
      myTab.addDecl(null,mySym);
    } catch(Exception ex) {
        success = true;
    } finally {
        if(!success) {
          System.out.println("No exception thrown after null String name");
        }
        else success = false;
    }
    try {
      myTab.addDecl(myString,null);
    } catch(Exception ex) {
        success = true;
    } finally {
        if(!success) {
          System.out.println("No exception after null Sym sym");
        }
        else success = false;
    }
    try {
      myTab.addDecl(null,null);
    } catch(Exception ex) {
        success = true;
    } finally {
        if(!success) {
          System.out.println("No exception thrown after both null args");
        }
        success = true;
    }

    // Try adding a valid argument for addDecl(), exception only on fail
    try {
      myTab.addDecl(myString,mySym);
    } catch(Exception ex) {
        System.out.println("Exception thrown after valid addDecl call");
    }
    
    // Add 100 entries to current scope using addDecl
    i = 0;
    try {
      while(i < 100) {
        myTab.addDecl(nameList.get(i),mySym);
        i++;
      }
    } catch(Exception ex) {
      System.out.println("Exception thrown during 100 valid addDecl calls");
    }

    // Remove current scope to test operation again
    try {
      myTab.removeScope();
    } catch(Exception ex) {
        System.out.println("Exception thrown removing scope");
    }

    // Try lookupLocal on empty list, with valid and invalid args
    Sym lookupSym;
    lookupSym = myTab.lookupLocal(null);
    if(lookupSym != null) {
      System.out.println("Non-null value returned for lookupLocal in empty"
          + " SymTable list");
    }
    lookupSym = myTab.lookupLocal(myString);
    if(lookupSym != null) {
      System.out.println("Non-null value returned for lookupLocal in empty"
          + " SymTable list");
    }

    // Add 100 entries to same scope
    myTab.addScope();
    i = 0;
    try {
      while(i < 100) {
        myTab.addDecl(nameList.get(i),mySym);
        i++;
      }
    } catch(Exception ex) {
      System.out.println("Exception thrown during 100 valid addDecl calls");
    }
    i = 0;

    // Test lookupLocal for all 100 entries
    while(i < 100) {
      lookupSym = myTab.lookupLocal(nameList.get(i));
      if(!lookupSym.toString().equals(mySym.toString())) {
        System.out.format("Sym not found at %d index\n", i);
      }
      i++;
    }

    // Test lookupLocal on String not in table
    lookupSym = myTab.lookupLocal("hello");
    if(lookupSym != null) {
      System.out.println("Invalid sym lookup returned true for lookupLocal");
    }
    try {
      myTab.removeScope();
    } catch(Exception ex) {
        System.out.println("Exception thrown on valid removeScope call");
    }
    // Add 100 different scopes to the table and add one Sym to each
    i = 100;
    try {
      while(i > 0) {
        i--;
        myTab.addScope();
        myTab.addDecl(nameList.get(i),mySym);
      }
    } catch(Exception ex) {
        System.out.println("Exception thrown adding 100 scopes with one Sym");
    }
    // Global lookup each one of the 100 Syms added
    while(i < 100) {
      lookupSym = myTab.lookupGlobal(nameList.get(i));
      if(!lookupSym.toString().equals(mySym.toString())) {
        System.out.format("Sym not found at %d index\n", i);
      }
      i++;
    }
    // Global lookup a Sym that hasn't been added
    lookupSym = myTab.lookupGlobal("hello");
    if(lookupSym != null) {
      System.out.println("Invalid sym lookup returned true for lookupLocal");
    }
    
    // Test print function; compare this with the expectedout.txt file
    myTab.print();
  }
}
