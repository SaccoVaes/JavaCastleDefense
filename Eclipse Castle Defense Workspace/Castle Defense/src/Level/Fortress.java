package Level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Invaders.Invader;

public class Fortress {
	private double hitPoints;
	private int[] coordinates;
	
	private Timer attackCooldown;
	private boolean canAttack;
	private int attackPower;
	private int attackRange;
	
	
	public Fortress(double hitpoints, int attackpower, int attackrange) 
	{
		this.hitPoints = hitpoints;
		this.attackPower = attackpower;
		this.attackRange = attackrange;
		
		//The timer sets canAttack on true after 1 second.
		attackCooldown = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canAttack = true;
			}
			});
	}
	
	public double getHitPoints() 
	{
		return hitPoints;
	}
	
	//The fortress attacks a invader object.
	public void AttackEnemy(Invader invader) 
	{
		invader.takeDamage(this.attackPower);
		attackCooldown.restart();
		canAttack = false;
	}
	
	//Receives damage from the Invader object
	public double takeDamage(Invader invader) 
	{
		hitPoints -= (double)invader.getAttackPower();
		System.out.print(this.getHitPoints() + "\n");
		return hitPoints;
	}
	
	
	
	
	
}
