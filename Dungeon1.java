package simpleRPG;

public class Dungeon1 
{

	private String EnterWeapon = "Sharp Sword";
	private static int EnemyNum = 10;
	private static String entrytext = "You enter a cave and see a sign. it reads... \n"
			 + " Beware traveler many dangers await you. Pass and you will be closer to freedom. You look down and pick up a weapon. "
			 + "You replace your sword with a Sharp Sword \n"
			 + "You instantly look up to see a monster.";
	private String treasure = "Small Blaster";
	private String boss = "Flame Ogre";
	
	
	public Dungeon1(String EW, int enemyNum, String text, String Treasure, String Boss)
	{
		EnterWeapon = EW;
		EnemyNum = enemyNum;
		entrytext = text;
		treasure = Treasure;
		boss = Boss;
	}


	public static String getEntryText() {
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


	public static int getEnemyNum() {
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


	public String getBoss() {
		return boss;
	}


	public void setBoss(String boss) {
		this.boss = boss;
	}
	
	
	
}
