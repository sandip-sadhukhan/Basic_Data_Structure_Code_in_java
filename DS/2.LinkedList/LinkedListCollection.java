import java.util.LinkedList;

public class LinkedListCollection {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
    
        list.add(10);
        list.add(20);
        list.add(40);

        System.out.println(list);
        
        list.removeLast();
        
        System.out.println(list);
        
    }
    

    

}
