#include <assert.h>


/*
  FINISH THIS FUNCTION. 
  
  The part of the input array data[start ... end] has (end-start+1)
  entries, with each entry holding a *DISTINCT* number.  You are
  *GUARANTEED* that the sequence of numbers in data[start ... end] is
  "unimodal":
  
  There exists some index p, start < p < end, such that the values in
  data[start ... end] increase up to position p and then decrease the
  remainder of the way until position end.  That is, data[start] <
  data[start+1] < ... < data[p] and data[p] > data[p+1]> ... >
  data[end].
  
  Since you are *GUARANTEED* that data[start ... end] is unimodal, you
  are *GUARANTEED* data[start ... end] must have at least *THREE*
  elements, i.e., end-start >= 2.
  
  Your task: find and return the ``peak entry'' p without having to
  read the entire array. In fact, your program must take no more than
  O(log n) time. We will discuss the recursive idea for solving this
  problem in a class.
  
  Note: 1) Your code must be recursion based.  2) You CANNOT linearly
  scan the input array data to find p. If you do, you get zero point. 
*/    


int peak(int data[], int start, int end){
  assert(end - start >= 2);

    int mid = (start+end)/2;

      if(end-start==2)
              return start+1;
      else if(data[mid]>data[mid-1] && data[mid]>data[mid+1]){
              return mid;
      }
      else if(data[mid]>data[mid-1] && data[mid]<data[mid+1]){
              peak(data, mid, end);
      }
      else if(data[mid]<data[mid-1] && data[mid]>data[mid+1]){
              peak(data, start, mid);
      }

 

  
}

