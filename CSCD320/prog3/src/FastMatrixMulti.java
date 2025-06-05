import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class FastMatrixMulti {


    public static int[][][] matrix_chain_order(final int[] p) {
        int n = p.length - 1;
        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            m[i][i] = 0;
        }

        for (int h = 2; h <= n; h++) {
            for (int i = 1; i <= n - h + 1; i++) {
                int j = i + h - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        int[][][] res = new int[2][][];
        res[0] = m;
        res[1] = s;
        return res;
    }


    public static void print_optimal_parens(final int[][] s, final int i, final int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            print_optimal_parens(s, i, s[i][j]);
            print_optimal_parens(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args){
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

        int[][][] result = matrix_chain_order(A);
        int[][] m = result[0];
        int[][] s = result[1];
        print_optimal_parens(s, 1, A.length - 1);
        System.out.println();
        System.out.println(m[1][A.length - 1]);
    }
}
