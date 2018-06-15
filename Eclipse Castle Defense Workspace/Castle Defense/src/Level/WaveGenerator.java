package Level;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;

import GameManager.CastleDefenseController;
import Invaders.Invader;
import Invaders.WeakInvader;

/*
 * This class has a collection of invaders, which exists of different kind of invaders.
 * 
 */
public class WaveGenerator {
	private ArrayList<Invader> invaders = new ArrayList<Invader>();
	private CastleDefenseController controller;

	public WaveGenerator(CastleDefenseController controller) {
		this.controller = controller;
	}
	
	public void createInvaders(Invader invader, int aantal) {
		for(int i = 0; i < aantal; i++) {
			invaders.add(new Invader(controller));
		}
	}
	
	public void deleteDeadInvader(Invader invader) {
		invaders.remove(invader);
	}
	
	public ArrayList<Invader> shuffleInvaders(){
		Collections.shuffle(invaders);
		return invaders;
		
	}
	
	public ArrayList<Invader> getInvaders() {
		return invaders;
	}
}
