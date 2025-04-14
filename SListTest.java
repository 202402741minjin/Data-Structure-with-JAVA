import java.util.NoSuchElementException;

public class SListTest {
    public static void main(String[] args) {
        SList<String> s = new SList<String>();
        s.insertFront("orange"); s.insertFront("apple");
        s.insertAfter("cherry", s.head.getNext());
        s.insertFront("pear");

        s.print();
        System.out.println(": s의 길이 = " + s.size());
        System.out.println("체리가 \t" + s.search("cherry")+"번째에 있다.");
        System.out.println("키위가 \t" + s.search("kiwi")+"번째에 있다. \n");
        s.deleteAfter(s.head);
        s.print();
        System.out.println(": s의 길이 = " + s.size());
        System.out.println();
        s.deleteFront(); s.print();
        System.out.println(": s의 길이 = " + s.size());
        System.out.println();

        SList<Integer> t = new SList<Integer>();
        t.insertFront(500); t.insertFront(200);
        t.insertAfter(400, t.head);
        t.insertFront(100);
        t.insertAfter(300, t.head.getNext());
        t.print();
        System.out.println(": t의 길이 = " + t.size());
    }
}

class Node <E> {
    private E item;
    private Node<E> next; //Node 객체는 항목을 저장할 item과 Node 레퍼런스를 저장하는 next 생성
    public Node(E newItem, Node<E> node){ //생성자의 파라미터로 넣어주기
        item = newItem; //item 변수에 파라미터로 받은 newItem 넣기
        next = node; //next 변수에 파라미터로 받은 node 넣기
    }
    // get과 set 메소드들
    public E getItem() {return item;}
    public Node<E> getNext() {return next;}
    public void setItem(E newItem) {item = newItem;}
    public void setNext(Node<E> newNext) { next = newNext; }
}


class SList <E> {
    protected Node head; //(S값)연결 리스트의 첫 노드 가리킴.
    private int size;
    public SList() { //연결 리스트 생성자. 빈 리스트를 먼저 객체로 만들어 초기화 시켜줌.
        head = null;
        size = 0;
    }

    public int search(E target) {
        Node p = head; //첫번째 노드의 주소를 p에 복사
        for(int k = 0; k < size; k++) {
            if (target == p.getItem()) return k;
            //내가 찾으려고 했던 것(target)과 p.getItem 한 것이 같다면 몇 번째 노드에서 찾은 건지 k값을 반환.
            p = p.getNext(); //계속 다음 것을 p에 복사(한칸 전진하고 그 값을 p에 저장하는 것)
        }
        return -1; //탐색을 실패하면 -1 반환
    } //target 을 찾을 때까지 or 리스트를 다 돌았을 때까지

    public void insertFront(E newItem) {
        head = new Node(newItem, head);
        size++; // 하나 추가했으니까 사이즈 하나 늘려주기
    }

    public void insertAfter(E newItem, Node p) {
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    public void deleteFront() {
        if(size == 0) throw new NoSuchElementException();
        head = head.getNext(); //head 뒤에 있는 노드 건너 뛰고 그 다음 노드의 주소를 불러옴.
        size--;
    }

    public void deleteAfter(Node p) {
        if (p == null) throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }

    public void print() {
        Node p = head;
        for(p = head; p != null; p = p.getNext()){
            System.out.print(p.getItem() + " ");
        }
    }

    public int size() {
        return size;
    }
}