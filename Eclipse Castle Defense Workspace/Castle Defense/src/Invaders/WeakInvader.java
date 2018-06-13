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
	}
}
