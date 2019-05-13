package simpleRPG;

import java.util.Random;

public class FightinDungeon {

	public static void main() 
	{
		
		
		attackInDungeon(SimpleRPG.lastButton);
		
		
		
		
		
	}
	
	public static void attackInDungeon(int button)
	{
		
		if(SimpleRPG.targetedEnemy == "Goblin") 
		{
			
			SimpleRPG.attackGoblin(button);	
		}
		else if(SimpleRPG.targetedEnemy == "Werewolf")
		{
			SimpleRPG.attackWerwolf(button);
		}
		else if(SimpleRPG.targetedEnemy == "Mummy")
		{
			SimpleRPG.attackMummy(button);
		}
		else if(SimpleRPG.targetedEnemy == "Flame Ogre")
		{
			fightBoss(button);
		}
		else
		{
			SimpleRPG.area.setText("You Are Not Targeting an Enemy");
		}	
	}
	
	public static int enemyCount = 0;
	
	public static void createNewEnemyInDungeon()
	{
		
		//chooses enemies inside of a dungeon
		if(enemyCount <= Dungeon1.getEnemyNum())
		{
			Random rand = new Random();
			
			int n = rand.nextInt(99);
			if(n <= 33)
			{
				SimpleRPG.targetedEnemy = "Werewolf";
				
			}
			else if(n >= 33 && n <= 67)
			{
				SimpleRPG.targetedEnemy = "Goblin";
			}
			else if(n >= 67)
			{
				SimpleRPG.targetedEnemy = "Mummy";
			}
			
			enemyCount++;
		}
		else if(enemyCount >= Dungeon1.getEnemyNum())
		{
			SimpleRPG.area.setText("You find a Small Blaster lying on the ground. It is in good condition so you pick it up."
					+ "\n You look up and see a flaming Ogre blocking the exit. You must kill it to escape.");
			SimpleRPG.targetedEnemy = "Flame Ogre";
			You.setWeap2At(9);
		}
		
		
		System.out.println(enemyCount);
		SimpleRPG.targetArea.setText(SimpleRPG.targetedEnemy);
		
		
		
	}

	public static void fightBoss(int button)
	{
		if(button == 1)
		{
			int diceRoll = You.getWeap1At() + SimpleRPG.D4();
			
			FlameOgre.setHP(FlameOgre.getHP() - diceRoll);
			
				if(FlameOgre.getHP() <= 0)
				{
					SimpleRPG.area.setText("You Killed the FlameOgre. You walk outside and take a deep breath. You have escaped");
					SimpleRPG.dead = true;
					SimpleRPG.addButtons();
				}
				else
				{
					You.setHP( You.getHP() - (FlameOgre.getAttack() -	You.getDefense()));
					if(You.getHP() <= 0)
					{
						SimpleRPG.area.setText("You Died, Game Over");
						SimpleRPG.dead = false;
						SimpleRPG.addButtons();
					}
					else
					{
						SimpleRPG.area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (FlameOgre.getAttack() - You.getDefense()) + " Damage");
					}
				}
		
		
		}
		else
		{
			int diceRoll = You.getWeap2At() + SimpleRPG.D4();
			FlameOgre.setHP(FlameOgre.getHP() - diceRoll);
			
				if(FlameOgre.getHP() <= 0)
				{
					SimpleRPG.area.setText("You Killed the FlameOgre. You walk outside and take a deep breath. You have escaped");
					SimpleRPG.dead = true;
					SimpleRPG.addButtons();
				}
				else
				{
					You.setHP( You.getHP() - (FlameOgre.getAttack() - You.getDefense()));

					if(You.getHP() <= 0)
					{
						SimpleRPG.area.setText("You Died, Game Over");
						SimpleRPG.dead = false;
						SimpleRPG.addButtons();
					}
					else
					{
						SimpleRPG.area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (FlameOgre.getAttack() - You.getDefense()) + " Damage");
					}
				}
			
		}
		SimpleRPG.stats.setText("HP: " + You.getHP() + "\n" + "Defense Modifier: " + You.getDefense() + "\n" + "Attack Modifier: " 
				+ You.getAttack() + "\n" + "Number of Potions: " + You.getPotion());
		
		
	}

}
