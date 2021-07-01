public class UsingArray {
    int arr[];
    int top;
    UsingArray(int size){
        arr = new int[size];
        top = -1;
    }
    public void push(int data){
        if(top >= arr.length-1){
            System.out.println("Array Already Full");
            return;
        }
        arr[++top] = data;
    }
    public void pop(){
        if(top<0){
            System.out.println("Array Empty.");
            return;
        }
        top--;
    }
    public int peek(){
        if(top<0){
            System.out.println("Array Empty.");
            return Integer.MIN_VALUE; // null
        }
        return arr[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull() {
        return top == arr.length -1;
    }
    public void deleteStack() {
        top = -1;
    }
    public void traverse(){
        System.out.println("Stack");
        System.out.println("======");
        for(int i=top;i>=0;i--){
            System.out.println(arr[i]);
        }
        System.out.println("======\n");
    }
    public static void main(String[] args) {
        UsingArray stack = new UsingArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack.isFull());
        stack.traverse();
        stack.pop();
        stack.pop();
        System.out.println(stack.isFull());
        stack.traverse();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.isEmpty());
        
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.traverse();
        stack.deleteStack();
        stack.traverse();
    }
}
