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

		System.out.print("���̵� >");
		id = sc.next();
		System.out.print("��й�ȣ >");
		pw = sc.next();

		if(id.equals("admin") && pw.equals("1234")) {
			System.out.println("�����ڷ� �α����ϼ̽��ϴ�.");
			storage.setLoginedUser(new UserDAO("admin", "1234", "������"));
			return;
		}

		UserDAO user = storage.getUser(id);
		if (user == null || !(user.getPw().equals(pw))) {
			System.out.println("�α��ο� �����߽��ϴ�.");
			return;
		}
		
		storage.setLoginedUser(user);
		System.out.println("�α��εǾ����ϴ�. " + user.getName());
	}

	@Override
	public void logout() {
		storage.setLoginedUser(null);
		System.out.println("�α׾ƿ��Ǿ����ϴ�.");
	}

	@Override
	public void join() {
		String id;
		String pw;
		String name;
		boolean duplicated;
		do {
			duplicated=false;
			System.out.print("��� ���̵� �Է� > ");
			id = sc.next();
			if(storage.getUser(id)!=null) {
				//�̹� id�� �����ϸ�
				System.out.println("���̵� �ߺ��˴ϴ�. �ٽ� �Է�!!");
				duplicated=true;
			}
		}while(duplicated);
		
		System.out.print("��� ��й�ȣ �Է� > ");
		pw = sc.next();
		System.out.print("����� �̸� �Է� > ");
		name = sc.next();

		UserDAO user = new UserDAO();
		user.setId(id);
		user.setPw(pw);
		user.setName(name);
		
		storage.getUserList().add(user);
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
	}

}
