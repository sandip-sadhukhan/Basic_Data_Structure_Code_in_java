public class Array {
    int arr[];
    Array(int size){
        arr = new int[size];
    }
    void traverse(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
    void deletion(int index){
        arr[index] = Integer.MIN_VALUE; // means deleted
    }
    int search(int data){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == data){
                return i;
            }
        }
        return -1;
    }
    void update(int index, int data){
        arr[index] = data;
    }
    public static void main(String[] args) {
        Array arr = new Array(5);
        arr.update(0,10);
        arr.update(1,20);
        arr.update(2,30);
        arr.traverse();
        arr.deletion(0);
        arr.traverse();
        System.out.println(arr.search(20));
        System.out.println(arr.search(50));
    }
}