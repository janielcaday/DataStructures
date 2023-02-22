class BTNode {
    int value;
    BTNode left;
    BTNode right;

    BTNode(int value){
        this.value = value;
        left = null;
        right = null;
    }
}
class BSTree {
    private BTNode root;

    public void insert(int value){
        recurseInsert(value, root);
    }

    public void recurseInsert(int value, BTNode node){
        BTNode current = node;
        BTNode toInsert = new BTNode(value);
        if (this.root == null){
            this.root = toInsert;
        }
        else if(value <= current.value){
            if(current.left == null){
                current.left = toInsert;
            }
            else {
                recurseInsert(value, current.left);
            }
        }
        else if(value > current.value){
            if(current.right == null){
                current.right = toInsert;
            }
            else {
                recurseInsert(value, current.right);
            }
        }
    }

    public void printInOrder(){
        traverseInOrder(this.root);
    }

    private void traverseInOrder(BTNode node){
        if(node != null){
            traverseInOrder(node.left);
            System.out.print(node.value + "\t");
            traverseInOrder(node.right);
        }
    }

    public void printPreOrder(){
        traversePreOrder(this.root);
    }

    private void traversePreOrder(BTNode node){
        if(node != null){
            System.out.print(node.value + "\t");
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void printPostOrder(){
        traversePostOrder(this.root);
    }

    private void traversePostOrder(BTNode node){
        if(node != null){
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(node.value + "\t");
        }
    }

    //TODO: Level-order

    //TODO: Self-balancing binary search tree

    //TODO: RedBlack tree
}

public class BTreeDemo {
    public static void main(String[] args) {
        BSTree tree = new BSTree();

        tree.insert(32);
        tree.insert(42);
        tree.insert(12);
        tree.insert(39);
        tree.insert(8);
        tree.insert(50);
        tree.insert(46);
        tree.insert(46);

        tree.printInOrder();

        System.out.println();
        tree.printPreOrder();

        System.out.println();
        tree.printPostOrder();
    }
}


