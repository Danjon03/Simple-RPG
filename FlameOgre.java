package simpleRPG;

public class FlameOgre 
{
	public static  int HP = 40;
	public static int Attack = 5;

	public FlameOgre(int OHP, int OAttack) 
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
