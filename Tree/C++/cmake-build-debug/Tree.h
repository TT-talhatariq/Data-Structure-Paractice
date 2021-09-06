//
// Created by The Pirogromor TT on 7/19/2021.
//

#ifndef C___TREE_H
#define C___TREE_H


class Tree {

    class Node{
    int data;
    Node * left;
    Node * right;
    public:
        Node(int val){
            data = val;
            left = right = nullptr;
        }
    };

    Node *root;
    public:

    Tree();
    void addroot(int val);
    void  addleftChild(int val, int par);
    void addrightChild(int val, int par);
    void DFS();
    void BFS();
};


#endif //C___TREE_H