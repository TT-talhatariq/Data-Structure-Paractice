import java.util.*;

public class Graph {

    ArrayList<Node> vertex_list;            //Graph Vertices

    //Vertex List
    Graph() {
        vertex_list = new ArrayList<Node>();
    }

    //Adding a vertex
    void add(String vertex) {
        Node tmp = new Node(vertex);
        vertex_list.add(tmp);
    }

    String getvertex(int a) {
        return vertex_list.get(a).index;
    }

    //Get Vertex Index
    int getvertex(String vertex) {
        for (int i = 0; i < vertex_list.size(); i++) {
            if (vertex_list.get(i).index == vertex) {
                return i;
            }
        }
        return -1;
    }

    //Adding Edge
    void addEdge(String from, String to, int weight) {
        int vertex_1 = getvertex(from);
        int vertex_2 = getvertex(to);

        Edge edge = new Edge(vertex_1, vertex_2, weight);
        vertex_list.get(vertex_1).list.add(edge);
    }

    //Normal Display
    void dispaly() {

        for (int i = 0; i < vertex_list.size(); i++) {
            System.out.print(vertex_list.get(i).index + " --> ");

            for (Edge edge : vertex_list.get(i).list) {
                System.out.print(vertex_list.get(edge.end).index + ", " + edge.wieght + ", ");
            }
            System.out.println("\b\b");
        }
    }

    //Explore Network of Graph via Recursion
    void ExploreNetwork(int vertexNo, ArrayList<Boolean> seen) {
        if (!seen.get(vertexNo)) {
            seen.set(vertexNo, true);

            System.out.println(getvertex(vertexNo) + " visited");

            for (Edge edge : vertex_list.get(vertexNo).list) {
                ExploreNetwork(edge.end, seen);
            }
        }
    }

    void deleteEdge(String from, String to) {
        int index = getvertex(from);
        int delete = getvertex(to);

        int op = -1;
        for (int i = 0; i < vertex_list.get(index).list.size(); i++) {
            if (vertex_list.get(index).list.get(i).end == delete) {
                op = i;
            }
        }

        vertex_list.get(index).list.remove(op);
    }

    //Explore only Reachable Vertices of Graph
    void TraverseReachableGraph() {
        ArrayList<Boolean> seen = new ArrayList<>();
        for (int i = 0; i < vertex_list.size(); i++) {
            seen.add(false);
        }
        ExploreNetwork(0, seen);
    }

    //Will Explore Every thing in Graph
    void TraverseCompleteGraph() {

        ArrayList<Boolean> seen = new ArrayList<>();
        for (int i = 0; i < vertex_list.size(); i++) {
            seen.add(false);
        }
        for (int i = 0; i < vertex_list.size(); i++)
            ExploreNetwork(i, seen);
    }

    void BFS() {
        ArrayList<Boolean> seen = new ArrayList<>();
        for (int i = 0; i < vertex_list.size(); i++) {
            seen.add(false);
        }

        Queue<Node> queue = new LinkedList<>();

        queue.add(vertex_list.get(0));

        Node cur;

        while (!queue.isEmpty()) {
            cur = queue.poll();
            seen.set(0, true);

            System.out.println(cur.index + " Visited");

            for (int i = 0; i < cur.list.size(); i++) {

                String vertex = getvertex(cur.list.get(i).end);
                int index = getvertex(vertex);
                if (!seen.get(index)) {
                    queue.add(vertex_list.get(index));
                    seen.set(index, true);
                }
            }
        }
    }
    void Find_path(String a, String b){

    }
    Stack<Node> Path_Find(int a, int b, ArrayList<Boolean> seen){

        Stack<Node> stack = new Stack<>();

        if (!seen.get(a)) {
            seen.set(a, true);

            System.out.println(getvertex(a) + " visited");

            for (Edge edge : vertex_list.get(a).list){
                ExploreNetwork(edge.end, seen);
            }
        }
        return stack;

    }
    /* Now the code below is for checking mother vertex
        of graph
        3 functions
     */
    void check_Mother_Vertex(){

        Boolean [] arr = new Boolean[this.vertex_list.size()];
        for(Node node: vertex_list){
            Arrays.fill(arr, false);
            mother_vertex(getvertex(node.index), arr);
            if(check_arr(arr))
                System.out.println(node.index  + " is a Mother Vertex");
        }

    }
    //checking for array
    boolean check_arr(Boolean [ ] seen){
        for(int i=0; i<seen.length; i++){
        if(!seen[i])
            return false;
        }
        return true;
    }
    //Via this method (DFS Scheme) we will check mother vertex
    void mother_vertex(int index, Boolean [] seen){
        //for every Given Node, We'll check
        Stack<Node> tmp = new Stack<>();
        tmp.push(vertex_list.get(index));

        while (!tmp.isEmpty()) {
            if (!seen[getvertex(tmp.peek().index)]) {
                seen[getvertex(tmp.peek().index)] = true;

                Node node = tmp.peek();
                tmp.pop();
                for (Edge edge : node.list) {
                    tmp.push(vertex_list.get(edge.end));
                }
            }
            else {
                tmp.pop();
            }
        }
    }

    /* the code below is for checking all possible paths between
    two vertices
     */
    int count_path(String a, String b){
        int start = getvertex(a);
        int end = getvertex(b);

        int path_count = 0;
        path_count = Count(start, end, path_count);
        return path_count;
    }

    int Count(int s, int d, int count){
        if(s==d)
            count++;

        for(Edge edge: vertex_list.get(s).list){
            count = Count(edge.end, d, count);
        }
        return count;
    }

    //Code for detecting Cycles
    Boolean isCyclic(){
        boolean[] visited = new boolean[vertex_list.size()];
        boolean[] recStack = new boolean[vertex_list.size()];

        // Call the recursive helper function to
        // detect cycle in different DFS trees
        for (int i = 0; i < vertex_list.size(); i++)
            if (isCyclicRec(i, visited, recStack))
                return true;
        return false;
    }
    Boolean isCyclicRec(int index, boolean [] visited, boolean [] recStack){
        if(recStack[index])
            return true;
        if(visited[index])
            return false;

        visited[index] = true;

        recStack[index] = true;

        for (Edge edge: vertex_list.get(index).list)
            if (isCyclicRec(edge.end, visited, recStack))
                return true;

        recStack[index] = false;
        return false;

    }

}