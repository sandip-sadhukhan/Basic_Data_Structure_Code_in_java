public class UsingArray {
    int[] arr;
    int rear, front;

    UsingArray(int size) {
        arr = new int[size];
        rear = -1;
        front = -1;
    }

    public boolean isEmpty() {
        return (rear == -1 || rear < front);
    }

    public boolean isFull() {
        return (rear == arr.length - 1);
    }

    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Full.");
        } else {
            if (front == -1) {
                front++;
            }
            rear++;
            arr[rear] = data;
        }
    }

    public void deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            front++;
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i] + ", ");
            }
            System.out.println();
        }
    }

    public void deleteQueue() {
        front = -1;
        rear = -1;
    }

    public static void main(String[] args) {
        UsingArray queue = new UsingArray(5);
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.traverse();
        queue.deQueue();
        queue.deQueue();
        queue.traverse();
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(10);
        queue.enQueue(10);
        queue.enQueue(10);
        queue.enQueue(10);
        queue.enQueue(20);
        queue.enQueue(30);
        queue.enQueue(40);
        queue.deleteQueue();
        System.out.println(queue.isEmpty());
    }
}
