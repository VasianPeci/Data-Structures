public class DoublyListNode<AnyType> {
    public AnyType element;
    public DoublyListNode<AnyType> prev;
    public DoublyListNode<AnyType> next;

    public DoublyListNode(AnyType element) {
        this(element, null, null);
    }

    public DoublyListNode(AnyType element, DoublyListNode<AnyType> prev, DoublyListNode<AnyType> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }
}