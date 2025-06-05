#include<stdio.h>

int main(void){
        int ell;
        int w;
        int s;
        ell=10;
        w=5;
        s=0;

    while(ell<=100){
        s=ell*w;
        printf("length: "" %4d" "  width:"" %2d" "  area:"" %4d\n", ell,w,s);
        ell=ell+10;
    }
    return 0;
        
}

~
~
