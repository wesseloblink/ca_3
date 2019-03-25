public class Main {

    public static void main(String[] args) {
        // TODO: Everything
        // Set up universe
        OuterGraph starsystem = new OuterGraph();

        starsystem.findRouteToNode(starsystem.getInnerGraphMap().get("F").getNodeByNumber(6),
                starsystem.getInnerGraphMap().get("C").getNodeByNumber(1));

        starsystem.findRouteToNode(starsystem.getInnerGraphMap().get("D").getNodeByNumber(7),
                starsystem.getInnerGraphMap().get("D").getNodeByNumber(8));

        starsystem.findRouteToNode(starsystem.getInnerGraphMap().get("K").getNodeByNumber(3),
                starsystem.getInnerGraphMap().get("A").getNodeByNumber(3));
    }
}
