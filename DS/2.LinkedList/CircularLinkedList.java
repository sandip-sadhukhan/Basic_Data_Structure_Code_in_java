public class CircularLinkedList {
    Node head = null;

    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void append(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }else {
            Node temp = head;
            temp = temp.next;
            if(temp == head){
                // only 1 element present 
                // we have to append position 2
                head.next = newNode;
                newNode.next = head;
            }
            while(temp.next!=head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            newNode.next = head;
        }else {
            Node prevHead = head;
            newNode.next = head;
            head = newNode;
            Node temp = head;
            do{
                temp = temp.next;
            }while(temp.next!=prevHead);
            temp.next = head;
        }
    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("LL Empty");
        }else {
            if(head.next == head){
                // only one element
                head = null;
            }else {
                Node prevHead = head;
                head = head.next;
                Node temp = head;
                do{
                    temp = temp.next;
                }while(temp.next!=prevHead);
                temp.next = head;
            }
        }
    }
    public void deleteEnd(){
        if(head == null){
            System.out.println("LL Empty");
        }else {
            Node ptr = head;
            Node preptr = null;
            while(ptr.next != head){
                preptr = ptr;
                ptr = ptr.next;
            }
            if(preptr == null){
                // only contain 1 element
                head = null;
            }else {
                preptr.next = head;
            }

        }
    }
    public void traverse(){
        if(head == null){
            System.out.println("LL empty");
        }else {
            Node temp = head;
            do{
                System.out.print(temp.data+"-->");
                temp = temp.next;
            }while(temp!=head);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.append(50);
        list.traverse();
        list.deleteEnd();
        list.deleteEnd();
        list.deleteFirst();
        list.traverse();
        list.deleteFirst();
        list.deleteFirst();
        // list.deleteFirst();
        list.traverse();
    }
}
