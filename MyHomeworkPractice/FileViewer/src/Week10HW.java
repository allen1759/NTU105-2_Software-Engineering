import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Week10HW {

	public static void main(String[] args) throws IOException {
		String inputFileName = args[0];
		FileReader fr = new FileReader(inputFileName);
//		FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);

		HashMap<String, View> allViews = new HashMap<String, View>();

        String currentLine = new String();
        while((currentLine = br.readLine()) != null) {
            String[] input = currentLine.split("\\s");

            if(!allViews.containsKey(input[0])) {
            	View textView = new TextView(input[1]);
            	allViews.put(input[0], textView);
            }
            else if(input[1].equals("add")) {
            	View currView = allViews.get(input[0]);
            	for(int i=2; i<input.length; i+=1) {
                    if(input[i].equals("scrollBar"))
                    	currView = new Scrollbar(currView);
                    else if(input[i].equals("thickBlackBorder"))
                    	currView = new ThickBlackBorder(currView);
            	}
            	allViews.put(input[0], currView);
            }
            else if(input[1].equals("display")) {
            	allViews.get(input[0]).display();
                System.out.println();
            }
        }
        br.close();
	}

}
