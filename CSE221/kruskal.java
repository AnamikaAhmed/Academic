import java.util.Scanner;



/* Let us create following weighted graph
             10
        0--------1
        |  \     |
       6|   5\   |15
        |      \ |
        2--------3
            4       */

// based on edges
public class kruskal{
 
 public static void main(String[] args){
  
  Scanner scan = new Scanner(System.in);
  int[][] matrix = new int[4][4];
  int[] parent = new int[4];
  int min;
  int u = 0; 
  int v = 0;
  int noOfEdges = 1;
  int total = 0;// store total weight of minimum spanning tree
  
  
  // taking input
  
  for(int i = 0; i < 5; i++){
   
   parent[i] = 0;
   
   for(int j = 0; j < 5; j++){
    
    matrix[i][j] = scan.nextInt();
    
   }
   
  }
  
  // finding the minimum value of edge
  
  while(noOfEdges < 6){ 
  // no of nodes-1
   
   min = 999;
   
   for(int i = 0; i < 5; i++){
    
    for(int j = 0; j < 5; j++){
     
     if(matrix[i][j] < min){
      
      min = matrix[i][j];
      u = i; // starting point of edge
      v = j; // engind point of edge
      
     }
     
    }
    
   }
   
   while(parent[u]!=0){
    u = parent[u];
   }
   
   while(parent[v]!=0){
    v = parent[v];
   }
   
   
   // checking if loop exists
   if(v!=u){
    
    noOfEdges++;
    System.out.println("Edge Found: " + u + "->" + v+" Min : " + min);
    total+=min; // total value of tree
    parent[v] = u; 
    
   }
   
   matrix[u][v] = 999; // to change minimum 
   matrix[v][u] = 999; // we do from both sides for non-directed sides
   
  }
  
  System.out.println("The weight of the minimum spanning tree is "+total);
  
 }
 
}
Contact GitHub API Training Shop Blog About

