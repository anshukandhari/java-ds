package backtracking.typeB;

import java.util.Arrays;

// https://www.geeksforgeeks.org/m-coloring-problem-backtracking-5/
public class GraphColouring {

  boolean graphColoring(int graph[][], int m){
    int color[] = new int[m];
    for(int i = 1; i<=color.length;i++)
      color[i-1] = i;

    int vertexColor[] = new int[graph.length];
    Arrays.fill(vertexColor, -1);

    if(!graphColoringUtil(graph,color, vertexColor, 0)){
      return false;
    }
    System.out.println(Arrays.toString(vertexColor));
    return true;
  }

  boolean graphColoringUtil(int graph[][], int color[], int vertexColor[], int v){
    if(v == graph.length)
      return true;

    for(int i = 0; i< color.length; i++){
      if(isSafe(graph,color[i],vertexColor,v)){
        vertexColor[v] = color[i];
        if(!graphColoringUtil(graph,color,vertexColor,v+1)){
          vertexColor[v] = -1;
        } else {
          return true;
        }
      }

    }

    return false;

  }

  boolean isSafe(int graph[][], int color, int vertexColor[], int v){
    for(int i = 0; i<graph.length; i++){
      if(graph[v][i]>0 && vertexColor[i] == color){
        return false;
      }
    }
    return true;
  }


  public static void main(String[] args) {
    GraphColouring gc = new GraphColouring();
    int graph[][] = {{0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0},
    };
    int m = 3; // Number of colors
    gc.graphColoring(graph, m);
  }


}
