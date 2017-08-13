import java.util.ArrayList;

public class Patient {
	private String name;
	private Integer frequency;
	private ArrayList<AnalogDevice> analogDevices;
	
	public Patient(String[] words){
		this.name = words[1];
		this.frequency = Integer.parseInt(words[2]);
		this.analogDevices = new ArrayList<AnalogDevice>();
	}

	public String getName(){
		return name;
	}

	public Integer getFrequency(){
		return frequency;
	}
	
	public Boolean attachAnalogDevice(String[] deviceInformation){

		String deviceCategory = deviceInformation[0];
		AnalogDevice analogDevice;
		
		if (deviceCategory.equals("PulseSensor")){
			analogDevice = new PulseSensor(deviceInformation[1], deviceInformation[2], deviceInformation[3], deviceInformation[4]);
		}
		else if (deviceCategory.equals("BloodPressureSensor")){
			analogDevice = new BloodPressureSensor(deviceInformation[1], deviceInformation[2], deviceInformation[3], deviceInformation[4]);
		}
		else if (deviceCategory.equals("TemperatureSensor")){
			analogDevice = new TemperatureSensor(deviceInformation[1], deviceInformation[2], deviceInformation[3], deviceInformation[4]);
		}
		else{
			System.out.println("invalid device type");
			return false;
		}
		
		analogDevices.add(analogDevice);
		return true;
	}
	
	public ArrayList<AnalogDevice> getDeviceList() {
		return analogDevices;
	}

}