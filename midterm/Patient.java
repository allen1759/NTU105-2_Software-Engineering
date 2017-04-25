import java.util.*;

public class Patient {
	private String name;
	private Integer frequency;
	private List<AnalogDevice> analogDevices = new LinkedList<AnalogDevice>();
	
	public Patient(String[] words, String[] lines){
		this.name = words[1];
		this.frequency = Integer.parseInt(words[2]);
	}

	public class DeviceMeasurement{
		private String deviceCategory;
		private String deviceName;
		private Float measurementValue;


		public DeviceMeasurement(String deviceCategory, String deviceName, Float measurementValue){
			this.deviceCategory = deviceCategory;
			this.deviceName = deviceName;
			this.measurementValue = measurementValue;
		}

		public String getDeviceCategory(){
			return deviceCategory;
		}

		public String getDeviceName(){
			return deviceName;
		}

		public Float getmeasurementValue(){
			return measurementValue;
		}
	}

	public void getName(){
		return this.name;
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

	public List<DeviceMeasurement> getFactors(){
		List<DeviceMeasurement> res = new LinkedList<DeviceMeasurement>();
		for (int i=0;i<analogDevices.size();++i){
			DeviceMeasurement deviceMeasurement = new DeviceMeasurement(analogDevice.getCategoryName(), analogDevice.name, analogDevice.measure());
			res.add(deviceMeasurement);
		}
		return res;
	}
}