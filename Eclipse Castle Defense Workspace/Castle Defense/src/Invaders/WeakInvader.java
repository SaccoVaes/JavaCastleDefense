package Invaders;

import javax.swing.Timer;

import GameManager.GameManager;

public class WeakInvader extends Invader {

	public WeakInvader(GameManager controller) {
		super(controller);
		attackPower = 20;
		speed = 20;
	}
	
}