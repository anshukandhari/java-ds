package patternPrinting;

public class Pattern1 {
  // Q: https://www.geeksforgeeks.org/c-programs-print-interesting-patterns/
  public static void printPattern1(int n){
    int m[][] = new int[2*n][2*n];

    int k = n;


    for(int i=0; i<n;i++){
      for(int j=0; j<k;j++){
        m[i][j]=1;
      }
      k--;
    }

    k = 1;

    for(int i=n; i<2*n;i++){
      for(int j=0; j<k;j++){
        m[i][j]=1;
      }
      k++;
    }

    k = n;
    for(int i=0; i<n;i++){
      for(int j=k; j<m.length;j++){
        m[i][j]=1;
      }
      k++;
    }

    k = 2*n-1;
    for(int i=n; i<2*n;i++){
      for(int j=k; j<m.length;j++){
        m[i][j]=1;
      }
      k--;
    }



    for(int i=0; i<m.length;i++){
      for(int j=0; j<m.length;j++){

        System.out.print(m[i][j]==1?"* ": " " + " ");
      }
      System.out.println();
    }


  }


  public static void main(String[] args) {
    printPattern1(5);
  }

}
