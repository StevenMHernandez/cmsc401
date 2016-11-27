// Steven Hernandez.
// Assignment 4.

import java.io.*; // imported for testing
import java.util.*;

public class cmsc401 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        // pass `file=true` to pull in data from a file instead of inputting the values by hand.
        if (args.length > 0 && args[0].equals("file=true")) {
            File file = new File("example_input.txt");
            in = new Scanner(file);
        }

        int cityCount = in.nextInt();
        int highwayCount = in.nextInt();

        DijkstraNode[] cities = new DijkstraNode[cityCount];
        cities[0] = new DijkstraNode(0);
        cities[1] = new DijkstraNode(0);

        for (int i = 0; i < cityCount - 2; i++) {
            cities[in.nextInt() - 1] = new DijkstraNode(in.nextInt());
        }

        for (int i = 0; i < highwayCount; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            int price = in.nextInt();

            cities[a].addPath(cities[b], price);
            cities[b].addPath(cities[a], price);
        }

        System.out.println(dijkstra(cities, 0, 1));
    }

    public static int dijkstra(DijkstraNode[] nodes, int from, int to) {
        nodes[from].total = 0;

        int whiteNodes = nodes.length;

        while (whiteNodes > 0) {
            int u = getClosestNode(nodes);

            nodes[u].done = true;

            for (DijkstraPath vertex : nodes[u].paths) {
                if (vertex.node.total > nodes[u].total + vertex.price + vertex.node.price) {
                    vertex.node.total = nodes[u].total + vertex.price + vertex.node.price;
                }
            }

            whiteNodes--;
        }

        return nodes[to].total;
    }

    private static int getClosestNode(DijkstraNode[] nodes) {
        int index = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].done && nodes[i].total <= min) {
                index = i;
                min = nodes[i].total;
            }
        }

        return index;
    }
}
