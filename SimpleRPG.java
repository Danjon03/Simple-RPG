package simpleRPG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class SimpleRPG 
{
	
	//JFrame related Variables
	private  static JFrame mainFrame = new JFrame();
	private  static JPanel panel = new JPanel();
	public static JTextArea area = new JTextArea();
	private static JTextArea targetArea = new JTextArea();
	private static JTextArea stats = new JTextArea();
	 
	 //Fighting buttons
	private static JButton attackWeapon2 = new JButton();
	private static  JButton attackWeapon1 = new JButton();
	
	private static JButton drinkPotion = new JButton();
	
	 //village buttons
	private static JButton visitShop = new JButton();
	private static JButton talkToStranger = new JButton();
	private static JButton buy = new JButton();
	private static JButton exitVillage = new JButton();
	
	  
	//Weapons
		private static RangedWeapon miniBlaster = new RangedWeapon("Small Bow", 6);
		private static Weapons sharpSword = new Weapons("Sharp Sword", 8);
		private static Weapons bluntSword = new Weapons("Blunt Sword", 5);
	  
	 //armor
	  static Armor stealthyCloak = new Armor(1, " Slightly Increase your Defense", 1, "Light Armor");
	  static Armor travelerChestPlate = new Armor(2, " Increased Defense", 2, "Descent Armor");
	  static Armor dragonHideArmor = new Armor(3, " High Defense", 3, "Dragon Hide Armor");
	  
	  private static Armor currentArmor;
	  
	 //Bosses
	 public static Boss flameOgre = new Boss(40, 8, "Flame Ogre", 0);
	 public static Boss giantSpider = new Boss(80, 7, "Giant Spider", 5);
	 public static Boss largeDragon = new Boss(120, 10, "Dragon", 3 );
	 public static Boss giant = new Boss(150, 4, "Giant", 0);
	 public static Boss sage = new Boss(200, 27, "Sage", 0);
	 
	//strings ints ect
	
	 
	 
	 
	 
	
	 
	 //variables that help the program to know where you are in the game
	 
	 //default is stage1 you can set where you start in the game with this variable
	 public static String location = "stage1";
	
	
	 
	 
	 
	 private static boolean dragonArmor = false;
	 public static boolean inDungeon = false;
	 public static int numberOfEnemiesInArea = 5;
	 public static int villageNumber = 1;
	 private static Village currentVillage;
	
	 public static Boss currentBoss;
	 
	 
	 public static ArrayList<Monsters> monsterArray = new ArrayList<Monsters>();
	 
	 //Constructor for player
	 static You mainCharacter = new You(15, 3, 2, bluntSword, miniBlaster, 0, 10, 0);
	 
	 //location objects
	 public static Dungeon1 dungeon = new Dungeon1(sharpSword, 10, "You enter a cave and see a sign. it reads... \n"
			 + " Beware traveler many dangers await you. Pass and you will be closer to freedom. You look down and pick up a weapon. "
			 + "You replace your sword with a Sharp Sword \n"
			 + "You instantly look up to see a monster.", "Small Blaster", flameOgre);
	 
	 
	 public static void main (String[] args) throws IOException
	 {
		
		 setup();
	 }
	
	public static void setup() 
	 {
		
		
		createNewStage();
		 mainFrame.setVisible(true);
		 mainFrame.setSize(1000, 800);
		 mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		//sets up the panel
		 panel.setVisible(true);
		 panel.setLayout(null);
		 mainFrame.add(panel);
		
		 //sets up the JTextArea
		 area.setVisible(true);
		 area.setEditable(false);
		 area.setLocation(50, 50);
		 area.setSize(700, 50);
		 panel.add(area);
		 area.setText("you find yourself in a deep forest. You don't know who you are or anything about your surroundings."
		 		+ "\nThen you look up to see a " + currentEnemy + " attacking you.");
		 
		//adds the buttons 
		addButtons();
		
		 targetArea.setVisible(true);
		 targetArea.setEditable(false);
		 targetArea.setLocation(50, 270);
		 targetArea.setSize(200, 50);
		 panel.add(targetArea);
		 targetArea.setText(monsterArray.get(0).getName());
		 
		 showStats();
		 inDungeon = true;
		//uncomment the line below to move location in game
	      setupNewLocation();
	 }

	//for throws
	public static int D20()
	{
		Random rand = new Random();
		
		int n = rand.nextInt(19);
		return n;
	}
	//for weapons
	public static int D4()
	{
		Random rand = new Random();
		
		int n = rand.nextInt(3);
		return n;
	}
	
	public static  int sneakCount = 0;
	
	private static ActionListener listener1 = new ActionListener()
	 {
		   public void actionPerformed(ActionEvent e)
		   {
					attackMonster(1);
		   }

		};

	private static ActionListener listener2 = new ActionListener()
	 {
		   public void actionPerformed(ActionEvent e)
		   {			   				  			  			
			   	System.out.print("button pressed ");
			   	attackMonster(2);
			   	System.out.print("Count of listeners: " + ((JButton) attackWeapon2).getActionListeners().length + " ");
		   }
		 };
		 
	public static void addButtons()
	{
		
	//button 1
		
		 attackWeapon1.setVisible(true);
		 attackWeapon1.setSize(150, 50);
		 attackWeapon1.setLocation(50, 100);
		 attackWeapon1.setText(mainCharacter.getWeapon1().getName());
		 attackWeapon1.setEnabled(true);
		 panel.add(attackWeapon1);
		
		 if(attackWeapon1.getActionListeners().length < 1)
		 {
			 attackWeapon1.addActionListener(listener1);
		 }
	//button 2
		 
		 
		 attackWeapon2.setVisible(true);
		 attackWeapon2.setSize(150, 50);
		 attackWeapon2.setLocation(250, 100);
		 attackWeapon2.setText(mainCharacter.getWeapon2().getName());
		 attackWeapon2.setEnabled(true);
		 panel.add(attackWeapon2);
		
		 if(attackWeapon2.getActionListeners().length < 1)
		 {		 
			 attackWeapon2.addActionListener(listener2);
		 }
		 //drink a potion
		 
		 drinkPotion.setVisible(true);
		 drinkPotion.setSize(150, 50);
		 drinkPotion.setLocation(50, 160);
		 drinkPotion.setText("Drink a Potion");
		 panel.add(drinkPotion);
		
		 if(drinkPotion.getActionListeners().length < 1)
		 {
			 drinkPotion.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   if(mainCharacter.getPotion() == 0)
			   {
				   area.setText("You don't have any more potions");
			   }
			   else
			   {
				   if(mainCharacter.getHP() > 10)
				   {
					   area.setText("You can't drink another potion");
				   }
				   else
				   {
			   mainCharacter.setPotion(mainCharacter.getPotion() - 1);
			   mainCharacter.setHP(mainCharacter.getHP() + 10);
			showStats();
				   }
			   }
			   }
		 });
		 }
		
		
	
	}
    
	public static void showStats()
	{
		if(currentArmor == null)
		{
		
		stats.setVisible(true);
		stats.setEditable(false);
		stats.setLocation(50, 350);
		stats.setSize(200, 300);
		panel.add(stats);
		stats.setText("HP: " + mainCharacter.getHP() + "\n" + "Defense Modifier: " + mainCharacter.getDefense() + "\n" + "Attack Modifier: " 
						+ mainCharacter.getAttack() + "\n" + "Number of Potions: " + mainCharacter.getPotion() + "\n" + "Gold: " + mainCharacter.getMoney());
		}
		else
		{
			stats.setVisible(true);
			stats.setEditable(false);
			stats.setLocation(50, 350);
			stats.setSize(200, 300);
			panel.add(stats);
			stats.setText("HP: " + mainCharacter.getHP() + "\n" + "Defense Modifier: " + mainCharacter.getDefense() + "\n" + "Attack Modifier: " 
							+ mainCharacter.getAttack() + "\n" + "Number of Potions: " + mainCharacter.getPotion() + "\n" + "Gold: " + mainCharacter.getMoney()
							+ "\nCurrent Armor: " + currentArmor.getName());
		}
		
	
	
	
	}
	
	
	public static  int currentEnemy = 0;
	public static int yourDamage;
	
	
	public static void attackMonster(int button) 
	{			
				if(button == 1)
				{
					yourDamage = mainCharacter.getWeapon1().getAttack() + D4() + mainCharacter.getAttack();
				}
				else
				{
					yourDamage = mainCharacter.getWeapon2().getAttack() + D4() + mainCharacter.getAttack();
				}
				
				if(currentEnemy == monsterArray.size() - 1)
				{
					if(inDungeon == true)
					{
						
						//System.out.println(" Enter setup new location");
						setupNewLocation();
						//System.out.println(" Exit setup new location");
						
					}
					else
					{
						
							fightBoss();
						
					}
				}
				else
				{
					
				//sets the monsters HP
					monsterArray.get(currentEnemy).setHP(monsterArray.get(currentEnemy).getHP() - yourDamage);
					
				//if monster is dead move on to the next monster
					if(monsterArray.get(currentEnemy).getHP() <= 0)
					{
						if(sneakCount != 0)
						{
							sneakCount--;
						}
						
						currentEnemy++;
						
						targetArea.setText(monsterArray.get(currentEnemy).getName());
						area.setText("You killed the " + monsterArray.get(currentEnemy - 1).getName());
					}
					else
					{
						monsterAttack();
					}
				
				}
	}
				
				
	public static void end()
		{
			attackWeapon2.setEnabled(false);
			attackWeapon1.setEnabled(false);
			
			drinkPotion.setEnabled(false);
			
			attackWeapon2.setVisible(false);
			attackWeapon1.setVisible(false);
			
			drinkPotion.setVisible(false);
		}
			
	public static void monsterAttack()
	{
		
	
		
			if(D20() >= 90)
			{
				area.setText("You dealt: " + yourDamage + " and the " + monsterArray.get(currentEnemy).getName() + " missed");
			}
			else
			{
				mainCharacter.setHP(  mainCharacter.getHP() - monsterArray.get(currentEnemy).getAttack() + mainCharacter.getDefense());
				area.setText("You dealt: " + yourDamage + " and the  " + monsterArray.get(currentEnemy).getName() + 
						" dealt " +(monsterArray.get(currentEnemy).getAttack() - mainCharacter.getDefense()) + " damage" );
			}
			
				showStats();

			if(mainCharacter.getHP() <= 0)
			{
				area.setText("You were killed by a " + monsterArray.get(currentEnemy).getName() );
				attackWeapon1.setEnabled(false);
				attackWeapon2.setEnabled(false);
				
				
		}	
	}
	 
	 
	public static void createNewStage()
	{
		currentEnemy = 0;
		monsterArray.clear();
		
		for(int i = 0; i < numberOfEnemiesInArea; i++)
		{
			Random monsterChoose = new Random();
			int r = monsterChoose.nextInt(99);
			
			if(inDungeon == true)
			{
				
				if(r <= 40)
				{
					monsterArray.add( new Monsters(10, 5, "Goblin", true));
					
				}
				else if(r > 40 && r <= 70 )
				{
					monsterArray.add( new Monsters(10, 5, "Werewolf", true));
					
				}
				else
				{
					monsterArray.add( new Monsters(15, 5, "Mummy", true));
					
				}
			}
			else
			{
				
				if(r <= 50)
				{
					monsterArray.add( new Monsters(10, 5, "Goblin", true));
					
				}
				else if(r > 50 && r <= 100)
				{
					monsterArray.add( new Monsters(10, 5, "Werewolf", true));
					
				}
			}	
		}
		

		
			
	}
	
	public static  void fightBoss()
	{
		
		currentBoss.attackPlayer();
	
		
	}
	
	private static Village village1 = new Village("Tamori Village", "Tamando", "The monsters you have fought have been causing trouble. We give you 100 gold.", stealthyCloak);
	private static Village saTowVillage = new Village("Sa-Tow Village", "Samando", "I have information on the weapon you speak of. It is hidden North of here, in the Dragon Roosts.", travelerChestPlate);
	//private static Village seasideVillage = new Village("Seaside Village", "Seasando", "The second stone you seek is on the iron islands. There is a mystic being guarding it", null);
	
	
	
	public static void enterVillage()
	{
		if(villageNumber == 1)
		{
			
			mainCharacter.setMoney(mainCharacter.getMoney() + 100);
			area.setText("You kill the " + dungeon.getBoss().getName() + " and enter a small village called " + village1.getName() + ". You talk to the leader of the village " + 
			village1.getLeaderName() + ", He tells you: \n" + village1.getInfo());
		
			addVillageButtons();
			end();
			showStats();
			villageNumber = 2;
		}
		else if(villageNumber == 2)
		{
			addVillageButtons();
			end();
			
		}
		
	}
	
	public static void exitVillage()
	{
		visitShop.setVisible(false);
		talkToStranger.setVisible(false);
		buy.setVisible(false);
		exitVillage.setVisible(false);
		
		visitShop.setEnabled(false);
		talkToStranger.setEnabled(false);
		buy.setEnabled(false);
		exitVillage.setEnabled(false);
		
		currentEnemy = 0;
		 area.setText("You leave the village and head North. you can see ruins on top of a hill. Between you and the hill is a horde of monsters");
		   numberOfEnemiesInArea = 8;
		   createNewStage();
		   targetArea.setText(monsterArray.get(currentEnemy).getName());
		   addButtons();
		  
		   drinkPotion.setEnabled(true);
		
	}
	
	public static void addVillageButtons()
	{
	
	// Buy Item
		 buy.setVisible(true);
		 buy.setSize(150, 50);
		 buy.setEnabled(false);
		 buy.setLocation(250, 100);
		 buy.setText("Buy Item");
		 panel.add(buy);
		 
		 if(buy.getActionListeners().length < 1)
		 {
			 buy.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {			   				  			  			
			   mainCharacter.setMoney(mainCharacter.getMoney() - 50);
				
			   currentArmor = currentVillage.getInShops();
			   
			   	showStats();
				giveArmorBonus(currentVillage.getInShops().getName());
				addVillageButtons();
				area.setText("You bought the " + currentVillage.getInShops().getName() + ". it will give you" + currentVillage.getInShops().getEffect() + "\n You leave the shop.");
				
				if(currentVillage == saTowVillage)
				{
					if(location  == "returningToSaTow" )
					{
						dragonArmor = true;
					}
					
					giveArmorBonus(dragonHideArmor.getName());
				}
				visitShop.setEnabled(false);
		   }
		 });
		 }
	
	// Visit Shop
		visitShop.setVisible(true);
		visitShop.setSize(150, 50);
		visitShop.setLocation(50, 100);
		visitShop.setText("Visit Shop");
		visitShop.setEnabled(true);
		 panel.add(visitShop);
		 
		 if(visitShop.getActionListeners().length < 1)
		 {
		 visitShop.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   if(mainCharacter.getMoney() >= 50)
				{
					buy.setEnabled(true);
					//addVillageButtons();
				}
				else
				{
					buy.setEnabled(false);
					//addVillageButtons();
				}
			   
			   
			   if(currentVillage.getInShops() == dragonHideArmor)
			   {
				   area.setText("You enter a shop and the owner tells you he can craft dragon armor out of your dragon hide.");
				   buy.setEnabled(true);
			   }
			   else
			   {
			   area.setText("You enter a shop and look at what is for sale. There is a " + currentVillage.getInShops().getName() + " for 50 gold");
			   }
			   
				
				
		   }
		   
		 });
		 }
	
	//Talk to a Stranger
		 talkToStranger.setVisible(true);
		 talkToStranger.setSize(150, 50);
		 talkToStranger.setLocation(50, 160);
		 talkToStranger.setText("Talk to a Stranger");
		 panel.add(talkToStranger);
		 
		 if(talkToStranger.getActionListeners().length < 1)
		 {
			 talkToStranger.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   area.setText("One of the locals gives you a wierd look and walks away. He must not like strangers.");
		   }
		 });
		 }
		 
	//Exit The village
		 exitVillage.setVisible(true);
		 exitVillage.setSize(150, 50);
		 exitVillage.setLocation(250, 160);
		 exitVillage.setText("Exit Village");
		 panel.add(exitVillage);
		 
		if(exitVillage.getActionListeners().length < 1)
		{
			 exitVillage.addActionListener(new ActionListener()
			 {
			   public void actionPerformed(ActionEvent e)
			   {
				  
				 setupNewLocation();
				  
				   
			   }
			 });
		}
	
	
	}//end of addVillageButtons
	
	public static void setupNewLocation() 
	{
		//sets up the first dungeon
		if(location == "stage1")
		{
			
			sneakCount = 0;
			area.setText(dungeon.getEntryText());
			mainCharacter.setWeapon1(dungeon.getEnterWeapon());
			attackWeapon1.setText(dungeon.getEnterWeapon().getName());
			
			currentEnemy = 0;
			numberOfEnemiesInArea = dungeon.getEnemyNum();
			inDungeon = true;
			location = "dungeon1";
			createNewStage();
		}
		//sets up fight with Flame Ogre
		else if(location == "dungeon1")
		{

			area.setText("You walk into the next room and see a giant Flame Ogre blocking the exit. It lets out a mighty roar."
					+ "\n You are in for the fight of your life.");
			currentBoss = flameOgre;
			location = "flameOgre";
			inDungeon = false;
			
			System.out.println("Error dungeon1");
		}
		else if(location == "flameOgre")
		{
			
			
			villageNumber = 1;
			
			currentVillage = village1;
			enterVillage();
			location = "TamoriVillage";
		}
		else if(location == "TamoriVillage")
		{
			
			location = "afterTamori";
			exitVillage();
			System.out.println("Error Tamori Village");
			inDungeon = true;
		}
		else if(location == "afterTamori")
		{
			waitSecs(0, "You walk into the ruins of the abandoned fort. Cobwebs are everywhere. You hear an ominous hissing.", false);
			
			waitSecs(3000, "There is a corpse of a man holding 10 potions. You take them", false);
			
			waitSecs(6000, "Then you look to the ceiling, where a Giant Spider sits, ready to pounce.", true);
			
			mainCharacter.setPotion(mainCharacter.getPotion() + 10);
			currentBoss = giantSpider;
			location = "inAbandonedFort/SamandoVillage";
			inDungeon = false;
			targetArea.setText("Giant Spider");
			
		}
		else if(location == "inAbandonedFort/SamandoVillage")
		{
			
			
			waitSecs(0, "You pass the corpse of the spider and look in a box. The box has a note inside. it reads: "
					+ "\nStop anyone from passing. If to many get to the castle all will be for nothing.", false);
			
			waitSecs(3000, "The spider's body is firmly wedged inside the East exit. You take the West exit.", false);
			
			waitSecs(6000, "There is a man outside who tells you a local legend.", false);
			
			waitSecs(9000, "There is a weapon that supposedly has incredible power. "
					+ "\nSamando, The Sa-Tow Village Leader, might have some information", false);
			
			waitSecs(12000, "You enter Sa-Tow Village and speak to Samando", false);
			
			waitSecs(15000, "He tells you that the weapon you heard from the traveler lies to the north in the Dragon Roosts", true);
			
			currentVillage = saTowVillage;
			villageNumber = 2;
			enterVillage();
			location = "roadAfterSaTow";
			
		}
		else if(location == "roadAfterSaTow")
		{
			numberOfEnemiesInArea = 3;
			createNewStage();
			area.setText("You exit the village and walk a ways. A man is being attacked by 3 monsters");
			
			
			addButtons();
			disableVillageButtons();
			location = "DragonRoost";
		}
		else if(location == "DragonRoost")
		{
			waitSecs(0, "You kill the monsters and you discuss each others plans for a while. "
					+ "\nThe man tells you that in order to enter the dragon roost, you need a special potion to protect you from heat", false);
			
			waitSecs(4000, "He gives you the required potion as a reward for saving him from the monsters. \n You drink the potion and enter the Dragon roost.", false);
			
			waitSecs(8000, " You see a giant Dragon standing in front of you."
			+ "\n behind the dragon is a small glowing rock, you ask the dragon what it is.", false);
			
			waitSecs(13000, "the dragon says that it is a powerful gem that, when united with a similar gem, will destroy every monster in the world"
			 +"\n You ask the dragon for the gem. The dragon Roars in delight and cackles you have to get through me first!", true);
		
			currentBoss = largeDragon;
			location = "returningToSaTow";
			inDungeon = false;
			targetArea.setText("Large Dragon");
		
		}
		else if(location == "returningToSaTow")
		{
			waitSecs(0, "You pull your sword out of the dragon and walk past it to pick up the stone."
					+ "\nIt is red with a warm glow.", false);
			
			waitSecs(4000, "You take a portion of the dragon's hide. You might be able to use it for something"
					+ "\nThen you leave the dragon roost and return to Sa-Tow Village", false);
		
			waitSecs(8000, "You speak to Samando who verifies the existence of the second stone."
					+ "\nSamando Tells you that the stones are powerful objects created by the two sages of power", false);
			

			waitSecs(12000, "The sage's power came from the stones. When united, they were unstopable."
					+ "\nEventually they wanted the power that the other held and they perished in combat with each other.", false);
		
			waitSecs(16000, "One is said to have the power to unite the stones in a prophesy, but we don't know the "
					+ "\nauthenticity of this prophesy.", true);
		
			saTowVillage.setInShops(dragonHideArmor);
			currentVillage = saTowVillage;
			enterVillage();
			location = "returnToFort";
		}
		else if(location == "returnToFort")
		{
			
			waitSecs(0, "You return to the fort to find that the Giant Spider corroded enough to pass through the East exit."
					+ "\nYou go through.", false);
			
			waitSecs(4000, "You walk down the road a ways and see a giant man up ahead."
					+ "\nAs you attempt to pass him he moves in your way.", false);
			
			waitSecs(8000, "He tells you that the path to the Abandoned Castle is being blocked by the orders of the Sage"
					+"\nYou attempt to resist, but the man sends you down a side road full of monsters.", true);
			
			numberOfEnemiesInArea = 10;
			createNewStage();
		
			
			addButtons();
		disableVillageButtons();
			location = "seasideVillage";
			
		}
		else if(location == "seasideVillage")
		{
			
			waitSecs(0, "You talk to the village leader, Seasondo, who tells you that they dont want to attract attention "
					+ "\nby making a fuss about you. They heal you and restock your potions", false);
			
			waitSecs(4000, "You leave the village and walk towards the beach. There is a small island out to sea"
					+ "\nWhen you look at the island, the stone starts to feel warmer", false);
			
			waitSecs(8000, "You enter the water and only begin to think 'I wish I had a boat,' when a brilliant flash "
					+ "\nlights up the beach. Floating in front of you is a small boat. You take it towards the island."
					+ "\nWhere a host of monsters waits to greet you", true);
			
			mainCharacter.setPotion(15);
			//change this to 10
			mainCharacter.setHP(10);
			
			numberOfEnemiesInArea = 15;
			createNewStage();
		
			addButtons();
			
			location = "IronIsland";
		}
		else if(location == "IronIsland")
		{
			waitSecs(0, "You walk past the monsters into an abandoned mine."
					+ "\nInside is a warning sign. Then you turn around to see the mouth of the mine close"
					+ "\n the cavern you are in trembles and suddenly realize, The Island is a Giant", false);
			
			waitSecs(5000, "You must attack very carefully from within the giant if you are to survive."
					+ "\nWhen you stab the inside of it's mouth, it violently lurches almost crushing you in its teeth ", true);
			
			currentBoss = giant;
			location = "goToCastle";
			inDungeon = false;
			targetArea.setText("Giant");
			
			
		}
		else if(location == "goToCastle")
		{
			waitSecs(0, "You kill the giant and its body sinks back down into the ocean. "
					+ "\nYou look around inside the giants mouth and you see that the giant has a cap on one of its teeth", false);
			
			waitSecs(4000, "One it's cap is a glowing blue stone. You take the stone and look at it for a minute"
					+ "\nThen the red stone floats out of your pocket and starts to meld with the blue one. "
					+ "\nYou feel stronger.", false);
			
			waitSecs(9000, "When the stones have finished melding, they glow a beutiful magenta color.  "
					+ "\n Then you start to dissolve. As you dissolve you hear a voice. "
					+ "\nYou are the master of all power, now free this world from the evil that has befallen us", false);
			
			waitSecs(15000, "The next thing you see is a courtyard, where a woman is chained."
					+ "\nShe tells you that she is a goddess, chained by the evil sage to take over the land"
					+ "\n All he needs is the powers of the stones you carry to meld his powers to hers and become an incarnite being", false);
			
			waitSecs(21000, "Then the sage steps out from behind a shadow and draws his sword."
					+ "\n he tells you that you are his counterpart. Two destined beings capable of using the powers of the melded stones"
					+ "\nThen he attacks", true);
			
		mainCharacter.setHP(25);
		mainCharacter.setAttack(20);
		mainCharacter.setDefense(mainCharacter.getDefense() + 10);
		mainCharacter.setPotion(20);
		showStats();
		
		currentBoss = sage;
		location = "TheEnd";
		inDungeon = false;
		targetArea.setText("Evil Sage");
		}
		else if(location == "TheEnd")
		{
			waitSecs(0, "The sage screams in agony as you pull your weapon from his chest."
					+ "\n Then he dissolves into a pile of ash.", false);
			
			waitSecs(4000, "You look towards the goddess who is no longer chained."
					+ "\nShe thanks you and gives some explanation.", false);
			
			waitSecs(8000, "You and the sage you just killed were opposite beings placed into the future by the "
					+ "\nTwo sages who drew their power from the stones.", false);
			
			waitSecs(12000, " Each of you were made to have the power to hold both stones."
					+ "\nIt was intended that the descendents would attempt to unite the stones and take over the kingdom.", false);
			
			waitSecs(17000, "However, the sages made a mistake. They did not tell you what your purpose was"
					+ "\nThis meant that you could choose to deny the task given to you. Now What will you choose?", true);
		
			disableAllButtons();
			setupEndButtons();
			
		}
		
	
	
	}
	
	public static void giveArmorBonus(String armor)
	{
		if(armor == "Light Armor")
		{
			
			mainCharacter.setDefense(mainCharacter.getDefense() + 1);
			
			
		}
		else if(armor == "Descent Armor" )
		{
			mainCharacter.setDefense(3);
			mainCharacter.setDefense(mainCharacter.getDefense() + travelerChestPlate.getDefense());
			
		}
		else if(armor == "Dragon Hide Armor")
		{
			
			mainCharacter.setDefense(3);
			mainCharacter.setDefense(mainCharacter.getDefense() + dragonHideArmor.getDefense());
		}
		showStats();
	}
	
	public static void waitSecs(int secs, String text, boolean lastText)
	{
		if(lastText == false)
		{
		Timer timer = new Timer(secs, new ActionListener() {
		    
			@Override
		    public void actionPerformed(ActionEvent e) 
		    {
		    	//make it to where the player cannot interact with the program while displaying text 
				disableAllButtons();

				area.setText(text);
			    
			    	
				
		    	
		    }
		});
		timer.setRepeats(false);
		timer.start();
		
		}
		else
		{
			Timer timer = new Timer(secs, new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) 
			    {
			    	
			    	area.setText(text);
			    	
			    	//resumes interaction with program
			    	enableAllButtons();
			    }
			});
			timer.setRepeats(false);
			timer.start();
		}
		
		
		
		
	}
	
	public static void disableAllButtons()
	{
		//Combat Buttons
		attackWeapon1.setEnabled(false);
		attackWeapon2.setEnabled(false);
		
		drinkPotion.setEnabled(false);
		
		//Village Buttons
		visitShop.setEnabled(false);
		talkToStranger.setEnabled(false);
		buy.setEnabled(false);
		exitVillage.setEnabled(false);
		
	
	}
	
	public static void disableVillageButtons()
	{
		visitShop.setEnabled(false);
		visitShop.setVisible(false);
		talkToStranger.setEnabled(false);
		talkToStranger.setVisible(false);
		buy.setEnabled(false);
		buy.setVisible(false);
		exitVillage.setEnabled(false);
		exitVillage.setVisible(false);
	
	}

	public static void enableAllButtons()
	{
		attackWeapon1.setEnabled(true);
		attackWeapon2.setEnabled(true);
		
		drinkPotion.setEnabled(true);
		
		//Village Buttons
		visitShop.setEnabled(true);
		talkToStranger.setEnabled(true);
		
		exitVillage.setEnabled(true);
	}
	
	
	

	
	public static void setupEndButtons()
	{
		System.out.println(attackWeapon1.getActionListeners().length);
		
		attackWeapon1.removeActionListener(listener1);
		attackWeapon2.removeActionListener(listener2);
		
		System.out.println(attackWeapon1.getActionListeners().length);
		
		attackWeapon1.addActionListener(new ActionListener()
		{
		   public void actionPerformed(ActionEvent e)
		   {
					area.setText("You take the stones and destroy every monster in the world."
							+ "\nThen you destroy them and live a simple life to the end of your days");
					attackWeapon1.setEnabled(false);
		   }

		});
		
		attackWeapon2.addActionListener(new ActionListener()
		 {
			   public void actionPerformed(ActionEvent e)
			   {
					area.setText("You use the stones to create an army out of the monsters and take over the kingdom"
							+ "\nYou rule the kingdom with an iron fist until you are killed three weeks later by a rebel.");
					attackWeapon2.setEnabled(false);
			   }

			});
		
		System.out.println(attackWeapon1.getActionListeners().length);
		
		attackWeapon1.setText("Be the Hero");
		attackWeapon2.setText("Take over Kingdom");
		
		drinkPotion.setEnabled(false);
		drinkPotion.setVisible(false);
		
	}

}//end Class



