package dao;

public class BookDAO {
	private String title;
	private String writer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "[" + title + ", " + writer + "]";
	}

	public BookDAO() {
		super();
	}

	public BookDAO(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
	}

}
