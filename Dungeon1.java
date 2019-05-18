package simpleRPG;



public class Dungeon1 extends SimpleRPG
{

	private String EnterWeapon = "Sharp Sword";
	private static int EnemyNum = 10;
	private static String entrytext = "You enter a cave and see a sign. it reads... \n"
			 + " Beware traveler many dangers await you. Pass and you will be closer to freedom. You look down and pick up a weapon. "
			 + "You replace your sword with a Sharp Sword \n"
			 + "You instantly look up to see a monster.";
	private String treasure = "Small Blaster";
	private static Monsters boss;
	
	
	public Dungeon1(String EW, int enemyNum, String text, String Treasure, Monsters Boss)
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


	public String getEnterWeapon() {
		return EnterWeapon;
	}


	public void setEnterWeapon(String enterWeapon) {
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


	public static Monsters getBoss() {
		return boss;
	}


	public void setBoss(Monsters Boss) {
		boss = Boss;
	}
	
	
	
		
		
	
		
		
		
		
		
	
	
	


	
}
