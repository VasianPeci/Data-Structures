public class DoublyLinkedListIterator<AnyType> {
    public DoublyListNode<AnyType> current;

    public DoublyLinkedListIterator() {
        current = null;
    }

    public DoublyLinkedListIterator(DoublyListNode<AnyType> node) {
        current = node;
    }

    public boolean isValid() {
        return current != null;
    }

    public AnyType retrieve() {
        return isValid() ? current.element : null;
    }

    public void advance() {
        if (isValid()) {
            current = current.next;
        }
    }

    public void previous() {
        if (isValid()) {
            current = current.prev;
        }
    }
}
