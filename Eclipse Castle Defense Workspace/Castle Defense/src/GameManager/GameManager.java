package GameManager;

import Invaders.Invader;
import Invaders.WeakInvader;
import Level.EnemyWave;
import Level.Fortress;
import Level.Road;

public class GameManager {
	private boolean gameOver = false;
	private Fortress fortress;
	private Road road;
	private EnemyWave enemies;
	
	public GameManager() {
		fortress = new Fortress(1000,30,10,this);
		road = new Road();
		enemies = new EnemyWave(this);
		
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
	
	//Moves all invaders that are active 1 step closer to the fortress
	public void moveInvaders() {
		
	}
	
	public void createEnemyWave() {
		enemies.createInvaders(new Invader(this), 6);
		enemies.createInvaders(new WeakInvader(this), 3);
	}
	
	public void increaseGold(Player player,int value) {
		player.increaseGold(value);
	}
	
			
	
	
}
