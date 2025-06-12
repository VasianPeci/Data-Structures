public class LinkedListIterator<AnyType> {
    public ListNode<AnyType> current;

    public LinkedListIterator(ListNode<AnyType> node){
        this.current = node;
    }

    public boolean isValid(){
        return current != null;
    }

    public AnyType retrieve(){
        return isValid() ? current.element : null;
    }

    public void advance(){
        if(isValid())   this.current = this.current.next;
    }

}
