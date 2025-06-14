public class DoublyLinkedList<AnyType> {
    private DoublyListNode<AnyType> header;
    private DoublyListNode<AnyType> trailer;

    public DoublyLinkedList() {
        header = new DoublyListNode<AnyType>(null);
        trailer = new DoublyListNode<AnyType>(null);
        header.next = trailer;
        trailer.prev = header;
    }

    public boolean isEmpty() {
        return header.next == trailer;
    }

    public void makeEmpty() {
        header.next = trailer;
    }

    public void addLast(AnyType x) {
        DoublyListNode<AnyType> newNode = new DoublyListNode<AnyType>(x, trailer.prev, trailer);
        trailer.prev.next = newNode;
        trailer.prev = newNode;
    }

    public void printList() {
        if (header.next == trailer) {
            System.out.println("List is empty");
        } else {
            DoublyListNode<AnyType> node = header.next;
            while (node != trailer) {
                System.out.print(node.element + " ");
                node = node.next;
            }
        }
        System.out.println();
    }
}
