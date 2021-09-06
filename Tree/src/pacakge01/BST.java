package pacakge01;

import java.util.*;

public class BST {
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

    BST(){
        root = null;
    }

    void addroot(int val){
        if(root==null)
            root = new Node(val);
        else
            return;
    }

    void insert(int data) {
        Node pre = null;
        Node tmp = root;
        while (tmp != null) {
            if (data > tmp.data) {
                pre = tmp;
                tmp = tmp.right;
            } else if (data < tmp.data) {
                pre = tmp;
                tmp = tmp.left;
            }
        }
        if (data < pre.data)
            pre.left = new Node(data);
        else
            pre.right = new Node(data);
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
    boolean search(Node root, int ata){

    if(root==null)
        return false;

    if(root.data == ata)
        return true;

    if(root.data>=ata)
        return search(root.left, ata);
    else
        return search(root.right, ata);

    }
    int min(Node root){
        if(root==null)
            return 0;

        Node tmp = root;
        while (tmp.left!=null)
            tmp = tmp.left;

        return tmp.data;
    }
    int max(){
        if(root==null)
            return 0;

        Node tmp = root;
        while (tmp.right!=null)
            tmp = tmp.right;

        return tmp.data;
    }
    int hieght(Node root){
        if(root==null)
            return -1;

        return Math.max(hieght(root.right), hieght(root.left))+1;
    }

    void deleteKey(int key) { root = deleteRec(root, key); }
    Node deleteRec(Node root, int num){
        if(root==null)
            return root;
        if (num<root.data)
            root.left = deleteRec(root.left, num);
        else if (num> root.data)
            root.right = deleteRec(root.right, num);

        else {
            if(root.left ==null)
                return root.right;
            else if (root.right==null)
                return root.left;

            root.data = min(root.right);
            root.right = deleteRec(root.right, root.data);
        }

        return root;

    }
}


