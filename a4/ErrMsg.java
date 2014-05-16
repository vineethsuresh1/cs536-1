// ErrMsg.java: used to create warnings and fatal errors
class ErrMsg {
    public static boolean errors = false;
    // Print fatal errors message
    static void fatal(int lineNum, int charNum, String message) {
        System.err.println(lineNum+":"+charNum+" **ERROR** "+message);
        ErrMsg.errors = true;
    }
    // Print warning errors message
    static void warn(int lineNum, int charNum, String message) {
        System.err.println(lineNum+":"+charNum+" **WARNING** " + message);
    }
}
