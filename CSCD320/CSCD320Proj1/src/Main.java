import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    private static int partition(final int[] A, final int left, final int right){
        int pivot = A[right];
        int index = left;
        for(int i=left; i<=right-1; i++){
            if(A[i]<=pivot){
                swap(A,index,i);
                index++;
            }
        }
        swap(A,index,right);
        return index;

    }


    public static int randomizedSelect(final int[] A, final int p, final int r, final int i){
        if(p==r)
            return A[p];
        int q = random_partition(A,p,r); //
        int k = q-p+1;
        if(i==k)
            return A[q];
        else if(i<k)
            return randomizedSelect(A,p,q-1,i);
        else
            return randomizedSelect(A,q+1,r,i-k);
    }

    public static int random_partition(final int[] A, final int left, final int right){
        int i = (int)(left+(Math.random()*(right-left)));
        swap(A,i,right);
        return partition(A,left,right);
    }

    private static void swap(final int[] a, final int i, final int y) {
        int temp = a[i];
        a[i]=a[y];
        a[y]=temp;
    }

    public static void main(final String[] args) {
        ArrayList<Integer> fill = new ArrayList<>();
        File inFile = null;
        Scanner dat = null;


        inFile = new File(args[0]);
        try {
            dat = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while(dat.hasNextLine())
            fill.add(Integer.parseInt(dat.nextLine()));


        int A[] = new int[fill.size()];
        for(int y=0; y<fill.size(); y++){
            A[y]=fill.get(y);
        }

        int i = Integer.parseInt(args[1]);


        System.out.println(randomizedSelect(A,0,A.length-1,i));
    }
}
