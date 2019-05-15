import java.util.ArrayList;
import java.util.List;


public class UndirectedGraphImplementation {
    public static void main(String[] args) {
        //adjacency List
        GraphNode n1 = new GraphNode(3);
        GraphNode n2 = new GraphNode(4);
        GraphNode n3 = new GraphNode(5);

        n1.neighbors.add(n2);
        n1.neighbors.add(n3);
        //undirected graph needs the nodes to point to each other
        n2.neighbors.add(n1);
        n3.neighbors.add(n1);
    }
}
class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
