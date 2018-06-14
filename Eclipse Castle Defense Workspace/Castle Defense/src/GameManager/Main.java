package GameManager;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Invaders.FastInvader;
import Invaders.Invader;
import Invaders.WeakInvader;
import Level.CastleDefensePanel;
import Level.Fortress;
/*
 * TODO Jframe aanmaken
 * Hoofdpaneel aanmaken met een borderlayout. Hiervan wordt BorderLayout.NORTH gebruikt voor een interfacepaneel en BorderLayout.CENTER gebruikt voor playground.
 * Aanmaken interfacepaneel
 * Aanmaken JButton for upgrade Castle en JLabel voor goldvalue weer te geven.
 * Aanmaken playgroundpaneel
 * Enemies op het paneel plaatsen (JPanels met images);
 * Fortress op het paneel plaatsen (JPanels met image?)
 * Background maken voor het playgroundpaneel (of een backgroundcolor meegeven)
 * 
 * 
 */

// Will extends from JFrame
public class Main extends JFrame {
	public static void main(String[] args) {
		
		CastleDefensePanel panel = new CastleDefensePanel();
		CastleDefenseController controller = new CastleDefenseController(panel);
		
		Fortress fortress  = new Fortress(1000,30,10,controller);
		Invader invader1 = new Invader(controller);
		WeakInvader invader2 = new WeakInvader(controller);
		FastInvader invader3 = new FastInvader(controller);
		Invader invader4 = new Invader(controller);
		
		//Testing if fortress and enemy functionalities are working correctly.
		invader1.Attack(fortress);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader2);
		fortress.AttackEnemy(invader3);
		invader1.Attack(fortress);
		invader2.Attack(fortress);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader2);
		
		JFrame frame = new JFrame();
	    frame.setSize( 600, 400 );
		frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
		frame.setTitle( "Castle Defense Sacco" );
		frame.setContentPane(new CastleDefensePanel());
		frame.setVisible(true);
		frame.setResizable(false);
		
		//panel.drawInvader(invader4);
		
	}
	
}
