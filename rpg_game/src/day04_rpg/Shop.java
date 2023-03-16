package day04_rpg;

import java.util.ArrayList;

public class Shop {
	public static ArrayList<Item> itemList = new ArrayList<>();

	public Shop() {
		Item temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("나무검");
		temp.setPower(3);
		temp.setPrice(1000);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("철검");
		temp.setPower(5);
		temp.setPrice(2000);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.WEAPON);
		temp.setName("레이피어");
		temp.setPower(7);
		temp.setPrice(2500);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("티셔츠");
		temp.setPower(1);
		temp.setPrice(300);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("가죽갑옷");
		temp.setPower(4);
		temp.setPrice(800);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.ARMOR);
		temp.setName("강철갑옷");
		temp.setPower(7);
		temp.setPrice(1500);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("은반지");
		temp.setPower(7);
		temp.setPrice(3000);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("금반지");
		temp.setPower(17);
		temp.setPrice(6000);
		this.itemList.add(temp);

		temp = new Item();
		temp.setKind(Item.RING);
		temp.setName("다이아반지");
		temp.setPower(35);
		temp.setPrice(20000);
		this.itemList.add(temp);
	}

	public void shopMng() {
		while (true) {
			System.out.println("=============== [상점] ===============");
			System.out.println("[1.무기] [2.갑옷] [3.반지] [0.뒤로가기]");
			int selKind = MainGame.scan.nextInt();
			if (selKind == 0)
				return;
			while (true) {
				if (selKind == Item.WEAPON)
					System.out.println("=========== [무기] ============");
				else if (selKind == Item.ARMOR)
					System.out.println("=========== [방어구] ============");
				else if (selKind == Item.RING)
					System.out.println("=========== [반지] ============");
				printItems(selKind);
				System.out.println("[골드 : " + Player.getMoney() + "]");
				System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
				int selNum = MainGame.scan.nextInt();
				if (selNum == 0)
					break;
				int count = 0;
				for (int i = 0; i < itemList.size(); i++) {
					if (itemList.get(i).getKind() == selKind) {
						count += 1;
						if (count == selNum) {
							Player.inven.addItem(itemList.get(i));
							Player.setMoney(Player.getMoney() - itemList.get(i).getPrice());
							System.out.println("[" + itemList.get(i).getName() + "] 을 구입했습니다.");
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							break;
						}
					}
				}
			}
		}
	}

	public void printItems(int kind) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).getKind() != kind)
				continue;
			System.out.print("[" + (count + 1) + "번]");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]");
			System.out.print("[가격 : " + itemList.get(i).getPrice() + "]");
			System.out.println("");
			count += 1;
		}
	}

}