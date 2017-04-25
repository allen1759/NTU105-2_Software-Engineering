public class DeviceMeasurement{
	
	private String deviceCategory;
	private String deviceName;
	private Float measurementValue;
	private Float lowerRange;
	private Float upperRange;

	public DeviceMeasurement(String deviceCategory, String deviceName, Float measurementValue, Float lowerRange, Float, upperRange){
		this.deviceCategory = deviceCategory;
		this.deviceName = deviceName;
		this.measurementValue = measurementValue;
		this.lowerRange = lowerRange;
		this.upperRange = upperRange;
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

	public FLoat getlowerRange(){
		return lowerRange;
	}

	public Float getUpperRange(){
		return upperRange;
	} 
}