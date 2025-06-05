import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Dijkstra {
    private static List<Vertex> graph;



    private static Vertex heapMin(final List<Vertex> queue) {
        Vertex min = queue.get(0);
        int minIndex = 0;
        for (int i = 1; i < queue.size(); i++) {
            Vertex v = queue.get(i);
            if (v.getDistance() < min.getDistance()) {
                min = v;
                minIndex = i;
            }
        }
        queue.remove(minIndex);
        return min;
    }


    private static void readFile(final String fileName) {
        graph = new ArrayList<>();
        ArrayList<String> p = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                p.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(p);
        for (int i = 0; i < p.size(); i++) {
            String[] s = p.get(i).split(":");
            int vId = Integer.parseInt(s[0]);
            Vertex vertex = new Vertex(vId);
            if (s.length > 1 && s[1].isEmpty()==false) {
                String[] neighbors = s[1].split(";");
                for (String n : neighbors) {
                    String[] nInfo = n.split(",");
                    int nId = Integer.parseInt(nInfo[0]);
                    int weight = Integer.parseInt(nInfo[1]);
                    vertex.getNeighbors().add(new Edge(nId, weight));
                }
            }
            graph.add(vertex);
        }
    }

    private static void dijkstra(final int source) {
        for (Vertex vertex : graph) {
            vertex.setDistance(Integer.MAX_VALUE);
            vertex.setPrevious(null);
        }
        graph.get(source).setDistance(0);

        List<Vertex> queue = new ArrayList<>(graph);

        while (queue.isEmpty()==false) {
            Vertex u = heapMin(queue);
            for (Edge neighbor : u.getNeighbors()) {
                Vertex v = graph.get(neighbor.getDestination());
                if (u.getDistance() != Integer.MAX_VALUE && v.getDistance() > u.getDistance() + neighbor.getWeight()) {
                    v.setDistance(u.getDistance() + neighbor.getWeight());
                    v.setPrevious(u);
                }
            }
        }
    }



    private static void printPath(final int source) {
        for (Vertex v : graph) {
            if (v.getId() != source) {
                if (v.getDistance() == Integer.MAX_VALUE)
                    System.out.println("[" + v.getId() + "] unreachable");
                else
                    System.out.println("[" + v.getId() + "] shortest path: (" + rebuild(source, v) +
                            ") shortest distance: " + v.getDistance());
            }
        }
    }

    private static String rebuild(final int source, final Vertex destination) {
        Vertex cur = destination;
        StringBuilder path = new StringBuilder();
        boolean end = true;
        while (cur != null && cur.getId() != source) {
            if(end) {
                path.insert(0, cur.getId());
                end = false;
            }
            else
                path.insert(0, cur.getId() + ",");
            cur = cur.getPrevious();
        }
        if (cur != null && cur.getId() == source) {
            path.insert(0, source + ",");
        }
        return path.toString();
    }



    public static void main(String[] args) {
        String fileName = args[0];
        int sourceVertex = Integer.parseInt(args[1]);

        readFile(fileName);
        dijkstra(sourceVertex);
        printPath(sourceVertex);
    }
}
