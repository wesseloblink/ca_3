import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InnerGraph {
    private String name;
    private List<InnerEdge> innerEdgeList;
    private Map<Integer, Node> nodeMap;

    public InnerGraph(String name) {
        this.name = name;

        nodeMap = new HashMap<>();
        innerEdgeList = new ArrayList<>();
    }

    public void addInnerEdge(Node firstNode, Node secondNode) {
        InnerEdge innerEdge = new InnerEdge(firstNode, secondNode);
        innerEdgeList.add(innerEdge);
    }

    public void addNode(Node node) {
        nodeMap.put(node.getNumber(), node);
    }

    public Node getNodeByNumber(int number) {
        return nodeMap.get(number);
    }

    public String getName() {
        return name;
    }

    public List<InnerEdge> getInnerEdgeList() {
        return innerEdgeList;
    }
}
