import java.util.*;
import java.io.File;
public class Djk{
    
    public static void main(String[] args) throws Exception{
        
        
        
        File file = new File("myFile.txt");
        Scanner sc = new Scanner(file);
        Scanner sc1 = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        
        int[] distance = new int[m];
        
        // initializing the distances to infinity
        for(int i =0; i<distance.length; i++){
            distance[i] = 999;
        }
        
        
        
        // filling up the Adjacency Matrix
        while(sc.hasNext()){
            int vertex1 = sc.nextInt();
            int vertex2 = sc.nextInt();
            int weight = sc.nextInt();
            
            matrix[vertex1][vertex2] += weight;
            
        }
        
        
        System.out.println("Enter the source node: ");
        int source = sc1.nextInt();
        
        dijk(source, distance, matrix);
        
        for(int i =0; i<matrix[source].length; i++){
            
            System.out.println(source+" --> "+i+" : "+  distance[i]);
            
        }
    }
    
    
    
    
    
    // updating all the nodes
    public static void dijk(int source, int[] distance, int[][] matrix){
        
        
        LinkedList<Integer> ll = new LinkedList<Integer>();
        
        ll.add(source);
        distance[source] = 0;
        
        
        
        while(!ll.isEmpty()){
            
            int var = ll.removeFirst();
            
            for(int i =0; i<matrix[var].length; i++){
                
                if((matrix[var][i] > 0) &&(distance[var]+matrix[var][i] < distance[i])) {
                    
                    distance[i] = distance[var]+matrix[var][i];
                    
                    ll.add(i);
                 
                }
                
            }
            
        }
    }
}







        
