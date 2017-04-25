import java.util.*;

public class Patient {
	private String name;
	private Integer frequency;
	private List<AnalogDevice> analogDevices = new LinkedList<AnalogDevice>();
	
	public Patient(String[] words, String[] lines){
		this.name = words[1];
		this.frequency = Integer.parseInt(words[2]);
	}
	
	public Boolean attachAnalogDevice(String[] deviceInformation){

		String deviceCategory = deviceInformation[0];
		AnalogDevice analogDevice;
		
		if (deviceCategory.equals("PulseSensor")){
			analogDevice = new PulseSensor(dI[1], dI[2], dI[3], dI[4]);
		}
		else if (deviceCategory.equals("BloodPressureSensor")){
			analogDevice = new BloodPressureSensor(dI[1], dI[2], dI[3], dI[4]);
		}
		else if (deviceCategory.equals("TemperatureSensor")){
			analogDevice = new TemperatureSensor(dI[1], dI[2], dI[3], dI[4]);
		}
		else{
			System.out.println("invalid device type");
			return false;
		}
		
		analogDevices.add(analogDevice);
		return true;
	}
}