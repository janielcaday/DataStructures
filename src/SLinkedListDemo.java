import java.util.ArrayList;

//
//class SLLNode<T> {
//    public T data;
//    public SLLNode next;
//
//}
//class SLinkedList {
//    private int size;
//    private SLLNode head;
//
//    public SLinkedList() {
//        this.size = 0;
//        this.head = null;
//    }
//
//    public void insert(int data){
//        SLLNode node = new SLLNode();
//        node.data = data;
//        SLLNode current = this.head;
//
//        if(this.head == null){
//            this.head = node;
//            this.head.next = null;
//        }
//        else {
//            while (current.next != null) {
//                current = current.next;
//            }
//            current.next = node;
//            node.next = null;
//        }
//        this.size++;
//    }
//
//    public void insertAt(int index, int data){
//        SLLNode node = new SLLNode();
//        node.data = data;
//        SLLNode current = this.head;
//
//        if(index > this.size-1){
//            System.out.println("Error. Index out of bounds.");
//        }
//        else if(index == 0){
//            insertFirst(data);
//        }
//        else{
//            int counter = 0;
//            SLLNode prevNode = new SLLNode();
//            while(counter < index-1){
//                current = current.next;
//                counter++;
//            }
//            node.next = current.next;
//            current.next = node;
//            this.size++;
//        }
//    }
//
//    void insertFirst(int data){
//        SLLNode node = new SLLNode();
//        node.data = data;
//        node.next = this.head;
//        this.head = node;
//        size++;
//    }
//
//    public void delete(){
//        SLLNode current = this.head;
//
//        if(this.size == 0){
//            System.out.println("Error. Index out of bounds");
//        }
//        else{
//            SLLNode prevNode = null;
//            while(current.next != null){
//                prevNode = current;
//                current = current.next;
//            }
//            prevNode.next = null;
//            this.size--;
//        }
//    }
//
//    public void deleteAt(int index){
//        SLLNode current = this.head;
//        SLLNode prevNode = new SLLNode();
//
//        if(index > this.size-1){
//            System.out.println("Error. Index out of bounds!");
//        }
//        else if(index == 0){
//            deleteFirst();
//        }
//        else{
//            int counter = 0;
//            while(counter < index){
//                prevNode = current;
//                current = current.next;
//                counter++;
//            }
//            prevNode.next = current.next;
//            this.size--;
//        }
//    }
//
//    void deleteFirst(){
//        if(head != null){
//            this.head = this.head.next;
//            size--;
//        }
//        else{
//            System.out.println("Error. Linked List is empty!");
//        }
//    }
//
//    public void printList(){
//        SLLNode current = this.head;
//        while(current != null){
//            System.out.print(current.data + "-> ");
//            current = current.next;
//        }
//        System.out.println();
//    }
//
//    public int size(){
//        return this.size;
//    }
//
//    public boolean exists(int data){
//        SLLNode current = this.head;
//        while(current != null){
//            if(current.data.equals(data)){
//                return true;
//            }
//            else{
//                current = current.next;
//            }
//        }
//        return false;
//    }
//}
//public class SLinkedListDemo {
//    public static void main(String[] args){
//        SLinkedList list = new SLinkedList();
//
//        list.insert(1);
//        list.insert(3);
//        list.insert(8);
//
//        list.printList();
////        System.out.println(list.size());
//
//        list.delete();
//        list.printList();
////        System.out.println(list.size());
//
//        list.insert(8);
//        list.printList();
////        System.out.println(list.size());
//        list.insertAt(0, 4);
//        list.printList();
//        System.out.println(list.size());
//
//        list.deleteAt(1);
//        list.printList();
//
//        System.out.println("has 3? " + list.exists(3));
//
//    }
//}
class SLLNode<T> implements Comparable<T>{
    T data;
    public SLLNode<T> next;

    public SLLNode(){
        this.data = null;
        this.next = null;
    }
    public SLLNode(T element){
        this.data = element;
        this.next = null;
    }

    @Override
    public int compareTo(T element) {
        if(element == this.data){
            return 0;
        } else {
            return 1;
        }
    }
}
class SLinkedList<T>{
    private int size;
    private SLLNode head;
    private SLLNode tail;

    public void add(T element){
        SLLNode<T> node = new SLLNode<T>();
        node.data = element;
        if(head == null){
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void add(int index, T element){
        SLLNode<T> current = head;
        SLLNode<T> node = new SLLNode<T>(element);
        int counter = 0;
        while(counter < index-1){
            current = current.next;
            counter++;
        }
        node.next = current.next;
        current.next = node;
        size++;
    }

    public void addFirst(T element){
        SLLNode<T> node = new SLLNode<>(element);
        node.next = head;
        head = node;
        size++;
    }

    public boolean removeFirst(){
        if(!isEmpty()){
            SLLNode<T> current = head;
            head = current.next;
            size--;
            return true;
        }
        return false;
    }

    public boolean removeAt(int index){
        if(!isEmpty()){
            SLLNode<T> current = head;
            int counter = 0;
            while(counter < index-1){
                current = current.next;
                counter++;
            }
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }

    public boolean removeLast(){
        if(!isEmpty()){
            SLLNode<T> current = head;
            SLLNode<T> prev = null;
            while(current.next != null){
                prev = current;
                current = current.next;
            }
            if(current.next == null){
                prev.next = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public boolean remove(T element){
        SLLNode<T> current = head;
        SLLNode<T> prev = null;
        while(!current.data.equals(element)){
            prev = current;
            current = current.next;
        }
        if(current.data.equals(element)){
            prev.next = current.next;
            size--;
            return true;
        }

        return false;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public String toString(){
        SLLNode<T> current = head;
        String text = "";
        while(current != null){
            text += current.data + "-> ";
            current = current.next;
        }
        return text;
    }
}
public class SLinkedListDemo{
    public static void main(String[] args) {
        SLinkedList<Integer> list1 = new SLinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(6);
        list1.add(4);
        list1.add(13);
        System.out.println(list1.toString());
    }

}