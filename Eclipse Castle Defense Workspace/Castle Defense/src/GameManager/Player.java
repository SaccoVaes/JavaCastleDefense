package GameManager;

public class Player {
	private String username;
	private int goldvalue;
	private int level;

	public Player() {
		// TODO Auto-generated constructor stub
	}
	
	public void increaseGold(int value) {
		goldvalue += value;
	}
	
	public int getGoldvalue() {
		return goldvalue;
	}
	
	

}
