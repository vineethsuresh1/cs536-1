// Test Program 2, CSX parser/scanner
// Used specifically for name analysis
//struct firstStruct{}
//struct myStruct {
//    int x;
//    struct firstStruct innerStruct;
//}
int x;
void declareFunction(int x, bool y){
    int myx;
    bool myy;
    int hi;
    myx = 2;
    myy = true;
    myx++;
    myx--;
    cin >> hi;
    cout << hi;
    if((myy) && myy) {
        int x;
        int y;
    }
    else {
        int x;
        int y;
        x=2;
        y=x;
    }
    while(myy) {
        int x;
        int y;
        y=x=2;
    }
    declareFunction(x, y);
}

int main() {

    bool y;
    x = 2;
    y = true;
    declareFunction(x,y);
}
