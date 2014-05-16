void declaremeTwice(int x, bool y){}
void declaremeTwice(bool x, bool y){
}
void voidDecls() {
    void x;
    void y;
}

void alreadyDeclared(int x, int x, int y) {
    int x,x;
    bool y,y;
    
}

void undeclaredVars() {
    x++;
    cin >> x;
    cout << x;
    x = x || y;
    x = x && y;
    x = x< y;
    x = x> y;
    x--;
    x = y-1;
    x = y+1;
    x = x==y;

}

void structAfterStuff(int x) {
    int y;
    y = x;
    struct Point myPoint;
}

void returnStatements() {
    return z;
    return x >= z;
    return x <= z;
    return x = 5;
}
