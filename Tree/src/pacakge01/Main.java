package pacakge01;

public class Main {
    public static void main(String [] args){

        //Tree with many Node
/*
        TreeArray tree = new TreeArray();
        tree.addroot(50);
        tree.addchild(40, 50);
        tree.addchild(20, 50);
        tree.addchild(90, 50);
        tree.addchild(33, 40);
        tree.addchild(77, 40);
        tree.addchild(109, 33);
        tree.addchild(456, 77);
        tree.addchild(4156, 109);
        tree.addchild(2456, 109);
        tree.addchild(4576, 109);
        tree.displayArrays();
*/
        //Binrary Tree
        /*
        BinaryTree tree = new BinaryTree();
        tree.addroot(50);
        tree.addLeftchild(4,50);
        tree.addRightChild(25, 50);

        tree.addLeftchild(5,4);
        tree.addRightChild(85, 4);

        tree.addLeftchild(7,25);
        tree.addRightChild(8, 25);

        tree.BFS();

        System.out.print(tree.sum_parent(2));


         */
        //Binary Search Tree
        BST bst = new BST();
        bst.addroot(100);
        bst.insert(20);
        bst.insert(45);
        bst.insert(120);
        bst.insert(15);
        bst.insert(35);

        //bst.DFS();
        System.out.println(bst.search(bst.root, 20));
        bst.deleteKey(20);

 //       System.out.println(bst.min());
          bst.DFS();
    }
}
