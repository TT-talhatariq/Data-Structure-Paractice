import java.util.ArrayList;

public class Main {
    public static void main(String [] args){

        Graph graph = new Graph();

        graph.add("A");
        graph.add("B");
        graph.add("C");
        graph.add("D");
        graph.add("E");


        graph.addEdge("A", "C", 5);
        graph.addEdge("B", "A", 8);
        graph.addEdge("C", "E", 2);
        graph.addEdge("C", "B", 56);
        graph.addEdge("B", "D", 22);
        graph.addEdge("E", "D", 6);


        //  graph.dispaly();        Normal Display


        // graph.TraverseReachableGraph();       //Reachable graph

        //graph.deleteEdge("B", "D"); //Now AFter deleting this, D will be accessed via A, not via B

        //graph.TraverseReachableGraph();
        graph.BFS();
        graph.check_Mother_Vertex();

        //System.out.println("Paths between A & D are: " + graph.count_path("A", "D"));

        if(graph.isCyclic())
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
