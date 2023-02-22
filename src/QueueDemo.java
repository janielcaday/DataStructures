//
//
////TODO: implementation of a queue using an integer array
//// - enqueue
//// - dequeue
//// - peek
//// - show
//// - size
//// - isEmpty
//// - isFull
//
//class Queue{
//
//    int queue[] = new int[5];
//    int size;
//    int head;
//    int tail;
//
//    public void enqueue(int data){
//        if(!isFull()){
//            queue[tail] = data;
//            tail = (tail+1)%5;
//            size++;
//        }
//        else{
//            System.out.println("Queue is full!");
//        }
//
//    }
//
//    public int dequeue(){
//        int data = queue[head];
//        if(!isEmpty()){
//            queue[head] = 0;
//            head = (head+1)%5;
//            size--;
//        }
//        else{
//            System.out.println("Queue is empty!");
//        }
//
//
//        return data;
//    }
//
//    public void show(){
//        for(int i = 0; i < queue.length; i++){
//            System.out.print(queue[(head+i)%5] + " ");
//        }
//        System.out.println();
//    }
//
//    public void clear(){
//        for(int i = 0; i < queue.length; i++){
//            queue[i] = 0;
//        }
//        head = 0;
//        tail = 0;
//        size = 0;
//    }
//
//    public boolean isEmpty(){
//        return size == 0;
//    }
//
//    public boolean isFull(){
//        return size == 5;
//    }
//
//    public int size(){
//        return size;
//    }
//}
//
//public class QueueDemo {
//    public static void main(String[] args){
//        Queue nums = new Queue();
//        nums.enqueue(5);
//        nums.enqueue(3);
//        nums.enqueue(6);
//        nums.enqueue(7);
//        nums.show();
//
//        nums.dequeue();
//        nums.show();
//
//        nums.enqueue(6);
//        nums.enqueue(7);
//        nums.show();
//    }
//}

import java.util.LinkedList;

class Queue<T>{

    private static final int CAPACITY = 5;
    public int len = 5;
    private Object[] data;
    public int size;
    public int head;
    public int tail;

    public Queue(){
        this.data = new Object[CAPACITY];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public Queue(int capacity){
        this.data = new Object[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }
    public void enqueue(T element){
        if(isFull()){
            expand();
        }

        this.data[size++] = element;

    }

    public T dequeue(){
        T ans = (T)data[head];

        if(!isEmpty()){
            data[head] = null;
            size--;
            rearrange();
            reduce();
        }

        return ans;
    }

    private void rearrange(){
        Object newQueue[] = new Object[data.length];
        int j = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] != null){
                newQueue[j] = data[i];
                j++;
            } else {
                newQueue[j] = null;
            }
        }
        data = newQueue;
    }
    public void clear(){
        data = new Object[size];
    }

    public T getElement(int index){
        T t = (T)data[index];
        return t;
    }

    public int find(T element){
        for(int i = 0; i < size; i++){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean isFull(){
        return size == data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public String toString(){
        String text = "[";

        if(!isEmpty()){
            text += data[0];
        }

        for(int i = 1; i < size; i++){
            text += ", " + data[i];
        }

        text += "]";

        return text;
    }
    private void expand(){
        int length = size();
        len += CAPACITY;
        Object newStack[] = new Object[len];
        System.arraycopy(data, 0, newStack, 0, length);
        data = newStack;
    }

    private void reduce(){
        int diff = data.length - size;
        if(diff > CAPACITY){
            int length = size();
            len -= CAPACITY;
            Object newStack[] = new Object[len];
            System.arraycopy(data, 0, newStack, 0, length);
            data = newStack;
        }

    }
}

public class QueueDemo {
    public static void main(String[] args){
        Queue<Integer> integerQueue = new Queue<>();

        integerQueue.enqueue(15);
        integerQueue.enqueue(8);
        integerQueue.enqueue(10);
        integerQueue.enqueue(13);
        integerQueue.enqueue(3);

        System.out.println(integerQueue.toString());

        integerQueue.dequeue();
        System.out.println(integerQueue.toString());
    }
}
