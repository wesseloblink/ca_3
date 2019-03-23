public class Main {

    public static void main(String[] args) {
        // TODO: Everything
        // Set up universe
        OuterGraph starsystem = new OuterGraph();

        starsystem.getInnerGraphMap().get("A").getNodeByNumber(1);
        starsystem.getInnerGraphMap().get("A").getNodeByNumber(2);

        starsystem.findRouteToNode(starsystem.getInnerGraphMap().get("D").getNodeByNumber(7),
                starsystem.getInnerGraphMap().get("D").getNodeByNumber(8));

    }
}
