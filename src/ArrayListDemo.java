class DynamicArrayList<T>{
    private static final int CAPACITY = 5;
    private Object[] data;
    private int size;

    //Default constructor to create empty list with capacity of 10
    public DynamicArrayList(){
        this.data = new Object[CAPACITY];
        this.size = 0;
    }

    public DynamicArrayList(int capacity){
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void add(T element){
        if (isFull()) {
            expand();
        }

        this.data[size++] = element;
    }

    public void add(int index, T element){
        Object tempArray[] = new Object[++size];

        int i = 0;
        while(i < index) {
            tempArray[i] = data[i];
            i++;
        }
        tempArray[i] = element;

        for(int j = index+1; j < tempArray.length; j++){
            tempArray[j] = data[j-1];
        }

        data = new Object[tempArray.length];

        for(int a = 0; a < size; a++){
            data[a] = tempArray[a];
        }
    }

    public boolean remove(T element){
        int index = -1;
        for(int i = 0; i < size; i++){
            if(data[i].equals(element)){
                index = i;
            }
        }

        if (index >= 0){
            for(int i = index; i < size-1; i++){
                data[i] = data[i+1];
            }
            size--;
            reduce();
        }
        return false;
    }

    public void removeFirst(){
        if (!isEmpty()) {
            for(int i = 0; i < size-1; i++){
                data[i] = data[i+1];
            }
            size--;
            reduce();
        }
    }

    public void removeLast(){
        if(!isEmpty()){
            data[size-1] = null;
            size--;
            reduce();
        }
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == data.length;
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
        Object tempArr[] = new Object[size];
        for(int i = 0; i < size; i++){
            tempArr[i] = data[i];
        }

        data = new Object[size + CAPACITY];

        for(int i = 0; i < size; i++){
            data[i] = tempArr[i];
        }
    }

    private void reduce(){
        int diff = data.length - size;
        if(diff > CAPACITY){
            Object tempArr[] = new Object[size];
            for(int i = 0; i < size; i++){
                tempArr[i] = data[i];
            }

            data = new Object[size - CAPACITY];

            for(int i = 0; i < size; i++){
                data[i] = tempArr[i];
            }

        }
    }
}

public class ArrayListDemo {
    public static void main(String[] args) {
        DynamicArrayList<Integer> intList = new DynamicArrayList<>();
        intList.add(4);
        intList.add(13);
        intList.add(3);
        intList.add(7);
        intList.add(14);
        intList.add(38);
        System.out.println(intList.toString());


        DynamicArrayList<String> strList = new DynamicArrayList<>();
        strList.add("Chloe");
        strList.add("Mia");
        strList.add("Rachel");
        strList.add("Kiko");
        strList.add("Ronan");
        System.out.println(strList.toString());

        strList.add(1, "Caday");
        System.out.println(strList.toString());
    }
}
