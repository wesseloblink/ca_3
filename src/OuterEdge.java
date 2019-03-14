public class OuterEdge {
    private InnerGraph graph1;
    private InnerGraph graph2;

    public OuterEdge(InnerGraph graph1, InnerGraph graph2) {
        this.graph1 = graph1;
        this.graph2 = graph2;
    }

    public InnerGraph getGraph1() {
        return graph1;
    }

    public InnerGraph getGraph2() {
        return graph2;
    }
}
