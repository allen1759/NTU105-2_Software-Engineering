import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FinalExam {
    public static void main(String[] args) throws IOException {
//        String inputFileName = args[0];
        String inputFileName = "Sample0.in";
        FileReader fr = new FileReader(inputFileName);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        String[] words = null;
        
        int bookNumber = Integer.parseInt(br.readLine());
        for(int i=0; i<bookNumber; i+=1) {
        	words = br.readLine().split(" ");
        	Library.getInstance().doAddBook(new Book(words[0], words[1]));
        }
        
        int userNumber = Integer.parseInt(br.readLine());
        for(int i=0; i<userNumber; i+=1) {
        	words = br.readLine().split(" ");
        	if(words[0].equals("Staff")) {
        		Library.getInstance().addUser(new Staff(words[1]));
        	}
        	else if(words[0].equals("Borrower")) {
        		Library.getInstance().addUser(new Borrower(words[1], Integer.parseInt(words[2])));
        	}
        }
        
        Library li = Library.getInstance();
        while((line = br.readLine()) != null) {
        	words = line.split(" ");
        	User currUser = Library.getInstance().findUser(words[0]);
        	if(words[1].equals("addBook")) {
        		String[] tmp = br.readLine().split(" ");
        		currUser.addBook(new Book(tmp[0], tmp[1]));
        	}
        	else if(words[1].equals("removeBook")) {
        		currUser.removeBook(new Integer(words[2]));
        	}
        	else if(words[1].equals("checkout")) {
        		String[] tmp = br.readLine().split(" ");
        		ArrayList<Integer> arr = new ArrayList<Integer>();
        		for(String ele : tmp) {
        			arr.add(new Integer(ele));
        		}
        		currUser.checkOut(arr, words[2]);
        	}
        	else if(words[1].equals("return")) {
        		currUser.returnBook(new Integer(words[2]));
        	}
        	else if(words[1].equals("listAuthor")) {
        		currUser.listBooksByAuthor(words[2]);
        	}
        	else if(words[1].equals("listSubject")) {
        		currUser.listBooksBySubject(words[2]);
        	}
        	else if(words[1].equals("findChecked")) {
        		currUser.findBorrowedBooks(words[2]);
        	}
        	else if(words[1].equals("findBorrower")) {
        		currUser.findBorrower(new Integer(words[2]));
        	}
        }
        
        br.close();
    }
}
