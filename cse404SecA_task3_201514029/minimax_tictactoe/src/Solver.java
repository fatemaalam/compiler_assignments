
public class Solver {
	
	/*
	 * The starting point of the game.
	 * Instantiates two agents (human/ minimax/ alpha beta pruning/ or other) and pass them to a game object.
	 * Here a TickTackToe game is implemented as an example. You need to extend the abstract class Game to create your own game.
	 * */
	
	public static void main(String[] args) 
	{
		

		Agent human = new HumanTTTAgent("Manush");
		Agent machine = new MinimaxTTTAgent("Computer");

		//System.out.println(human.name+" vs. "+machine.name);
		
		Game game = new TickTackToe(human,machine);
                game.showGameState();
                game.play();
                
                
                
               // new frame().setVisible(true);
                
                
                
                
                
                
                
                
                
                
                
                //HumanTTTAgent h=new HumanTTTAgent();
              //  human.makeMove(game);
              //  TickTackToe toe=new TickTackToe(human,machine);
             //   boolean board=toe.isBoardFull();
             //   if(board=true){
             //       System.out.println("Board is full");
            //    }
               /* toe.initialize(false);
                if(toe.isBoardFull()){
                    System.out.println("Board is full");
                }
                else
                    System.out.println("Board is not full");
		//game.play();
                if(toe.isValidCell(2,3)){
                    System.out.println("This is valid cell");
                }
                else{
                    System.out.println("Invalid cell");
                }  */
		
	}
        public static void window(){
            
        }

}
