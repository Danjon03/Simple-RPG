package simpleRPG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SimpleRPG 
{

	
	
	
	//JFrame related Variables
	private  static JFrame mainFrame = new JFrame();
	private  static JPanel panel = new JPanel();
	private static JTextArea area = new JTextArea();
	private static JTextArea targetArea = new JTextArea();
	private static JTextArea stats = new JTextArea();
	 
	 //Fighting buttons
	private static JButton attackWeapon2 = new JButton();
	private static  JButton attackWeapon1 = new JButton();
	private static  JButton sneak = new JButton();
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
	  static Armor stealthyCloak = new Armor(0, "Increased stealth", 3, "Stealthy Cloak");
	
	 //Bosses
	 public static Boss flameOgre = new Boss(40, 8, "Flame Ogre", 0);
	 public static Boss giantSpider = new Boss(80, 7, "Giant Spider", 5);
	 
	//strings ints ect
	 public static boolean inDungeon = false;
	 public static int numberOfEnemiesInArea = 5;
	 public static int villageNumber = 1;
	 
	 //default is stage1 you can set where you start in the game with this variable
	 public static String location = "stage1";
	 public static ArrayList<Monsters> monsterArray = new ArrayList<Monsters>();
	 
	 //Constructor for player
	 static You mainCharacter = new You(10, 3, 2, bluntSword, miniBlaster, 0, 10, 0);
	 
	 //location objects
	 public static Dungeon1 dungeon = new Dungeon1(sharpSword, 10, "You enter a cave and see a sign. it reads... \n"
			 + " Beware traveler many dangers await you. Pass and you will be closer to freedom. You look down and pick up a weapon. "
			 + "You replace your sword with a Sharp Sword \n"
			 + "You instantly look up to see a monster.", "Small Blaster", flameOgre);
	 
	 
	 public static void main (String[] args)
	 {
		
		 setup();
	 }
	
	public static void setup()
	 {
		
		
		createNewStage();
		 mainFrame.setVisible(true);
		 mainFrame.setSize(800, 800);
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
		 area.setText("You have entered into a deep forest. Monsters are trying to kill you. You must escape. \n" + "Oh no! there is a Goblin attacking you.");
		 
		//adds the buttons 
		addButtons();
		
		 targetArea.setVisible(true);
		 targetArea.setEditable(false);
		 targetArea.setLocation(50, 270);
		 targetArea.setSize(200, 50);
		 panel.add(targetArea);
		 targetArea.setText(monsterArray.get(0).getName());
		 
		 showStats();
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
	public static void addButtons()
	{
		//button 1
		
		 attackWeapon1.setVisible(true);
		 attackWeapon1.setSize(150, 50);
		 attackWeapon1.setLocation(50, 100);
		
		 attackWeapon1.setText(mainCharacter.getWeapon1().getName());
		
		 attackWeapon1.setEnabled(true);
		 panel.add(attackWeapon1);
		 attackWeapon1.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   
			 
				   attackMonster(1);
			 
		   }
		   
		 });
		 
		 //button 2
		 
		 
		 attackWeapon2.setVisible(true);
		 attackWeapon2.setSize(150, 50);
		 attackWeapon2.setLocation(250, 100);
		 attackWeapon2.setText(mainCharacter.getWeapon2().getName());
		 
		 attackWeapon2.setEnabled(true);
		 panel.add(attackWeapon2);
		 attackWeapon2.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {			   				  			  			
					   attackMonster(2);						   		    
		   }
		 });
	
		 //drink a potion
		 
		 drinkPotion.setVisible(true);
		 drinkPotion.setSize(150, 50);
		 drinkPotion.setLocation(50, 160);
		 drinkPotion.setText("Drink a Potion");
		 //drinkPotion.setEnabled(dead);
		 panel.add(drinkPotion);
		 drinkPotion.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   if(mainCharacter.getPotion() == 0)
			   {
				   area.setText("mainCharacter don't have any more potions");
			   }
			   else
			   {
			   mainCharacter.setPotion(mainCharacter.getPotion() - 1);
			   mainCharacter.setHP(10);
			showStats();
		   
			   }
			   }
		 });
	
		
		 sneak.setVisible(true);
		 sneak.setSize(150, 50);
		 sneak.setLocation(250, 160);
		 sneak.setText("Sneak");
		
		
		 panel.add(sneak);
		 sneak.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   
			   if(sneakCount != 0)
			   {
				   area.setText("The Monsters already see you. You can't sneak around them");
				  
			   }
			   else
			   {
				   if(currentEnemy >= monsterArray.size() - 2)
				   {
					  
					   area.setText("You can't sneak around these monsters");
				   }
				   else
				   {
					  int sneakDamage = D4() + D4() - mainCharacter.getDefense();
					 
					   
					   if(D20() >= 15 - mainCharacter.getDodge())
					   {
						   area.setText("mainCharacter sneaked around a group of monsters");
						   currentEnemy = currentEnemy + 3;
						   targetArea.setText(monsterArray.get(currentEnemy).getName());
						  
					   }
					   else
					   {
						   area.setText("You were seen trying to sneak around a group of monsters and you took " + sneakDamage + " damage");
						   mainCharacter.setHP(mainCharacter.getHP() - sneakDamage);
						   sneakCount = 3;
						  
					   }
					
				   }
			   }
			   
			   showStats();
			   
		   }
		 });
	
	
	
	
	}
    
	public static void showStats()
	{
		
		stats.setVisible(true);
		stats.setEditable(false);
		stats.setLocation(50, 350);
		stats.setSize(200, 300);
		panel.add(stats);
		stats.setText("HP: " + mainCharacter.getHP() + "\n" + "Defense Modifier: " + mainCharacter.getDefense() + "\n" + "Attack Modifier: " 
						+ mainCharacter.getAttack() + "\n" + "Number of Potions: " + mainCharacter.getPotion() + "\n" + "Gold: " + mainCharacter.getMoney());
		
		
	
	
	
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
						fightBoss();
						sneak.setEnabled(false);
					}
					else
					{
						setupNewLocation();
					
					
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
			sneak.setEnabled(false);
			drinkPotion.setEnabled(false);
			
			attackWeapon2.setVisible(false);
			attackWeapon1.setVisible(false);
			sneak.setVisible(false);
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
	
	public static int times = 0;
	public static  void fightBoss()
	{
		
		if(times == 0)
		{
			area.setText("You walk into the next room and see a giant " + dungeon.getBoss().getName() + " tower above you. You must kill it to escape");
			targetArea.setText(dungeon.getBoss().getName());
		}
		
		
		
		else
		{
		
			dungeon.getBoss().setHP(dungeon.getBoss().getHP() - yourDamage);
		
		if(dungeon.getBoss().getHP() <= 0)
		{
			inDungeon = false;
			setupNewLocation();
			
			
			
		}
		else
		{
			
			
				if(D4() >= 90)
				{
					area.setText("You dodged the " + dungeon.getBoss().getName() + "'s attack. You dealt " + yourDamage + " damage");
				}
				else
				{
					mainCharacter.setHP(mainCharacter.getHP() - (dungeon.getBoss().getAttack() - mainCharacter.getDefense()));
					area.setText("You took " + dungeon.getBoss().getAttack() + " from the " + dungeon.getBoss().getName() + " and you dealt " + yourDamage + " damage" );
					showStats();
					
					if(mainCharacter.getHP() <= 0)
					{
						area.setText("You were killed at the hands of the " + dungeon.getBoss().getName());
						end();
					}
				}
			
		}
		}
		times++;
		
		}
	
	public static Village village1 = new Village("Tamori Village", "Tamando", "The monsters you have fought have been causing trouble. We give you 100 gold.", stealthyCloak);
	
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
		
		 area.setText("You leave the village and head North. you can see ruins on top of a hill. Between you and the hill is a horde of monsters");
		   numberOfEnemiesInArea = 8;
		   createNewStage();
		   targetArea.setText(monsterArray.get(currentEnemy).getName());
		   addButtons();
		   sneak.setEnabled(true);
		   drinkPotion.setEnabled(true);
		
	}
	
	public static void addVillageButtons()
	{
		 buy.setVisible(true);
		 buy.setSize(150, 50);
		 buy.setEnabled(false);
		 buy.setLocation(250, 100);
		 buy.setText("Buy Item");
		 
		 
		 panel.add(buy);
		 buy.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {			   				  			  			
			   mainCharacter.setMoney(mainCharacter.getMoney() - 50);
				showStats();
				giveArmorBonus(village1.getInShops());
				addVillageButtons();
				area.setText("You bought the " + village1.getInShops() + ". it will help you to sneak past monsters"
						+ "\n You leave the shop.");
				visitShop.setEnabled(false);
		   }
		 });
		
		
		
		
		
		visitShop.setVisible(true);
		visitShop.setSize(150, 50);
		visitShop.setLocation(50, 100);
		visitShop.setText("Visit Shop");
		
		visitShop.setEnabled(true);
		 panel.add(visitShop);
		 visitShop.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   area.setText("You enter a shop and look at what is for sale. There is a " + village1.getInShops() + " for 50 gold");
			 
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
				
		   }
		   
		 });
		 
		 //button 2
		 
		 
		
	
		 //drink a potion
		
		 talkToStranger.setVisible(true);
		 talkToStranger.setSize(150, 50);
		 talkToStranger.setLocation(50, 160);
		 talkToStranger.setText("Talk to a Stranger");
		 //drinkPotion.setEnabled(dead);
		 panel.add(talkToStranger);
		 talkToStranger.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   area.setText("One of the locals gives you a wierd look and walks away. He must not like strangers.");
			
			   
			   
		   }
		 });
	
		 exitVillage.setVisible(true);
		 exitVillage.setSize(150, 50);
		 exitVillage.setLocation(250, 160);
		 exitVillage.setText("Exit Village");
		 //drinkPotion.setEnabled(dead);
		 panel.add(exitVillage);
		 exitVillage.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			  
			   setupNewLocation();
			  
			   
		   }
		 });
		 
	}
	
	public static void setupNewLocation()
	{
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
		else if(location == "dungeon1")
		{
			villageNumber = 1;
			enterVillage();
			location = "TamoriVillage";
		}
		else if(location == "TamoriVillage")
		{
			location = "afterTamori";
			exitVillage();
			System.out.println(location);
		}
		else if(location == "afterTamori")
		{
			area.setText("You walk into the ruins of the abandoned fort. Cobwebs are everywhere. You hear an ominous hissing. "
					+ "\n You look around and see a corpse on the grounds it is holding 10 potions. You take them and move on."
					+ "\n Then you see the giant spider looking down on you.");
			mainCharacter.setPotion(mainCharacter.getPotion() + 10);
			location = "inAbandonedFort";
			dungeon.setBoss(giantSpider);
			inDungeon = true;
			
			System.out.println(location);
			
		}
		else if(location == "inAbandonedFort")
		{
			area.setText("You pass the corpse of the spider and look in a box. The box has a note inside. it reads:"
					+ "\n Stop anyone from passing. If to many get to the castle all will be for nothing."
					+ "\n To Be Continued...");
		}
	
	}

	public static void giveArmorBonus(String armor)
	{
		if(armor == "Stealthy Cloak")
		{
			mainCharacter.setDodge(stealthyCloak.getEffectModifier());
			System.out.println(mainCharacter.getDodge());
		}
	}
	
	
}//end Class



