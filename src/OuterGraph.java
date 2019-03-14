import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        innerGraphA.addNode(new Node(1, Color.RED));
        innerGraphA.addNode(new Node(2, Color.BLUE));
        innerGraphA.addNode(new Node(3, Color.YELLOW));
        innerGraphA.addNode(new Node(4, Color.RED));
        innerGraphA.addNode(new Node(5, Color.RED));
        innerGraphA.addNode(new Node(6, Color.YELLOW));
        innerGraphA.addNode(new Node(7, Color.RED));
        innerGraphA.addNode(new Node(8, Color.RED));
        innerGraphA.addNode(new Node(9, Color.YELLOW));

        // B
        innerGraphB.addNode(new Node(1, Color.RED));
        innerGraphB.addNode(new Node(2, Color.RED));
        innerGraphB.addNode(new Node(3, Color.YELLOW));
        innerGraphB.addNode(new Node(4, Color.YELLOW));
        innerGraphB.addNode(new Node(5, Color.RED));
        innerGraphB.addNode(new Node(6, Color.RED));
        innerGraphB.addNode(new Node(7, Color.BLUE));
        innerGraphB.addNode(new Node(8, Color.RED));
        innerGraphB.addNode(new Node(9, Color.GREEN));

        // C
        innerGraphC.addNode(new Node(1, Color.RED));
        innerGraphC.addNode(new Node(2, Color.RED));
        innerGraphC.addNode(new Node(3, Color.BLUE));
        innerGraphC.addNode(new Node(4, Color.RED));
        innerGraphC.addNode(new Node(5, Color.GREEN));
        innerGraphC.addNode(new Node(6, Color.BLUE));
        innerGraphC.addNode(new Node(7, Color.RED));
        innerGraphC.addNode(new Node(8, Color.GREEN));
        innerGraphC.addNode(new Node(9, Color.YELLOW));

        // D
        innerGraphD.addNode(new Node(1, Color.BLUE));
        innerGraphD.addNode(new Node(2, Color.BLUE));
        innerGraphD.addNode(new Node(3, Color.BLUE));
        innerGraphD.addNode(new Node(4, Color.BLUE));
        innerGraphD.addNode(new Node(5, Color.BLUE));
        innerGraphD.addNode(new Node(6, Color.BLUE));
        innerGraphD.addNode(new Node(7, Color.RED));
        innerGraphD.addNode(new Node(8, Color.RED));
        innerGraphD.addNode(new Node(9, Color.YELLOW));

        // E
        innerGraphE.addNode(new Node(1, Color.GREEN));
        innerGraphE.addNode(new Node(2, Color.GREEN));
        innerGraphE.addNode(new Node(3, Color.BLUE));
        innerGraphE.addNode(new Node(4, Color.RED));
        innerGraphE.addNode(new Node(5, Color.YELLOW));
        innerGraphE.addNode(new Node(6, Color.YELLOW));
        innerGraphE.addNode(new Node(7, Color.GREEN));
        innerGraphE.addNode(new Node(8, Color.GREEN));
        innerGraphE.addNode(new Node(9, Color.YELLOW));

        // F
        innerGraphF.addNode(new Node(1, Color.BLUE));
        innerGraphF.addNode(new Node(2, Color.BLUE));
        innerGraphF.addNode(new Node(3, Color.GREEN));
        innerGraphF.addNode(new Node(4, Color.RED));
        innerGraphF.addNode(new Node(5, Color.GREEN));
        innerGraphF.addNode(new Node(6, Color.GREEN));
        innerGraphF.addNode(new Node(7, Color.BLUE));
        innerGraphF.addNode(new Node(8, Color.GREEN));
        innerGraphF.addNode(new Node(9, Color.GREEN));

        // G
        innerGraphG.addNode(new Node(1, Color.GREEN));
        innerGraphG.addNode(new Node(2, Color.GREEN));
        innerGraphG.addNode(new Node(3, Color.GREEN));
        innerGraphG.addNode(new Node(4, Color.GREEN));
        innerGraphG.addNode(new Node(5, Color.YELLOW));
        innerGraphG.addNode(new Node(6, Color.GREEN));
        innerGraphG.addNode(new Node(7, Color.GREEN));
        innerGraphG.addNode(new Node(8, Color.YELLOW));
        innerGraphG.addNode(new Node(9, Color.YELLOW));

        // H
        innerGraphH.addNode(new Node(1, Color.YELLOW));
        innerGraphH.addNode(new Node(2, Color.YELLOW));
        innerGraphH.addNode(new Node(3, Color.YELLOW));
        innerGraphH.addNode(new Node(4, Color.YELLOW));
        innerGraphH.addNode(new Node(5, Color.GREEN));
        innerGraphH.addNode(new Node(6, Color.GREEN));
        innerGraphH.addNode(new Node(7, Color.YELLOW));
        innerGraphH.addNode(new Node(8, Color.YELLOW));
        innerGraphH.addNode(new Node(9, Color.BLUE));

        // K
        innerGraphK.addNode(new Node(1, Color.YELLOW));
        innerGraphK.addNode(new Node(2, Color.RED));
        innerGraphK.addNode(new Node(3, Color.YELLOW));
        innerGraphK.addNode(new Node(4, Color.YELLOW));
        innerGraphK.addNode(new Node(5, Color.GREEN));
        innerGraphK.addNode(new Node(6, Color.RED));
        innerGraphK.addNode(new Node(7, Color.YELLOW));
        innerGraphK.addNode(new Node(8, Color.BLUE));
        innerGraphK.addNode(new Node(9, Color.RED));

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


}
