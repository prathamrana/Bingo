import java.util.*;
import java.lang.*;
import java.util.Arrays;
public class Bingo{
   private int[][] card = new int [5][5];
   private int[] calls = new int[75];
   private int way =0; // 1 means horizontal, 2 means vertical, 3 means diagonal, 4 means four corners Bingo
   private String BingoLabel;
   
   //Contructor
   public Bingo(){
      card = new int[5][5];
      calls = new int[75];
      way = 0;
   }
   
   //This method will simulate the caller who calls out 75 random numbers by generating the 1D array values
   public void makeCalls(){
      for(int r=0;r<calls.length;r++){
         calls[r]= 1+(int)(Math.random()*(75));
      }
      System.out.println(Arrays.toString(calls));
   }
   
  // This method is used to shuffle the 1D array
   public void shuffle(){
      int idx1,idx2, temp;
      temp=0;
      for(int i=0;i<100;i++){
         idx1 = (int)(Math.random()*(75));
         idx2 = (int)(Math.random()*(75));
         temp = calls[idx1];
         calls[idx1]=calls[idx2];
         calls[idx2]=temp;
      }
   }
  
   //This method creates the random 5x5 2D Bingo card
   public void makeCard(){
	for(int r=0;r<card.length;r++){
         for(int c=0;c<card[r].length;c++){
            card[r][0] =1+(int)(Math.random()*(15)); 
         }
      } 
      for(int r=0;r<card.length;r++){
         for(int c=0;c<card[r].length;c++){
            card[r][1] =16+(int)(Math.random()*(15));
         }
      }  
      for(int r=0;r<card.length;r++){
         for(int c=0;c<card[r].length;c++){
            card[r][2] =31+(int)(Math.random()*(15));
            card[2][2]=0;
         }
      }  
      for(int r=0;r<card.length;r++){
         for(int c=0;c<card[r].length;c++){
            card[r][3] =46+(int)(Math.random()*(15));
         }
      }  
      for(int r=0;r<card.length;r++){
         for(int c=0;c<card[r].length;c++){
            card[r][4] =61+(int)(Math.random()*(15));
         }
         
      }  
      
    
   }
public void printCalls(){
	for(int c=0;c<calls.length;c++){
         System.out.print(calls[c]+ " ");
         }
         }
 
 //This method will print the 1D call simulator array
   public void printCard(){
      String Bingo[] = {"B", "I","N", "G", "O"};
 for(int b=0;b<Bingo.length;b++){
         System.out.print(Bingo[b]+ "\t\t");
      }
      System.out.println();
      
      for(int r=0;r<card.length;r++){
         for(int c=0;c<card[r].length;c++){
         
            System.out.print(card[r][c] + "\t\t");
         }
         System.out.println();
      }
   }
   
   
           //Checks horizontally, vertically, and diagonally  
   public boolean done(){
      return false;
   }
   
   //Is num a B, I, N, G, or O
   public String getLetter(int num){
      if(num<=15)
         return "B " + num;
      else if(num<=30)
         return " I" + num;  
      else if(num<=45)
         return " N " + num; 
      else if(num<=60)
         return " G" + num; 
      else 
         return " O" + num;        
   }
   
   //after the number is called, if found, replace it with a 0;
   public void markCard(int n){
      for(int r=0; r<card.length;r++){
         for(int c=0; c<card[r].length;c++){
            if(card[r][c] ==n){
               card[r][c] =0;
               System.out.println();
               printCard();
         }
         }
         }
   }
   //Keep calling numbers until you get a Bingo
   public void play(){
      //Take each element from the calls array prints each element using getLetter(num) check using mark card method
      int i =0;
      while(i<=74){
         System.out.print(getLetter(calls[i]));
         markCard(calls[i]);
         if(how() ==true){
            System.out.println("It took " + i+1 + " numbers to get a Bingo");
            System.exit(1);
         }
         i++;
         }
   }
   
   //was the Bingo horizontal, vertical, diagonal, corner
   public boolean how(){
      //check if any row has all zeros
      for(int r =0;r<card.length;r++){
         if(card[r][0] == 0 && card[r][1]==0 && card[r][2]==0 && card[r][3]==0 && card[r][4]==0){
            way =1;
            return true;
         }
      }
       //check if any column has all zeros
      for(int c=0;c<card[0].length;c++){
         if(card[0][c]==0 && card[1][c]==0 && card[2][c]==0 && card[3][c]==0 && card[4][c]==0){
            way=2;
            return true;
         }
      }
      //check if any diagonal has all zeros
      if(card[0][0]==0 && card[1][1]==0 && card[2][2]==0 && card[3][3]==0 && card[4][4]==0){
         way =3;
         return true;
      }
      if(card[0][4]==0 && card[1][3]==0 && card[2][2]==0 && card[3][1]==0 && card[4][0]==0){
         way =3;
         return true;
      }
     //check if any four corners has all zeros
      if(card[0][0]==0 && card[0][4]==0 && card[4][0]==0 && card[4][4]==0){
         way=4;
         return true;
      }
      return false;
   }
}