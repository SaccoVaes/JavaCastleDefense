package Invaders;

import javax.swing.Timer;

import GameManager.GameManager;
import Level.Fortress;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeakInvader extends Invader {

	public WeakInvader(GameManager controller) {
		super(controller);
		attackPower = 25;
		speed = 10;
                goldvalue = 10;
                hitPoints = 50;
                isDead = false;
                
//		this.controller = controller;
//		attackCooldown = new Timer(1000, new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				canAttack = true;
//				System.out.print("test");
//			}
//			});
//		attackCooldown.start();
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