package Invaders;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import GameManager.CastleDefenseController;
import Level.Fortress;

import GameManager.CastleDefenseController;

public class FastInvader extends Invader {

	public FastInvader(CastleDefenseController controller) {
		super(controller);
		attackPower = 50;
      	speed = 20;
        hitPoints = 100;
        goldvalue = 30;
        isDead = false;
}

}
