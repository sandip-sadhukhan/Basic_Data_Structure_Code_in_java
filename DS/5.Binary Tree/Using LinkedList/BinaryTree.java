import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root = null;

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

    public static Node searchData(Node root, int data){
        if(root == null) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node peek = q.peek();
            if(peek.left != null){
                q.offer(peek.left);
            }
            if(peek.right != null){
                q.offer(peek.right);
            }
            // match
            if(peek.data == data){
                return peek;
            }
            q.poll();
        }
        return null;

    }

    public void insert(Node root, int data){
        if(this.root == null){
            this.root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            // insert all child
            Node peek = q.peek();
            if(peek.left != null){
                q.offer(peek.left);
            }else {
                peek.left = new Node(data);
                return;
            }
            if(peek.right != null){
                q.offer(peek.right);
            }else {
                peek.right = new Node(data);
                return;
            }
            q.poll();
        }
    }

    public static void deleteNode(Node root, int data){
        Node searchedNode = searchData(root, data);
        Node deepestNode = null;

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
            q.poll();
            if(q.isEmpty()){
                deepestNode = peek;
            }
        }
        // data copy
        searchedNode.data = deepestNode.data;

        // delete the deepest node
        q.offer(root);
        while(!q.isEmpty()){
            // insert all child
            Node peek = q.peek();
            if(peek.left != null){
                if(peek.left == deepestNode){
                    peek.left = null;
                }else {
                    q.offer(peek.left);
                }
            }
            if(peek.right != null){
                if(peek.right == deepestNode){
                peek.right = null;
                }else {
                    q.offer(peek.right);
                }
            }
            q.poll();
        }
        
    }

    public Node reverse(Node root){
        if(root == null) return null;
        Node temp = root.left;
        root.left = reverse(root.right);
        root.right = reverse(temp);
        return root;
    }
    
    public static void main(String[] args) {
        // creation
        BinaryTree bt = new BinaryTree();
        
        // Insert manually
        // bt.root = new Node(20);
        // bt.root.left = new Node(100);
        // bt.root.right = new Node(3);
        // bt.root.left.left = new Node(50);
        // bt.root.left.right = new Node(15);
        // bt.root.right.left = new Node(250);
        // bt.root.right.right = new Node(35);
        // bt.root.left.left.left = new Node(222);

        // System.out.println("PREORDER TRAVERSAL");
        // preOrder(bt.root);
        // System.out.println("\n==========");
        // System.out.println("INORDER TRAVERSAL");
        // inOrder(bt.root);
        // System.out.println("\n==========");
        // System.out.println("POSTORDER TRAVERSAL");
        // postOrder(bt.root);
        // System.out.println("\n==========");
        // System.out.println("LEVELORDER TRAVERSAL");
        // levelOrder(bt.root);
        // System.out.println("\n==========");
        
        
        // System.out.println("Searching a data");
        // System.out.println(searchData(bt.root, 223));
        // System.out.println("\n==========");
        
        // System.out.println("Insert a data");
        // insert(bt.root, 200);
        // insert(bt.root, 400);
        // insert(bt.root, 500);
        // inOrder(bt.root);
        // System.out.println("\n==========");
        // System.out.println("delete data");
        // deleteNode(bt.root, 20);
        // levelOrder(bt.root);
        // System.out.println("\n==========");


        bt.insert(bt.root, 1);
        bt.insert(bt.root, 2);
        bt.insert(bt.root, 3);
        bt.insert(bt.root, 4);
        bt.insert(bt.root, 5);
        bt.insert(bt.root, 6);
        bt.insert(bt.root, 7);
        bt.insert(bt.root, 8);
        bt.insert(bt.root, 9);

        levelOrder(bt.root);
        System.out.println("\n==========");

        // Reverse
        bt.reverse(bt.root);
        levelOrder(bt.root);
        System.out.println("\n==========");

        
    }
}
