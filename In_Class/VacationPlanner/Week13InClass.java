import java.io.*;

public class Week13InClass{
	public static void main(String[] args){
		String inputFileName = args[0];
		FileReader fr;
		BufferedReader br;

		try{
			fr = new FileReader(inputFileName);
			br = new BufferedReader(fr);

			VacationPlanner builder = null;
			String line;
			while((line = br.readLine()) != null){
				String[] inputs = line.split("\\s");
				switch(inputs[0]){
					case "Backpacking":
						if (builder != null){
							builder.getVacation().printVacation();
							System.out.println();
						}
						builder = new BackpackingVacationPlanner();
						break;
					case "Normal":
						if (builder != null){
							builder.getVacation().printVacation();
							System.out.println();
						}
						builder = new NormalVacationPlanner();
						break;
					case "Day":
						builder.bookDay(inputs[1]);
						break;
					case "SpecialEvent":
						builder.bookSpecialEvents(inputs[1]);
						break;
					case "Hotel":
						builder.chooseHotel(inputs[1]);
						break;
					case "Reservation":
						builder.makeRestaurantReservations(inputs[1]);
						break;
					case "Tickets":
						builder.chooseAdmissionTickets(inputs[1]);
						break;
					default:
						break;
				}
			}
			builder.getVacation().printVacation();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}