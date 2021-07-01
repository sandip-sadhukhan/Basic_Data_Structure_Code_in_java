import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left=null, right=null;
    Node(int data){
        this.data = data;
    }
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
public class BinarySearchTree{
    Node root = null;

    public Node search(Node root, int value){
        if(root == null) return null;
        else if(root.data == value){
            return root;
        }else if(root.data > value){
            System.out.print(root.left + "-->");
            return search(root.left, value);
        }else{
            System.out.print(root.right + "-->");
            return search(root.right, value);
        }
    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data + ", ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data + ", ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + ", ");
    }
    public static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            // insert all child
            Node peek = q.peek();
            if(peek.left != null){
                q.offer(peek.left);
            }
            if(peek.right != null){
                q.offer(peek.right);
            }
            System.out.print(q.poll().data+", ");
        }
    }
    public Node insert(Node curr, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(curr == null){
            Node newNode = new Node(data);
            curr = newNode;
        }else if(data <= curr.data){
            curr.left = insert(curr.left, data);
        }else {
            curr.right = insert(curr.right, data);
        }
        return curr;
    }
    public static Node findMin(Node root){
        if(root == null) return null;
        if(root.left != null){
            return findMin(root.left);
        }else {
            return root;
        }
    }
    public static Node deleteNode(Node root, int data){
        if(root == null) return null;
        if(data < root.data){
            root.left = deleteNode(root.left, data);
        }else if(data>root.data){
            root.right = deleteNode(root.right, data);
        }else {
            //this node need to be deleted
            if(root.left != null && root.right != null){ // has both child
                Node minNode = findMin(root.right);
                root.data = minNode.data;
                root.right = deleteNode(root.right, root.data);
            }else if(root.left != null){ // has only left child
                return root.left;
                
            }else if (root.right != null){ // has only right child
                return root.right;

            }else { // has no child
                return null;
            }
        }

        return root;
    }
    public static void main(String[] args) {
        BinarySearchTree bt = new BinarySearchTree();
        
        // insert data manually
        bt.insert(bt.root, 100);
        bt.insert(bt.root, 80);
        bt.insert(bt.root, 200);
        bt.insert(bt.root, 70);
        bt.insert(bt.root, 90);
        bt.insert(bt.root, 150);
        bt.insert(bt.root, 300);
        bt.insert(bt.root, 50);
        bt.insert(bt.root, 250);
        bt.insert(bt.root, 400);
        bt.insert(bt.root, 40);
        bt.insert(bt.root, 60);

        
        // System.out.println(bt.search(bt.root, 15));

        System.out.println("PREORDER TRAVERSAL");
        preOrder(bt.root);
        System.out.println("\n==========");
        System.out.println("INORDER TRAVERSAL");
        inOrder(bt.root);
        System.out.println("\n==========");
        System.out.println("POSTORDER TRAVERSAL");
        postOrder(bt.root);
        System.out.println("\n==========");
        System.out.println("LEVELORDER TRAVERSAL");
        levelOrder(bt.root);
        System.out.println("\n==========");

        System.out.println("Delete");
        // deleteNode(bt.root, 150);
        // deleteNode(bt.root, 200);
        deleteNode(bt.root, 100);
        levelOrder(bt.root);
        System.out.println("\n==========");


    }
}