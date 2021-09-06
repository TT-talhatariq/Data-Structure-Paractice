package pacakge01;

public class TreeArray
{
    int[] node;
    int[] parent;
    int size;
    TreeArray(){
        //Setting arrays size to 999
        node = new int[999];
        parent = new int[999];
        size = 0;
    }
    void addroot(int root){
        node[0] = root;
        parent[0] = -1;         //No Parent of Root
        size = 1;
    }
    void addchild(int Node, int Parent ){
        for(int i=0; i<size; i++){

            //Going to find parent node (if exist)
            if(node[i] == Parent){

                //if found, add node & parent in respective arrays
                node[size] = Node;
                parent[size] = Parent;
                size++;
                break;
            }
        }
    }
    void displayArrays()
    {
        for(int j=0; j<size; j++)
        {
            System.out.print("Node: " + node[j]);
            System.out.println(" Parent: " + parent[j]);
        }
    }

}
