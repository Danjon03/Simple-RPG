package simpleRPG;



public class Weapons extends SimpleRPG
{
	public String name;
	public int attack;
	
	public Weapons(String Name, int Attack)
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
