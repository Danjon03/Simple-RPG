package simpleRPG;

import java.util.Random;

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


	public static Monsters getBoss() {
		return boss;
	}


	public void setBoss(Monsters boss) {
		this.boss = boss;
	}
	
	
	
		
		
	
		
		
		
		
		
	
	
	 public static Monsters dungonMonsterArray[] = new Monsters[10];
	public void createDungeon()
	{
		for(int i = 0; i < dungonMonsterArray.length; i++)
		{
			Random monsterChoose = new Random();
			int r = monsterChoose.nextInt(99);
			
			if(r <= 50)
			{
				dungonMonsterArray[i] = new Monsters(15, 8, "Goblin");
				System.out.println("new Goblin");
			}
			else if(r > 50 && r <= 60)
			{
				dungonMonsterArray[i] = new Monsters(15, 8, "Werewolf");
				System.out.println("new Werewolf");
			}
			else if(r > 60)
			{
				dungonMonsterArray[i] = new Monsters(20, 5, "Mummy" );
				System.out.println("new Mummy");
			}
			
		}
		
		
	}
	
	public static int currentEnemyInDungeon = 1;
	
	public static int yourDamage;
	public void attackMonsterinDungeon(int button)
	{
		
			
			if(button == 1)
			{
				yourDamage = you.getWeap1At() + D4() + you.getAttack();
			}
			else
			{
				yourDamage = you.getWeap2At() + D4() + you.getAttack();
			}
			
			if(currentEnemy == dungonMonsterArray.length )
			{
				
				fightBoss();
			}
			else
			{
			dungonMonsterArray[currentEnemy].setHP( dungonMonsterArray[currentEnemy].getHP() - yourDamage);
				
				if(dungonMonsterArray[currentEnemy].getHP() <= 0)
				{
					if(currentEnemy == 9)
					{
						area.setText("You kill the monster you are fighting and see a Flame Ogre Towering above you in front of the exit."
								+ "\n you pick up a Small Blaster lying near you and take a deep breath for the fight ahead.");
						currentEnemy++;
						attackWeapon2.setText("Small Blaster");
						you.setWeap2At(6);
					}
					else
					{
					currentEnemy++;
					targetArea.setText(dungonMonsterArray[currentEnemy].getName());
					area.setText("You killed the " + dungonMonsterArray[currentEnemy - 1].getName() + " now a " + dungonMonsterArray[currentEnemy].getName() + " is attacking you");
					System.out.println(currentEnemy);
					}
					
				}
				else
				{
					monsterAttackinDungeon();
				}
			}
			
	}


	
}
