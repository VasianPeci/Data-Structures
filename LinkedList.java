public class LinkedList<AnyType> {
    private ListNode<AnyType> header;

    public LinkedList(){
        this.header = new ListNode<AnyType>(null);
    }

    public boolean isEmpty(){
        return header.next == null;
    }

    public void makeEmpty(){
        header.next = null;
    }

    public LinkedListIterator<AnyType> zeroth(){
        return new LinkedListIterator<AnyType>(header);
    }

    public LinkedListIterator<AnyType> first(){
        return new LinkedListIterator<AnyType>(header.next);
    }

    public static <AnyType> void printList(LinkedList<AnyType> list){
        if(list.isEmpty()){
            System.out.println("List is empty!");
        } else{
            LinkedListIterator<AnyType> itr = list.first();
            System.out.print("[");
            while (itr.isValid()) {
                System.out.print(itr.retrieve() + " ");
                itr.advance();
            }
            System.out.print("]");
        }
    }

    public LinkedListIterator<AnyType> find(AnyType x){
        ListNode<AnyType> node = header.next;
        while(node != null && !node.element.equals(x)){
            node = node.next;
        }
        return new LinkedListIterator<AnyType>(node);
    }

    public void remove(AnyType x){
        LinkedListIterator<AnyType> itr = findPrevious(x);
        if(itr.isValid()){
            itr.current.next = itr.current.next.next;
        }
    }

    public LinkedListIterator<AnyType> findPrevious(AnyType x){
        ListNode<AnyType> node = header;
        while(node.next != null && !node.next.element.equals(x)){
            node = node.next;
        }
        if (node.next == null) {
            return new LinkedListIterator<AnyType>(null);
        }
        return new LinkedListIterator<AnyType>(node);
    }

    public void insert(AnyType x, LinkedListIterator<AnyType> p){
        if(p != null && p.isValid()){
            p.current.next = new ListNode<AnyType>(x, p.current.next);;
        }
    }
}
