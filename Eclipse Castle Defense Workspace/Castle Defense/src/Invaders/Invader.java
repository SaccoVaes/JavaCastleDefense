package Invaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import GameManager.GameManager;
import Level.Fortress;

public class Invader {
	protected int attackPower = 50;
	protected int speed = 10;
	protected int hitPoints = 100;
	protected boolean isDead = false;
	protected Timer attackCooldown;
	protected boolean canAttack;
	protected int goldvalue = 20;
	protected GameManager controller;
	
	public Invader(GameManager controller) {
		this.controller = controller;
		attackCooldown = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canAttack = true;
				System.out.print("test");
			}
			});
		attackCooldown.start();
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	//Invader takes damage from the fortress
	public void takeDamage(int attackpower) {
		hitPoints -= attackpower;
		System.out.print("Invader: AUCH! I took " + attackpower + " damage! My health is now: " + this.getHitPoints() + "\n");
		if(hitPoints <= 0) {
			setDead(true);
			System.out.print("Invader: I have been defeated! :((" +  "\n");
		}
	}
	
	//Invader attacks the fortress.
	public void Attack(Fortress fortress) {
		fortress.takeDamage(this);
		System.out.print("Invader: I attacked the fortress for " + this.getAttackPower() + " damage!" + "\n");
		canAttack = false;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	//Gets the canAttack boolean value.
	public boolean attackReady() {
		return canAttack;
	}

	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
}
