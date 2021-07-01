public class UsingLinkedList {
    Node head = null;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void push(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void pop(){
        if(head == null){
            System.out.println("Stack is Empty!");
            return;
        }
        head = head.next;
    }
    public int peek() {
        if(head == null){
            System.out.println("Stack is Empty!");
            return Integer.MIN_VALUE;
        }
        return head.data;
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void delete(){
        head = null;
    }
    public void traverse(){
        if(head == null){
            System.out.println("Stack is Empty.");
        }else {
            Node temp = head;
            System.out.println("Stack");
            System.out.println("======");
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.next;
            }
            System.out.println("======\n");
        }
    }
    public static void main(String[] args) {
        UsingLinkedList stack = new UsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.traverse();
        stack.pop();
        stack.pop();
        stack.traverse();
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        stack.delete();
        System.out.println(stack.isEmpty());
    }
}
