import java.util.NoSuchElementException;

public class CListTest {
    public static void main(String[] args) {
        CList<String> s = new CList<String>();

        s.insert("pear"); s.insert("cherry");
        s.insert("orange"); s.insert("apple");
        s.print();
        System.out.print(" : s의 길이 = " + s.size() + "\n");

        s.delete();
        s.print();
        System.out.print(" : s의 길이 = " + s.size() + "\n");
    }
}

class CList <E> {
    private Node last;
    private int size;
    public CList() {
        last = null;
        size = 0;
    }

    public void insert(E newItem) {
        Node newNode = new Node(newItem, null);
        if(last == null) {
            newNode.setNext(newNode);
            last = newNode;
        }else{
            newNode.setNext(last.getNext());
            last.setNext(newNode);
        }
        size++;
    }

    public Node delete() {
        if(isEmpty()) throw new NoSuchElementException();
        Node x = last.getNext();
        if(x == last)
            last = null;
        else{
            last.setNext(x.getNext());
            x.setNext(null);
        }
        size--;
        return x;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if(isEmpty())
            System.out.println("배열이 비어 있음.");
        else{
            Node p = last.getNext();
            for(int i = 0; i < size; i++){
                System.out.print(p.getItem() + " ");
                p = p.getNext();
            }
        }
    }

    public int size() {
        return size;
    }
}