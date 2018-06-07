package GameManager;

import Invaders.FastInvader;
import Invaders.Invader;
import Invaders.WeakInvader;
import Level.Fortress;


// Will extends from JFrame
public class Main {
	public static void main(String[] args) {
		
		GameManager controller = new GameManager();
		Fortress fortress  = new Fortress(1000,30,10,controller);
		Invader invader1 = new Invader(controller);
		WeakInvader invader2 = new WeakInvader(controller);
		FastInvader invader3 = new FastInvader(controller);
		
		invader1.Attack(fortress);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader2);
		fortress.AttackEnemy(invader3);
		invader1.Attack(fortress);
		invader2.Attack(fortress);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader1);
		fortress.AttackEnemy(invader1);
	}
	
}
