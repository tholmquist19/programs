/*
  Extensively read the Unix manual pages for the details of any API
  function that you are to use. This is the way you will follow in
  doing this assignment as well as your future programming assignments
  from other posts.
*/



#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<sys/uio.h>
#include<unistd.h>
#include<fcntl.h>



/* We set a small buffer size in order to test your code using a small file. */
#define BUFFER_SIZE 10






/*
  Make a copy of the file whose name is saved in string "fin" and save
  the copy named as the string "fout". In this function, you can ONLY
  use these Unix system calls: open, read, write, close, to read/write
  a file.

  return: the total number of lines in fin.

  25 points.
*/
int syscall_line_count(char *fin, char *fout){
  /* FILL IN YOUR CODE HERE */

  /* Hint: Use a loop and the "read" and "write" Unix system calls to
     read/write/count the lines in the given file. The general steps
     to read and write a file: 1) open the file. 2) read/write. 3)
     close the file.
     
     Here, the file open/read/write/close are done via the file
     descriptors, NOT the FILE pointers.

     In this implementation, we use a buffer of size BUFFER_SIZE bytes.

     Note that the read system call just simply reads in the requested
     number of bytes from the file, if available, and returns the
     actual number of bytes that are read in. It does not do anything
     else. If you want to count the number of lines in the file, you
     will need to count the number of '\n' in each buffer that you
     read from the file. The total count of '\n' over all the reads
     from the file represent the number of lines in the 'fin' file.

     To copy the file data into a new file, you will use the write
     system call to write out the buffer into the destination file.

     Note: Since this function is to use the Unix system calls, you
     will have to write and test and run this function on a Unix-like
     system, such as Linux, MacOS, etc.
  */
  
  char buffer[BUFFER_SIZE]; /* The buffer used for read and write data. */
  int in, out;   /* The file descriptors for the input file and the copy of the file. */
  int count=-1;     /* the number of lines */

  in = open(fin, O_RDONLY);
  if(in < 0){
    fprintf(stderr, "System call file open for reading failed. Exit. \n");
    exit(1);
  }
  
  out = open(fout, O_WRONLY|O_CREAT);
  if(out < 0){
    fprintf(stderr, "System call file open for writing failed. Exit. \n");
    exit(1);
  }

  int n;
  /* Start of your work here */
  while((n = read(in, buffer, sizeof (buffer)))>0){
      write(out, buffer, n);
      for(int i=0; i<n; i++){
          if(buffer[i] == '\n')
              count++;
      }
  }
  
  
  /* End of your work here */
  
  close(in);
  close(out);

  return count;
}



/*
  Make a copy of the file whose name is saved in string 'fin' and save
  the copy named as the string 'fout'. In this function, you can ONLY
  use the standard lib function 'fgetc' and 'fputc' to read and write
  characters from/into a file.

  return: the total number of characters in 'fin'.

  25 points.
*/
int stream_io_char_count(char *fin, char *fout){
  /* FILL IN YOUR CODE HERE */

  /* Hint: Use a loop and the 'fgetc' and 'fputc' to read/write/count
     the characters in the given file. The general steps to read and
     write a file: 1) fopen the file. 2) read/write. 3) fclose the
     file. In this function, you will need to use two FILE pointers:
     one for reading and the other for writing.*/
    FILE *fp, *fo;
    int count=-1;
    char c;

    fp = fopen(fin, "r");
    if(fp == NULL){
        fprintf(stderr, "File open for reading failed. Exit. \n");
        exit(1);
    }
    fo = fopen(fout, "w");
    if(fo == NULL){
        fprintf(stderr, "File open for writing failed. Exit. \n");
        exit(1);
    }
    for(c = getc(fp); c != EOF; c = getc(fp)){
        count++;
        fputc(c, fo);
    }
    fclose(fp);

    return count;
}


/*
  Make a copy of the file 'fin' and save the copy named as the string
  'fout'. In this function, you can ONLY use the standard lib function
  'fgets' and 'fputs' to read and write lines from/into a file.

  return: the total number of lines in 'fin'.


  25 points.
*/
int stream_io_line_count(char *fin, char *fout){
  /* FILL IN YOUR CODE HERE */

  /* Hint: Use a loop and the 'fgets' and 'fputs' to read/write/count
     the lines in the given file. The general steps to read and write a
     file: 1) fopen the file. 2) read/write. 3) fclose the file. In
     this function, you will need to use two FILE pointers: one for
     reading and the other for writing.  You can assume every line in
     the fin file will not be longer than 1000 characters.
  */

    FILE *fp, *fo;
    char buffer[1001];
    int count=-1;

    fp = fopen(fin, "r");
    if(fp == NULL){
        fprintf(stderr, "File open for reading failed. Exit. \n");
        exit(1);
    }
    fo = fopen(fout, "w");
    if(fo == NULL){
        fprintf(stderr, "File open for reading failed. Exit. \n");
        exit(1);
    }

    while(fgets(buffer, 1001, fp) != NULL){
        count++;
        fputs(buffer, fo);
    }
    fclose(fp);
    fclose(fo);
    return count;
}


/*
  The given file named by the passed-in string 'fin' has many lines,
  where every line follows the structure (age,weight), where age is an
  integer representing a person's age and the weight is another integer
  representing the person's weight.

  This function uses fscanf function to read in the records one line
  after another, and in the meantime, accumulate the total age and the
  total weight and the number of records. In the end, this function
  saves the average age in the passed-in array location result[0] and
  the average weight in result[1] and the total number of records in
  result[2]. The average age is defined as the sum of all the ages
  divided by the number of recordes.  The average weight is defined as
  the sum of all the weights divided by the number of recordes. We use
  integers to calculate and save the average age and weight.



  25 points.
*/
void stream_io_scanf(char *fin, int *result){
  /* FILL IN YOUR CODE HERE */

  /* Hint: Use a loop and the "fscanf" to read in the records, and
     maintain the relevant aggregates/statistics on the fly.  The
     general steps to read a file: 1) fopen the file. 2) read. 3)
     fclose the file. In this function, you will need to use one FILE
     pointer.

     Note: In order to let fscanf work properly, the fscanf function's
     format parameter (the second parameter surrounded by the double
     quotes) must match every record's structure including each
     record's invisible '\n' character at the end of each line.
  */
    FILE *fp;
    int age;
    int weight;
    int records = 0;
    int fAge = 0;
        int fWeight = 0;

    fp = fopen(fin, "r");
    if(fp == NULL){
        fprintf(stderr, "File open for reading failed. Exit. \n");
        exit(1);
    }
    while(fscanf(fp, "(%d,%d)\n", &age, &weight) == 2){
        fAge+=age;
        fWeight+=weight;
        records++;
    }
    fAge = fAge/records;
    fWeight = fWeight/records;
    result[0] = fAge;
    result[1] = fWeight;
    result[2] = records;
    fclose(fp);
}



/*
  Do not change the main function.
*/

int main(int argc, char ** argv)
{
  /* This program takes the command line parameter argv[1] and argv[2]
     as the name of the files that are to be process. */

  int count;
  int result[3];

  count = stream_io_char_count(argv[1], "cp_by_stream_chars.txt");
  printf("%s ----> %d characters copied via stream.\n", argv[1], count);

  count = stream_io_line_count(argv[1], "cp_by_stream_lines.txt");
  printf("%s ----> %d lines copied via stream.\n", argv[1], count);

  stream_io_scanf(argv[2], result);
  printf("%s ----> Average age: %d, average weight: %d, total number of records:%d\n",\
     argv[2], result[0], result[1], result[2]);


  count = syscall_line_count(argv[1], "cp_by_syscalls_lines.txt");
  printf("%s ----> %d lines copied via system calls.\n", argv[1], count);


  
  return 0;
}


/*
If everything works correctly, the command "./main test.txt age_weight.txt" using the provided
files 'test.txt' and 'age_weight.txt' should produce the following as well as three copies of
the 'test.txt'. The three copies are named as 'cp_by_stream_chars.txt', 'cp_by_stream_lines.txt',
and 'cp_by_syscalls_lines.txt'.


test.txt ----> 81 characters copied via stream.
test.txt ----> 11 lines copied via stream.
age_weight.txt ----> Average age: 41, average weight: 154, total number of records:10
test.txt ----> 11 lines copied via system calls.
*/
