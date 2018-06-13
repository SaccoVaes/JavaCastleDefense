package Level;

import java.awt.Graphics;
import java.util.ArrayList;

import GameManager.GameManager;
import Invaders.Invader;
import Invaders.WeakInvader;

/*
 * This class has a collection of invaders, which exists of different kind of invaders.
 * 
 */
public class EnemyWave {
	private ArrayList<Invader> invaders = new ArrayList<Invader>();

	public EnemyWave() {
		
	}
	
	public void createInvaders(Invader invader, int aantal) {
		for(int i = 0; i < aantal; i++) {
			invaders.add(invader);
		}
	}
	
	public void deleteDeadInvader(Invader invader) {
		invaders.remove(invader);
	}
	
	public ArrayList<Invader> getInvaders() {
		return invaders;
	}
}
