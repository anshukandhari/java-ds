package graphs.cycle;



public class CycleOfOddSumUG {
  public boolean hasCycle(int g[][]){
    boolean visited[] = new boolean[g.length];
    boolean isCyclic = false;
    for(int i = 0; i< g.length; i++){
      if(!visited[i] && !isCyclic){
        isCyclic = hasCycleUtil(g, visited, -1, i, 0);
      }

    }
    return isCyclic;
  }

  private boolean  hasCycleUtil(int g[][], boolean visited[], int parent, int v, int sum){

    visited[v] = true;

    for(int i = 0; i< g.length; i++){
      if(g[v][i] == 0){
        continue;
      }

      if(i != parent && visited[i]){
        if(sum%2 == 1){
          return  true;
        }
        continue;
      }

      if(!visited[i] && hasCycleUtil(g, visited, v, i, sum+g[v][i])){
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    CycleOfOddSumUG obj = new CycleOfOddSumUG();
    int g[][] = {
        {0,20,0,12},
        {10, 0,1,0},
        {0,1,0,2},
        {12,0,2,0}};
    if(obj.hasCycle(g)){
      System.out.println("Has Cycle with odd sum");
    } else {
      System.out.println("Graph doesn't contain cycle with odd sum");
    }
  }
}
