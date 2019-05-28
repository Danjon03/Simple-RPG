package simpleRPG;



public class Dungeon1 extends SimpleRPG
{

	private Weapons EnterWeapon;
	private static int EnemyNum;
	private static String entrytext;
	private String treasure = "Small Blaster";
	private static Boss boss;
	
	
	public Dungeon1(Weapons EW, int enemyNum, String text, String Treasure, Boss Boss)
	{
		EnterWeapon = EW;
		EnemyNum = enemyNum;
		entrytext = text;
		treasure = Treasure;
		boss = Boss;
	}


	public String getEntryText() {
		return entrytext;
	}


	public static void setEntryText(String entryText) {
		entrytext = entryText;
	}


	public Weapons getEnterWeapon() {
		return EnterWeapon;
	}


	public void setEnterWeapon(Weapons enterWeapon) {
		EnterWeapon = enterWeapon;
	}


	public int getEnemyNum() {
		return EnemyNum;
	}


	public void setEnemyNum(int enemyNum) {
		EnemyNum = enemyNum;
	}


	public String getTreasure() {
		return treasure;
	}


	public void setTreasure(String treasure) {
		this.treasure = treasure;
	}


	public Boss getBoss() {
		return boss;
	}


	public void setBoss(Boss Boss) {
		boss = Boss;
	}
	
	
	
		
		
	
		
		
		
		
		
	
	
	


	
}
