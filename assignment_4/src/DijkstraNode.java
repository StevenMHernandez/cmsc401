import java.util.ArrayList;

public class DijkstraNode {
    public int price = 0;

    public int total = Integer.MAX_VALUE;

    public boolean done = false;

    public ArrayList<DijkstraPath> paths = new ArrayList<DijkstraPath>();

    public DijkstraNode(int price) {
        this.price = price;
    }

    public void addPath(DijkstraNode node, int price) {
        this.paths.add(new DijkstraPath(node, price));
    }
}
