package Java.Queu;

public class Circular {
    static class Queue{
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queue(int n){
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }

        public static boolean isEmpty(){
            return rear == -1 && front ==-1;
        }

        public static boolean isFull(){
            return (rear +1 ) % size == front;
        }

        public static void add(int data){
            if(isFull()){
                System.out.println("Queu is full");
                return;
            }
            if(front == -1){
                front = 0;
            }
            rear = (rear +1)  % size;
            arr[rear] = data;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            int result = arr[front];
            front = (front +1 ) % size;
            //last el delete
            if(rear == front){
                rear = front = -1;
            }
            else{
                front = (front +1 ) % size;
            }
            return result;
        }


    }
}
