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
	
}
