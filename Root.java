/* This program is to find value of root node in a tree 
when value of each node and sum of child nodes of all nodes is given. */

package javacodes;

import java.util.*;     //import packages

public class Root{       
    
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        
        System.out.println("Number of vertices in tree");
        
        int v=in.nextInt();     //taking number of vertices as input
        
        int sumt=0,sumc=0,tmp;
        
        System.out.println("Values of vertices");
        
        for(int i=1;i<=v;i++)
        {
            tmp=in.nextInt();       //taking values of each node as input
            
            sumt+=tmp;
        }
        
        System.out.println("Enter sum of child's values");
        
        for(int i=1;i<=v;i++)
            
        {
            tmp=in.nextInt();
            
            sumc+=tmp;
        }
        
        System.out.println("Value of root node is :"+(sumt-sumc));
    }
}
