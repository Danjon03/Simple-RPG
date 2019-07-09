package simpleRPG;

public class Village extends SimpleRPG
{
	private String name;
	private String LeaderName;
	private String info;
	private Armor InShops;
	
	
	public Village(String Name, String leaderName, String whatLeaderSays, Armor inShops )
	{
		name = Name;
		LeaderName = leaderName;
		info = whatLeaderSays;
		InShops = inShops;
	}


	public String getName() {
		return name;
	}


	public String getLeaderName() {
		return LeaderName;
	}


	public String getInfo() {
		return info;
	}


	public Armor getInShops() {
		return InShops;
	}
	
	
	public void setInShops(Armor inShop)
	{
		InShops = inShop;
	}
	
	
	
	
}
