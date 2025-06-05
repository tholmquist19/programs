#include <stdio.h>

#define LOW 1
#define HIGH 5
#define STEP 1

int main(void){

        int w, h;
        float s;

        for(w=LOW; w<=HIGH; w++){

                for(h=LOW; h<=HIGH; h++){
                        s=(double)w*h/2;
                        printf("width =""%3d"",""  height =""%3d"",",w,h);

                        printf(" area =""%.1f""\n",s);
                }

        }
        return 0;
}



