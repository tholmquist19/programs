#include<stdio.h>

#include"peak.h"



int main()
{
  int a[] = {1, 4, 7, 11, 9, 8, 6, 3};

  int start, end; 

  start = 0; end = 4; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 0; end = 5; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 0; end = 6; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 0; end = 7; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 1; end = 4; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 1; end = 5; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 1; end = 6; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 1; end = 7; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 2; end = 4; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 2; end = 5; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 2; end = 6; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 
  start = 2; end = 7; printf("Peak of a[%d...%d] is at: %d\n", start, end, peak(a, start, end)); 

  return 0; 
}


/*
  The output on the screen shall be the following: 

Peak of a[0...4] is at: 3
Peak of a[0...5] is at: 3
Peak of a[0...6] is at: 3
Peak of a[0...7] is at: 3
Peak of a[1...4] is at: 3
Peak of a[1...5] is at: 3
Peak of a[1...6] is at: 3
Peak of a[1...7] is at: 3
Peak of a[2...4] is at: 3
Peak of a[2...5] is at: 3
Peak of a[2...6] is at: 3
Peak of a[2...7] is at: 3
*/
