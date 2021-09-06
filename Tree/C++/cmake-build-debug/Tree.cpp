//
// Created by The Pirogromor TT on 7/19/2021.
//
#include "Tree.h"
using namespace std;
void Tree ::addroot(int val) {
    root = new Node(val);
}
void Tree ::addleftChild(int val, int par) {
    Node *tmp = nullptr;
    Node *parent = nullptr;
    std::stack<Node *> stack ;

    if(root == nullptr){
        cout << "Empty Tree\n";
        return;
    }
    stack.push(root);
    while (!stack.empty()){

        tmp = stack.pop();

    }

}