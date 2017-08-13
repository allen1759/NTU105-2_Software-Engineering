import java.util.ArrayList;

public class AuthorIterator implements Iterator {

	private String author;
	private ArrayList<Book> books;
	private int ind;
	
	public AuthorIterator(String author, ArrayList<Book> books) {
		this.author = new String(author);
		this.books = books;
		ind = 0;
	}

	@Override
	public boolean hasNext() {
		do {
			if(books.get(ind).getAuthor().equals(author))
				return true;
			else
                ind += 1;
		} while(ind < books.size());

		return false;
	}

	@Override
	public Object next() {
		if( hasNext() ) {
			Object ret = books.get(ind);
			ind += 1;
			return ret;
		}
		else
			return null;
	}
}
