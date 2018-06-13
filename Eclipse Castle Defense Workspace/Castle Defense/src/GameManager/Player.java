package GameManager;

public class Player {
	private String username;
	private static int goldvalue;
	private int playerLevel;

	public  Player() {
		// TODO Auto-generated constructor stub
	}
	
	public static void increaseGold(int value) {
		goldvalue += value;
	}
	
	public int getGoldvalue() {
		return goldvalue;
	}
	
	

}
