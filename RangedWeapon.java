package simpleRPG;

public class RangedWeapon extends SimpleRPG
{
	public static  String name;
	public static int attack;

	public RangedWeapon(String Name, int Attack) 
	{
		name = Name;
		attack = Attack;
	}

	public String getName() {
		return name;
	}

	public int getAttack() {
		return attack;
	}
	
	
	
	
	
}
