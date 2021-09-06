package pacakge01;

import java.util.*;

public class BinaryTree {
   class Node {
       int data;
       Node left;
       Node right;

       Node(int val) {
           data = val;
           left = right = null;
       }

   }
       Node root;

       BinaryTree(){
           root = null;
       }

       void addroot(int val){
           if(root==null)
               root = new Node(val);
            else
                return;
       }

       void addLeftchild(int val, int parent){
           if(root == null)
               return;
           Node tmp, ptr;
           ptr = null;
           Stack<Node> stack = new Stack<>();
           stack.push(root);

           while (!stack.isEmpty()){
               tmp = stack.pop();
               if(tmp.data == parent){
                   ptr = tmp;
                   break;
               }
               else {
                   if(tmp.left!=null){
                       stack.push(tmp.left);

                   }
                   if(tmp.right!=null){
                       stack.push(tmp.right);
                   }
               }
           }
           if(ptr == null)
               return;

           if(ptr.left!=null)
               return;
           ptr.left = new Node(val);
       }

       void addRightChild(int val, int parent){
           if(root == null)
               return;

           Node tmp, ptr;
           ptr = null;
           Stack<Node> stack = new Stack<>();
           stack.push(root);

           while (!stack.isEmpty()){
               tmp = stack.pop();
               if(tmp.data == parent){
                   ptr = tmp;
                   break;
               }
               else {
                   if(tmp.right!=null){
                       stack.push(tmp.right);

                   }
                   if(tmp.left!=null){
                       stack.push(tmp.left);
                   }
               }
           }
           if(ptr == null)
               return;

           if(ptr.right!=null)
               return;
           ptr.right = new Node(val);
       }
       void BFS(){
           if(root == null)
               return;

           Queue <Node> queue  = new LinkedList<>();
           queue.add(root);
           while (!queue.isEmpty()){
               Node t = queue.poll();
               System.out.print(t.data + " ");

               if(t.right!=null)
                   queue.add(t.right);
               if(t.left!=null)
                   queue.add(t.left);
           }

       }


       void DFS(){
        System.out.print("Choose Method:\n1) In-Order \n2) Pre-Order\n3) Post-Order");
        int choice;
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();

        switch (choice){
            case 1:
                Inorder(root);
                break;
            case 2:
                Preorder(root);
                break;
            case 3:
                Postorder(root);
                break;
        }

       }
       void Inorder(Node head){
           if(head == null)
               return;

           Inorder(head.left);
           System.out.print(head.data + " ");
           Inorder(head.right);
       }
    void Preorder(Node head){
        if(head == null)
            return;

        System.out.print(head.data + " ");
        Preorder(head.left);
        Preorder(head.right);
    }
    void Postorder(Node head){
        if(head == null)
            return;

        Postorder(head.left);
        Postorder(head.right);
        System.out.print(head.data + " ");
    }
    int sum(Node root){
           if(root == null)
               return 0;
           return root.data + sum(root.left) + sum(root.right);
    }

    int sum_parent(int child){
           Stack<Node> stack = new Stack<>();
           stack.push(root);
           int sum = 0;

           Node tmp;
           while (!stack.isEmpty()){
               tmp = stack.pop();
               if(tmp.left!=null)
                   stack.push(tmp.left);
               if(tmp.right!=null)
                   stack.push(tmp.right);


               if(tmp.left != null && tmp.left.data == child)
                   sum+=tmp.data;
               if( tmp.right != null && tmp.right.data == child){
                   sum+=tmp.data;
               }

           }
           return sum;
    }
}


