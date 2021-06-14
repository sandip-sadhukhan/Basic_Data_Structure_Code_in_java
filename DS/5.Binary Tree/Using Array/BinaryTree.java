public class BinaryTree {
    int[] arr;
    int lastUsedIndex = 0;
    BinaryTree(int size){
        arr = new int[size + 1]; // coz 0th index will be 0 always
    }
    public void insert(int data){
        if(lastUsedIndex >= arr.length - 1){
            System.out.println("Binary Tree is Full.");
        }else {
            lastUsedIndex++;
            arr[lastUsedIndex] = data;
        }
    }
    public void levelOrder(){
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
    public void preOrder(int index){
        if(index>lastUsedIndex) return;
        else{
            System.out.print(arr[index]+", ");
            preOrder(index*2); // left
            preOrder(index*2+1); // right
        }
    }
    public void inOrder(int index){
        if(index>lastUsedIndex) return;
        else{
            inOrder(index*2); // left
            System.out.print(arr[index]+", ");
            inOrder(index*2+1); // right
        }
    }
    public void postOrder(int index){
        if(index>lastUsedIndex) return;
        else{
            postOrder(index*2); // left
            postOrder(index*2+1); // right
            System.out.print(arr[index]+", ");
        }
    }
    public boolean search(int data){
        for (int i = 1; i <= lastUsedIndex; i++) {
            if(arr[i] == data){
                return true;
            }
        }
        return false;
    }
    public void deleteNode(int data){
        for (int i = 1; i <= lastUsedIndex; i++) {
            if(arr[i] == data){
                // data found
                if(i != lastUsedIndex){
                    arr[i] = arr[lastUsedIndex];
                    lastUsedIndex--;
                }
            }
        }
        System.out.println(data + " Not Found");
    }
    public void deleteTree(){
        arr = null;
    }
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(10);
        bt.insert(20);
        bt.insert(100);
        bt.insert(3);
        bt.insert(50);
        bt.insert(15);
        bt.insert(250);
        bt.insert(35);
        bt.insert(222);
        
        System.out.println("Level Order Traversal");
        bt.levelOrder();
        System.out.println("\n==========");
        
        System.out.println("Pre Order Traversal");
        bt.preOrder(1);
        System.out.println("\n==========");
        
        System.out.println("In Order Traversal");
        bt.inOrder(1);
        System.out.println("\n==========");
        
        System.out.println("Post Order Traversal");
        bt.postOrder(1);
        System.out.println("\n==========");
        
        bt.deleteNode(3);
        System.out.println("Level Order Traversal");
        bt.levelOrder();
        System.out.println("\n==========");
    }
}