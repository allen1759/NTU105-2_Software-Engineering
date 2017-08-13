
public class Book {
	private static int currentID = 0;

	private Integer id;
	private String subject, author;
	private boolean isCheckedOut;
	private User borrower;
	
	public Book(String author, String subject) {
		id = new Integer(currentID);
		currentID += 1;
		this.subject = subject;
		this.author = author;
		isCheckedOut = false;
		borrower = null;
	};
	
	public Integer getID() {
		return id;
	}

	public String getSubject() {
		return subject;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public boolean isCheckedOut() {
		return isCheckedOut;
	}
	
	public User getBorrower() {
		return borrower;
	}
	
	public void checkOutBook(User borrower) {
		if(isCheckedOut)
			System.out.println("Can not check out since the book is checked out");
		else {
            isCheckedOut = true;
            borrower.addBorrowBook(this);
            this.borrower = borrower;
		}
	}
	
	public void returnBook() {
		if(isCheckedOut) {
            isCheckedOut = false;
            borrower.removeBorrowBook(this);
            this.borrower = null;
		}
		else
			System.out.println("Can not return since the book isn't checked out");
	}
	
	public void display() {
		System.out.println("ID: " + id.toString() + " Author: " + author + " Subject: " + subject);
	}
}
