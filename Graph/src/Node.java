import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Node {

    String index;           //Label of Graph
    ArrayList<Edge> list = new ArrayList<Edge>();
    Node(String n) {
        index = n;
    }
}

