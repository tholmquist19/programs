public class TransitiveClosure {
    public static boolean[][] transitiveClosure(int[][] graph) {
        int n = graph.length;
        boolean[][] closure = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                closure[i][j] = (i == j || graph[i][j] == 1);
            }
        }
        for (int i = 0; i < n; i++) {
            depthFirstSearch(graph, closure, i, i);
        }
        return closure;
    }
}
