package Invaders;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import GameManager.GameManager;
import Level.Fortress;

import GameManager.GameManager;

public class FastInvader extends Invader {

	public FastInvader(GameManager controller) {
		super(controller);
		attackPower = 50;
      	speed = 20;
        hitPoints = 100;
        goldvalue = 30;
        isDead = false;
}

}
