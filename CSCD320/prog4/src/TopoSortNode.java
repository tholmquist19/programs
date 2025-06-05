import java.util.ArrayList;
import java.util.List;

public class TopoSortNode {
    private int value;
    private List<TopoSortNode> children;
    private boolean visited;

    public TopoSortNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
        this.visited = false;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setVisited(final boolean set) {
        this.visited = set;
    }

    public int getValue() {
        return this.value;
    }

    public List<TopoSortNode> getChildren() {
        return this.children;
    }

    public void addChild(final TopoSortNode child) {
        this.children.add(child);
    }
}
