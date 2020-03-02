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
		storage.getUserList().add(new UserDAO("a", "a", "홍길동"));
		storage.getBookList().add(new BookDAO("시나공 정보처리기사", "박길동"));
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
			System.out.print("1.로그인 2.회원가입 3.종료 > ");
			choice = sc.nextInt();
		} while (choice < 1 || choice > 3);

		switch (choice) {
		case 1:// 로그인
			userManage.login();
			break;
		case 2:// 회원가입
			userManage.join();
			break;
		case 3:// 종료
		default:
			System.exit(0);
			break;
		}
	}

	public void userMenu() {
		int choice;
		do {
			System.out.print("1.책목록조회 2.대여신청 3.반납신청 4.로그아웃 > ");
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
			System.out.print("1.회원목록조회 2.책 추가 3.로그아웃 > ");
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
