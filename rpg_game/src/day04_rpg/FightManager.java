package day04_rpg;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FightManager {

	ArrayList<Monster> monsterList = new ArrayList<>();
	Guild guild;
	Random ran;

	public FightManager() {
		// 초기화
		this.guild = new Guild();
		this.ran = new Random();

		Monster temp = new Monster("슬라임", 30, 2, 0, 2);
		this.monsterList.add(temp);
		temp = new Monster("늑대", 50, 5, 0, 5);
		this.monsterList.add(temp);
		temp = new Monster("골렘", 100, 10, 10, 12);
		this.monsterList.add(temp);
		temp = new Monster("고블린", 200, 15, 0, 22);
		this.monsterList.add(temp);
		temp = new Monster("리치", 300, 30, 0, 40);
		this.monsterList.add(temp);
		temp = new Monster("킹 스켈레톤", 1000, 50, 10, 100);
		this.monsterList.add(temp);
	}

	public void run() {

		while (true) {
			printAllMonster();
			int sel = selectMonster() - 1;
			isFight(sel);
		}
	}

	private void isFight(int index) {
		this.guild.printParty();
		boolean isDead = true;
		while (isDead) {
			attack(index);
			if (Guild.partyList.length == 0 && monsterList.get(index).getHp() <= 0) {
				isDead = false;
			}
			result(index);
		}
	}

	private void result(int index) {
		//exp 관리
		for (int i = 0; i < Guild.partyList.length; i++) {
			Monster monster = this.monsterList.get(index);
			Unit unit = Guild.partyList[i];
			int exp = monster.getExp();
			while(exp<=0) {
				unit.setExp(unit.getExp() + exp);
				if(unit.getExp()>=10) {
					levelUp(i);
				}
				exp-=10;
			}
		}
		
	}

	private void levelUp(int index) {
		Unit unit = Guild.partyList[index];
		unit.setLevel(unit.getLevel()+1);
		unit.setMaxHp(unit.getMaxHp()+10);
		unit.setAtt(unit.getAtt()+3);
		unit.setHp(unit.getMaxHp());
	}

	private void defense(int index) {
		System.out.println("## 방어 ##");
		int rNum = this.ran.nextInt(Guild.partyList.length) + 1;
		Monster monster = this.monsterList.get(index);
		Unit unit = Guild.partyList[rNum];
		int result = 0;
		if (unit.getDef() >= monster.getAtt()) {
			result = 1;
		} else {
			result = monster.getAtt() - unit.getDef();
		}
		System.out.printf("%s가 %s에게 %d의 데미지를 주었다!\n", monster.getName(), unit.getName(), result);
		unit.setHp(unit.getHp() - result);
		if (unit.getHp() <= 0) {
			System.out.printf("%s가 죽었다..", unit.getName());
			Unit[] temp = Guild.partyList;
			Guild.partyList = new Unit[temp.length - 1];
			int n = 0;
			for (int i = 0; i < temp.length; i++) {
				if (i != rNum)
					Guild.partyList[n++] = temp[i];
			}
			Player.getGuildList().remove(rNum);
		}
	}

	private void attack(int index) {
		System.out.println("## 공격 ##");
		for (int i = 0; i < Guild.partyList.length; i++) {
			Monster monster = this.monsterList.get(index);
			Unit unit = Guild.partyList[i];
			System.out.printf("%s의 체력 %d/%d\n", monster.getName(), monster.getHp(), monster.getMaxHp());
			int result = 0;
			if (monster.getDef() >= unit.getAtt()) {
				result = 1;
			} else {
				result = unit.getAtt() - monster.getDef();
			}
			System.out.printf("%s가 %s에게 %d의 데미지를 주었다!\n", unit.getName(), monster.getName(), result);
			monster.setHp(monster.getHp() - result);
			if (monster.getHp() <= 0) {
				System.out.println("몬스터가 죽었다!");
				monster.setAtt(monster.getMaxHp());
				for (int j = 0; j < Guild.partyList.length; j++) {
					Unit temp = Guild.partyList[i];
					temp.setHp(temp.getMaxHp());
				}

				break;
			} else {
				defense(index);
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void printAllMonster() {
		System.out.println("=== 사 냥 터 ===");
		for (int i = 0; i < this.monsterList.size(); i++) {
			System.out.printf("%d) %s\n", i + 1, this.monsterList.get(i).getName());
			System.out.printf("hp:%d att:%d def:%d\n", this.monsterList.get(i).getMaxHp(),
					this.monsterList.get(i).getAtt(), this.monsterList.get(i).getDef());
		}
	}

	private int selectMonster() {
		System.out.println("사냥하실 몬스터를 고르세요.");
		return MainGame.scan.nextInt();
	}
}
