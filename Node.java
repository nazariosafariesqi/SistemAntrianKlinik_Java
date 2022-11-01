public class Node<T> {

    Node next;
    AntrianKlinik data = new AntrianKlinik();

    public Node(AntrianKlinik data, Node<T> next) {
        this.data = data;
        this.next = next;
    }
}
