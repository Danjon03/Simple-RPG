package simpleRPG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SimpleRPG {

	
	 public static  JFrame mainFrame = new JFrame();
	
	 public static  JPanel panel = new JPanel();
	
	 
	
	 public static JTextArea area = new JTextArea();
	 public static JTextArea targetArea = new JTextArea();
	 public static JTextArea stats = new JTextArea();
	 
	 public static JButton attackWeapon2 = new JButton();
	 public static  JButton attackWeapon1 = new JButton();
	 
	
	 public static String Weapon1 = You.getWeapon1();
	 public static String Weapon2 = You.getWeapon2();
	
	 
	 public static You you = new You(10, 3, 2, "Blunt Sword", 4, "Mini Blaster", 5, 0, 0, 10);
	 public Goblin goblin = new Goblin(10, 5); 
	 
	
	 

	 public static int KillCount = 0;
	 public static int lastButton;
	
	 public static String targetedEnemy = "Goblin";
	 
	 public static boolean dead = true;
	 public static boolean inDungeon = false;
	
	
	 
	 public static void main(String[] args) {
		
		 
		setup();
		//sets up the JFrame 
		
	 }
	
	
	public static void setup()
	 {
		
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
		 targetArea.setText(targetedEnemy);
		 
		 showStats();
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
	
	public static void addButtons()
	{
		//button 1
		
		 attackWeapon1.setVisible(true);
		 attackWeapon1.setSize(150, 50);
		 attackWeapon1.setLocation(50, 100);
		 attackWeapon1.setText(You.getWeapon1());
		 System.out.println(You.getWeapon1());
		 attackWeapon1.setEnabled(dead);
		 panel.add(attackWeapon1);
		 attackWeapon1.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   lastButton = 1;
		    
			   if(inDungeon == true)
			   {
				   FightinDungeon.main();
			   }
			   else
			   {
				   attack(1);
			   }
		   }
		   
		 });
		 
		 //button 2
		 
		 
		 attackWeapon2.setVisible(true);
		 attackWeapon2.setSize(150, 50);
		 attackWeapon2.setLocation(250, 100);
		 attackWeapon2.setText(You.getWeapon2());
		 System.out.println(You.getWeapon2());
		 attackWeapon2.setEnabled(dead);
		 panel.add(attackWeapon2);
		 attackWeapon2.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   lastButton = 2;
			   if(inDungeon == true)
			   {
				   	FightinDungeon.main();
			   }
			   else
			   {
				   attack(2);
			   }
		    
		   }
		 });
	
		 //drink a potion
		 JButton drinkPotion = new JButton();
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
			   if(You.getPotion() == 0)
			   {
				   area.setText("You don't have any more potions");
			   }
			   else
			   {
			   You.setPotion(You.getPotion() - 1);
			   You.setHP(10);
			   stats.setText("HP: " + You.getHP() + "\n" + "Defense Modifier: " + You.getDefense() + "\n" + "Attack Modifier: " 
						+ You.getAttack() + "\n" + "Number of Potions: " + You.getPotion());
		   
			   }
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
		stats.setText("HP: " + You.getHP() + "\n" + "Defense Modifier: " + You.getDefense() + "\n" + "Attack Modifier: " 
						+ You.getAttack() + "\n" + "Number of Potions: " + You.getPotion());
		
		
	
	
	
	}
	
	
	
	
	public static void attack(int button)
	{
		
		if(KillCount == 5)
		{
			
			area.setText(Dungeon1.getEntryText());
			You.setWeap1At(8);
			You.setWeapon1("Sharp Sword");
			attackWeapon1.setText("Sharp Sword");
			inDungeon = true;
		
		
			  area.setText(Dungeon1.getEntryText());
			 
				
		}
		
		else
		{
		if(targetedEnemy == "Goblin") 
		{
			
			attackGoblin(button);	
		}
		else if(targetedEnemy == "Werewolf")
		{
			attackWerwolf(button);
		}	
		else
		{
			area.setText("You Are Not Targeting an Enemy");
		}	
	}
	}

	
	public static void createNewEnemy()
	{
		Goblin.reset();
		Werwolf.reset();
		Mummy.reset();
		
		KillCount++;
			System.out.println(KillCount);
			
				Random rand = new Random();
				
				int n = rand.nextInt(99);
				if(n <= 50)
				{
					targetedEnemy = "Werewolf";
					
				}
				else if(n >= 50)
				{
					targetedEnemy = "Goblin";
				}
				targetArea.setText(targetedEnemy);
			}
		
	
	
	
	public static void attackGoblin(int button)
	{
		if(button == 1)
		{
			int diceRoll = You.getWeap1At() + D4();
			
			Goblin.setHP(Goblin.getHP() - diceRoll);
			
				if(Goblin.getHP() <= 0)
				{
					area.setText("You Killed the Goblin Now there is another monster Attacking You");
					if(inDungeon == true)
					{
						FightinDungeon.createNewEnemyInDungeon();
					}
					else
					{
					createNewEnemy();
					}
				}
				else
				{
					You.setHP( You.getHP() - (Goblin.getAttack() - You.getDefense()));
					if(You.getHP() <= 0)
					{
						area.setText("You Died, Game Over");
						dead = false;
						addButtons();
					}
					else
					{
					area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (Goblin.getAttack() - You.getDefense()) + " Damage");
					}
				}
		
		
		}
		else
		{
			int diceRoll = You.getWeap2At() + D4();
			Goblin.setHP(Goblin.getHP() - diceRoll);
			
				if(Goblin.getHP() <= 0)
				{
					area.setText("You Killed the Goblin Now there is another monster Attacking You");
					
					area.setText("You Killed the Goblin Now there is another monster Attacking You");
					if(inDungeon == true)
					{
						FightinDungeon.createNewEnemyInDungeon();
					}
					else
					{
					createNewEnemy();
					}
				}
				else
				{
					You.setHP( You.getHP() - (Goblin.getAttack() - You.getDefense()));

					if(You.getHP() <= 0)
					{
						area.setText("You Died, Game Over");
						dead = false;
						addButtons();
					}
					else
					{
					area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (Goblin.getAttack() - You.getDefense()) + " Damage");
					}
				}
			
		}
		stats.setText("HP: " + You.getHP() + "\n" + "Defense Modifier: " + You.getDefense() + "\n" + "Attack Modifier: " 
				+ You.getAttack() + "\n" + "Number of Potions: " + You.getPotion());
	}
	
	
	public static void attackWerwolf(int button)
	{
		if(button == 1)
		{
			int diceRoll = You.getWeap2At() + D4();
			
			Werwolf.setHP(Werwolf.getHP() - diceRoll);
			
				if(Werwolf.getHP() <= 0)
				{
					area.setText("You Killed the Werewolf Now there is another monster Attacking You");
					
					
					if(inDungeon == true)
					{
						FightinDungeon.createNewEnemyInDungeon();
						System.out.print("Enemy Killed in Dungeon");
					}
					else
					{
					createNewEnemy();
					}
				}
				else
				{
					You.setHP( You.getHP() - (Werwolf.getAttack() - You.getDefense()));

					if(You.getHP() <= 0)
					{
						area.setText("You Died, Game Over");
						dead = false;
						addButtons();
					}
					else
					{
					area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (Werwolf.getAttack() - You.getDefense()) + " Damage");
					}
				}
		
				
		}
		else
		{
			int diceRoll = You.getWeap2At() + D4();
			Werwolf.setHP(Werwolf.getHP() - diceRoll);
			
				if(Werwolf.getHP() <= 0)
				{
					area.setText("You Killed the Werwolf Now there is another monster Attacking You");
					
					
					if(inDungeon == true)
					{
						FightinDungeon.createNewEnemyInDungeon();
					}
					else
					{
						createNewEnemy();
					}
				}
				else
				{
					You.setHP( You.getHP() - (Werwolf.getAttack() - You.getDefense()));
					if(You.getHP() <= 0)
					{
						area.setText("You Died, Game Over");
						dead = false;
						addButtons();
					}
					else
					{
					area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (Goblin.getAttack() - You.getDefense()) + " Damage");
					}
				}
			
		}
		stats.setText("HP: " + You.getHP() + "\n" + "Defense Modifier: " + You.getDefense() + "\n" + "Attack Modifier: " 
				+ You.getAttack() + "\n" + "Number of Potions: " + You.getPotion());
	}
	
	public static void attackMummy(int button)
	{
		if(button == 1)
		{
			int diceRoll = You.getWeap1At() + D4();
			
			Mummy.setHP(Mummy.getHP() - diceRoll);
			
				if(Mummy.getHP() <= 0)
				{
					area.setText("You Killed the Mummy Now there is another monster Attacking You");
					
					if(inDungeon == true)
					{
						FightinDungeon.createNewEnemyInDungeon();
					}
					else
					{
					createNewEnemy();
					}
				}
				else
				{
					You.setHP( You.getHP() - (Mummy.getAttack() - You.getDefense()));

					if(You.getHP() <= 0)
					{
						area.setText("You Died, Game Over");
						dead = false;
						addButtons();
					}
					else
					{
					area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (Mummy.getAttack() - You.getDefense()) + " Damage");
					}
				}
		
				
		}
		else
		{
			int diceRoll = You.getWeap2At() + D4();
			Mummy.setHP(Mummy.getHP() - diceRoll);
			
				if(Mummy.getHP() <= 0)
				{
					area.setText("You Killed the Werwolf Now there is another monster Attacking You");
					
					if(inDungeon == true)
					{
						FightinDungeon.createNewEnemyInDungeon();
					}
					else
					{
					createNewEnemy();
					}
				}
				else
				{
					You.setHP( You.getHP() - (Mummy.getAttack() - You.getDefense()));
					if(You.getHP() <= 0)
					{
						area.setText("You Died, Game Over");
						dead = false;
						addButtons();
					}
					else
					{
					area.setText( "You Dealt " + diceRoll + " Damage" + "\n" + "You took " + (Mummy.getAttack() - You.getDefense()) + " Damage");
					}
				}
			
		}
		stats.setText("HP: " + You.getHP() + "\n" + "Defense Modifier: " + You.getDefense() + "\n" + "Attack Modifier: " 
				+ You.getAttack() + "\n" + "Number of Potions: " + You.getPotion());

	}
	
	

	
	
	

}//end Class
