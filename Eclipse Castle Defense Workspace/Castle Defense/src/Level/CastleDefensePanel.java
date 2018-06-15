package Level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import GameManager.CastleDefenseController;
import Invaders.Invader;

public class CastleDefensePanel extends JPanel {
	private int level;
	private Fortress fortress;
	private ArrayList<Invader> enemiesInWave = new ArrayList<Invader>();
	private ArrayList<Invader> activeEnemies = new ArrayList<Invader>();
	private BufferedImage imageFortress,imageRoad,imageRoadInverted,imageGrass;
	protected Timer spawnCooldown;
	protected Timer moveCooldown;
	private CastleDefenseController controller;
	private WaveGenerator wavegenerator = new WaveGenerator(controller);
	
	public CastleDefensePanel(CastleDefenseController controller) {
		this.controller = controller;
		
		//Paints background
		if(preloadImages() == true) {
			this.setBackground(Color.LIGHT_GRAY);
			repaint();	
		}
		
		//Creates an enemy wave
		wavegenerator.createInvaders(new Invader(this.controller), 6);
		enemiesInWave = wavegenerator.getInvaders();
		
		//Invader can spawn every 3 seconds
		spawnCooldown = new Timer(3000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enemiesInWave.size() > 0) {
					activeEnemies.add(enemiesInWave.get(0));
					enemiesInWave.remove(enemiesInWave.get(0));
				}
				repaint();
				spawnCooldown.restart();
				
			}
			});
		
		spawnCooldown.start();
		
		//Invader can move every few seconds.
		moveCooldown = new Timer(200, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveInvaders();
				repaint();
				moveCooldown.restart();
			}
			});
		
		moveCooldown.start();

	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        drawFortAndRoad(g);
	        if(activeEnemies.size() > 0) {
		        for(Invader i : activeEnemies) {
		        	drawInvader(i,g);
		        }
	        }
	    }
	 
	 public void drawFortAndRoad(Graphics pen) {;
	 	pen.drawImage(imageFortress, 0, 50, null);
	 	pen.drawImage(imageFortress, 0, 50, this);
	 	pen.drawImage(imageRoad, 52, 110, this); // 61 height
	 	pen.drawImage(imageGrass, 52, 171, this); // 58 height 291 width
	 	pen.drawImage(imageGrass, 52, 221, this);
	 	pen.drawImage(imageGrass, 342, 171, this);
	 	pen.drawImage(imageGrass, 342, 221, this);
	 	pen.drawImage(imageRoadInverted, 52, 279, this);
	 }
	 
	public boolean preloadImages() {
		try {                
			imageFortress = ImageIO.read(new File("Fortress.png"));
			imageRoad = ImageIO.read(new File("Road.png"));
			imageRoadInverted = ImageIO.read(new File("RoadInverted.png"));
			imageGrass = ImageIO.read(new File("grassRoad.png"));
			return true;
	       } catch (IOException ex) {
	           System.out.print("Niet goed geimporteerd");
	           return false;
	       }
	}
	
	//Moves all invaders that are active 1 step closer to the fortress
	public void moveInvaders() {
		for(Invader i : activeEnemies) {
			i.move();
		}
		repaint();
	}
	
	public void drawInvader(Invader invader,Graphics pen) {
		pen.drawImage(invader.getImageInvader(),invader.getLocationX(),invader.getLocationY(),null);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Fortress getFortress() {
		return fortress;
	}

	public void setFortress(Fortress fortress) {
		this.fortress = fortress;
	}

}
