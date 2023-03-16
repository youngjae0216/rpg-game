package day04_rpg;

import java.util.ArrayList;

public class Player {
	private static int money;
	public static Guild guild = new Guild();
	public static Inventory inven = new Inventory();

	Player() {
		this.money = 100000;
		this.guild.setGuild();
	}

	public static int getMoney() {
		return Player.money;
	}

	public static void setMoney(int money) {
		Player.money = money;
	}

	public void guildMenu() {
		this.guild.guildMenu();
	}

	public void inventoryMenu() {
		this.inven.inventoryMenu();
	}

	static public ArrayList<Unit> getGuildList() {
		return guild.guildList;
	}

	static public ArrayList<Item> getItemList() {
		return inven.itemList;
	}

	static public Unit getGuildUnit(int num) {
		return guild.getGuildUnit(num);
	}

	static public int getGuildSize() {
		return guild.guildList.size();
	}

	static public int getItemSize() {
		return inven.itemList.size();
	}
}