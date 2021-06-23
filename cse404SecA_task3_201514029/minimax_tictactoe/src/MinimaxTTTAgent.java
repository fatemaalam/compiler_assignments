
/**
 * Example MiniMax agent extending Agent class.
 * Here, for simplicity of understanding min and max functions are written separately. One single function can do the task. 
 * @author Azad
 *
 */
public class MinimaxTTTAgent extends Agent
{
   // int 
    public static int c=0,count=0;
	
	public MinimaxTTTAgent(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(Game game) {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}TickTackToe tttGame = (TickTackToe) game;
		
                int a=-10000, b=10000;
		
                        CellValueTuple best = max(tttGame,0);
              //  CellValueTuple best = maxAlph(tttGame,a,b,0);
                //System.out.println("Branch:"+count);
		if(best.col!=-1)
		{
			tttGame.board[best.row][best.col] = role;
		}
		
	}
	
	private CellValueTuple max(TickTackToe game,int depth)
	{	
		CellValueTuple maxCVT = new CellValueTuple();
		maxCVT.utility = -100;
                maxCVT.depth=1000000;
	 
                CellValueTuple tmp = new CellValueTuple();
                count++;
		int winner = game.checkForWin();
                
                if(winner==1){    //pc wins
			maxCVT.utility=10; 
                        maxCVT.depth=depth;
			return maxCVT;
		}
		else if(winner==0) {   //manush wins but pc loses
			maxCVT.utility=-10;
                        maxCVT.depth=depth;
			return maxCVT;  
		}
		else if (game.isBoardFull()){ // draw
			maxCVT.utility=0;
                        maxCVT.depth=depth;
			return maxCVT;  
		}
                else{
                    for (int i = 0; i <=2; i++) {
                        //Object arr = arr[i];
                        for (int j = 0; j <=2; j++) {
                           // Object arr = arr[j];
                            if(game.isValidCell(i,j)){
                                game.board[i][j]=1;
                               
				 tmp=min(game,depth+1);
                                 if(tmp.utility>maxCVT.utility){
					maxCVT.utility=tmp.utility;
					maxCVT.row=i;
					maxCVT.col=j;
                                        maxCVT.depth=tmp.depth;

                            }
                                 else if(maxCVT.utility==tmp.utility && maxCVT.depth>tmp.depth){
                                     maxCVT.utility=tmp.utility;
					maxCVT.row=i;
					maxCVT.col=j;
                                        maxCVT.depth=tmp.depth;
                                 }
                                  game.board[i][j]=-1;
                            
                        }
                        
                    }
                }
                }
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
		//implement max function of minimax/alpha-beta pruning algorithm
		
               
		return maxCVT;
			
	}
	
	private CellValueTuple min(TickTackToe game,int depth)
	{	
		CellValueTuple minCVT = new CellValueTuple();
		minCVT.utility = 100;
                minCVT.depth=1000000;
	 
                CellValueTuple tmp = new CellValueTuple();
                count++;
		int winner = game.checkForWin();
                
                if(winner==1){    //pc wins
			minCVT.utility=10; 
                         minCVT.depth=depth;
			return minCVT;
		}
		else if(winner==0) {   //manush wins but pc loses
			minCVT.utility=-10;
                         minCVT.depth=depth;
			return minCVT;  
		}
		else if (game.isBoardFull()){ // draw
			minCVT.utility=0;
                         minCVT.depth=depth;
			return minCVT;  
		}
                else{
                    for (int i = 0; i <=2; i++) {
                        //Object arr = arr[i];
                        for (int j = 0; j <=2; j++) {
                           // Object arr = arr[j];
                            if(game.isValidCell(i,j)){
                                game.board[i][j]=0;
                               
				 tmp=max(game,depth+1);
                                 if(tmp.utility<minCVT.utility){
					minCVT.utility=tmp.utility;
					minCVT.row=i;
					minCVT.col=j;

                                        minCVT.depth=tmp.depth;
                            }
                                 else if(minCVT.utility==tmp.utility && minCVT.depth>tmp.depth){
                                     minCVT.utility=tmp.utility;
					minCVT.row=i;
					minCVT.col=j;
                                        minCVT.depth=tmp.depth;
                                 }
                                  game.board[i][j]=-1;
                            
                        }
                        
                    }
                }
                }
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
		//implement max function of minimax/alpha-beta pruning algorithm
		
               
		return minCVT;
			
	}
	private CellValueTuple maxAlph(TickTackToe game,int alpha,int beta,int depth)
	{	
		CellValueTuple alp = new CellValueTuple();
		alp.utility = alpha;
	 
                alp.depth=1000000;
                CellValueTuple tmp = new CellValueTuple();
                count++;
		int winner = game.checkForWin();
                
                if(winner==1){    //pc wins
			alp.utility=10;
                        alp.depth=depth;
                        
			return alp;
		}
		else if(winner==0) {   //manush wins but pc loses
			alp.utility=-10;
                         alp.depth=depth;
			return alp;  
		}
		else if (game.isBoardFull()){ // draw
			alp.utility=0; 
                         alp.depth=depth;
			return alp;  
		}
                else{
                    for (int i = 0; i <=2; i++) {
                        //Object arr = arr[i];
                        for (int j = 0; j <=2; j++) {
                           // Object arr = arr[j];
                            if(game.isValidCell(i,j)){
                                game.board[i][j]=1;
                               
				 tmp=minbeta(game,alpha,beta,depth+1);
                                 if(tmp.utility>alp.utility){
					alp.utility=tmp.utility;
					alp.row=i;
					alp.col=j;
                                        alpha=tmp.utility;
                                         alp.depth=tmp.depth;
                                        

                            }
                                 else if(alp.utility==tmp.utility && alp.depth>tmp.depth){
                                     alp.utility=tmp.utility;
					alp.row=i;
					alp.col=j;
                                        alpha=tmp.utility;
                                         alp.depth=tmp.depth;
                                 }
                                 
                                  game.board[i][j]=-1;
                                  
                                  if(alpha>=beta){
                                      c++;
                                      break;
                                  }
                            
                        }
                        
                    }
                }
                }
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
		//implement max function of minimax/alpha-beta pruning algorithm
		
               
		return alp;
			
	}
	
	private CellValueTuple minbeta(TickTackToe game,int alpha,int beta,int depth)
	{	
		CellValueTuple bta = new CellValueTuple();
		bta.utility = beta;
                bta.depth=1000000;
	 
                
                CellValueTuple tmp = new CellValueTuple();
                count++;
		int winner = game.checkForWin();
                
                if(winner==1){    //pc wins
			bta.utility=10; 
                        bta.depth=depth;
			return bta;
		}
		else if(winner==0) {   //manush wins but pc loses
			bta.utility=-10;
                         bta.depth=depth;
			return bta;  
		}
		else if (game.isBoardFull()){ // draw
                     bta.depth=depth;
			bta.utility=0; 
			return bta;  
		}
                else{
                    for (int i = 0; i <=2; i++) {
                        //Object arr = arr[i];
                        for (int j = 0; j <=2; j++) {
                           // Object arr = arr[j];
                            if(game.isValidCell(i,j)){
                                game.board[i][j]=0;
                               
				 tmp=maxAlph(game,alpha,beta,depth+1);
                                 if(tmp.utility<bta.utility){
					bta.utility=tmp.utility;
					bta.row=i;
					bta.col=j;
                                        beta=tmp.utility;
                                         bta.depth=tmp.depth;

                            }
                                 else if(bta.utility==tmp.utility && bta.depth>tmp.depth){
                                     bta.utility=tmp.utility;
					bta.row=i;
					bta.col=j;
                                        alpha=tmp.utility;
                                         bta.depth=tmp.depth;
                                 }
                                  game.board[i][j]=-1;
                                  
                                  
                            if(alpha>=beta){
                                c++;
                                 break;
                                  }
                        }
                        
                    }
                }
                }
		//Check if the terminating condition is fullfilled and return the object of CellValueTuple
		//implement max function of minimax/alpha-beta pruning algorithm
		
               
		return bta;
			
	}
	
	private int minRole()
	{
		if(role==0)return 1;
		else return 0;
	}

	class CellValueTuple
	{
		int row,col, utility,depth;
		public CellValueTuple() {
			// TODO Auto-generated constructor stub
			row =-1;
			col =-1;
		}
	}

}
