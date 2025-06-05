#include<stdio.h>

unsigned int lcs(unsigned int, unsigned int);


/* You are not allowed to change the main function. */

int main()
{
  unsigned int num, s;
  
  num = 0x7a3e95f6; 
  s = 0; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 2; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 4; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 8; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 12; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 13; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 28; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));
  s = 32; printf("num = %x, s = %2d, lcs(num, s) = %x\n", num, s, lcs(num, s));

  
  return 0; 
}

/*
The output print from the main function should be the following: 

num = 7a3e95f6, s =  0, lcs(num, s) = 7a3e95f6
num = 7a3e95f6, s =  2, lcs(num, s) = e8fa57d9
num = 7a3e95f6, s =  4, lcs(num, s) = a3e95f67
num = 7a3e95f6, s =  8, lcs(num, s) = 3e95f67a
num = 7a3e95f6, s = 12, lcs(num, s) = e95f67a3
num = 7a3e95f6, s = 13, lcs(num, s) = d2becf47
num = 7a3e95f6, s = 28, lcs(num, s) = 67a3e95f
num = 7a3e95f6, s = 32, lcs(num, s) = 7a3e95f6
*/



/*
Return the left cyclic shift of an unsigned integer num for s positions, 
i.e., cut off the leftmost s bits and append them onto the right end of 
the bit sequence of num. 

The value s can be: s>=0 and s<=32, which is the number of bits of unsigned integer in most systems. 
*/
unsigned int lcs(unsigned int num, unsigned int s){

    unsigned int c = num<<s;
    unsigned int b = num>>32-s;
    unsigned int a = c|b;
    
    return a;
}


