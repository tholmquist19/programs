#include <stdio.h>

#define MAXLINE 1000



int my_getline(char line[], int maxline);
int check(char line[], char p[]);



int main(int argc, char **argv)
{
  char line[MAXLINE];       // current input line
  int len;
  
  while ((len = my_getline(line, MAXLINE)) > 0)
     
      if(check(line, argv[1]))
          printf("%s", line);

  
  return 0;
}

/* getline: read a line into s, return length */
int my_getline(char s[], int lim)
{
  int c, i;

  for (i = 0; (i < lim-1) && ((c = getchar()) != EOF) && (c != '\n'); ++i)
    s[i] = c;
  if (c == '\n')
    {
      s[i] = c;
      ++i;
    }
  s[i] = '\0';
  return i;
}

int check(char line[], char p[])
{
    int i, j;
    int lineL = strlen(line);
    int pL = strlen(p);


    if(lineL<pL){
        return 0;
    }

    for(i=0; i<= lineL-pL; i++){
        for(j=0; j<= pL; j++){
            if(line[i+j] != p[j])
                break;
        }
        if (j == pL +1)
            return 1;
    
    }
    return 0;
    
    

}
