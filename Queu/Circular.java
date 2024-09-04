package Java.Queu;

public class Circular {
    static class Queu{
        static int arr[];
        static int size;
        static int front;
        static int rear;

        Queu(int n){
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
            
            //last el delete
            if(rear == front){
                rear = front = -1;
            }
            else{
                front = (front +1 ) % size;
            }
            return result;
        }

        //peek
        public static int peek(){
            if(isEmpty()){
                System.out.println("Empty queue");
                return -1;
            }
            return arr[front];
        }

    }
    public static void main(String args []){
        Queu q = new Queu(5);
        q.add(1);
        q.add(2);
        q.add(3);
        //  System.out.println(q.remove());
        // q.add(4);
        // System.out.println(q.remove());
        // q.add(5);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
