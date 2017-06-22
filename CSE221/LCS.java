
import java.util.*;
public class LCS{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the two strings");
        
        //  first input
        String a = sc.next();
        
        System.out.println("First String: "+a);
        a = 0+a; // concatenated
        char[] array1 = a.toCharArray();
        
        // second input
        String b = sc.next(); 
        
        System.out.println("Second String: "+b);
        b = 0+b;
        char[] array2 = b.toCharArray();
        
        int length1 = a.length();
        int length2 = b.length();
        int[][] matrix = new int[length1][length2];
        
        // filling up adjacency matrix
        for(int i = 0; i<length1; i++){
            for(int j =0; j<length2; j++){
                if(i ==0 || j==0){
                    matrix[i][j] = 0;
                }
                
                else if(array1[i]==(array2[j])){
                    // shoman hole diagonal+1
                    matrix[i][j] = matrix[i-1][j-1]+1;
                    
               
                }
                
                else if(array1[i]!=(array2[j])){
                    
                    // upor or pasher maximum value boshbe
                    matrix[i][j] = Math.max (matrix[i-1][j], matrix[i][j-1]); // method for maximum Math.max()
                    
                }
            }
        }
   
        int m = matrix[length1-1][length2-1]; // last ghorer value
        System.out.println("The length of the longest subsequence is: "+m);
        
        int i = length1-1; // length of first string
        int j = length2-1; // length of second string
        
        
        
        Stack st = new Stack();
        
        
        
        
        //BackTracking
        
        while(i>0 && j>0){
            
            // jokhon 2 tai same
            if(array1[i] == array2[j]){
                
                
                st.push(array1[i]);
                
                i--;
                j--;
                
            }
            
            // uporer ta pasher cheye boro
            else if(matrix[i-1][j]>matrix[i][j-1]){
                i--;
                
                
            }
            
            // pasher ta uporer cheye boro or soman
            else{
                
                j--;
                
            }
            
        }
        
        
        // while stack is not empty (printing values)
        while(!st.empty()){
            Object popResult = st.pop();
            System.out.print(popResult+" ");
        }
        System.out.println();
        
        System.out.println("The matrix is: ");
        for(int k =0; k<length1; k++){
            for(int l =0; l<length2; l++){
                System.out.print(matrix[k][l]+" ");
            }
            System.out.println();
        }
        
        sc.close();
        
    }
}



                   
                    
