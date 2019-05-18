package simpleRPG;

public class Monsters extends SimpleRPG
{
	
	private   int HP;
	private int Attack;
	private String name;
	private boolean alive;
	
	public  Monsters(int OHP, int OAttack, String Name, boolean isAlive) 
	{	
		HP = OHP;
		Attack = OAttack;
		name = Name;
		alive = isAlive;
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
	
	public boolean getAlive()
	{
		return alive;
	}
}
