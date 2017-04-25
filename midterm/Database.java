import java.util.*;

public class Database{

	public List<String> inputOrder;
	public Map<String, HashMap<ArrayList<Record>>> patientRecord;

	Database(){
		inputOrder = new ArrayList<String>();
		patientRecord = new HashMap<String, HashMap<ArrayList<Record>>>();
	}

	public void insert(String patientName, String deviceName, int time, float value){
		if(!patientRecord.containskey(patientName)){
			inputOrder.add(patientName);
			Map<ArrayList<Record>> recordList = new HashMap<ArrayList<Record>>();
			patientRecord.put(patientName, recordList);
		}
		if(!patientRecord.get(patientName).containskey(deviceName)){
			ArrayList<Record> record = new ArrayList<Record>();
			patientRecord.get(patientName).put(deviceName, record);
		}

		Record tempRecord = new Record(time, value);
		patientRecord.get(patientName).get(deviceName).add(tempRecord);
	}

	public void display(){
		
	}

	private class Record{
		int time;
		float value;
		Record(int time, float value){
			this.time = time;
			this.value = value;
		}
	}
}