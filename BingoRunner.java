public class BingoRunner{
   public static void main(String[] args){
   Bingo b = new Bingo();
   
   b.makeCalls();
   b.shuffle();
   b.printCalls();
   System.out.println();
   b.makeCard();
   b.printCard();
   b.play();
   }
   }               