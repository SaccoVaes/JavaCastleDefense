package Invaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Level.Fortress;

public class Invader {
	private int attackPower;
	private int speed;
	private int hitPoints;
	private boolean isDead = false;
	private Timer attackCooldown;
	private boolean canAttack;
	
	public Invader(int attackpower, int hitpoints) {
		this.attackPower = attackpower;
		this.hitPoints = hitpoints;
		
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
		System.out.print(this.getHitPoints() + "\n");
		if(hitPoints <= 0) {
			isDead = true;
		}
	}
	
	//Invader attacks the fortress.
	public void Attack(Fortress fortress) {
		fortress.takeDamage(this);
		canAttack = false;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	//Gets the canAttack boolean value.
	public boolean attackReady() {
		return canAttack;
	}
	
	
}
