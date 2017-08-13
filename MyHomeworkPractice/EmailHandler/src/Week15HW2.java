import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Week15HW2 {

	public static void main(String[] args) throws IOException {

		String inputFileName = args[0];
		FileReader fr = new FileReader(inputFileName);
//		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		
		Handler handlerChain = new SpamHandler(new ComplaintHandler(new FanHandler(null)));

        String str = new String();
        while((str = br.readLine()) != null) {
        	handlerChain.handle(str);
        }
        
        br.close();
	}

}
