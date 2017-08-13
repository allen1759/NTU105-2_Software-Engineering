import java.util.ArrayList;

public class SubjectIterator implements Iterator {

	private String subject;
	private ArrayList<Book> books;
	private int ind;
	
	public SubjectIterator(String subject, ArrayList<Book> books) {
		this.subject = new String(subject);
		this.books = books;
		ind = 0;
	}

	@Override
	public boolean hasNext() {
		do {
			if(books.get(ind).getSubject().equals(subject))
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
