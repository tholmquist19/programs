#include <stdio.h>

#define IN 1    
#define OUT 0   

int main(void){
  int c, nl, nw, nc, state, nlc, pc, inP, cCheck;
  state = OUT;
  inP = OUT;
  nl = nw = nc = pc = nlc = 0;
  
  while((c = getchar()) != EOF){
    ++nc;
    if (c == '\n'){
      ++nl;
      cCheck++;
    }
    if (c == ' ' || c == '\n' || c =='\t')
      state = OUT;
    else if (state == OUT){
      state = IN;
      ++nw;
    }
    if(c == '\n'&& cCheck>=2)
	    inP = OUT;
    else if(inP == OUT && c!= ' ' && c!= '\n' &&  c != '\t'){
	    pc++;
	    inP = IN;
	    cCheck = 0;
	   }
    else{
	    inP=IN;
    }
  }
  


  printf("%d %d %d %d \n", pc, nl, nw, nc);

  return 0;
}

