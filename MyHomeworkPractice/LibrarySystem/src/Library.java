import java.util.ArrayList;
import java.util.TreeMap;

public class Library {

	static private Library library = null;
	private TreeMap<Integer, Book> books;
	private TreeMap<String, User> users;

	private Library() {
		books = new TreeMap<Integer, Book>();
		users = new TreeMap<String, User>();
	}

	static public Library getInstance() {
		if(library == null) {
			library = new Library();
		}
        return library;
	}
	
	public User findUser(String userName) {
		return users.get(userName);
	}
	
	public Book findBook(Integer bookID) {
		return books.get(bookID);
	}
	
	public void addUser(User newUser) {
		users.put(newUser.getName(), newUser);;
	}
	
	public Iterator createAuthorIterator(String author) {
		return new AuthorIterator(author, new ArrayList<Book>(books.values()));
	}
	
	public Iterator createSubjectIterator(String subject) {
		return new SubjectIterator(subject, new ArrayList<Book>(books.values()));
	}
	
	public void doCheckOut(ArrayList<Integer> booksID, String userName) {
		for(Integer bookID : booksID) {
			books.get(bookID).checkOutBook(users.get(userName));
		}
	}
	
	public void doReturn(Integer bookID) {
		books.get(bookID).returnBook();
	}
	
	public void doAddBook(Book newBook) {
		books.put(newBook.getID(), newBook);
	}
	
	public void doRemoveBook(Integer bookID) {
		books.remove(bookID);
	}
}
