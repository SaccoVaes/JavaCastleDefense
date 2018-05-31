package GameManager;

import Level.Fortress;

public class GameManager {

	
	
	private boolean gameOver = false;
	private Fortress fortress;
	
	public GameManager() {
		fortress = new Fortress(1000,10,10);
		
	}
	//Checks if is player has lost the game.
	public boolean isGameOver() {
		
		if(fortress.getHitPoints() <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
			
	
	
}
