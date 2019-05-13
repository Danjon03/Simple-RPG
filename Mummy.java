package simpleRPG;

public class Mummy 
{
	public static  int HP = 10;
	public static int Attack = 8;

	public Mummy(int OHP, int OAttack) 
	{
		HP = OHP;
		Attack = OAttack;
	}
	
	public static void reset()
	{
		HP = 15;
		Attack = 5;
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
	
	
	
	
}
