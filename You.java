package simpleRPG;

public class You 
{
	private static int HP;
	private static int Defense;
	private static int Attack;
	private static String Weapon1;
	private static String Weapon2;
	private static int Money;
	private static int XP;
	private static int potion;
	private static int Weap1At;
	private static int Weap2At;
	
	public static int getDefense() 
	{
		return Defense;
	}

	public static void setDefense(int defense) {
		Defense = defense;
	}

	public static int getAttack() {
		return Attack;
	}

	public static void setAttack(int attack) {
		Attack = attack;
	}

	public static int getMoney() {
		return Money;
	}

	public static void setMoney(int money) {
		Money = money;
	}

	public static void setHP(int hP) {
		HP = hP;
	}
	
	public static void setXP(int xP)
	{
		XP = xP;
	}
	
	public static int getXP()
	{
		return XP;
	}

	public You(int YourHP, int YourDefense, int YourAttack, String YourWeapon1, int Weapon1Attack,  String YourWeapon2, int Weapon2Attack, int YourMoney, int YourXP, int HealthPotions) 
	{
		HP = YourHP;
		Defense = YourDefense;
		Attack = YourAttack;
		Weapon1 = YourWeapon1;
		Weapon2 = YourWeapon2;
		Money = YourMoney;
		XP = YourXP;
		potion = HealthPotions;
		Weap1At = Weapon1Attack;
		Weap2At = Weapon2Attack;
	}
	
	

	public static int getWeap1At() {
		return Weap1At;
	}

	public static void setWeap1At(int weap1At) {
		Weap1At = weap1At;
	}

	public static int getWeap2At() {
		return Weap2At;
	}

	public static void setWeap2At(int weap2At) {
		Weap2At = weap2At;
	}

	public static int getPotion() {
		return potion;
	}

	public static void setPotion(int potion) {
		You.potion = potion;
	}

	
	
	public static String getWeapon1() {
		return Weapon1;
	}

	public static String getWeapon2() {
		return Weapon2;
	}

	public static void setWeapon1(String weapon )
	{
		Weapon1 = weapon;
	}
	
	public static void setWeapon2(String weapon)
	{
		Weapon2 = weapon;
	}
	
	public static int getHP()
	{
		return HP;
	}
	
	
}
