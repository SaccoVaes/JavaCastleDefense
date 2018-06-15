package GameManager;

import java.awt.Graphics;
import java.util.ArrayList;

import Invaders.Invader;
import Invaders.WeakInvader;
import Level.CastleDefensePanel;
import Level.WaveGenerator;
import Level.Fortress;

public class CastleDefenseController {
	private boolean gameOver = false;
	private Fortress fortress;
	private WaveGenerator enemies;
	private Player player;
	
	public CastleDefenseController() {

		fortress = new Fortress(1000,30,10,this);
		enemies = new WaveGenerator(this);
		player = new Player();
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
	
	public void createEnemyWave() {
		enemies.createInvaders(new Invader(this), 6);
	}
	
	public void increaseGold(int value) {
		Player.increaseGold(value);
	}
	
	public void printPlayerGoldValue() {
		System.out.println("Speler heeft : " + player.getGoldvalue() + " gold nu!");
	}
	
}
