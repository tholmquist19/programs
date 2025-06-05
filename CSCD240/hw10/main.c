#include<stdio.h>
#include"string_sort.h"

int main()
{
  char * ss1[5] = {"hi", "hello", "", "how", "byebye"};
  char * ss2[5] = {"hi", "hello", "", "how", "byebye"};
  char * ss3[5] = {"hi", "hello", "", "how", "byebye"};
  char * ss4[5] = {"hi", "hello", "", "how", "byebye"};
  char * ss5[5] = {"hi", "hello", "", "how", "byebye"};
  int offset, num;
  
  printf("********************\n");
  offset = 0;
  num = 5 - offset;
  string_sort(ss1 + offset, num);
  for(int i = 0; i < 5; i++)
    printf("%s\n", ss1[i]);
  printf("********************\n");
  offset = 1;
  num = 5 - offset;
  string_sort(ss2 + offset, num);
  for(int i = 0; i < 5; i++)
    printf("%s\n", ss2[i]);
  
  printf("********************\n");
  offset = 2;
  num = 5 - offset;
  string_sort(ss3 + offset, num);
  for(int i = 0; i < 5; i++)
    printf("%s\n", ss3[i]);
  
  printf("********************\n");
  offset = 3;
  num = 5 - offset;
  string_sort(ss4 + offset, num);
  for(int i = 0; i < 5; i++)
    printf("%s\n", ss4[i]);
  
  printf("********************\n");
  offset = 4;
  num = 5 - offset;
  string_sort(ss5 + offset, num);
  for(int i = 0; i < 5; i++)
    printf("%s\n", ss5[i]);
  
  
  return 0;
}
/*
  The output on the screen shall be the following:
********************
byebye
hello
hi
how
********************
hi
byebye
hello
how
********************
hi
hello
byebye
how
********************
hi
hello
byebye
how
********************
hi
hello
how
byebye
*/
