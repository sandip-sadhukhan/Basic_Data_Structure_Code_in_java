public class LinkedList {
    // Head element that refers to the first node
    Node Head;

    // Node Class
    class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data){
        Node newNode = new Node(data);

        // if the head is null
        // then head element will be the data
        if(this.Head == null){
            this.Head = newNode;
        }else {
            // traverse to null
            Node temp = this.Head;
            while(temp.next != null){
                temp = temp.next;
            }
            // now temp is the last element
            // add data at the end
            temp.next = newNode;
        }
    }

    public void traverse(){

        if(this.Head == null){
            System.out.println("Linked List is empty");
            return;
        }

        Node temp = this.Head;
        // traverse through last element
        while(temp != null){
            // print the data
            System.out.print(temp.data);
            // if last element then dont print the arrow
            if(temp.next != null){
                System.out.print(" --> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);

        newNode.next = this.Head;
        this.Head = newNode;
    }

    public void insertAt(int data, int position){

        if(position <=0){
            System.out.println("Invalid Location. Location cannot be less than zero.");
            return;
        }
        else if(position == 1){
            this.insertFirst(data);
            return;
        }

        // Here take the position starting from 1 not 0
        // if the position is 3 then 3rd element will be the data
        Node temp = this.Head;
        for(int i=1;i<=position-2;i++){
            if(temp == null){
                // not enough element
                System.out.println("LinkedList Bounce Error.");
                return;
            }
            temp = temp.next; // traverse
        }
        // now join
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public int search(int data){

        // traverse through start to end
        Node temp = this.Head;
        int position = 1;
        while(temp != null){
            if(temp.data == data){
                return position;
            }
            position++;
            temp = temp.next;
        }

        return -1;
    }

    public void deleteFirst(){
        if(this.Head == null){
            System.out.println("No element so can't delete");
            return;
        }
        this.Head = this.Head.next;
    }

    public void deleteLast() {
        if(this.Head == null){
            System.out.println("No element so can't delete");
            return;
        }

        // traverse to the end
        Node temp = this.Head;
        // second last element will be temp
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteAt(int position){
        if(position <=0){
            System.out.println("Invalid Location. Location cannot be less than zero.");
            return;
        }
        else if(position == 1){
            this.deleteFirst();
            return;
        }

        // traverse through the previous position
        Node temp = this.Head;
        for(int i=1;i<=position-2;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    public void delete(){
        this.Head = null;
    }

    public static void main(String[] args) {
        // creation
        LinkedList list = new LinkedList();
        
        // Append
        list.append(10);
        list.append(30);
        list.append(20);

        // insert first
        list.insertFirst(40);
        list.insertFirst(50);

        // insert middle
        list.insertAt(60, 4);
        list.insertAt(70, 10); // give java bounce error coz not enough element
        list.insertAt(80, 7); // insert last
        list.insertAt(90, 1); // insert first


        // Traverse
        list.traverse();
        
        // Search
        System.out.println("Search 70: "+ list.search(70));
        System.out.println("Search 60: "+ list.search(60));
        
        // Delete
        list.deleteFirst();
        list.deleteLast();

        list.traverse();
        
        list.deleteAt(3);
        list.traverse();
        
        // delete link list
        list.delete();
        list.traverse();
    }
}