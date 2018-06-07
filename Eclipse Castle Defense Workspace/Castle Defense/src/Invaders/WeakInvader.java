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

/*
	private int attackPower = 50;
	private int speed = 10;
	private int hitPoints = 100;
	private boolean isDead = false;
	private Timer attackCooldown;
	private boolean canAttack;


*/