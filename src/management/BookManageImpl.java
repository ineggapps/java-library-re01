package management;

import java.util.List;
import java.util.Scanner;

import dao.BookDAO;

public class BookManageImpl implements BookManage {

	private Storage storage = Storage.getInstance();
	private Scanner sc = new Scanner(System.in);

	@Override
	public void add() {
		BookDAO book = new BookDAO();
		System.out.println("책 이름 입력: ");
		book.setTitle(sc.next());
		System.out.println("작가 입력: ");
		book.setWriter(sc.next());
		
		storage.getBookList().add(book);
		System.out.println(book.getTitle() + "을 추가했습니다.");
		System.out.println(book);
		
	}

	@Override
	public void list() {
		List<BookDAO> bookList = storage.getBookList();
		for(BookDAO book:  bookList) {
			System.out.println(book);
		}
	}

}
