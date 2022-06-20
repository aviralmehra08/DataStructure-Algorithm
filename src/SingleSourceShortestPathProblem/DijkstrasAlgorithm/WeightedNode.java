package SingleSourceShortestPathProblem.DijkstrasAlgorithm;
import java.util.*;
public class WeightedNode implements Comparable<WeightedNode>
{
    public String name;
    ArrayList<WeightedNode> neighbors=new ArrayList<WeightedNode>();//Storing the neighbours of the node
    HashMap<WeightedNode, Integer> weight=new HashMap<>();
    boolean isVisited=false;
    public WeightedNode parent;
    public int distance;
    public int index;
    public WeightedNode(String name, int index)
    {
        this.name=name;
        distance=Integer.MAX_VALUE;
        this.index=index;
    }
    @Override // To have String as an output on console
    public String toString()
    {
        return name;
    }
    @Override
    public int compareTo(WeightedNode o)
    {
        return this.distance=o.distance;
    }
}
