package day04_rpg;

public class Unit {
	private String name;
	private int level;
	private int hp;
	private int maxHp;
	private int att;
	private int def;
	private int exp;
	private boolean party;
	private Item weapon;
	private Item armor;
	private Item ring;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return this.maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getAtt() {
		return this.att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return this.def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getExp() {
		return this.exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public boolean isParty() {
		return this.party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}

	public Item getWeapon() {
		return this.weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	public Item getArmor() {
		return this.armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return this.ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	public Unit(String n, int l, int h, int a, int d, int e) {
		this.name = n;
		this.level = l;
		this.maxHp = h;
		this.att = a;
		this.def = d;
		this.exp = e;
		this.hp = this.maxHp;
		this.party = false;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public Unit(String n, int l, int h, int a, int d, int e, boolean p) {
		this.name = n;
		this.level = l;
		this.maxHp = h;
		this.att = a;
		this.def = d;
		this.exp = e;
		this.hp = this.maxHp;
		this.party = p;
		this.weapon = null;
		this.armor = null;
		this.ring = null;
	}

	public void setItem(Item w, Item a, Item r) {
		this.weapon = w;
		this.armor = a;
		this.ring = r;
	}

	public void printStatus() {
		System.out.print("[이름 : " + this.name + "]");
		System.out.print(" [레벨 : " + this.level + "]");
		if (this.ring != null) {
			System.out.print(" [체력 : " + this.hp + " + " + this.ring.getPower());
		} else {
			System.out.print(" [체력 : " + this.hp);
		}
		if (this.ring != null) {
			System.out.println(" / " + this.maxHp + " + " + this.ring.getPower() + "]");
		} else {
			System.out.println(" / " + this.maxHp + "]");
		}
		if (this.weapon != null) {
			System.out.print("[공격력 : " + this.att + " + " + this.weapon.getPower() + "]");
		} else {
			System.out.print("[공격력 : " + this.att + "]");
		}
		if (this.armor != null) {
			System.out.print(" [방어력 : " + this.def + " + " + this.armor.getPower() + "]");
		} else {
			System.out.print(" [방어력 : " + this.def + "]");
		}
		System.out.println(" [파티중 : " + this.party + "]");
	}

	public void printEquitedItem() {
		if (this.weapon == null) {
			System.out.println("[무기 : 없음 ]");
		} else {
			System.out.println("[무기 : " + this.weapon.getName() + "]");
		}
		if (this.armor == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.println("[방어구 : " + this.armor.getName() + "]");
		}
		if (this.ring == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.println("[반지 : " + this.ring.getName() + "]");
		}
	}
}