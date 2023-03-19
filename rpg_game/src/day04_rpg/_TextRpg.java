package day04_rpg;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

class MainGame {
	public static Scanner scan = new Scanner(System.in);
	public static Random ran = new Random();

	public MainGame() {
		Player player = new Player();
		Shop shop = new Shop();
		FileData fileData = new FileData();
		FightManager fm = new FightManager();
		while (true) {
			printMainMenu();
			int sel = scan.nextInt();
			if (sel == 1) {
				player.guildMenu();
			} else if (sel == 2) {
				shop.shopMng();
			} else if (sel == 3) {
				player.inventoryMenu();
			} else if (sel == 4) {
				fm.run();
			} else if (sel == 5) {
				try {
					fileData.save();
					System.err.println("저장완료");
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("저장실패");
				}
			} else if (sel == 6) {
				try {
					fileData.loadData();
					System.err.println("로드성공");
				} catch (IOException e) {
					e.printStackTrace();
					System.err.println("로드실패");
				}
			} else {
				System.out.println("게임을 종료 합니다.");
				break;
			}
		}
		MainGame.scan.close();
	}

	private void printMainMenu() {
		System.out.println("=============== [메인메뉴] ================");
		System.out.println("[1.길드관리] [2.상점] [3.인벤토리] [4. 사냥터]");
		System.out.println("[5.저장] [6.로드] [0.종료]");
	}
}

public class _TextRpg {
	public static void main(String[] args) {
		new MainGame();
	}
}