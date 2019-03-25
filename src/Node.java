import java.util.LinkedList;
import java.util.List;

public class Node {
    private int number;
    private Color color;
    private InnerGraph innerGraph;

    public Node(int number, Color color, InnerGraph innerGraph) {
        this.number = number;
        this.color = color;
        this.innerGraph = innerGraph; // For debugging purposes
    }




    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    public InnerGraph getInnerGraph() {
        return innerGraph;
    }
}
