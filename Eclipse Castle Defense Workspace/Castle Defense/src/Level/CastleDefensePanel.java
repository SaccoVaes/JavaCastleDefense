package Level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Invaders.Invader;

public class CastleDefensePanel extends JPanel {
	private int level;
	private Fortress fortress;
	private EnemyWave enemies;
	private ArrayList<Invader> activeEnemies = new ArrayList<Invader>();
	private BufferedImage imageFortress,imageRoad,imageRoadInverted,imageGrass;
	private Graphics myPen;
	
	

	public CastleDefensePanel() {
		if(preloadImages() == true) {
			this.setBackground(Color.LIGHT_GRAY);
			repaint();	
		}
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
		 	myPen = g;
	        super.paintComponent(myPen);
	        drawFortAndRoad();      
	    }
	 
	 public void drawFortAndRoad() {
		 System.out.println(this);
		 myPen.drawImage(imageFortress, 0, 50, this);
		 myPen.drawImage(imageRoad, 52, 110, this); // 61 height
		 myPen.drawImage(imageGrass, 52, 171, this); // 58 height 291 width
		 myPen.drawImage(imageGrass, 52, 221, this);
		 myPen.drawImage(imageGrass, 342, 171, this);
		 myPen.drawImage(imageGrass, 342, 221, this);
		 myPen.drawImage(imageRoadInverted, 52, 279, this);
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
	public void moveInvaders(Graphics g) {
		for(Invader i : activeEnemies) {
			i.move();
		}
		repaint();
	}
	
	public void drawInvader(Invader invader) {
		System.out.println(invader.getImageInvader());
		System.out.println(invader.getLocationX());
		System.out.println(invader.getLocationY());
		//System.out.println(this);
		myPen.drawImage(invader.getImageInvader(),invader.getLocationX(),invader.getLocationY(),this);
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

	public EnemyWave getEnemies() {
		return enemies;
	}

	public void setEnemies(EnemyWave enemies) {
		this.enemies = enemies;
	}	
	
	public Graphics getMyPen() {
		return myPen;
	}

}
