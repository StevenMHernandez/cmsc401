public class DijkstraPath {
    public DijkstraNode node;

    public int price = 0;

    public DijkstraPath(DijkstraNode node, int price) {
        this.node = node;
        this.price = price;
    }
}
