package Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
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
      // get Neighbors
  public ArrayList<GraphNode> getNeighbors(GraphNode node) {
    ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
    int nodeIndex = node.index;
    for (int i=0; i<adjacencymatrix.length; i++) {
      if(adjacencymatrix[nodeIndex][i]==1) {
        neighbors.add(nodeList.get(i));
      }
    }
    return neighbors;

  }

  // BSF internall
  void bfsVisit(GraphNode node) {
    LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    queue.add(node);
    while(!queue.isEmpty()) {
      GraphNode currentNode = queue.remove(0);
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
      for (GraphNode neighbor: neighbors) {
        if (!neighbor.isVisited) {
          queue.add(neighbor);
          neighbor.isVisited = true;
        }
      }
    }
  }

  public void bfs() {
    for (GraphNode node : nodeList) {
      if(!node.isVisited) {
        bfsVisit(node);
      }
    }
  }

  public void dfsVisit(GraphNode node)
  {
    Stack<GraphNode> stack = new Stack<>();
    stack.push(node);
    while(!stack.isEmpty()) {
      GraphNode currentNode = stack.pop();
      currentNode.isVisited = true;
      System.out.print(currentNode.name + " ");
      ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
      for (GraphNode neighbor : neighbors) {
        if (!neighbor.isVisited) {
          stack.push(neighbor);
          neighbor.isVisited = true;
        }
      }

    }
  }

  void dfs() {
    for (GraphNode node : nodeList) {
      if(!node.isVisited) {
        dfsVisit(node);
      }
    }
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
        g.bfs();
    }
}
