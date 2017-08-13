import java.util.ArrayList;

public class Staff extends User {

	public Staff(String name) {
		super(name);
	}

	@Override
	public void checkOut(ArrayList<Integer> booksID, String userName) {
		User currUser = Library.getInstance().findUser(userName);
		if(currUser.isExceedLimit(booksID.size())) {
			System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
		}
		else
			Library.getInstance().doCheckOut(booksID, userName);
	}

	@Override
	public void returnBook(Integer bookID) {
		Library.getInstance().doReturn(bookID);
	}

	@Override
	public void addBook(Book newBook) {
		Library.getInstance().doAddBook(newBook);
	}

	@Override
	public void removeBook(Integer bookID) {
		Library.getInstance().doRemoveBook(bookID);
	}

	@Override
	public void findBorrowedBooks(String name) {
		User currUser = Library.getInstance().findUser(name);
		currUser.displayBorrowBooks();
	}

	@Override
	public void findBorrower(Integer bookID) {
		Book currBook = Library.getInstance().findBook(bookID);
		currBook.getBorrower().displayUserName();
	}

	@Override
	protected boolean isExceedLimit(int number) {
		return false;
	}
}
