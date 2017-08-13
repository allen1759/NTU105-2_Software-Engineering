import java.util.ArrayList;

public class Program {

	private int monitor_period;
	private ArrayList<Patient> patients;
	private Database database;

	public Program(int monitor_period, ArrayList<Patient> patients) {
		this.monitor_period = monitor_period;
		this.patients = patients;
		this.database = new Database();
	}
	
	public DeviceMeasurement readFactor(AnalogDevice device) {
		return new DeviceMeasurement(device.getCategoryName(), device.getDeviceName(), device.measure(), device.getLowerRange(), device.getUpperRange());
	}
	
	public void monitor() {
		for(int timer=0; timer<=monitor_period; timer+=1) {
			for(Patient patient : patients) {
				if(timer % patient.getFrequency() == 0) {
					ArrayList<AnalogDevice> deviceList = patient.getDeviceList();
					for(AnalogDevice device : deviceList) {
						DeviceMeasurement deviceMeasurement = readFactor(device);
						storeDB(patient.getName(), deviceMeasurement, timer);
						compareRange(patient.getName(), deviceMeasurement, timer);
					}
				}
			}
		}
		database.display();
	}
	
	public void storeDB(String patientName, DeviceMeasurement deviceMeasurement, int currentTime) {
		database.insert(patientName, deviceMeasurement.getDeviceCategory() + " " + deviceMeasurement.getDeviceName(), currentTime, deviceMeasurement.getmeasurementValue());
	}
	
	public void compareRange(String patientName, DeviceMeasurement deviceMeasurement, int currentTime) {
		if(deviceMeasurement.getmeasurementValue()==-1) {
			NurseStation.displayDevFall(currentTime, deviceMeasurement.getDeviceName());
		}
		else if(!deviceMeasurement.isSafeRange()) {
			NurseStation.displayPatientDanger(currentTime, patientName, deviceMeasurement.getDeviceName(), deviceMeasurement.getmeasurementValue());
		}
	}
	
}
