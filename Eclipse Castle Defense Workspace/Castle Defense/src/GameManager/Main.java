package GameManager;

import Invaders.Invader;
import Level.Fortress;

public class Main {
	public static void main(String[] args) {
		Fortress fortress  = new Fortress(1000,10,10);
		Invader monster = new Invader(100,50);
		
		monster.Attack(fortress);
		fortress.AttackEnemy(monster);
	}
	
}
