public class UsingLinkedList{
    Node head=null, tail=null;
    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void enQueue(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void deQueue(){
        if(isEmpty()){
            System.out.println("Queue is Empty.");
        }else {
            // if there is only one element
            if(head == tail){
                head = null;
                tail = null;
            }else {
                head = head.next;
            }
        }
    }
    public int peek(){
        return head.data;
    }
    public void traverse(){
        if(isEmpty()){
            System.out.println("Queue is Empty.");
        }else {
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data + ", ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        UsingLinkedList queue = new UsingLinkedList();
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.traverse();
        queue.deQueue();
        queue.deQueue();
        queue.traverse();
    }
}