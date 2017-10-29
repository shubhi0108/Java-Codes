package javacodes;

import java.util.Scanner;
/** class TicTacToe takes in user input and prints the game to the screen*/
public class TicTacToe {
    
    public static void main(String args[])
    {
        int flag=0;
        
        Scanner in=new Scanner(System.in);
        
        System.out.println("Enter name\nPlayer 1 :");
        // get name1
        String name1=in.nextLine();
        
        System.out.println("Player 2 :");
        // get name2
        String name2=in.nextLine();
        // 2D array of 3 elements each
        char[][] m=new char[3][3];Setm(m);
        
        
        int r,c,count=0,u=1;
        
        //game turns are 9
        while(count<=9)
        {
        	//if all the tiles are full finish the game
            if(count==9)
                
                break;
            
            //print to show which player's turn           
            RefPos(u);
            
            r=in.nextInt();
            
            c=in.nextInt();
            
            //if filled position entered then re-enter the position
            if(m[r][c]!=' ')
                
                continue;
            
            count++;
            //0 for player 1
            //x for player 2
            //after each player plays u turns from player 1 to player 2 or vice-versa
            if(u==1)
            {
                m[r][c]='0';
                
                u=2;Printm(m);
            }
            else if(u==2)
            {
                m[r][c]='x';
                
                u=1;Printm(m);
            }
            //after 5 turns there is a possibility for one of the players to win the game
            if(count>=5)
            {
            	//to check if any winning combinations made
              flag=Check(m);
              
              //flag = 0 means no winning combination
              if(flag>0)
              {
                  if(u==1)
                      
                  {System.out.println("\nPlayer 2 : "+name2+", Won!!");return;}
                  
                  else
                      
                  {System.out.println("\nPlayer 1 : "+name1+", Won!!");return;}
              }
            }
        }
        System.out.println("\nMatch Drawn - Tie!!");
    }
    //to check for any winning combination
    public static int Check(char[][] m)
    {   
        //to check horizontally and vertically 
    	//if horizontally return 1
    	//if vertically return 2
        for(int i=0;i<3;i++)
        {
            if((m[i][0]==m[i][1])&&(m[i][0]==m[i][2])&&(m[i][1]==m[i][2])&&(m[i][0]==m[i][2])&&m[i][0]!=' ')
                
                return 1;
            
            if((m[0][i]==m[1][i])&&(m[0][i]==m[2][i])&&(m[1][i]==m[2][i])&&(m[i][0]==m[2][i])&&m[0][i]!=' ')
                
                return 2;
        }
        //to check diagonally from left to right
          if((m[0][0]==m[1][1])&&(m[0][0]==m[2][2])&&(m[1][1]==m[2][2])&&(m[0][0]==m[2][2])&&m[0][0]!=' ')
              
                return 3;
          
        //to check diagonally from right to left  
        if((m[2][0]==m[1][1])&&(m[2][0]==m[0][2])&&(m[1][1]==m[0][2])&&(m[2][0]==m[1][1])&&m[2][0]!=' ')
            
                return 4;
        //if no winning combination return 0
        return 0;
    }
    //function to print the tic tac toe board with the player's turns
    public static void Printm(char[][] m)
    {
        System.out.println("\n\n\n\n\n");
        
        for(int i=0;i<3;++i)
            
        {   
            System.out.print("\t\t\t");
            
            for(int j=0;j<3;j++)
            {
                System.out.print(m[i][j]);
                
                if(j!=2)
                    
                    System.out.print(" | ");
            }
            if(i!=2)
                
                System.out.println("\n\t\t\t__|___|___");
        }
    }
    //default values(empty) to all the positions of the board
    public static void Setm(char[][] m)
    {
        for(int i=0;i<3;++i)
        {
            for(int j=0;j<3;++j)
            {
                m[i][j]=' ';
            }
        }
    }
    //function for reference positions and to tell which player's turn
    public static void RefPos(int u)
    {
        //System.out.println("\nReference Position:\n");
        
        //System.out.println("(0,0) | (0,1)  | (0,2)");
        
        //System.out.println("______|________|______");
        
        //System.out.println("(1,0) | (1,1)  | (1,2)");
        
        //System.out.println("______|________|______");
        
        //System.out.println("(2,0) | (2,1)  | (2,2)");
        
        System.out.println("Player "+u+", Enter values:");       
    }
}
