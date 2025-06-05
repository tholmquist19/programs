import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Richest {
    private static void heapify(final int[] A, final int root, final int size) {
        int smallest = root;
        int left = 2 * root;
        int right = 2 * root+1;

        if (left < size && A[left] < A[smallest])
            smallest = left;
        if (right < size && A[right] < A[smallest])
            smallest = right;
        if (smallest != root) {
            int swap = A[root];
            A[root] = A[smallest];
            A[smallest] = swap;
            heapify(A, size, smallest);
        }
    }


    public static void build_min_heap(final int[] A,final int size){
        int heapSize = size;
        for(int i = heapSize; i>=0;i--) {
            heapify(A, i, size);
        }
    }


    public static void heapSort(final int[] A, final int size){
        build_min_heap(A,size);
        int heap_size = size;
        for(int i=A.length-1; i>=2; i--){
            int temp = A[1];
            A[1]=A[i];
            A[i]=temp;
            heap_size--;
            build_min_heap(A,heap_size);
        }
    }




    public static void main(final String[] args) {
        File inFile = null;
        Scanner dat = null;
        int[] A = new int[10000];

        inFile = new File(args[0]);
        try {
            dat = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        int y = 1;
        while(dat.hasNextLine() && y<=9999) {
            A[y] = (Integer.parseInt(dat.nextLine()));
            y++;
        }

        build_min_heap(A, A.length-1);
        while(dat.hasNextLine()){
            int line = Integer.parseInt(dat.nextLine());
            if (A[1] < line)
            {
                A[1] = line;
                heapify(A, 1, A.length-1);
            }
        }

        heapSort(A, A.length-1);


        //Create file to write to for 10,000
        try {
            File myObj = new File("richest-top10k.output");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //Create file to write to for 10
        try {
            File myObj = new File("richest-top10.output");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //write to file for 10,000
        try {
            FileWriter myWriter = new FileWriter("richest-top10k.output");
            for(int i=1; i<A.length; i++) {
                myWriter.write(A[i]+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //write to file for 10
        try {
            FileWriter myWriter = new FileWriter("richest-top10.output");
            int h = A.length-10;
            for(int i=1; i<11; i++) {
                myWriter.write(A[i]+"\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
