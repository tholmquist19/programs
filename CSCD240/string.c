#include<stdio.h>
#include<string.h>


void string_reverse(char s[]);
void string_remove(char s[], char c);


/*
  You are NOT allowed to change the main function.
*/
int main(){
  char s_0[] = "hello world!";
  char s_1[] = "how are you?";
  char s_2[] = "i am doing well.";
  char s_3[] = "";
  char s_4[] = "i";
  char s_5[] = "hi";


  
  char s_6[] = "how about you?";
  char s_7[] = "i am tossed by 240 :-(";
  char s_8[] = "you will be fine :-)";
  char s_9[] = "";
  char s_10[] = "y";
  char s_11[] = "yo";
  char s_12[] = "y";


  string_reverse(s_0);
  string_reverse(s_1);
  string_reverse(s_2);
  string_reverse(s_3);
  string_reverse(s_4);
  string_reverse(s_5);


  
  string_remove(s_6, 'o');
  string_remove(s_7, 's');
  string_remove(s_8, 'z');
  string_remove(s_9, 'o');
  string_remove(s_10, 'y');
  string_remove(s_11, 'o');
  string_remove(s_12, 'o');


      
  printf("s_0: %s\n", s_0);
  printf("s_1: %s\n", s_1);
  printf("s_2: %s\n", s_2);
  printf("s_3: %s\n", s_3);
  printf("s_4: %s\n", s_4);
  printf("s_5: %s\n", s_5);
  printf("s_6: %s\n", s_6);
  printf("s_7: %s\n", s_7);
  printf("s_8: %s\n", s_8);
  printf("s_9: %s\n", s_9);
  printf("s_10: %s\n", s_10);
  printf("s_11: %s\n", s_11);
  printf("s_12: %s\n", s_12);
 
  
  return 0;
}



/*
  The output from the main function printf should be the following:

s_0: !dlrow olleh
s_1: ?uoy era woh
s_2: .llew gniod ma i
s_3:
s_4: i
s_5: ih
s_6: hw abut yu?
s_7: i am toed by 240 :-(
s_8: you will be fine :-)
s_9:
s_10:
s_11: y
s_12: y


*/






/*
   Reverse the string s. For example, if s is "hello",
   after the function call, s becomes "olleh".

   You CANNOT use additional arrays or standard C lib
   functions other than the strlen function in the implementation of
   this function.
*/
void string_reverse(char s[]){
  
int i, t;
  int len = strlen(s);

  for(i=0;i<len/2;i++)
  {
      t=s[i];
      s[i]=s[len-i-1];
      s[len-i-1]=t;
  }

}

/*
   Reverse all the occurrences of the character c from the string s.

   Note: c is not allowed to be `\0`.

   For example, if s is "hello" and c is 'l',
   after the function call, s becomes "heo".
   If c does not show up in s at all, s will not change
   after this function call.

   You CANNOT use additional arrays or standard C lib
   functions other than the strlen function in the implementation of
   this function.
*/
void string_remove(char s[], char c){
    int i, y;
    int len = strlen(s);

    for(i = 0; i<len; i++){
        if(s[i] == c){
            for(y=i; y<len; y++){
            s[y] = s[y+1];
        }
        len--;
        i--;
        }
    }


}
