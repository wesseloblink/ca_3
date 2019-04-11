import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class DataProvider {

    public DataProvider() {
        // Default constructor
    }

    /**
     * Read data from json file and instantiate objects accordingly
     * @param outerGraph Instance of the outerGraph class, to be updated with objects
     * @param fileName   The file (e.g. input.json) to be used
     * @throws NullPointerException Thrown in case of incorrect or missing file
     */
    public void readFromFile(OuterGraph outerGraph, String fileName) throws NullPointerException {
        // Get JSON file
        InputStream is = getClass().getResourceAsStream(fileName);
        if (is == null) {
            throw new NullPointerException("Cannot find file " + fileName);
        }

        // Parse file to jsonObj
        JSONTokener tokener = new JSONTokener(is);
        JSONObject jsonObj = new JSONObject(tokener);

        // Get JSONArrays from jsonObj
        JSONArray solarSystems = jsonObj.getJSONArray("solarsystems");
        JSONArray outerConns = jsonObj.getJSONArray("outerconnections");
        JSONArray innerConns = jsonObj.getJSONArray("innerconnections");

        for (int i = 0; i < solarSystems.length(); i++) {
            // For each object in solarSystems
            // Get Solar System as JSONObject
            JSONObject solarSystem = (JSONObject) solarSystems.get(i);

            // Get Solar System's nodes as JSONArray
            JSONArray nodes = solarSystem.getJSONArray("nodes");

            // Create InnerGraph and fill it with nodes
            outerGraph.getInnerGraphMap().put(solarSystem.getString("name"), makeInnerGraph(solarSystem, nodes));
        }

        for (int i = 0; i < outerConns.length(); i++) {
            // For each object in outerConns
            // Get Outer Connection as JSONObject
            JSONObject outerConn = (JSONObject) outerConns.get(i);

            // Create instances of InnerGraphs based on the outerConn object
            InnerGraph firstInnerGraph = outerGraph.getInnerGraphMap().get(outerConn.getString("firstsystem"));
            InnerGraph secondInnerGraph = outerGraph.getInnerGraphMap().get(outerConn.getString("secondsystem"));

            // Create new outerEdge object using above instances
            OuterEdge outerEdge = new OuterEdge(firstInnerGraph, secondInnerGraph);

            // Add the outerEdge to the list
            outerGraph.getOuterEdgeList().add(outerEdge);
        }

        for (int i = 0; i < innerConns.length(); i++) {
            // For each object in innerConns
            // Get Inner Connection as JSONObject
            JSONObject innerConn = (JSONObject) innerConns.get(i);

            // Get the innerGraph to add to
            InnerGraph innerGraph = outerGraph.getInnerGraphMap().get(innerConn.getString("solarsystem"));

            // Create instances of Nodes to add in innerGraph
            Node firstNode = innerGraph.getNodeByNumber(innerConn.getInt("firstnode"));
            Node secondNode = innerGraph.getNodeByNumber(innerConn.getInt("secondnode"));

            // Add the nodes to innerGraph
            innerGraph.addInnerEdge(firstNode, secondNode);
        }
    }

    /**
     * Create InnerGraph object from supplied resources
     * @param solarSystem The SolarSystem to base it on
     * @param nodes       The nodes to fill it with
     * @return InnerGraph object
     */
    private InnerGraph makeInnerGraph(JSONObject solarSystem, JSONArray nodes) {
        // Create InnerGraph object instance of solarSystem
        InnerGraph innerGraph = new InnerGraph(solarSystem.getString("name"));

        for (int i = 0; i < nodes.length(); i++) {
            // For each node in solarSystem

            // Create JSONObject object instance of node
            JSONObject node = nodes.getJSONObject(i);

            // Instantiate variables to save later
            int nodeNumber = node.getInt("number");
            String nodeStringColor = node.getString("color");

            // Create Node object instance of node
            Node nodeToInsert = new Node(nodeNumber, getNodeColor(nodeStringColor), innerGraph);

            // Add the node to the innerGraph
            innerGraph.addNode(nodeToInsert);
        }
        return innerGraph;
    }

    /**
     * Return color object for node
     * @param nodeColorString String to check
     * @return Color object
     */
    private Color getNodeColor(String nodeColorString) {
        Color nodeColor;

        switch (nodeColorString) {
            case "RED":
                nodeColor = Color.RED;
                break;
            case "GREEN":
                nodeColor = Color.GREEN;
                break;
            case "BLUE":
                nodeColor = Color.BLUE;
                break;
            default:
                nodeColor = Color.YELLOW;
                break;
        }
        return nodeColor;
    }
}
