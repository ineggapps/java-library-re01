import java.util.Scanner;

public class LibraryService {
	Scanner sc = new Scanner(System.in);

	public void entrance() {
		
	}

	public void initMenu() {
		int choice;
		do {
			System.out.print("1.�α��� 2.ȸ������ 3.���� > ");
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
			System.out.print("1.å�����ȸ 2.�뿩��û 3.�ݳ���û 4.�α׾ƿ� > ");
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
			System.out.print("1.ȸ�������ȸ 2.�뿩�����ȸ 3.�α׾ƿ� > ");
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
