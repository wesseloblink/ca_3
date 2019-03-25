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

    /**
     * Return inner edges containing specified node
     *
     * @param node The node to search for
     * @return A list of InnerEdges
     */
    public List<InnerEdge> getInnerEdgesForNode(Node node) {
        List<InnerEdge> innerEdgesForNode = new ArrayList<>();

        for (InnerEdge innerEdge : innerEdgeList) {
            if (innerEdge.getNode1().equals(node)) {
                innerEdgesForNode.add(innerEdge);
            } else if (innerEdge.getNode2().equals(node)) {
                innerEdgesForNode.add(innerEdge);
            }
        }
        return innerEdgesForNode;
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
