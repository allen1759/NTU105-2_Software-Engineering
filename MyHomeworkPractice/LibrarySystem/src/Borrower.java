import java.util.ArrayList;

public class Borrower extends User {

	int threshold;
	Borrower(String name, int threshold) {
		super(name);
		this.threshold = threshold;
	}

	@Override
	public void checkOut(ArrayList<Integer> booksID, String userName) {
		System.out.println("Borrower can not check out the books");
	}

	@Override
	public void returnBook(Integer bookID) {
		System.out.println("Borrower can not return book");
	}

	@Override
	public void addBook(Book newBook) {
		System.out.println("Borrower can not add book");
	}

	@Override
	public void removeBook(Integer bookID) {
		System.out.println("Borrower can not remove book");
	}

	@Override
	public void findBorrowedBooks(String name) {
		if(name.equals(this.getName())) {
			displayBorrowBooks();
		}
		else
			System.out.println("Borrower can not find books checked out by other users");
	}

	@Override
	public void findBorrower(Integer bookID) {
		System.out.println("Borrower can not find borrower");
	}

	@Override
	protected boolean isExceedLimit(int number) {
		return number > this.threshold;
	}

}
