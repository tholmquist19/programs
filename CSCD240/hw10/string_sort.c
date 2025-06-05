/*YOU CANNOT USE ANY FUNCTION FROM THE string.h Library !!! If you do, you will get
zero. */
/* Write a statement here to include the string_sort.h file */
/*
Input: Both s1 and s2 are strings, i.e., they are terminated by '\0'.
Output:
       0: if s1 and s2 are exactly the same.
      -1: if s1 is lexicographically smaller than s2.
       1: if s1 is lexicographically larger than s2.
For examples:
       1) if s1 = "hello", s2 = "hallow", return 1.
       2) if s1 = "hello", s2 = "hol", return -1.
       3) if s1 = "", s2 = "abc", return -1.
       4) if s1 = "hi", s2 = "hi", return 0.
*/
int my_strcmp(char * s1, char * s2){
    int i=0;
    while(s1[i] != '\0' || s2[i] !='\0'){
        if(s1[i]>s2[i]){
            return 1;
            break;
        }
        else if(s2[i]>s1[i]){
            return -1;
            break;
        }
        else if(s1[i]==s2[i]){
            return 0;
        }
        else{
            i++;
        }
    }
    
    
}
/*
    Input: 'ss' is an array of strings. 'num' is the of strings in 'ss', i.e., the
size of the array 'ss'.
    Output: The function does not return anything, but the function will sort all
the elements (strings) in the array 'ss', so that all the array elements in
lexicographically ascending ordering. The sorting algorithm you are going to
implement is the SelectionSort that you should have learned from CSCD210.
    Hint: During the sorting procedure, you will use the my_strcmp function to
compare elements in the array.
*/
void string_sort(char ** ss, int num){
  char *temp;
  char *tempy;
    for(int i=0; i<num; i++){
      temp=ss[i];
      for(int y=0; y<num; y++){
          tempy=ss[y];
          if(ss[y]==""){
              ss[1]=ss[y];
              ss[y]=ss[y+1];
          }
          if(my_strcmp(ss[i],ss[y])<0){
             ss[i]=tempy;
             ss[y]=temp;
         }
      }
    }
}
