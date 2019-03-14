public class InnerEdge {
    private Node node1;
    private Node node2;

    public InnerEdge(Node start, Node end) {
        this.node1 = start;
        this.node2 = end;
    }

    public Node getNode1() {
        return node1;
    }

    public Node getNode2() {
        return node2;
    }
}
