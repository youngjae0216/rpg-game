package day04_rpg;

import java.util.ArrayList;

public class Guild {
	final int PARTY_SIZE = 4;
	public static ArrayList<Unit> guildList = new ArrayList<>(); // 캡슐화
	public static Unit[] partyList;
	
	public void setGuild() {
		Unit temp = new Unit("호랑이", 1, 30, 10, 5, 0);
		guildList.add(temp);
		temp = new Unit("황금돼지", 1, 20, 11, 12, 0);
		guildList.add(temp);
		temp = new Unit("거북이", 1, 20, 2, 5, 0);
		guildList.add(temp);
		temp = new Unit("장영재", 1, 400, 20, 20, 0);
		guildList.add(temp);
		for (int i = 0; i < guildList.size(); i++) {
			guildList.get(i).setParty(true);
		}
		partyList = new Unit[this.PARTY_SIZE];
		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty() == true) {
				partyList[n] = guildList.get(i);
				n += 1;
			}
		}
	}

	public Unit getGuildUnit(int num) {
		return guildList.get(num);
	}

	public void printAllUnitStaus() {
		System.out.println("======================================");
		System.out.println("[골드 : " + Player.getMoney() + "]");
		System.out.println("============= [길드원] =================");
		for (int i = 0; i < guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guildList.get(i).getName() + "]");
			System.out.print(" [레벨 : " + guildList.get(i).getLevel() + "]");
			System.out.print(" [체력 : " + guildList.get(i).getHp());
			System.out.println(" / " + guildList.get(i).getMaxHp() + "]");
			System.out.print("[공격력 : " + guildList.get(i).getAtt() + "]");
			System.out.print(" [방어력 : " + guildList.get(i).getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("=================================");
	}

	public void printUnitStaus(int num) {
		guildList.get(num).printStatus();
	}

	public void printUnitItem(int num) {
		guildList.get(num).printEquitedItem();
	}

	public void buyUnit() {
		if (Player.getMoney() < 5000) {
			System.out.println("골드가 부족합니다.");
			return;
		}
		String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
		String[] n2 = { "명", "기", "종", "민", "영", "석", "광" };
		String[] n3 = { "수", "자", "민", "수", "석", "재", "철" };

		String name = n1[MainGame.ran.nextInt(n1.length)];
		name += n2[MainGame.ran.nextInt(n1.length)];
		name += n3[MainGame.ran.nextInt(n1.length)];
		int ran = MainGame.ran.nextInt(8) + 2;
		int hp = ran * 11;
		int att = ran + 1;
		int def = ran / 2 + 1;
		Unit temp = new Unit(name, 1, hp, att, def, 0);

		System.out.println("=====================================");
		System.out.print("[이름 : " + name + "]");
		System.out.print(" [레벨 : " + 1 + "]");
		System.out.print(" [체력 : " + hp);
		System.out.println(" / " + hp + "]");
		System.out.print("[공격력 : " + att + "]");
		System.out.println(" [방어력 : " + def + "]");
		System.out.println("길드원을 추가합니다.");
		System.out.println("=====================================");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		guildList.add(temp);
		Player.setMoney(Player.getMoney() - 5000);
		if(partyList.length<4) {
			temp.setParty(true);
			Unit[] tempParty = partyList;
			partyList = new Unit[tempParty.length+1];
			for(int i=0; i<tempParty.length;i++) {
				partyList[i]=tempParty[i];
			}
			partyList[tempParty.length] = temp;
		}
	}

	public void removeUnit() {
		printAllUnitStaus();
		System.out.println("삭제할 번호를 입력하세요 ");
		int sel = MainGame.scan.nextInt();
		if (guildList.get(sel - 1).isParty()) {
			System.out.println("파티중인 멤버는 삭제할수 없습니다.");
		} else {
			System.out.println("=================================");
			System.out.print("[이름 : " + guildList.get(sel - 1).getName() + "]");
			System.out.println("길드원을 삭제합니다.");
			System.out.println("=================================");
			guildList.remove(sel - 1);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void printParty() {
		System.out.println("================ [파티원] ===============");
		for (int i = 0; i < partyList.length; i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + partyList[i].getName() + "]");
			System.out.print(" [레벨 : " + partyList[i].getLevel() + "]");
			System.out.print(" [체력 : " + partyList[i].getHp());
			System.out.println(" / " + partyList[i].getMaxHp() + "]");
			System.out.print("[공격력 : " + partyList[i].getAtt() + "]");
			System.out.print(" [방어력 : " + partyList[i].getDef() + "]");
			System.out.println(" [파티중 : " + guildList.get(i).isParty() + "]");
			System.out.println("");
		}
		System.out.println("=====================================");
	}

	public void partyChange() {

		printParty();
		System.out.println("교체할 번호를 입력하세요 ");
		int partyNum = MainGame.scan.nextInt();
		printAllUnitStaus();
		System.out.println("참가할 번호를 입력하세요 ");
		int guildNum = MainGame.scan.nextInt();

		partyList[partyNum - 1].setParty(false);
		guildList.get(guildNum - 1).setParty(true);

		System.out.println("====================================");
		System.out.print("[이름 : " + partyList[partyNum - 1].getName() + "]");
		System.out.print("에서 ");
		System.out.print("[이름 : " + guildList.get(guildNum - 1).getName() + "]");
		System.out.println("으로 교체 합니다. ");
		System.out.println("====================================");

		int n = 0;
		for (int i = 0; i < guildList.size(); i++) {
			if (guildList.get(i).isParty()) {
				partyList[n++] = guildList.get(i);
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드원목록] [2.길드원추가(5000골드)] [3.길드원삭제]\n" + "[4.파티원교체] [5.회복하기] [0.뒤로가기]");
			int sel = MainGame.scan.nextInt();
			if (sel == 1) {
				printAllUnitStaus();
			} else if (sel == 2) {
				buyUnit();
			} else if (sel == 3) {
				removeUnit();
			} 
			else if (sel == 4) {
				partyChange();
			} 
			else if (sel == 5) {
				fullHp();
			} 
			else if (sel == 0) {
				break;
			}
		}
	}

	private void fullHp() {
		for(int i=0;i<guildList.size();i++) {
			guildList.get(i).setHp(guildList.get(i).getMaxHp());
		}
	}


}