import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week15HW1 {

	public static void main(String[] args) throws IOException {
		String inputFileName = args[0];
		FileReader fr = new FileReader(inputFileName);
		BufferedReader br = new BufferedReader(fr);
		
		Scrapbook scrapbook = new Scrapbook();
		Document document = new Document();
        String str = new String();
        MenuItem cut = new Cut(scrapbook, document);
        MenuItem copy = new Copy(scrapbook, document);
        MenuItem paste = new Paste(scrapbook, document);
        while((str = br.readLine()) != null) {
        	if(str.equals("Cut"))
        		cut.Operate();
        	else if(str.equals("Copy"))
        		copy.Operate();
        	else if(str.equals("Paste"))
        		paste.Operate();
        }
        
        br.close();
	}

}
