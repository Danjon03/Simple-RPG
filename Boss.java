package simpleRPG;

public class Boss extends SimpleRPG 
{

	private   int HP;
	private int Attack;
	private String name;
	private int defense;
	
	public  Boss(int OHP, int OAttack, String Name, int Defense) 
	{	
		HP = OHP;
		Attack = OAttack;
		name = Name;
		defense = Defense;
	}
	
	public String getName()
	{
		return name;
	}

	public int getAttack()
	{
		return Attack;
	
	}
	
	
	public int getHP()
	{
		return HP;
	}

	
	public void setHP(int newHP)
	{
		HP = newHP;
	}
	
	public int getDefense()
	{
		return defense;
	}
	
	public void attackPlayer()
	{
		System.out.println("Using attackPlayer");
		currentBoss.setHP(currentBoss.getHP() - yourDamage);
		System.out.println(currentBoss.getHP());
		if(currentBoss.getHP() <= 0)
		{
			currentBoss.getHP();
			setupNewLocation();
		}
		else
		{	
				if(D4() >= 90)
				{
					area.setText("You dodged the " + currentBoss.getName() + "'s attack. You dealt " + yourDamage + " damage");
				}
				else
				{
					mainCharacter.setHP(mainCharacter.getHP() - (currentBoss.getAttack() - mainCharacter.getDefense()));
					area.setText("You took " + (currentBoss.getAttack() - mainCharacter.getDefense()) + " from the " + currentBoss.getName() + 
							" and you dealt " + yourDamage + " damage" );
					showStats();
					
					if(mainCharacter.getHP() <= 0)
					{
						area.setText("You were killed at the hands of the " + currentBoss.getName());
						end();
					}
				}
			
		}
	
	
	}
}
