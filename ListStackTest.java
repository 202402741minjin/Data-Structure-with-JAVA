import java.util.EmptyStackException;

public class ListStackTest {
    public static void main(String[] args) {
        ListStack<String> stack = new ListStack<String>();

        stack.push("apple");
        stack.push("orange");
        stack.push("cherry");
        System.out.println(stack.peek());

        stack.push("pear");
        stack.print();
        stack.pop();
        System.out.println(stack.peek());
        stack.push("grape");
        stack.print();
    }
}

class Node<E> {
    private E item;
    private Node<E> next;
    public Node(E newItem, Node<E> node) {
        item = newItem;
        next = node;
    }
    public E getItem() { return item; }
    public Node<E> getNext() { return next; }
    public void setItem(E newItem) { item = newItem; }
    public void setNext(Node<E> newNext) { next = newNext; }
}

class ListStack <E> {
    private Node<E> top;
    private int size;
    public ListStack() {
        top = null;
        size = 0;
    }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E peek() {
        if(isEmpty()) throw new EmptyStackException();
        return top.getItem();
    }

    public void push(E newItem) {
        Node newNode = new Node(newItem, top); //리스트 앞부분에 삽입
        top = newNode;
        size++;
    }

    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        E topItem = top.getItem();
        top = top.getNext();
        size--;
        return topItem;
    }

    public void print() {
        if(isEmpty())
            System.out.println("리스트 비어있음.");
        else{
            for(Node p = top; p != null; p = p.getNext()){
                System.out.print(p.getItem() + " ");
            }
            System.out.println();
        }
    }
}