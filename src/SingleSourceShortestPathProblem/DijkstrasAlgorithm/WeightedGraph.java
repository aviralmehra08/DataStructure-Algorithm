package SingleSourceShortestPathProblem.DijkstrasAlgorithm;
import java.util.*;
public class WeightedGraph
{
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

  public WeightedGraph(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  void dijkstra(WeightedNode node) {
    PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
    node.distance = 0;
    queue.addAll(nodeList);
    while(!queue.isEmpty()) {
      WeightedNode currentNode = queue.remove();
      for (WeightedNode neighbor : currentNode.neighbors) {
        if(queue.contains(neighbor)) {
          if (neighbor.distance > currentNode.distance + currentNode.weight.get(neighbor)) {
            neighbor.distance = (currentNode.distance + currentNode.weight.get(neighbor));
            neighbor.parent = currentNode;
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    for (WeightedNode nodeToCheck : nodeList) {
      System.out.print("Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
      pathPrint(nodeToCheck);
      System.out.println();
    }
  }

  public static void pathPrint(WeightedNode node) {
   if (node.parent  != null) {
     pathPrint(node.parent);
   }
   System.out.print(node.name + " ");
 }

  public void addWeightedEdge(int i, int j, int d) {
    WeightedNode first = nodeList.get(i);
    WeightedNode second = nodeList.get(j);
    first.neighbors.add(second);
    first.weight.put(second,d);
  }
    public static void main(String args[])
    {
        ArrayList<WeightedNode> nodeList=new ArrayList<>();
        nodeList.add(new WeightedNode("A", 0));
        nodeList.add(new WeightedNode("B", 1));
        nodeList.add(new WeightedNode("C", 2));
        nodeList.add(new WeightedNode("D", 3));
        nodeList.add(new WeightedNode("E", 4));
        nodeList.add(new WeightedNode("F", 5));
        nodeList.add(new WeightedNode("G", 6));
        WeightedGraph newGraph=new WeightedGraph(nodeList);
        newGraph.addWeightedEdge(0, 1, 2);
        newGraph.addWeightedEdge(0, 2, 5);
        newGraph.addWeightedEdge(1, 2, 6);
        newGraph.addWeightedEdge(1, 3, 1);
        newGraph.addWeightedEdge(1, 4, 3);
        newGraph.addWeightedEdge(2, 5, 8);
        newGraph.addWeightedEdge(3, 4, 4);
        newGraph.addWeightedEdge(4, 6, 9);
        newGraph.addWeightedEdge(5, 6, 7);
        System.out.println("Printing Dijkstra From source: A");
        newGraph.dijkstra(nodeList.get(0));
    }
}
