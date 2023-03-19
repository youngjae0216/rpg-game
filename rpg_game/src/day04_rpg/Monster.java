package day04_rpg;

public class Monster {

	private String name;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private int gold;
	
	
	public Monster(String name, int hp, int att, int def, int exp, int gold) {
		this.name = name;
		this.maxHp = hp;
		this.hp = this.maxHp;
		this.att = att;
		this.def = def;
		this.exp = exp;
		this.gold = gold;
	}
	
	public void printMonster() {
		System.out.println("---------------------------------");
		System.out.printf("%s(%d) :  %d / %d\n",this.name,this.gold,this.hp,this.maxHp);
		System.out.printf("공격 : %d 방어 : %d 경험치 : %d\n",this.att,this.def,this.exp);
		System.out.println("---------------------------------");
		
		
	}
	
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
	
}
