package simpleRPG;

public class You 
{
	private int HP;
	private static int Defense;
	private int Attack;
	private Weapons weapon1;
	private RangedWeapon weapon2;
	private int Money;
	
	private int potion;
	
	private int dodge;
	
	
	public You(int YourHP, int YourDefense, int YourAttack, Weapons Weapon1, RangedWeapon Weapon2, int YourMoney, int HealthPotions, int Yourdodging) 
	{
		HP = YourHP;
		Defense = YourDefense;
		Attack = YourAttack;
		weapon1 = Weapon1;
		weapon2 = Weapon2;
		
		Money = YourMoney;
		
		potion = HealthPotions;
		
		dodge = Yourdodging;
	}
	
	
	
	public int getDefense() 
	{
		return Defense;
	}
 
	public void setDefense(int defense) {
		Defense = defense;
	}

	public int getAttack() {
		return Attack;
	}

	public void setAttack(int attack) {
		Attack = attack;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money) {
		Money = money;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getPotion() {
		return potion;
	}

	public void setPotion(int potions) {
		potion = potions;
	}

	public Weapons getWeapon1() {
		
		return weapon1;
		
	}

	public RangedWeapon getWeapon2() {
		return weapon2;
	}

	public void setWeapon1(Weapons weapon )
	{
		weapon1 = weapon;
	}
	
	public void setWeapon2(RangedWeapon weapon)
	{
		weapon2 = weapon;
	}
	
	public int getHP()
	{
		return HP;
	}

	public int getDodge() {
		return dodge;
	}

	public void setDodge(int dodgeing) {
		dodge = dodgeing;
	}
	
	
}
