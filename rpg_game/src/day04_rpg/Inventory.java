package day04_rpg;

import java.util.ArrayList;

public class Inventory {
	public static ArrayList<Item> itemList = new ArrayList<>();

	public void inventoryMenu() {
		while (true) {
			System.out.println("============ [인벤메뉴] =============");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 0)
				break;
			if (sel == 1) {
				equipMenu();
			}
			if (sel == 2) {
				sellMenu();
			}
		}
	}

	public void equipMenu() {
		Player.guild.printAllUnitStaus();
		System.out.println("아이템 착용할 길드원을 선택하세요 ");
		int selUnit = MainGame.scan.nextInt();
		while (true) {
			Player.guild.printUnitStaus(selUnit - 1);
			Player.guild.printUnitItem(selUnit - 1);
			printItemList();
			System.out.println("착용할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selEquip = MainGame.scan.nextInt() - 1;
			if (selEquip >= 0) {
				if (itemList.get(selEquip).getKind() == Item.WEAPON) {
					if (Player.getGuildUnit(selUnit - 1).getWeapon() != null) {
						itemList.add(Player.getGuildUnit(selUnit - 1).getWeapon());
					}
					Player.getGuildUnit(selUnit - 1).setWeapon(itemList.get(selEquip));
				} 
				else if (itemList.get(selEquip).getKind() == Item.ARMOR) {
					if (Player.getGuildUnit(selUnit - 1).getArmor() != null) {
						itemList.add(Player.getGuildUnit(selUnit - 1).getArmor());
					}
					Player.getGuildUnit(selUnit - 1).setArmor(itemList.get(selEquip));
				} 
				else if (itemList.get(selEquip).getKind() == Item.RING) {
					if (Player.getGuildUnit(selUnit - 1).getRing() != null) {
						itemList.add(Player.getGuildUnit(selUnit - 1).getRing());
					}
					Player.getGuildUnit(selUnit - 1).setRing(itemList.get(selEquip));
				}
				itemList.remove(selEquip);

			} else {
				break;
			}
		}
	}

	public void printItemList() {
		System.out.println("============ [아이템리스트] ==============");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "]");
			System.out.println("");
		}
	}

	public void sellMenu() {
		while (true) {
			printItemList();
			System.out.println("[골드 : " + Player.getMoney() + "]");
			System.out.println("판매할 아이템 번호를 입력하세요. (50 % 세금) [0.뒤로가기]");
			int selSell = MainGame.scan.nextInt();
			if (selSell != 0) {
				System.out.println(itemList.get(selSell - 1).getName() + "을 판매합니다.");
				Player.setMoney(Player.getMoney() + (itemList.get(selSell - 1).getPrice() / 2));
				itemList.remove(selSell - 1);
			} else {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void addItem(Item item) {
		itemList.add(item);
	}

}