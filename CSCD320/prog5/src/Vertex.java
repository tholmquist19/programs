import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    private int id;
    private int distance;
    private Vertex previous;
    private List<Edge> neighbors;

    public Vertex(final int id) {
        this.id = id;
        this.distance = Integer.MAX_VALUE;
        this.previous = null;
        this.neighbors = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(final int distance) {
        this.distance = distance;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(final Vertex previous) {
        this.previous = previous;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    @Override
    public int compareTo(final Vertex other) {
        return Integer.compare(this.distance, other.distance);
    }
}

