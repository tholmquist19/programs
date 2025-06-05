public class LightestPath {
    public static int lightestPath(int[][] W, int j, int k) {
        // Base case: when reaching the starting vertex
        if (j == 0 && k == 0) {
            return W[0][0];
        }

        // Handle the case when j or k is out of bounds
        if (j < 0 || k < 0) {
            return Integer.MAX_VALUE; // Return a large value to avoid considering paths with negative indices
        }

        // Recursive step: calculate the weight of the lightest path ending at vertex (j, k)
        int fromTop = lightestPath(W, j - 1, k); // Path from (j-1, k)
        int fromLeft = lightestPath(W, j, k - 1); // Path from (j, k-1)
        int fromDiagonal = lightestPath(W, j - 1, k - 1); // Path from (j-1, k-1)

        // Return the weight of the lightest path ending at vertex (j, k)
        return W[j][k] + Math.min(fromTop, Math.min(fromLeft, fromDiagonal));
    }





    public static int lightest_path_iterative(int[][] W) {
        int m = W.length;
        int n = W[0].length;

        // Initialize a 2D array to store the cumulative weights of the lightest paths
        int[][] pathWeight = new int[m][n];

        // Fill the dp array bottom-up
        for (int j = 0; j < m; j++) {
            for (int k = 0; k < n; k++) {
                if (j == 0 && k == 0)
                    pathWeight[j][k] = W[j][k];
                else if (j == 0)
                    pathWeight[j][k] = pathWeight[j][k - 1] + W[j][k];
                else if (k == 0)
                    pathWeight[j][k] = pathWeight[j - 1][k] + W[j][k];
                else
                    pathWeight[j][k] = W[j][k] + Math.min(pathWeight[j - 1][k], Math.min(pathWeight[j][k - 1], pathWeight[j - 1][k - 1]));
            }
        }

        // Return the weight of the lightest path ending at the destination vertex
        return pathWeight[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] W = {
                {5, 3, 8, 2},
                {7, 2, 1, 9},
                {8, 2, 1, 5}
        };
        int M = W.length - 1;
        int N = W[0].length - 1;
        System.out.println(lightestPath(W,M,N)); // Output: 6
    }
}

