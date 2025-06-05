public class Edge {
    int destination;
    int weight;

    public Edge(final int destination, final int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination(){
        return this.destination;
    }
    public int getWeight(){
        return this.weight;
    }
}
