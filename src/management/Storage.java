package management;

import java.util.ArrayList;
import java.util.List;

import dao.BookDAO;
import dao.RentalDAO;
import dao.UserDAO;

public class Storage {
	// 정석은 아님 (멀티쓰레드 환경 지원X)
	private static Storage instance;
	private List<UserDAO> userList = new ArrayList<UserDAO>();
	private List<BookDAO> bookList = new ArrayList<BookDAO>();
	private List<RentalDAO> rentalList = new ArrayList<RentalDAO>();

	private UserDAO loginedUser = null;

	private Storage() {

	}

	public static Storage getInstance() {
		if (instance == null) {
			instance = new Storage();
		}
		return instance;
	}

	public List<UserDAO> getUserList() {
		return userList;
	}

	public List<BookDAO> getBookList() {
		return bookList;
	}

	public List<RentalDAO> getRentalList() {
		return rentalList;
	}

	public UserDAO getLoginedUser() {
		return loginedUser;
	}

	public void setLoginedUser(UserDAO loginedUser) {
		this.loginedUser = loginedUser;
	}
	
	public UserDAO getUser(String id) {
		for(UserDAO user: userList) {
			if(id.equals(user.getId())) {
				return user;
			}
		}
		return null;
	}

}
