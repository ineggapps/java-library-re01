package management;

import java.util.Scanner;

import dao.UserDAO;

public class UserManageImpl implements UserManage {

	private Scanner sc = new Scanner(System.in);
	private Storage storage = Storage.getInstance();

	@Override
	public void login() {
		String id;
		String pw;

		System.out.print("아이디 >");
		id = sc.next();
		System.out.print("비밀번호 >");
		pw = sc.next();

		if(id.equals("admin") && pw.equals("1234")) {
			System.out.println("관리자로 로그인하셨습니다.");
			storage.setLoginedUser(new UserDAO("admin", "1234", "관리자"));
			return;
		}

		UserDAO user = storage.getUser(id);
		if (user == null || !(user.getPw().equals(pw))) {
			System.out.println("로그인에 실패했습니다.");
			return;
		}
		
		storage.setLoginedUser(user);
		System.out.println("로그인되었습니다. " + user.getName());
	}

	@Override
	public void logout() {
		storage.setLoginedUser(null);
		System.out.println("로그아웃되었습니다.");
	}

	@Override
	public void join() {
		String id;
		String pw;
		String name;
		boolean duplicated;
		do {
			duplicated=false;
			System.out.print("희망 아이디 입력 > ");
			id = sc.next();
			if(storage.getUser(id)!=null) {
				//이미 id가 존재하면
				System.out.println("아이디가 중복됩니다. 다시 입력!!");
				duplicated=true;
			}
		}while(duplicated);
		
		System.out.print("희망 비밀번호 입력 > ");
		pw = sc.next();
		System.out.print("사용자 이름 입력 > ");
		name = sc.next();

		UserDAO user = new UserDAO();
		user.setId(id);
		user.setPw(pw);
		user.setName(name);
		
		storage.getUserList().add(user);
		System.out.println("회원가입이 완료되었습니다.");
	}

}
