import javax.xml.crypto.Data;
import java.util.*;

public class OuterGraph {

    private Map<String, InnerGraph> innerGraphMap;
    private List<OuterEdge> outerEdgeList;

    public OuterGraph() {
        // Initialize systems hashmap
        this.innerGraphMap = new HashMap<>();
        this.outerEdgeList = new ArrayList<>();

        // Read data
        DataProvider dataProvider = new DataProvider();
        dataProvider.readFromFile(this, "galaxydata.json");
    }

    /**
     * Find and print the route from one node to another
     * @param startNode  The node to start from
     * @param targetNode The node to find
     */
    public void findRouteToNode(Node startNode, Node targetNode) {
        Set<Node> visited = new HashSet<>();
        LinkedList<Node> result = dfs(startNode, targetNode, visited);

        if(result.size() > 0) {
            System.out.println("It took " + result.size() + " steps to find the target planet.");
            System.out.println("Path walked:");

            for (int i = 0; i < result.size(); i++) {
                // Loop through result (list of nodes)
                Node node = result.get(i);

                if (i== 0 && i == result.size() -1 ) {
                    System.out.println(node.getInnerGraph().getName() + node.getNumber() + " (start and finish)");
                } else if (i == 0) {
                    System.out.println(node.getInnerGraph().getName() + node.getNumber() + " (start)");
                } else if (i == result.size() - 1) {
                    System.out.println(node.getInnerGraph().getName() + node.getNumber() + " (finish)");
                } else {
                    System.out.println(node.getInnerGraph().getName() + node.getNumber());
                }
            }
        } else {
            System.out.println("No path found to the target planet.");
        }
    }

    /**
     * Do a depth-first search to find the target node
     *
     * @param startNode  The node we start from
     * @param targetNode The node we're looking for
     * @return A LinkedList of nodes representing the searched route
     */
    private LinkedList<Node> dfs(Node startNode, Node targetNode, Set<Node> visited) {
        LinkedList<Node> solution;
        visited.add(startNode);

        if (startNode.equals(targetNode)) {
            // If the start node is also the node we're looking for
            // Return an empty list of nodes since we did not travel to find the solution
            solution = new LinkedList<>();
            solution.add(startNode);
            return solution;
        } else {
            // If the start node is not the node we're looking for
            List<Node> neighbors = getNeighbors(startNode, targetNode);
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    // If we have not visited the neighbor before
                    // Do a recursive call to this method on the neighbor
                    solution = dfs(neighbor, targetNode, visited);

                    if (solution.size() > 0) {
                        // If we found a route
                        solution.addFirst(startNode);
                        return solution;
                    }
                }
            }
        }

        return new LinkedList<>();
    }

    /**
     * Find and return a list of neighboring nodes
     *
     * @param startNode The node to find neighbors for
     * @return A list of neighboring nodes
     */
    private ArrayList<Node> getNeighbors(Node startNode, Node targetNode) {
        // Initialize variables
        ArrayList<Node> neighbors = new ArrayList<>();
        Map<String, InnerGraph> innerGraphs = getInnerGraphByNode(startNode);

        for (InnerEdge innerEdge : getInnerEdgesByNode(startNode)) {
            // Loop through all the InnerEdges

            if (innerEdge.getNode1().equals(startNode)) {
                // If node1 of innerEdge is the node we're looking for
                // Save node1 of innerEdge as neighbor
                neighbors.add(innerEdge.getNode2());
            } else if (innerEdge.getNode2().equals(startNode)) {
                // Same as above but now for node2
                neighbors.add(innerEdge.getNode1());
            }
        }

        for (OuterEdge outerEdge : outerEdgeList) {
            // Loop through all the OuterEdges
            if (innerGraphs.containsValue(outerEdge.getGraph1()) || innerGraphs.containsValue(outerEdge.getGraph2())) {
                // If either of the graphs is one of our InnerGraphs
                if (outerEdge.getGraph1().getName().equals(startNode.getInnerGraph().getName())) {
                    // If graph1 is the graph containing our startNode
                    // Get graph2's node with the same number as startNode
                    Node potentionalNeighbor = outerEdge.getGraph2().getNodeByNumber(startNode.getNumber());

                    if (potentionalNeighbor.getColor().equals(startNode.getColor())) {
                        // If the potentional neighbor has the same number and color as startNode
                        neighbors.add(potentionalNeighbor);
                    }
                } else if (outerEdge.getGraph2().getName().equals(startNode.getInnerGraph().getName())) {
                    // The same as above but for graph2 instead
                    Node potentionalNeighbor = outerEdge.getGraph1().getNodeByNumber(startNode.getNumber());

                    if (potentionalNeighbor.getColor().equals(startNode.getColor())) {
                        neighbors.add(potentionalNeighbor);
                    }
                }
            }
        }

        if (neighbors.contains(targetNode)) {
            // If the target node is found
            ArrayList<Node> finalNeighbors = new ArrayList<>();
            finalNeighbors.add(targetNode);

            return finalNeighbors;
        }
        return neighbors;
    }

    /**
     * Get all InnerGraphs where the specified node is mentioned
     *
     * @param startNode The node to look for
     * @return A Map of InnerGraphs
     */
    private Map<String, InnerGraph> getInnerGraphByNode(Node startNode) {
        Map<String, InnerGraph> innerGraphMap = new HashMap<>();
        int startNodeNumber = startNode.getNumber();
        Color startNodeColor = startNode.getColor();

        InnerGraph startGraph = startNode.getInnerGraph();
        List<InnerGraph> connectedGraphs = getConnectedGraphs(startGraph);

        for (InnerGraph innerGraph : connectedGraphs) {
            // Loop through the list of InnerGraphs
            if (innerGraph.getNodeByNumber(startNodeNumber).getColor().equals(startNodeColor)) {
                innerGraphMap.put(innerGraph.getName(), innerGraph);
            }
        }
        return innerGraphMap;
    }

    /**
     * Method to return connected InnerGraphs compared to current InnerGraph
     *
     * @param startGraph InnerGraph to compare with
     * @return List of connected InnerGraphs
     */
    private List<InnerGraph> getConnectedGraphs(InnerGraph startGraph) {
        List<InnerGraph> innerGraphs = new ArrayList<>();

        for (OuterEdge outerEdge : outerEdgeList) {
            if (outerEdge.getGraph1().equals(startGraph)) {
                innerGraphs.add(outerEdge.getGraph2());
            } else if (outerEdge.getGraph2().equals(startGraph)) {
                innerGraphs.add(outerEdge.getGraph1());
            }
        }
        return innerGraphs;
    }

    /**
     * Get a list of InnerEdges containing the specified Node
     *
     * @param nodeToFind The node to find InnerEdges for
     * @return ArrayList of type InnerEdge
     */
    private ArrayList<InnerEdge> getInnerEdgesByNode(Node nodeToFind) {
        ArrayList<InnerEdge> innerEdges = new ArrayList<>();

        for (Map.Entry<String, InnerGraph> item : innerGraphMap.entrySet()) {
            for (InnerEdge innerEdge : item.getValue().getInnerEdgeList()) {
                if (innerEdge.getNode1().equals(nodeToFind)) {
                    innerEdges.add(innerEdge);
                } else if (innerEdge.getNode2().equals(nodeToFind)) {
                    innerEdges.add(innerEdge);
                }
            }
        }
        return innerEdges;
    }

    public Map<String, InnerGraph> getInnerGraphMap() {
        return innerGraphMap;
    }

    public List<OuterEdge> getOuterEdgeList() {
        return outerEdgeList;
    }

    // @enduml
}
