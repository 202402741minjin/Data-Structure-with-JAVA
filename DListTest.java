import java.util.NoSuchElementException;
public class DListTest {
    public static void main(String[] args) {
        DList<String> s = new DList<String>();

        s.insertAfter(s.head, "apple");
        s.insertBefore(s.tail, "orange");
        s.insertBefore(s.tail, "cherry");
        s.insertAfter(s.head.getNext(), "pear");
        s.print(); System.out.println();

        s.delete(s.tail.getPrevious());
        s.print(); System.out.println();

        s.insertBefore(s.tail, "grape");
        s.print(); System.out.println();
        s.delete(s.head.getNext()); s.print();
        System.out.println();
        s.delete(s.head.getNext()); s.print();
        System.out.println();
        s.delete(s.head.getNext()); s.print();
        System.out.println();
        s.delete(s.head.getNext()); s.print();
        System.out.println();
    }
}
class DList <E> {
    protected DNode head, tail;
    protected int size;
    public DList() {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    public void insertBefore(DNode p, E newItem) {
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    public void insertAfter(DNode p, E newItem) {
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);

        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    public void delete(DNode x) {
        if (x == null) throw new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if(isEmpty()) {
            System.out.println("리스트가 비어있음");
        }else{
            DNode i;
            for(i = head.getNext(); i != tail; i = i.getNext()){
                System.out.print(i.getItem() + " ");
            }
        }
    }

}

class DNode <E> {
    private E item;
    private DNode previous;
    private DNode next;
    public DNode(E newItem, DNode p, DNode q) { // 노드 생성자
        item = newItem;
        previous = p;
        next = q;
    }
    // get 메서드와 set 메서드
    public E getItem() { return item; }
    public DNode getPrevious() { return previous; }
    public DNode getNext() { return next; }
    public void setItem(E newItem) { item = newItem; }
    public void setPrevious(DNode p) { previous = p; }
    public void setNext(DNode q) {next = q; }
}
