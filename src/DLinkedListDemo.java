class DLLNode {
    public int data;
    public DLLNode prev, next;
}
class DLinkedList {
    private int size;
    private DLLNode head;
    private DLLNode tail;

    public DLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public void insert(int data){
        DLLNode current = this.head;
        DLLNode node = new DLLNode();
        node.data = data;

        if(this.head == null){
            this.head = node;
            this.head.next = null;
            this.head.prev = null;
        }
        else{
            while(current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
            node.next = null;
        }
        this.size++;
    }

    public void insertFirst(int data){
        DLLNode node = new DLLNode();
        node.data = data;
        node.prev = null;
        node.next = this.head;
        this.head = node;
        size++;
    }

    public void insertAt(int index, int data){

        if(index > this.size){
            System.out.println("Error. Index out of bounds!");
        }
        else if(index == 0){
            insertFirst(data);
        }
        else{
            DLLNode current = this.head;
            int counter = 0;
            DLLNode node = new DLLNode();
            node.data = data;
            while(counter < index-1){
                current = current.next;
                counter++;
            }
            node.next = current.next;
            node.prev = current;
            current.next = node;
            this.size++;
        }
    }

    public void delete(){
        if(head == null){
            System.out.println("Error. List is already empty!");
        }
        else{
            DLLNode current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current = current.prev;
            current.next = null;
            this.size--;
        }
    }

    public void deleteFirst() {
        if(head != null){
            this.head = this.head.next;
            size--;
        }
        else{
            System.out.println("Error. List is already empty!");
        }
    }

    public void deleteAt(int index){
        if(index > this.size){
            System.out.println("Error. Index out of bounds");
        }
        else if(index == 0){
            deleteFirst();
        }
        else if(index == this.size-1){
            delete();
        }
        else{
            int counter = 0;
            DLLNode current = this.head;
            while(counter < index){
                current = current.next;
                counter++;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            size--;
        }
    }

    public void printList(){
        DLLNode current = this.head;

        while(current != null){
            System.out.print(" <-" + current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public int size(){
        return this.size;
    }
}

public class DLinkedListDemo {
    public static void main(String[] args) {
        DLinkedList list = new DLinkedList();

        list.insert(5);
        list.insert(7);
        list.insert(8);
        list.printList();
        System.out.println(list.size());

        list.delete();
        list.printList();

        list.insertFirst(8);
        list.printList();

        list.insertAt(2, 3);
        list.printList();

        list.deleteFirst();
        list.printList();

        list.deleteAt(1);
        list.printList();
    }
}
