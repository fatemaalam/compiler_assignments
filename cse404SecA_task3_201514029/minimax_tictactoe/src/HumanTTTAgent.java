import java.util.Scanner;
//0 manush
//1 pc
/**
 * An example class implementing Agent class for human players. 
 * The implementation is coupled with the actual game (here, TickTackToe) the agent is playing.
 * 
 *
 */
public class HumanTTTAgent extends Agent
{

	static Scanner in = new Scanner(System.in);
	public HumanTTTAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
            
		TickTackToe tttGame = (TickTackToe) game;
                int r=0,c=0;
                
                
                System.out.println("Take input from 0 to 2");
                
                r=in.nextInt();
                c=in.nextInt();
                
                //TickTackToe
                if(tttGame.isValidCell(r,c)==false){

                    System.out.println("Invalid input so enter new row and colum position");
                    r=in.nextInt();
                    c=in.nextInt();
                }
              
                    tttGame.board[r][c]=0;
                
		/*Human Agent will give his move;
                
                 if the move is not is a valid position (use the isValidCell(row, col) function of TickTackToe object) 
                            it will again ask for move otherwise play will be contunied*/
                
                
	
	}


	

}
