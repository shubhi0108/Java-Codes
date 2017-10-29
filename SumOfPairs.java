package javacodes;

/**
 * Given an array of ints A and an int m, find out if there exists
 * a pair of elements in A that add up to m in a relatively fast way.
 */
public class SumOfPairs {
  
  public static boolean sumExists(int[] list, int m) {
    int[] differences = new int[list.length];
    
    for (int i = 0; i < list.length; i++) {
      int curr = list[i];
      
      // ignore the trivial case where m is an element of the list.
      if (curr == m) {
        continue;
      }
      
      int diff = m - curr;
      
      for (int j = 0; j <= i; j++) {
        int currDiff = differences[j];
        
        if (currDiff == diff || currDiff == curr) {
          
          System.out.println("A pair is " + curr + " and " + diff + "\n");
          return true;
        }
      }
      
      differences[i] = diff;
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    int[] l = {1, 8, 10, 3, 2, 6};
    
    System.out.println(sumExists(l, 8));
  }
}
