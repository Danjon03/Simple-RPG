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

	
	
	


	


	public  static JFrame mainFrame = new JFrame();
	
	 public  static JPanel panel = new JPanel();
	
	 
	
	 public static JTextArea area = new JTextArea();
	 public static JTextArea targetArea = new JTextArea();
	 public static JTextArea stats = new JTextArea();
	 
	 public static JButton attackWeapon2 = new JButton();
	 public static  JButton attackWeapon1 = new JButton();
	 
	
	
	
	 
	 public static You you = new You(100, 3, 2, "Blunt Sword", 4, "Mini Blaster", 5, 0, 0, 10);
	
	 
	

	 
	
	
	 public static String targetedEnemy = "Goblin";
	 
	 public static boolean dead = true;
	 public static boolean inDungeon = false;
	
	
	 
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
		 targetArea.setText(monsterArray[0].getName());
		 
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
		
		 attackWeapon1.setEnabled(dead);
		 panel.add(attackWeapon1);
		 attackWeapon1.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   
			 if(inDungeon == true)
			 {
				 dungeon.attackMonsterinDungeon(1);
				 
			 }
			 else
			 {
				   attackMonster(1);
			 } 
		   }
		   
		 });
		 
		 //button 2
		 
		 
		 attackWeapon2.setVisible(true);
		 attackWeapon2.setSize(150, 50);
		 attackWeapon2.setLocation(250, 100);
		 attackWeapon2.setText(You.getWeapon2());
		 
		 attackWeapon2.setEnabled(dead);
		 panel.add(attackWeapon2);
		 attackWeapon2.addActionListener(new ActionListener()
		 {
		   public void actionPerformed(ActionEvent e)
		   {
			   
				  
			   
			   
			   
			  
			   if(inDungeon == true)
				 {
					 dungeon.attackMonsterinDungeon(2);
					 
				 }
				 else
				 {
					   attackMonster(2);
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
			   if(you.getPotion() == 0)
			   {
				   area.setText("You don't have any more potions");
			   }
			   else
			   {
			   you.setPotion(you.getPotion() - 1);
			   you.setHP(10);
			showStats();
		   
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
		stats.setText("HP: " + you.getHP() + "\n" + "Defense Modifier: " + you.getDefense() + "\n" + "Attack Modifier: " 
						+ you.getAttack() + "\n" + "Number of Potions: " + you.getPotion());
		
		
	
	
	
	}
	
	
	public static  int currentEnemy = 0;
	public static int yourDamage;
	
	public static Dungeon1 dungeon = new Dungeon1("Sharp Sword", 10, "You enter a cave and see a sign. it reads... \n"
			 + " Beware traveler many dangers await you. Pass and you will be closer to freedom. You look down and pick up a weapon. "
			 + "You replace your sword with a Sharp Sword \n"
			 + "You instantly look up to see a monster.", "Small Blaster", new Monsters(40, 8, "Flame Ogre", true));
	
	
	public static void attackMonster(int button)
	{
		
		
		
		
				
				if(button == 1)
				{
					yourDamage = you.getWeap1At() + D4() + you.getAttack();
				}
				else
				{
					yourDamage = you.getWeap2At() + D4() + you.getAttack();
				}
				
				if(currentEnemy == monsterArray.length - 1)
				{
					area.setText("You Win");
					end();
				}
				else
				{
				//sets the monsters HP
				monsterArray[currentEnemy].setHP( monsterArray[currentEnemy].getHP() - yourDamage);
					
				//if monster is dead move on to the next monster
					if(monsterArray[currentEnemy].getHP() <= 0)
					{
						
						currentEnemy++;
					
						
							targetArea.setText(monsterArray[currentEnemy].getName());
							area.setText("You killed the " + monsterArray[currentEnemy - 1].getName());
							
						
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
		}
		
			
	

	public static void monsterAttack()
	{
		
	
		
			if(D20() >= 90)
			{
				area.setText("You dealt: " + yourDamage + " and the " + monsterArray[currentEnemy].getName() + " missed");
			}
			else
			{
				you.setHP(  you.getHP() - monsterArray[currentEnemy].getAttack() + you.getDefense());
				area.setText("You dealt: " + yourDamage + " and the  " + monsterArray[currentEnemy].getName() + 
						" dealt " +(monsterArray[currentEnemy].getAttack() - you.getDefense()) + " damage" );
			}
			
				showStats();

			if(you.getHP() <= 0)
			{
				area.setText("You were killed by a " + monsterArray[currentEnemy].getName() );
				attackWeapon1.setEnabled(false);
				attackWeapon2.setEnabled(false);
				
				
		}	
	}
	
	
	
	   public static Monsters[] monsterArray = new Monsters[5];
	 
	 
	 
	public static void createNewStage()
	{
		
		for(int i = 0; i < monsterArray.length; i++)
		{
			Random monsterChoose = new Random();
			int r = monsterChoose.nextInt(99);
			
			if(r <= 50)
			{
				monsterArray[i] = new Monsters(10, 5, "Goblin", true);
				System.out.println("new Goblin");
			}
			else if(r > 50 && r <= 100)
			{
				monsterArray[i] = new Monsters(10, 5, "Werewolf", true);
				System.out.println("new Werewolf");
			}
			
		}

		
			
	}

	/*
	public static void monsterAttackinDungeon()
	{
		
		if(D20() >= 90)
		{
			area.setText("You dealt: " + yourDamage + " and the " + Dungeon1.dungonMonsterArray[currentEnemy].getName() + " missed");
		}
		else
		{
			you.setHP(  you.getHP() - monsterArray[currentEnemy].getAttack() + you.getDefense());
			area.setText("You dealt: " + yourDamage + " and the  " + Dungeon1.dungonMonsterArray[currentEnemy].getName() + " dealt " + (Dungeon1.dungonMonsterArray[currentEnemy].getAttack() - you.getDefense()) + " damage" );
		}
		
			showStats();


	}
	
	
	public  void fightBoss()
	{
		targetArea.setText(Dungeon1.getBoss().getName());
		Dungeon1.getBoss().setHP(Dungeon1.getBoss().getHP() - yourDamage);
		
		if(Dungeon1.getBoss().getHP() <= 0)
		{
			currentEnemy++;
			
			area.setText("You killed the " + Dungeon1.getBoss().getName() + " you walk outside and take a deep breath. You have escaped.");
			
		}
		else
		{
			if(D4() >= 90)
			{
				area.setText("You dodged the " + Dungeon1.getBoss().getName() + "'s attack. You dealt " + yourDamage + " damage");
			}
			else
			{
				you.setHP(you.getHP() - Dungeon1.getBoss().getAttack());
				area.setText("You took " + Dungeon1.getBoss().getAttack() + " from the Flame Ogre and you dealt " + yourDamage + " damage" );
				showStats();
			}
		}
		
		
	}
	
	*/
	
	

}//end Class
