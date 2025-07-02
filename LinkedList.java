@SuppressWarnings("rawtypes")
public class LinkedList<AnyType extends Comparable> {
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

    public static <AnyType extends Comparable> void printList(LinkedList<AnyType> list){
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

    
    // Sum of linked list elements
    public int sum(){
        int sum = 0;
        ListNode<AnyType> node = header.next;
        while (node != null) {
            sum += (int) node.element;
            node = node.next;
        }
        return sum;
    }

    // Size of linked list
    public int size(){
        int size = 0;
        ListNode<AnyType> node = header.next;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    // Find element at k index
    public AnyType elementAtK(int k) {
        if (k < 0 || k > size()-1) {
            return null;
        }

        ListNode<AnyType> node = header.next;
        int count = 0;

        while (count != k) {
            node = node.next;
            count++;
        }
        
        return node.element;
    }

    // remove method without iterator
    public void removeWithoutIterator(AnyType x) {
        ListNode<AnyType> node = header;
        while (node.next != null) {
            if (node.next.element.equals(x)) {
                node.next = node.next.next;
                return;
            }
            node = node.next;
        }
    }

    // add a node with value k in j position
    public void addAtJ(AnyType k, int j) {
        if (j < 0 || j > size()) {
            System.out.println("Invalid position");
            return;
        }
        ListNode<AnyType> node = header;
        int count = 0;
        while (count != j) {
            node = node.next;
            count++;
        }
        node.next = new ListNode<AnyType>(k, node.next);
    }

    // number of elements between two positions (complicated version)
    public int countBetween(int i, int j) {
        if (i < 0 || i > size()-1 || j < 0 || j > size()-1) {
            throw new IndexOutOfBoundsException("Illegal Arguments.");
        }

        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }

        int count = 0;
        ListNode<AnyType> node = header.next;
        while (count != i) {
            node = node.next;
            count++;
        }
        count = 0;

        while (i != j-1) {
            node = node.next;
            count++;
            i++;
        }

        return count;
    }

    // method for moving max value node in the beginning and min value node in the end
    @SuppressWarnings("unchecked")
    public void moveMaxToBeginningAndMinToEnd() {
        if (header.next == null) {
            return;
        }
        ListNode<AnyType> node = header.next;
        AnyType min = node.element;
        AnyType max = node.element;
        node = node.next;
        while (node != null) {
            if (node.element.compareTo(max) > 0) {
                max = node.element;
            }
            if (node.element.compareTo(min) < 0) {
                min = node.element;
            }
            node = node.next;
        }
        node = header;

        //move max to beginning
        node.next = new ListNode<AnyType>(max, node.next);
        node = node.next;

        //remove the max and min duplicates of the list and move min to end
        while (node.next != null) {
            if (node.next.element.equals(max)) {
                node.next = node.next.next;
                continue;
            }
            if (node.next.element.equals(min)) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
        node.next = new ListNode<AnyType>(min);
    }

    // remove all elements which are part of the other list
    public void removeElementsOfOtherList(LinkedList<AnyType> otherList) {
        ListNode<AnyType> node = header;
        while (node.next != null) {
            boolean deleted = false;
            ListNode<AnyType> temp = otherList.header.next;
            while (temp != null) {
                if (temp.element.equals(node.next.element)) {
                    node.next = node.next.next;
                    deleted = true;
                    break;
                }
                temp = temp.next;
            }
            if (!deleted)
                node = node.next;
        }
    }
}
