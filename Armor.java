package simpleRPG;

public class Armor extends SimpleRPG
{
	
	private int df;
	private String Effect;
	private int effectModifier;
	private String name;
	
	
	public Armor(int defense, String effect, int effectMod, String Name) 
	{
		df = defense;
		Effect = effect;
		effectModifier = effectMod;
		name = Name;
		
		
	}


	public int getDefense() {
		return df;
	}

	public String getEffect() {
		return Effect;
	}

	public int getEffectModifier()
	{
		return effectModifier;
	}


	public String getName() {
		return name;
	}


	
	
	
	
	
	
}
