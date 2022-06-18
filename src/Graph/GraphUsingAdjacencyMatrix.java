package Graph;
import java.util.ArrayList;
public class GraphUsingAdjacencyMatrix
{
    ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
    int adjacencymatrix[][];
    public GraphUsingAdjacencyMatrix(ArrayList<GraphNode> noddeList)
    {
        this.nodeList=noddeList;
        adjacencymatrix=new int[noddeList.size()][noddeList.size()];
    }
    public void addUndirectedEdge(int i, int j)
    {
        adjacencymatrix[i][j]=1;
        adjacencymatrix[j][i]=1;
    }
    public String toString()
    {
        StringBuilder s=new StringBuilder();
        s.append("  ");
        for(int i=0;i<nodeList.size();i++)
        {
            s.append(nodeList.get(i).name+" ");
        }
        s.append("\n");
        for(int i=0;i<nodeList.size();i++)
        {
            s.append(nodeList.get(i).name+": ");
            for(int j: adjacencymatrix[i])
            {
                s.append((j)+" ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    public static void main(String args[])
    {
        ArrayList<GraphNode> nodeList=new ArrayList<GraphNode>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));

        GraphUsingAdjacencyMatrix g=new GraphUsingAdjacencyMatrix(nodeList);
        g.addUndirectedEdge(0, 1);
        g.addUndirectedEdge(0, 2);
        g.addUndirectedEdge(0, 3);
        g.addUndirectedEdge(1, 4);
        g.addUndirectedEdge(2, 3);
        g.addUndirectedEdge(3, 4);
        System.out.print(g.toString());
    }
}
