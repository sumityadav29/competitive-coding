package leetcode;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class LCode133 {
    public static void main(String[] args) {
        Node node = new Node();
        cloneGraph(node);
    }

    private static Map<Node, List<Node>> graphToAdjacencyList(Node node) {
        Map<Node, List<Node>> adj = new HashMap<>();
        Map<Node, Boolean> visited = new HashMap<>();

        List<Node> bfs = new ArrayList<>();
        bfs.add(node);
        int i = 0;
        while (i < bfs.size()) {
            Node curr = bfs.get(i);
            i++;
            if (visited.containsKey(curr)) {
                continue;
            }

            visited.put(curr, true);

            if (!adj.containsKey(curr)) {
                adj.put(curr, new ArrayList<>());
            }

            for (Node neighbour : curr.neighbors) {
                adj.get(curr).add(neighbour);
                bfs.add(neighbour);
            }
        }
        return adj;
    }

    private static Node adjListToGraph(Map<Node, List<Node>> adj, Node head) {
        Map<Node, Node> nodeClones = new HashMap<>();
        for (Node node : adj.keySet()) {
            if (!nodeClones.containsKey(node)) {
                nodeClones.put(node, new Node(node.val));
            }
            for (Node neighbour : node.neighbors) {
                if (!nodeClones.containsKey(neighbour)) {
                    nodeClones.put(neighbour, new Node(neighbour.val));
                }
            }
        }

        for (Map.Entry<Node, List<Node>> entry : adj.entrySet()) {
            for (Node neighbour : entry.getValue()) {
                nodeClones.get(entry.getKey()).neighbors.add(nodeClones.get(neighbour));
            }
        }

        return nodeClones.get(head);
    }

    private static void printGraph(Node head) {
        Map<Node, Boolean> visited = new HashMap<>();
        List<Node> bfs = new ArrayList<>();
        bfs.add(head);

        for (int i = 0 ; i < bfs.size() ; i++) {
            Node curr = bfs.get(i);
            if (visited.containsKey(curr)) {
                continue;
            }

            visited.put(curr, true);

            StringBuilder sb = new StringBuilder().append(curr.val).append(" -> ");
            for(Node neighbour : curr.neighbors) {
                sb.append(neighbour.val).append(", ");
                bfs.add(neighbour);
            }
            System.out.println(sb);
        }
    }

    private static void printNeighbours(Node node) {
        for (Node neighbour : node.neighbors) {
            System.out.println(neighbour.val);
        }
    }

    public static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, List<Node>> adj = graphToAdjacencyList(node);
        return adjListToGraph(adj, node);
    }
}
