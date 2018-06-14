package Invaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameManager.CastleDefenseController;
import Level.Fortress;

public class Invader {
	protected CastleDefenseController controller;
	protected int attackPower = 50;
	protected int speed = 10;
	protected int hitPoints = 100;
	protected boolean isDead = false;
	protected Timer attackCooldown;
	protected Timer spawnCooldown;
	protected boolean canAttack;
	protected boolean canSpawn;
	protected boolean isActive;
	protected int goldvalue = 20;
	protected int locationX = 580;
	protected int locationY;
	protected BufferedImage imageInvader;
	

	public Invader(CastleDefenseController controller) {
		this.controller = controller;
		Random rand = new Random();
		locationY = rand.nextInt(200)+200;
		
		try {                
			imageInvader = ImageIO.read(new File("Invader.png"));
	     }catch (IOException ex) {
	         System.out.print("Niet goed geimporteerd");
	     }
		
		//Invader can attack 2 seconds
		attackCooldown = new Timer(2000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canAttack = true;
			}
			});
		attackCooldown.start();
		
		//Invader can spawn every 3 seconds
		spawnCooldown = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				canSpawn = true;
			}
			});
		spawnCooldown.start();
		
	}
	
	public int getAttackPower() {
		return attackPower;
	}
	
	public BufferedImage getImageInvader() {
		return imageInvader;
	}
	
	//Invader takes damage from the fortress
	public void takeDamage(int attackpower) {
		hitPoints -= attackpower;
		System.out.print("Invader: AUCH! I took " + attackpower + " damage! My health is now: " + this.getHitPoints() + "\n");
		if(hitPoints <= 0) {
			setDead(true);
			controller.increaseGold(this.goldvalue);
			System.out.print("Invader: I have been defeated! :((" +  "\n");
			controller.printPlayerGoldValue();
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
	
	public int getLocationX() {
		return locationX;
	}

	public int getLocationY() {
		return locationY;
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
	
	public void move() {
		locationX -= 5;
	}
	
	
}
