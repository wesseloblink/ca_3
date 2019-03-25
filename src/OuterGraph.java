import java.util.*;

public class OuterGraph {
    private Map<String, InnerGraph> innerGraphMap;
    private List<OuterEdge> outerEdgeList;

    public OuterGraph() {
        // Initialize systems hashmap
        this.innerGraphMap = new HashMap<>();
        this.outerEdgeList = new ArrayList<>();

        // Create graphs of nodes
        InnerGraph innerGraphA = new InnerGraph("A");
        InnerGraph innerGraphB = new InnerGraph("B");
        InnerGraph innerGraphC = new InnerGraph("C");
        InnerGraph innerGraphD = new InnerGraph("D");
        InnerGraph innerGraphE = new InnerGraph("E");
        InnerGraph innerGraphF = new InnerGraph("F");
        InnerGraph innerGraphG = new InnerGraph("G");
        InnerGraph innerGraphH = new InnerGraph("H");
        InnerGraph innerGraphK = new InnerGraph("K");

        // Add inner graph nodes
        // A
        innerGraphA.addNode(new Node(1, Color.RED, innerGraphA));
        innerGraphA.addNode(new Node(2, Color.BLUE, innerGraphA));
        innerGraphA.addNode(new Node(3, Color.YELLOW, innerGraphA));
        innerGraphA.addNode(new Node(4, Color.RED, innerGraphA));
        innerGraphA.addNode(new Node(5, Color.RED, innerGraphA));
        innerGraphA.addNode(new Node(6, Color.YELLOW, innerGraphA));
        innerGraphA.addNode(new Node(7, Color.RED, innerGraphA));
        innerGraphA.addNode(new Node(8, Color.RED, innerGraphA));
        innerGraphA.addNode(new Node(9, Color.YELLOW, innerGraphA));

        // B
        innerGraphB.addNode(new Node(1, Color.RED, innerGraphB));
        innerGraphB.addNode(new Node(2, Color.RED, innerGraphB));
        innerGraphB.addNode(new Node(3, Color.YELLOW, innerGraphB));
        innerGraphB.addNode(new Node(4, Color.YELLOW, innerGraphB));
        innerGraphB.addNode(new Node(5, Color.RED, innerGraphB));
        innerGraphB.addNode(new Node(6, Color.RED, innerGraphB));
        innerGraphB.addNode(new Node(7, Color.BLUE, innerGraphB));
        innerGraphB.addNode(new Node(8, Color.RED, innerGraphB));
        innerGraphB.addNode(new Node(9, Color.GREEN, innerGraphB));

        // C
        innerGraphC.addNode(new Node(1, Color.RED, innerGraphC));
        innerGraphC.addNode(new Node(2, Color.RED, innerGraphC));
        innerGraphC.addNode(new Node(3, Color.BLUE, innerGraphC));
        innerGraphC.addNode(new Node(4, Color.RED, innerGraphC));
        innerGraphC.addNode(new Node(5, Color.GREEN, innerGraphC));
        innerGraphC.addNode(new Node(6, Color.BLUE, innerGraphC));
        innerGraphC.addNode(new Node(7, Color.RED, innerGraphC));
        innerGraphC.addNode(new Node(8, Color.GREEN, innerGraphC));
        innerGraphC.addNode(new Node(9, Color.YELLOW, innerGraphC));

        // D
        innerGraphD.addNode(new Node(1, Color.BLUE, innerGraphD));
        innerGraphD.addNode(new Node(2, Color.BLUE, innerGraphD));
        innerGraphD.addNode(new Node(3, Color.BLUE, innerGraphD));
        innerGraphD.addNode(new Node(4, Color.BLUE, innerGraphD));
        innerGraphD.addNode(new Node(5, Color.BLUE, innerGraphD));
        innerGraphD.addNode(new Node(6, Color.BLUE, innerGraphD));
        innerGraphD.addNode(new Node(7, Color.RED, innerGraphD));
        innerGraphD.addNode(new Node(8, Color.RED, innerGraphD));
        innerGraphD.addNode(new Node(9, Color.YELLOW, innerGraphD));

        // E
        innerGraphE.addNode(new Node(1, Color.GREEN, innerGraphE));
        innerGraphE.addNode(new Node(2, Color.GREEN, innerGraphE));
        innerGraphE.addNode(new Node(3, Color.BLUE, innerGraphE));
        innerGraphE.addNode(new Node(4, Color.RED, innerGraphE));
        innerGraphE.addNode(new Node(5, Color.YELLOW, innerGraphE));
        innerGraphE.addNode(new Node(6, Color.YELLOW, innerGraphE));
        innerGraphE.addNode(new Node(7, Color.GREEN, innerGraphE));
        innerGraphE.addNode(new Node(8, Color.GREEN, innerGraphE));
        innerGraphE.addNode(new Node(9, Color.YELLOW, innerGraphE));

        // F
        innerGraphF.addNode(new Node(1, Color.BLUE, innerGraphF));
        innerGraphF.addNode(new Node(2, Color.BLUE, innerGraphF));
        innerGraphF.addNode(new Node(3, Color.GREEN, innerGraphF));
        innerGraphF.addNode(new Node(4, Color.RED, innerGraphF));
        innerGraphF.addNode(new Node(5, Color.GREEN, innerGraphF));
        innerGraphF.addNode(new Node(6, Color.GREEN, innerGraphF));
        innerGraphF.addNode(new Node(7, Color.BLUE, innerGraphF));
        innerGraphF.addNode(new Node(8, Color.GREEN, innerGraphF));
        innerGraphF.addNode(new Node(9, Color.GREEN, innerGraphF));

        // G
        innerGraphG.addNode(new Node(1, Color.GREEN, innerGraphG));
        innerGraphG.addNode(new Node(2, Color.GREEN, innerGraphG));
        innerGraphG.addNode(new Node(3, Color.GREEN, innerGraphG));
        innerGraphG.addNode(new Node(4, Color.GREEN, innerGraphG));
        innerGraphG.addNode(new Node(5, Color.YELLOW, innerGraphG));
        innerGraphG.addNode(new Node(6, Color.GREEN, innerGraphG));
        innerGraphG.addNode(new Node(7, Color.GREEN, innerGraphG));
        innerGraphG.addNode(new Node(8, Color.YELLOW, innerGraphG));
        innerGraphG.addNode(new Node(9, Color.YELLOW, innerGraphG));

        // H
        innerGraphH.addNode(new Node(1, Color.YELLOW, innerGraphH));
        innerGraphH.addNode(new Node(2, Color.YELLOW, innerGraphH));
        innerGraphH.addNode(new Node(3, Color.YELLOW, innerGraphH));
        innerGraphH.addNode(new Node(4, Color.YELLOW, innerGraphH));
        innerGraphH.addNode(new Node(5, Color.GREEN, innerGraphH));
        innerGraphH.addNode(new Node(6, Color.GREEN, innerGraphH));
        innerGraphH.addNode(new Node(7, Color.YELLOW, innerGraphH));
        innerGraphH.addNode(new Node(8, Color.YELLOW, innerGraphH));
        innerGraphH.addNode(new Node(9, Color.BLUE, innerGraphH));

        // K
        innerGraphK.addNode(new Node(1, Color.YELLOW, innerGraphK));
        innerGraphK.addNode(new Node(2, Color.RED, innerGraphK));
        innerGraphK.addNode(new Node(3, Color.YELLOW, innerGraphK));
        innerGraphK.addNode(new Node(4, Color.YELLOW, innerGraphK));
        innerGraphK.addNode(new Node(5, Color.GREEN, innerGraphK));
        innerGraphK.addNode(new Node(6, Color.RED, innerGraphK));
        innerGraphK.addNode(new Node(7, Color.YELLOW, innerGraphK));
        innerGraphK.addNode(new Node(8, Color.BLUE, innerGraphK));
        innerGraphK.addNode(new Node(9, Color.RED, innerGraphK));

        // Add inner graph edges
        // A
        innerGraphA.addInnerEdge(innerGraphA.getNodeByNumber(1), innerGraphA.getNodeByNumber(2));
        innerGraphA.addInnerEdge(innerGraphA.getNodeByNumber(1), innerGraphA.getNodeByNumber(4));
        innerGraphA.addInnerEdge(innerGraphA.getNodeByNumber(3), innerGraphA.getNodeByNumber(6));
        innerGraphA.addInnerEdge(innerGraphA.getNodeByNumber(6), innerGraphA.getNodeByNumber(9));
        innerGraphA.addInnerEdge(innerGraphA.getNodeByNumber(7), innerGraphA.getNodeByNumber(8));

        // B
        innerGraphB.addInnerEdge(innerGraphB.getNodeByNumber(1), innerGraphB.getNodeByNumber(2));
        innerGraphB.addInnerEdge(innerGraphB.getNodeByNumber(5), innerGraphB.getNodeByNumber(6));

        // C
        innerGraphC.addInnerEdge(innerGraphC.getNodeByNumber(1), innerGraphC.getNodeByNumber(2));
        innerGraphC.addInnerEdge(innerGraphC.getNodeByNumber(1), innerGraphC.getNodeByNumber(4));
        innerGraphC.addInnerEdge(innerGraphC.getNodeByNumber(2), innerGraphC.getNodeByNumber(3));
        innerGraphC.addInnerEdge(innerGraphC.getNodeByNumber(4), innerGraphC.getNodeByNumber(7));
        innerGraphC.addInnerEdge(innerGraphC.getNodeByNumber(5), innerGraphC.getNodeByNumber(6));
        innerGraphC.addInnerEdge(innerGraphC.getNodeByNumber(5), innerGraphC.getNodeByNumber(8));

        // D
        innerGraphD.addInnerEdge(innerGraphD.getNodeByNumber(1), innerGraphD.getNodeByNumber(4));
        innerGraphD.addInnerEdge(innerGraphD.getNodeByNumber(2), innerGraphD.getNodeByNumber(3));

        // E
        innerGraphE.addInnerEdge(innerGraphE.getNodeByNumber(1), innerGraphE.getNodeByNumber(4));
        innerGraphE.addInnerEdge(innerGraphE.getNodeByNumber(2), innerGraphE.getNodeByNumber(3));
        innerGraphE.addInnerEdge(innerGraphE.getNodeByNumber(5), innerGraphE.getNodeByNumber(6));
        innerGraphE.addInnerEdge(innerGraphE.getNodeByNumber(7), innerGraphE.getNodeByNumber(8));
        innerGraphE.addInnerEdge(innerGraphE.getNodeByNumber(6), innerGraphE.getNodeByNumber(9));

        // F
        innerGraphF.addInnerEdge(innerGraphF.getNodeByNumber(1), innerGraphF.getNodeByNumber(2));
        innerGraphF.addInnerEdge(innerGraphF.getNodeByNumber(2), innerGraphF.getNodeByNumber(3));
        innerGraphF.addInnerEdge(innerGraphF.getNodeByNumber(3), innerGraphF.getNodeByNumber(6));
        innerGraphF.addInnerEdge(innerGraphF.getNodeByNumber(6), innerGraphF.getNodeByNumber(9));
        innerGraphF.addInnerEdge(innerGraphF.getNodeByNumber(7), innerGraphF.getNodeByNumber(8));

        // G
        innerGraphG.addInnerEdge(innerGraphG.getNodeByNumber(2), innerGraphG.getNodeByNumber(3));
        innerGraphG.addInnerEdge(innerGraphG.getNodeByNumber(4), innerGraphG.getNodeByNumber(5));
        innerGraphG.addInnerEdge(innerGraphG.getNodeByNumber(8), innerGraphG.getNodeByNumber(9));

        // H
        innerGraphH.addInnerEdge(innerGraphH.getNodeByNumber(1), innerGraphH.getNodeByNumber(2));
        innerGraphH.addInnerEdge(innerGraphH.getNodeByNumber(2), innerGraphH.getNodeByNumber(3));
        innerGraphH.addInnerEdge(innerGraphH.getNodeByNumber(4), innerGraphH.getNodeByNumber(7));
        innerGraphH.addInnerEdge(innerGraphH.getNodeByNumber(5), innerGraphH.getNodeByNumber(6));
        innerGraphH.addInnerEdge(innerGraphH.getNodeByNumber(8), innerGraphH.getNodeByNumber(9));

        // K
        innerGraphK.addInnerEdge(innerGraphK.getNodeByNumber(1), innerGraphE.getNodeByNumber(4));
        innerGraphK.addInnerEdge(innerGraphK.getNodeByNumber(4), innerGraphE.getNodeByNumber(7));
        innerGraphK.addInnerEdge(innerGraphK.getNodeByNumber(7), innerGraphE.getNodeByNumber(8));
        innerGraphK.addInnerEdge(innerGraphK.getNodeByNumber(8), innerGraphE.getNodeByNumber(9));

        // Add graphs of nodes to map
        innerGraphMap.put("A", innerGraphA);
        innerGraphMap.put("B", innerGraphB);
        innerGraphMap.put("C", innerGraphC);
        innerGraphMap.put("D", innerGraphD);
        innerGraphMap.put("E", innerGraphE);
        innerGraphMap.put("F", innerGraphF);
        innerGraphMap.put("G", innerGraphG);
        innerGraphMap.put("H", innerGraphH);
        innerGraphMap.put("K", innerGraphK);

        // Add outer edges
        // A
        outerEdgeList.add(new OuterEdge(innerGraphA, innerGraphB));
        outerEdgeList.add(new OuterEdge(innerGraphA, innerGraphC));
        outerEdgeList.add(new OuterEdge(innerGraphA, innerGraphD));
        // B
        outerEdgeList.add(new OuterEdge(innerGraphB, innerGraphD));
        outerEdgeList.add(new OuterEdge(innerGraphB, innerGraphF));
        outerEdgeList.add(new OuterEdge(innerGraphB, innerGraphK));
        // C
        outerEdgeList.add(new OuterEdge(innerGraphC, innerGraphD));
        outerEdgeList.add(new OuterEdge(innerGraphC, innerGraphE));
        // D
        outerEdgeList.add(new OuterEdge(innerGraphD, innerGraphF));
        // E
        outerEdgeList.add(new OuterEdge(innerGraphE, innerGraphF));
        outerEdgeList.add(new OuterEdge(innerGraphE, innerGraphG));
        // F
        outerEdgeList.add(new OuterEdge(innerGraphF, innerGraphH));
        // G
        outerEdgeList.add(new OuterEdge(innerGraphG, innerGraphH));
        // H
        outerEdgeList.add(new OuterEdge(innerGraphH, innerGraphK));
    }

    /**
     * Find and print the route from one node to another
     *
     * @param startNode     The node to start from
     * @param targetNode    The node to find
     */
    public void findRouteToNode(Node startNode, Node targetNode) {
        Set<Node> visited = new HashSet<>();
        LinkedList<Node> result = dfs(startNode, targetNode, visited);
        System.out.println("It took " + result.size() + " steps to find the target planet.");
        System.out.println("Path walked:");
        for(Node node : result) {
            System.out.println(node.getInnerGraph().getName() + node.getNumber());
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
            solution = new LinkedList<Node>();
            solution.add(startNode);
            return solution;
        } else {
            // If the start node is not the node we're looking for
            List<Node> neighbors = getNeighbors(startNode);
            for (Node neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    solution = dfs(neighbor, targetNode, visited);

                    if (solution.size() > 0) {
                        // If solution is not empty
//                        solution.addFirst(startNode);
                        solution.addLast(startNode);
                        return solution;
                    }
//                    if (solution.getLast().equals(targetNode)) {
//                        solution.addFirst(startNode);
//                        return solution;
//                    }
                }
            }
        }

        visited.remove(startNode);
        return new LinkedList<>();
    }

    /**
     * Find and return a list of neighboring nodes
     *
     * @param startNode The node to find neighbors for
     * @return A list of neighboring nodes
     */
    private ArrayList<Node> getNeighbors(Node startNode) {
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

            boolean canAdd = true;

            if (innerGraphs.containsValue(outerEdge.getGraph1()) || innerGraphs.containsValue(outerEdge.getGraph2())) {
                // Graph1 (A)
                if (outerEdge.getGraph1().getName().equals(startNode.getInnerGraph().getName())) {
                    // If it's A
                    Node potentionalNeighbor = outerEdge.getGraph2().getNodeByNumber(startNode.getNumber());

                    if(potentionalNeighbor.getColor().equals(startNode.getColor())) {
                        neighbors.add(potentionalNeighbor);
                    }
                } else {
                    Node potentionalNeighbor = outerEdge.getGraph1().getNodeByNumber(startNode.getNumber());

                    if(potentionalNeighbor.getColor().equals(startNode.getColor())) {
                        neighbors.add(potentionalNeighbor);
                    }

                }


                // Graph2 (D)



            }



//            if (innerGraphs.containsValue(outerEdge.getGraph1())) {
//                // Als innergraphs graph1 van outeredge bevat
//
//                // Save potentional neighbor
//                Node potentionalNeighbor = outerEdge.getGraph1().getNodeByNumber(startNode.getNumber());
//
//                for (Node node : neighbors) {
//                    if(node.equals(potentionalNeighbor)) {
//                        canAdd = false;
//                    }
//                }
//
//                if (potentionalNeighbor.getColor().equals(startNode.getColor()) && canAdd) {
//                    // Als graph1 een identieke node bevat
//                    // Sla deze dan op als neighbor
//                    neighbors.add(potentionalNeighbor);
//                }
//            } if (innerGraphs.containsValue(outerEdge.getGraph2())) {
//                // If innergraphs contains graph2 of outeredge
//
//                // Save potentional neighbor
//                Node potentionalNeighbor = outerEdge.getGraph2().getNodeByNumber(startNode.getNumber());
//
//                for (Node node : neighbors) {
//                    if(node.equals(potentionalNeighbor)) {
//                        canAdd = false;
//                    }
//                }
//
//                if(potentionalNeighbor.getColor().equals(startNode.getColor()) && canAdd) {
//                    // If graph2 contains an identical node
//                    // Add this node as neighbor
//                    neighbors.add(potentionalNeighbor);
//                }
//            }

//            if (innerGraphs.containsValue(outerEdge.getGraph1())) {
//                // If graph1 of OuterGraph is the graph containing the startnode
//                // Add graph2 node to neighbors
//                neighbors.add(outerEdge.getGraph1().getNodeByNumber(startNode.getNumber()));
////                innerGraphs.remove(outerEdge.getGraph1());
//            } else if (innerGraphs.containsValue(outerEdge.getGraph2())) {
//                // Same as above but now for graph2
//                neighbors.add(outerEdge.getGraph2().getNodeByNumber(startNode.getNumber()));
//            }
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

        for (Map.Entry<String, InnerGraph> item : getInnerGraphMap().entrySet()) {
            // Loop through the map of InnerGraphs

            // Keep searching in each InnerGraph unless we confirmed we need it or we're through it
            boolean keepSearching = true;

            for (InnerEdge innerEdge : item.getValue().getInnerEdgeList()) {
                // Loop through the innerEdges in the current InnerGraph

                if (innerEdge.getNode1().getNumber() == startNodeNumber && innerEdge.getNode1().getColor().equals(startNodeColor)) {
                    // If innerEdge's node1 is the node we're looking for
                    // Add the current InnerGraph to the innerGraphMap
                    innerGraphMap.put(item.getKey(), item.getValue());

                    // Stop searching because we've confirmed we need this innerGraph
                    keepSearching = false;
                } else if (innerEdge.getNode2().getNumber() == startNodeNumber && innerEdge.getNode2().getColor().equals(startNodeColor)) {
                    // Do the same as above but for node2
                    innerGraphMap.put(item.getKey(), item.getValue());
                    keepSearching = false;
                }
            }
        }
        return innerGraphMap;
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
}
