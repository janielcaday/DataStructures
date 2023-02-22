import java.util.Arrays;

//TODO: implementation of a stack using an integer array

class Stack<T>{

    private static final int CAPACITY = 5;

    private Object[] data;

    private int top;

    public Stack(){
        this.data = new Object[CAPACITY];
        this.top = 0;
    }

    public Stack(int capacity){
        this.data = new Object[capacity];
        this.top = 0;
    }

    void push(T element){
        if(isFull()){
            expand();
        }

        this.data[top++] = element;
    }

    public void pop(){
        if(isEmpty()){
            System.out.println("Error. Stack is already empty");
        } else {
            data[top-1] = null;
            top--;
            reduce();
        }
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("Error. Stack is already empty");
        }
        return (T)data[top-1];
    }

    int size(){
        return top;
    }


    public void clear(){
        data = new Object[top];
    }

    public T getElement(int index){
        T t = (T)data[index];
        return t;
    }

    public int find(T element){
        for(int i = 0; i < top; i++){
            if(data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    public boolean isFull(){
        return top == data.length;
    }

    public boolean isEmpty(){
        return top <= 0;
    }

    public String toString(){
        String text = "[";

        if(!isEmpty()){
            text += data[0];
        }

        for(int i = 1; i < top; i++){
            text += ", " + data[i];
        }

        text += "]";

        return text;
    }

    private void expand(){
        int length = size();
        Object newStack[] = new Object[top + CAPACITY];
        System.arraycopy(data, 0, newStack, 0, length);
        data = newStack;
    }

    private void reduce(){
        int diff = data.length - top;
        if(diff > CAPACITY){
            int length = size();
            Object newStack[] = new Object[top - CAPACITY];
            System.arraycopy(data, 0, newStack, 0, length);
            data = newStack;
        }

    }

}


public class StackDemo {

    public static void main(String[] args){
        Stack<Integer> intStck = new Stack<>();
        intStck.push(15);
        intStck.push(8);
        intStck.push(10);
        intStck.push(13);
        intStck.push(3);
        intStck.push(14);
        System.out.println(intStck.toString());

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Chloe");
        stringStack.push("Mia");
        stringStack.push("Rachel");
        stringStack.push("Kiko");
        stringStack.push("Ronan");
        System.out.println(stringStack.toString());
    }
}
