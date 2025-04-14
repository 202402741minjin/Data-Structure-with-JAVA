import java.util.EmptyStackException;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<String>();

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
class ArrayStack<E> {
    private E s[];
    private int top;
    public ArrayStack() {
        s = (E[]) new Object[1];
        top = -1;
    }

    public int size() { return top+1; }
    public boolean isEmpty() { return (top == -1); }

    public void print() {
        if(isEmpty())
            System.out.println("배열 비어있음.");
        for(int i = 0; i < size(); i++) {
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
    public E peek() {
        if(isEmpty()) throw new EmptyStackException();
        return s[top];
    }

    private void resize(int newSize) {
        E[] t = (E[]) new Object[newSize];
        for(int i = 0; i < size(); i++)
            t[i] = s[i];
        s = t;
    }

    public void push(E newItem) {
        if(size() == s.length)
            resize(2*s.length);
        s[++top] = newItem; //top를 하나 증가시키고 새 item을 넣어주는 과정을 한번에 진행.
    }

    public E pop() {
        if(isEmpty()) throw new EmptyStackException();
        E item = s[top]; //임시로 top 자리에 있는 원소 담아두기
        s[top--] = null; //top 자리 null로 만든 뒤, top 하나 감소
        if(size() > 0 && size() == s.length/4)
            resize(s.length/2);
        return item;
    }
}