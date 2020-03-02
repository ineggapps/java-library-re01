import java.util.Scanner;

import dao.BookDAO;
import dao.UserDAO;
import management.BookManage;
import management.BookManageImpl;
import management.Storage;
import management.UserManage;
import management.UserManageImpl;

public class LibraryService {
	private Scanner sc = new Scanner(System.in);
	private Storage storage = Storage.getInstance();
	private UserManage userManage = new UserManageImpl();
	private BookManage bookManage = new BookManageImpl();

	public LibraryService() {
		storage.getUserList().add(new UserDAO("a", "a", "ȫ�浿"));
		storage.getBookList().add(new BookDAO("�ó��� ����ó�����", "�ڱ浿"));
	}

	public void entrance() {
		UserDAO user = storage.getLoginedUser();
		if (user == null) {
			initMenu();
		} else if (user != null && user.getId().equals("admin")) {
			managerMenu();
		} else {
			userMenu();
		}
	}

	public void initMenu() {
		int choice;
		do {
			System.out.print("1.�α��� 2.ȸ������ 3.���� > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);

		switch (choice) {
		case 1:// �α���
			userManage.login();
			break;
		case 2:// ȸ������
			userManage.join();
			break;
		case 3:// ����
		default:
			System.exit(0);
			break;
		}
	}

	public void userMenu() {
		int choice;
		do {
			System.out.print("1.å�����ȸ 2.�뿩��û 3.�ݳ���û 4.�α׾ƿ� > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 4);
		switch (choice) {
		case 1:
			bookManage.list();
			break;
		case 2:
			break;
		case 3:
		default:
			break;
		case 4:
			userManage.logout();
			break;
		}
	}

	public void managerMenu() {
		int choice;
		do {
			System.out.print("1.ȸ�������ȸ 2.å �߰� 3.�α׾ƿ� > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);
		switch (choice) {
		case 1:
			break;
		case 2:
			bookManage.add();
			break;
		case 3:
		default:
			userManage.logout();
			break;
		}
	}

}
