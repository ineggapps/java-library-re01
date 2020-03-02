import java.util.Scanner;

public class LibraryService {
	Scanner sc = new Scanner(System.in);

	public void entrance() {
		
	}

	public void initMenu() {
		int choice;
		do {
			System.out.print("1.로그인 2.회원가입 3.종료 > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);

		switch (choice) {
		case 1:
			break;
		case 2:
			break;
		case 3:
		default:
			break;
		}
	}
	
	public void userMenu() {
		int choice;
		do {
			System.out.print("1.책목록조회 2.대여신청 3.반납신청 4.로그아웃 > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);
		switch (choice) {
		case 1:
			break;
		case 2:
			break;
		case 3:
		default:
			break;
		case 4:
			break;
		}
	}
	
	public void managerMenu() {
		int choice;
		do {
			System.out.print("1.회원목록조회 2.대여목록조회 3.로그아웃 > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);
		switch (choice) {
		case 1:
			break;
		case 2:
			break;
		case 3:
		default:
			break;
		}
	}
	
}
