import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class TopoSort {
    private List<TopoSortNode> nodes;
    String st = "";

    public TopoSort() {
        nodes = new ArrayList<>();
    }

    public void addNode(final int value) {
        if(nodes.contains(getNodeByValue(value))==false)
            nodes.add(new TopoSortNode(value));
    }

    public void addEdge(final int parentValue, final int childValue) {
        TopoSortNode parent = getNodeByValue(parentValue);
        TopoSortNode child = getNodeByValue(childValue);
        if (parent != null) {
            if (child == null) {
                child = new TopoSortNode(childValue);
            }
            if (nodes.contains(child) == false) {
                nodes.add(child);
            }
            parent.addChild(child);
        } else {
            System.out.println("No parent node found");
        }
    }

    private TopoSortNode getNodeByValue(final int value) {
        for (TopoSortNode node : nodes) {
            if (node.getValue() == value) {
                return node;
            }
        }
        return null;
    }

    public String DFS(final TopoSort Graph){
        for(int i=0;i<Graph.nodes.size(); i++){
            TopoSortNode u = nodes.get(i);
            if(u.getVisited() == false)
                st = graph_DFS(Graph, u);
        }
        return st;
    }

    public String graph_DFS(final TopoSort Graph, final TopoSortNode s){
        //System.out.println(s.getValue());
        st += s.getValue()+",";
        s.setVisited(true);
        List<TopoSortNode> children = s.getChildren();
        for(int i=0; i<children.size(); i++){
            TopoSortNode child = children.get(i);
            if(child.getVisited() == false)
                graph_DFS(Graph,child);
        }
        return st;
    }


    public List<TopoSortNode> getNodes() {
        return nodes;
    }

    public static void main(String[] args) {
        TopoSort dag = new TopoSort();
        ArrayList<String> fill = new ArrayList<>();
        ArrayList<Integer> addNodes = new ArrayList<>();
        File inFile = null;
        Scanner dat = null;


        inFile = new File(args[0]);
        try {
            dat = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        while(dat.hasNextLine())
            fill.add(dat.nextLine());
        Collections.sort(fill);

        for(int y=0; y<fill.size(); y++){
            String[] nodes = fill.get(y).split(":");
            int node = Integer.parseInt(nodes[0]);

            dag.addNode(node);
            if(nodes.length>1){
                String[] edges = nodes[1].split(",");
                Arrays.sort(edges);
                for(int x=0; x<edges.length; x++) {
                    int add = Integer.parseInt(edges[x]);
                    dag.addEdge(node, add);
                }
            }
        }

        String st = dag.DFS(dag);
        if(st.endsWith(",")){
            st = st.substring(0,st.length()-1);
        }
        System.out.println(st);
    }
}
