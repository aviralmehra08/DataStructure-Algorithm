package DivideAndConquerAlgorithms;

public class NumberOfPathsToReachLastCell
{
    public int numberOfPaths(int array[][], int row, int col, int cost) {
        if (cost < 0) {
          return 0;
        }
    
        if (row == 0 && col == 0) {
          return (array[0][0]-cost==0)? 1 : 0;
        }
    
        if (row == 0) {
          return numberOfPaths(array, 0, col-1, cost-array[row][col]);
        }
    
        if (col == 0 ) {
          return numberOfPaths(array, row-1, 0, cost-array[row][col]);
        }
    
        int noOfPathsFromPreviousRow = numberOfPaths(array, row-1, col, cost-array[row][col]);
        int noOfPathsFromPreviousCol = numberOfPaths(array, row, col-1, cost-array[row][col]);
    
        return noOfPathsFromPreviousRow + noOfPathsFromPreviousCol;
    
      }
      public static void main(String args[])
      {
        int array[][]={
            {4,7,8,6,4},
            {6,7,3,9,2},
            {3,8,1,2,4},
            {7,1,7,3,7},
            {2,9,8,9,3}
        };
        int cost=25;
        NumberOfPathsToReachLastCell n=new NumberOfPathsToReachLastCell();
        System.out.println(n.numberOfPaths(array, array.length-1, array[0].length-1, cost));
      }    
}
