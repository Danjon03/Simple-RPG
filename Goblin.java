package simpleRPG;

public class Goblin 
{
	
	public static  int HP = 10;
	public static int Attack = 5;

	public Goblin(int OHP, int OAttack) 
	{
		HP = OHP;
		Attack = OAttack;
	}

	public static int getHP() {
		return HP;
	}

	public static void setHP(int hP) {
		HP = hP;
	}

	public static int getAttack() {
		return Attack;
	}

	public static void setAttack(int attack) {
		Attack = attack;
	}

	
	public static void reset()
	{
		HP = 10;
		Attack = 4;
	}

	
	
	
	
	
	
	
}
