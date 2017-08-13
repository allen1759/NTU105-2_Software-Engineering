import java.util.ArrayList;

public abstract class User {

	private String name;
	private ArrayList<Book> borrowBooks;

	public User(String name) {
		this.name = new String(name);
		borrowBooks = new ArrayList<Book>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addBorrowBook(Book book) {
		borrowBooks.add(book);
	}
	
	public void removeBorrowBook(Book book) {
		borrowBooks.remove(book);
	}
	
	public void displayUserName() {
		System.out.println("User: " + name);
	}

	public void displayBorrowBooks() {
		for(Book book : borrowBooks) {
			book.display();
		}
	}
	
	public void listBooksByAuthor(String author) {
		Iterator iter = Library.getInstance().createAuthorIterator(author);
		listBooks(iter);
	}
	
	public void listBooksBySubject(String subject) {
		Iterator iter = Library.getInstance().createSubjectIterator(subject);
		listBooks(iter);
	}
	
	private void listBooks(Iterator iter) {
		while(iter.hasNext()) {
			Book currBook = (Book)iter.next();
			currBook.display();
		}
	}
	
	abstract public void checkOut(ArrayList<Integer> booksID, String userName);
	abstract public void returnBook(Integer bookID);
	abstract public void addBook(Book newBook);
	abstract public void removeBook(Integer bookID);
	abstract public void findBorrowedBooks(String name); 
	abstract public void findBorrower(Integer bookID);
	abstract protected boolean isExceedLimit(int number);
}
