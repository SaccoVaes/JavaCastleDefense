package Level;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GameManager.GameManager;
import Invaders.Invader;

public class CastleDefensePanel extends JPanel {
	private int level;
	private Fortress fortress;
	private EnemyWave enemies;
	private JPanel centerpanel = new JPanel();
	private BufferedImage imageFortress,imageRoad,imageRoadInverted,imageGrass,imageInvader,imageFastInvader,imageWeakInvader;
	private Graphics mypen;
		
	public CastleDefensePanel() {
		preloadImages();
		this.setBackground(Color.LIGHT_GRAY);
		
		repaint();	
		
	}
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(mypen);
	        drawFortAndRoad();
	    }
	 
	 public void drawFortAndRoad() {
		 mypen.drawImage(imageFortress, 0, 50, this);
		 mypen.drawImage(imageRoad, 52, 110, this); // 61 height
		 mypen.drawImage(imageGrass, 52, 171, this); // 58 height 291 width
		 mypen.drawImage(imageGrass, 52, 221, this);
		 mypen.drawImage(imageGrass, 342, 171, this);
		 mypen.drawImage(imageGrass, 342, 221, this);
		 mypen.drawImage(imageRoadInverted, 52, 279, this);
	 }
	 
	public boolean preloadImages() {
		try {                
			imageFortress = ImageIO.read(new File("Fortress.png"));
			imageRoad = ImageIO.read(new File("Road.png"));
			imageRoadInverted = ImageIO.read(new File("RoadInverted.png"));
			imageGrass = ImageIO.read(new File("grassRoad.png"));
			imageInvader = ImageIO.read(new File("Invader.png"));
			imageFastInvader = ImageIO.read(new File("FastInvader.png"));
			imageWeakInvader = ImageIO.read(new File("WeakInvader.png"));
			return true;
	       } catch (IOException ex) {
	           System.out.print("Niet goed geimporteerd");
	           return false;
	       }
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

}
